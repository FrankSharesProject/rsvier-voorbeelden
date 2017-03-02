/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pojo.Adrestype;

/**
 *
 * @author Ian
 */
@Stateless
public class AdrestypeFacade extends AbstractFacade<Adrestype> {

    @PersistenceContext(unitName = "RSVierRestPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AdrestypeFacade() {
        super(Adrestype.class);
    }
    
}
