package org.javaee7.wildfly.samples.everest.catalog;

import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.javaee7.wildfly.samples.everest.cart.Cart;

/**
 * @author arungupta
 */
@Named
@Stateless
public class ItemBean implements Serializable {
    @PersistenceContext EntityManager em;
    
    @Inject Cart cart;
    
    public List<Item> getItems() {
        return em.createNamedQuery("Item.findAll", Item.class).getResultList();
    }
    
    public Item getItem() {
        int itemId = Integer.valueOf(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("itemId"));
        return em.createNamedQuery("Item.findById", Item.class).setParameter("id", itemId).getSingleResult();
    }
    
    public void addItemsToCart() {
        // add them to cart
    }
}
