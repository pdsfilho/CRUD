package br.com.loginapp.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static final EntityManagerFactory em;
	private static EntityManager entityManager;
	
	static {
		em= Persistence.createEntityManagerFactory("LOGINAPP_PU");
	}
	
	public static EntityManager getEntityManager() {
		if(entityManager ==null) {
			entityManager = em.createEntityManager();
		}
		return entityManager;
		}
}

