/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pojo.Adres;

/**
 *
 * @author Ian
 */
@Stateless
public class AdresFacade extends AbstractFacade<Adres> {

    @PersistenceContext(unitName = "RSVierRestPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AdresFacade() {
        super(Adres.class);
    }
    
}
