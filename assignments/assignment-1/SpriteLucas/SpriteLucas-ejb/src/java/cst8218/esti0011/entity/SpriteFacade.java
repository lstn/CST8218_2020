/*
 * CST8218 Assignment 1
 * Author: Lucas Estienne <esti0011@algonquinlive.com>
 * 2020W Term
 */
package cst8218.esti0011.entity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tgk
 */
@Stateless
public class SpriteFacade extends AbstractFacade<Sprite> {
    @PersistenceContext(unitName = "SpriteLucas-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SpriteFacade() {
        super(Sprite.class);
    }
    
}
