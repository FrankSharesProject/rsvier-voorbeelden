/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pojo.Bestelling;

/**
 *
 * @author Ian
 */
@Stateless
public class BestellingFacade extends AbstractFacade<Bestelling> {

    @PersistenceContext(unitName = "RSVierRestPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BestellingFacade() {
        super(Bestelling.class);
    }
    
}
