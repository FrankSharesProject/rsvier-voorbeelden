/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security.jwt;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

public class JwtLoginFilter extends AbstractAuthenticationProcessingFilter{
    private Logger log = LoggerFactory.getLogger(JwtLoginFilter.class);
    private JwtUtil jwtUtil;

    public JwtLoginFilter(String url, AuthenticationManager authenticationManager) {
         super(new AntPathRequestMatcher(url));
         setAuthenticationManager(authenticationManager);
         jwtUtil = new JwtUtil();
    }

     @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
    throws AuthenticationException, IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        log.debug("Attempting authentication on username '" + username + "'");
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
        return getAuthenticationManager().authenticate(token);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication)
    throws IOException, ServletException {
        log.debug("Authentication successful");
        String name = authentication.getName();
        String jwt = jwtUtil.generateJwt(name);
        Cookie cookie = new Cookie("jwt-auth", jwt);
        response.addCookie(cookie);
        chain.doFilter(request, response);
    }
    
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed)
    throws IOException, ServletException{
        response.sendRedirect("");
    }
}
