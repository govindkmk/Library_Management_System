package configuration;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfiguration {
	
	private HibernateConfiguration() {
		
	}
	
	private static SessionFactory sessionFactory = null;
	
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) {
			//load configuration from hibernate.cfg.xml
			Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
			
			//build session factory
			sessionFactory = configuration.buildSessionFactory();
			
			
		}
		return sessionFactory;
	}
	
}
