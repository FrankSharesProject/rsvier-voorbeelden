/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security.jwt;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

public class JwtAuthenticationFilter extends GenericFilterBean{
    private JwtUtil jwtUtil = new JwtUtil();
    private Logger log = LoggerFactory.getLogger(JwtAuthenticationFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse res = (HttpServletResponse) response;
        
        Cookie[] cookies = req.getCookies();
        String token = null;
        for(Cookie c : cookies){
            if(c.getName().equals("jwt-auth")){
                token = c.getValue();
            }
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(token != null){
            log.debug("Jwt access token found");
            if(jwtUtil.verifyJwt(token)){
                String username = jwtUtil.getUsername(token);
                authentication = new AuthenticatedUser(username);
            }
            else{
                authentication = new AuthenticatedUser(null);
                authentication.setAuthenticated(false);
            }
        }
        else{
            log.warn("Jwt access token not found!");
        }
        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(request,response);
    }
}