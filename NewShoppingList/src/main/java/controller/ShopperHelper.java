package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Shopper;

/**
* @author Kevin Roney - karoney
* CIS 175 - Fall 2023
* Feb 21, 2023
*/
public class ShopperHelper {
	static EntityManagerFactory	emfactory =	Persistence.createEntityManagerFactory("NewShoppingList");
	
	public void insertShopper(Shopper s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);;
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Shopper> showAllShoppers(){
		EntityManager em = emfactory.createEntityManager();
		List<Shopper> allShoppers = em.createQuery("SELECT s FROM Shopper s").getResultList();
		return allShoppers;
	}

	/**
	 * @param shopperName
	 * @return
	 */
	public Shopper findShopper(String nameToLookUp) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Shopper> typedQuery = em.createQuery("select sh from Shopper sh where sh.shopperName = :selectedName", Shopper.class);
		
		typedQuery.setParameter("selectedName",	nameToLookUp);
		typedQuery.setMaxResults(1);
		
		Shopper foundShopper;
		try {
			foundShopper = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
			foundShopper = new Shopper(nameToLookUp);
		}
		em.close();
		
		return foundShopper;
	}
}
