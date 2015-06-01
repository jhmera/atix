/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entidades.Marca;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ACER
 */
@Stateless
public class MarcaFacade extends AbstractFacade<Marca> {
    @PersistenceContext(unitName = "atixPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MarcaFacade() {
        super(Marca.class);
    }
    
}
