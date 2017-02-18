package es.uniovi.asw.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Jpa {

	private static EntityManagerFactory emf = null;
	private static EntityManager em = null;

	/**
	 * Creates and returns the EntitiyManager object necessary to perform 
	 * persistence operations
	 * @return EntityManager object
	 */
	public static EntityManager getEntityManager() {
		emf = Persistence.createEntityManagerFactory("users");
		em = emf.createEntityManager();
		emf.createEntityManager();
		
		return em;
	}
}
