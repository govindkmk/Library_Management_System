package daoimpl;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import configuration.HibernateConfiguration;
import dao.BookDAO;
import model.Book;

public class BookDAOImp implements BookDAO{

	@Override
	public boolean addBook(Book book) throws SQLException {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(book);
		session.getTransaction().commit();
		return true;
	}

	@Override
	public boolean updateBook(Book book) throws SQLException {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(book);
		session.getTransaction().commit();
		return true;
	}

	@Override
	public Book getBookById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Book book = session.get(Book.class, id);
		session.getTransaction().commit();
		return book;
	}

	@Override
	public List<Book> getAllBooks() throws SQLException {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Book> books = session.createQuery("FROM Book").list();
		session.getTransaction().commit();
		return books;
	}

	@Override
	public boolean deleteBook(Book book) throws SQLException {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(book);
		session.getTransaction().commit();
		return true;
	}

	@Override
	public Book getBookByName(String bookName) throws SQLException {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		String getByNameQuery = "FROM Book WHERE name = :bname";
		Query query = session.createQuery(getByNameQuery);
		query.setParameter("bname", bookName);
		
		Book book = (Book) query.getSingleResult();
		
		session.getTransaction().commit();
		return book;
	}

}
