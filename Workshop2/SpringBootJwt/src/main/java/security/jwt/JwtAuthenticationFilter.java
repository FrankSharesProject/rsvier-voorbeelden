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
        //In dit geval moet er naar het token gekeken worden in de RESPONSE, en niet de request.
        String token = res.getHeader("jwt-auth");
        if(token != null){
            log.debug("Jwt access token found");
            String username = jwtUtil.getUsername(token);
            Authentication authentication = new AuthenticatedUser(username);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        else{
            log.warn("Jwt access token not found!");
        }
        filterChain.doFilter(request,response);
    }
}

/* //Old
Enumeration<String> headerNames = req.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String header = headerNames.nextElement();
            System.out.println("Header " + header + " found");
        }
        String header = req.getHeader("jwt-auth");
        Authentication authentication = null;
        if(header != null){
            System.out.println("Auth header found");
            System.out.println("Header: " + header);
            String username = jwtUtil.getUsername(header);
            if(username != null){
                authentication = new AuthenticatedUser(username);
                System.out.println("Authorized");
            }
        }
        SecurityContextHolder.getContext().setAuthentication(authentication);
*/