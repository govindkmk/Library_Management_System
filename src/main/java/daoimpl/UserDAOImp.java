package daoimpl;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import configuration.HibernateConfiguration;
import dao.UserDAO;
import model.User;

public class UserDAOImp implements UserDAO{

	@Override
	public boolean addUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		return true;
	}

	@Override
	public boolean updateUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
		return true;
	}

	@Override
	public User getUserById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		User user = session.get(User.class, id);
		session.getTransaction().commit();
		return user;
	}

	@Override
	public List<User> getAllUsers() throws SQLException {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<User> users = session.createQuery("FROM User").list();
		session.getTransaction().commit();
		return users;
	}

	@Override
	public boolean deleteUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(user);
		session.getTransaction().commit();
		return true;
	}

	@Override
	public User loginUser(String email, String password) throws SQLException {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		String getByEmailANDPasswordQuery = "FROM User WHERE email = :uemail AND password = :upassword";
		Query query = session.createQuery(getByEmailANDPasswordQuery);
		query.setParameter("uemail", email);
		query.setParameter("upassword", password);
		
		User user = (User) query.getSingleResult();
		
		session.getTransaction().commit();
		return user;
	}

	@Override
	public User getUserByName(String userName) throws SQLException {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		String getByNameQuery = "FROM User WHERE name = :uname";
		Query query = session.createQuery(getByNameQuery);
		query.setParameter("uname", userName);
		
		User user = (User) query.getSingleResult();
		
		session.getTransaction().commit();
		return user;
	}

	@Override
	public boolean updateUserPassword(User user) throws SQLException {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
		return true;
	}

	@Override
	public User getUserByEmail(String email) throws SQLException {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		String getByEmailQuery = "FROM User WHERE email = :uemail";
		Query query = session.createQuery(getByEmailQuery);
		query.setParameter("uemail", email);
		
		User user = (User) query.getSingleResult();
		
		session.getTransaction().commit();
		return user;
	}

}
