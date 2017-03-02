/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pojo.AccountType;

/**
 *
 * @author Ian
 */
@Stateless
public class AccountTypeFacade extends AbstractFacade<AccountType> {

    @PersistenceContext(unitName = "RSVierRestPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccountTypeFacade() {
        super(AccountType.class);
    }
    
}
