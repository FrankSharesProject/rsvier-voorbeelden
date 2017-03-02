/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package features.account;

import com.lambdaworks.crypto.SCryptUtil;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private Logger log = LoggerFactory.getLogger(AccountService.class);
    
    @Autowired
    AccountDao accountDao;
    
    @Autowired
    AccountTypeDao accountTypeDao;
    
    public Account getAccount(Integer id){
        Account account = accountDao.findOne(id);
        AccountType type = accountTypeDao.findOne(account.getAccountType().getId());
        account.setAccountType(type);
        return account;
    }
    
    public Account getAccount(String username){
        Account account = accountDao.findByUsername(username);
        if(account!= null){
            log.debug("Account found with id " + account.getId() + " and type " + account.getAccountType().getType());
        }
        else{
            log.error("No account found");
        }
        /*
        AccountType type = accountTypeDao.findOne(account.getAccountType().getId());
        account.setAccountType(type);*/
        return account;
    }
    
    public boolean matchUsernameAndPassword(String username, String password){
        Account account = accountDao.findByUsername(username);
        if(account != null){
            return SCryptUtil.check(password, account.getWachtwoord());
        }
        return false;
    }
    
    public Account createAccount(Account account){
        return accountDao.save(account);
    }
    
    public List<AccountType> getAllAccountTypes(){
        return accountTypeDao.findAll();
    }
    
    public AccountType getAccountType(Integer id){
        return accountTypeDao.findOne(id);
    }
    
}
