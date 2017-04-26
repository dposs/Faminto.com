package com.faminto.util.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class JPAUtil {
	
	public static final String DEFAULT_PERSISTENCE_UNIT = "faminto-mysql";

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;

	static {
		entityManagerFactory = Persistence.createEntityManagerFactory(DEFAULT_PERSISTENCE_UNIT);
	}
	
	private JPAUtil() {}
	
	public static EntityManager getEntityManager() {
		if (entityManager == null) {
			entityManager = entityManagerFactory.createEntityManager();
		}
		return entityManager;
	}
}