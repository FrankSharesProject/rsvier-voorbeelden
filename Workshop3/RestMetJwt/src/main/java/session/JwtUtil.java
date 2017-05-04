/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Ian
 */
public class JwtUtil {
    private Logger log = LoggerFactory.getLogger(JwtUtil.class);
    
    public String generateJwt(String user, String accountstatus){
        generateKey();
        
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.add(Calendar.DATE, 2);
        Date expirationDate = calendar.getTime();
        Key key = getKey();
        if(key != null){
            String compactJws = Jwts.builder()
                .claim("accountstatus", accountstatus)
                .setSubject(user)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();

            if(verifyJwt(compactJws)){
                return compactJws;
            }
            else{
                return null;
            }
        }
        else{
            return null;
        }
    }
    
    public boolean verifyJwt(String compactJws){
        try {
            Jwts.parser().setSigningKey(getKey()).parseClaimsJws(compactJws);
            return true;
        } catch (SignatureException e) {
            //TODO: log exception
            return false;
        }
    }
    
    private Key getKey(){
        Key key = null;
        File file = new File("key.dat");
        if(!file.exists()){
            return null;
        }
        try(BufferedInputStream keyReader = new BufferedInputStream(new FileInputStream("key.dat"))){
            byte[] encodedKey = new byte[keyReader.available()];
            if(keyReader.read(encodedKey) >=0){
                byte[] decodedKey = Base64.getDecoder().decode(encodedKey);
                // rebuild key using SecretKeySpec
                key = new SecretKeySpec(decodedKey, 0, decodedKey.length, "HmacSHA256"); 
            }
        } catch (FileNotFoundException ex) {
            return null;
        } catch (IOException ex) {
            return null;
        }
        return key;
    }
    
    private void generateKey(){
        try(BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream("key.dat"))){
            SecretKey key = KeyGenerator.getInstance("HmacSHA256").generateKey();
            byte[] encodedKey = Base64.getEncoder().encode(key.getEncoded());
            output.write(encodedKey);
            System.out.println(new String(encodedKey));
            output.flush();
        }
        catch (FileNotFoundException | NoSuchAlgorithmException ex) {
            log.error(ex.getMessage());
        } catch (IOException ex) {
            log.error(ex.getMessage());
        }
    }
}
