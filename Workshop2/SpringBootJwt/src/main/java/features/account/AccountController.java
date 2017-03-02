/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package features.account;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import security.jwt.JwtUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AccountController {
    
    private final JwtUtil jwtUtil = new JwtUtil();
    
    @Autowired
    private AccountService accountService;
    
    @RequestMapping(method=RequestMethod.GET, value="/login")
    public String addAccountToLogin(){
        return "redirect:klant";
    }
    /*
    @RequestMapping(method=RequestMethod.POST, value="/login")
    public @ResponseBody void login(@ModelAttribute("account") Account account, HttpServletRequest request, HttpServletResponse response){
        if(account.getUsername() != null){
            if(accountService.matchUsernameAndPassword(account.getUsername(), account.getWachtwoord())){
                try {
                    response.addHeader("jwt-auth", jwtUtil.generateJwt(account.getUsername()));
                    response.sendRedirect("klant");
                } catch (IOException ex) {
                    System.err.println("IOException for redirect: " + ex.getMessage());
                }
                
            }
        }
        try {
            response.sendRedirect("login");
        } catch (IOException ex) {
            System.err.println("IOException for redirect: " + ex.getMessage());
        }
    }
    */
    
    @RequestMapping(method=RequestMethod.POST, value="/login")
    public String login(){
        return "redirect:klant";
    }
}
