package org.sample.serverless.aws.rds;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (null != sessionFactory)
			return sessionFactory;

		Configuration configuration = new Configuration();

		String jdbcUrl = "jdbc:mysql://127.0.1.1/test";

		configuration.setProperty("hibernate.connection.url", jdbcUrl);
		configuration.setProperty("hibernate.connection.username", "test");
		configuration.setProperty("hibernate.connection.password", "test");
		configuration.addAnnotatedClass(User.class);
		configuration.configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		try {
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);

		} catch (HibernateException e) {
			System.err.println("Initial SessionFactory creation failed." + e);
			throw new ExceptionInInitializerError(e);
		}
		return sessionFactory;
	}
}
