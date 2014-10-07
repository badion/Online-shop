package com.onlineshop.badion.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {

	private static SessionFactory sessionFactory = buildSessionFactory();

	private static ServiceRegistry serviceRegistry;

	private static SessionFactory buildSessionFactory() {

		try {
			  Configuration configuration = new Configuration();
			  configuration.configure();
			  serviceRegistry = new ServiceRegistryBuilder().applySettings(
			            configuration.getProperties()).build();
			  
			return configuration.buildSessionFactory(serviceRegistry);

		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed.");
			throw new ExceptionInInitializerError(ex);
		}

	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
