package daoimpl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import javax.persistence.*;

import configuration.HibernateConfiguration;
import dao.AuthorDAO;
import model.Author;

public class AuthorDAOImp implements AuthorDAO{

	@Override
	public boolean addAuthor(Author author) throws SQLException {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(author);
		session.getTransaction().commit();
		return true;
	}

	@Override
	public boolean updateAuthor(Author author) throws SQLException {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(author);
		session.getTransaction().commit();
		return true;
	}

	@Override
	public Author getAuthorById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Author author = session.get(Author.class, id);
		session.getTransaction().commit();
		return author;
	}

	@Override
	public List<Author> getAllAuthors() throws SQLException {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Author> authors = session.createQuery("FROM Author").list();
		session.getTransaction().commit();
		return authors;
	}

	@Override
	public boolean deleteAuthor(Author author) throws SQLException {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(author);
		session.getTransaction().commit();
		return true;
	}

	@Override
	public Author getAuthorByName(String authorName) throws SQLException {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		String getByNameQuery = "FROM Author WHERE name = :aname";
		Query query = session.createQuery(getByNameQuery);
		query.setParameter("aname", authorName);
		
		Author author = (Author) query.getSingleResult();
		
		session.getTransaction().commit();
		return author;
	}


}
