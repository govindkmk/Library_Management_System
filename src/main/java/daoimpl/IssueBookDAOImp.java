package daoimpl;

import java.math.BigInteger;
import java.util.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

import javax.persistence.Query;

import org.hibernate.query.*;
import org.hibernate.type.DateType;
import org.hibernate.type.DoubleType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import configuration.HibernateConfiguration;
import dao.IssueBookDAO;
import model.Book;
import model.IssueBook;
import model.User;

public class IssueBookDAOImp implements IssueBookDAO{

	@Override
	public boolean issueBook(IssueBook issueBook) throws SQLException {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(issueBook);
		session.getTransaction().commit();
		return true;
	}

	@Override
	public boolean updateIssueBook(IssueBook issueBook) throws SQLException {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(issueBook);
		session.getTransaction().commit();
		return true;
	}

	@Override
	public IssueBook getIssueBookById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		IssueBook issueBook = session.get(IssueBook.class, id);
		session.getTransaction().commit();
		return issueBook;
	}

	@Override
	public List<IssueBook> getAllIssueBooks() throws SQLException {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		String getAllIssueBooksQuery = "SELECT ib.id, u.name as user_name, b.name as book_name, b.isbn_number, b.price, ib.issue_date, ib.return_date FROM ISSUE_BOOK ib INNER JOIN USER u ON ib.user_id = u.id INNER JOIN BOOK b ON ib.book_id = b.id";
		NativeQuery query = session.createSQLQuery(getAllIssueBooksQuery);

		List<Object[]> resultList = query.getResultList();
		
		List<IssueBook> issueBooks = new ArrayList<>();
		for (Object[] result : resultList) {
		    IssueBook issueBook = new IssueBook();
		    issueBook.setId((int) result[0]);
		    
		    User user = new User();
		    user.setName(String.valueOf(result[1]));
		    
		    Book book = new Book();
		    book.setName(String.valueOf(result[2]));
		    book.setIsbnNumber((int) result[3]);
		    book.setPrice(((BigDecimal) result[4]).doubleValue());
		    
		    issueBook.setUser(user);
		    issueBook.setBook(book);
		    issueBook.setIssueDate((Date) result[5]);
		    issueBook.setReturnDate((Date) result[6]);
		    
		    issueBooks.add(issueBook);
		}
		session.getTransaction().commit();
		return issueBooks;
	}

	@Override
	public boolean deleteIssueBook(IssueBook issueBook) throws SQLException {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(issueBook);
		session.getTransaction().commit();
		return true;
	}

	@Override
	public List<IssueBook> getUserTotalIssuedBooks(Integer userId) throws SQLException {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		String getUserIssueBooksQuery = "SELECT * FROM issue_book WHERE user_id = :userId";
		NativeQuery query = session.createSQLQuery(getUserIssueBooksQuery);
		query.setParameter("userId", userId);
		List<IssueBook> issueBooks = query.getResultList();
		session.getTransaction().commit();
		return issueBooks;
	}
	
	public List<IssueBook> getUserIssuedBooks(Integer userId) throws SQLException {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		String getUserIssueBooksQuery = "SELECT ib.id, b.name, b.isbn_number, ib.issue_date, ib.return_date, ib.fine FROM ISSUE_BOOK ib JOIN BOOK b ON ib.book_id = b.id WHERE ib.user_id = :userId";
		NativeQuery query = session.createSQLQuery(getUserIssueBooksQuery);
		query.setParameter("userId", userId);
		List<Object[]> resultList = query.getResultList();
		
		List<IssueBook> issueBooks = new ArrayList<>();
		for (Object[] result : resultList) {
		    IssueBook issueBook = new IssueBook();
		    issueBook.setId((int) result[0]);
		    
		    Book book = new Book();
		    book.setName(String.valueOf(result[1]));
		    book.setIsbnNumber((int) result[2]);
		    
		    issueBook.setBook(book);
		    issueBook.setIssueDate((Date) result[3]);
		    issueBook.setReturnDate((Date) result[4]);
		    issueBook.setFine(((BigDecimal) result[5]).doubleValue());
		    
		    issueBooks.add(issueBook);
		}
		
		session.getTransaction().commit();
		return issueBooks;
	}

	@Override
	public BigInteger returnedBooks() throws SQLException {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		BigInteger totalReturnedBooks;
		String countReturnedBooksQuery = "SELECT COUNT(*) FROM issue_book WHERE return_date IS NOT NULL";
		NativeQuery query = session.createSQLQuery(countReturnedBooksQuery);
		totalReturnedBooks = (BigInteger) query.uniqueResult();
		
		session.getTransaction().commit();
		return totalReturnedBooks;
	}

	@Override
	public BigInteger userNotReturnedBooks(int userId) throws SQLException {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		BigInteger userTotalNotReturnedBooks;
		String countReturnedBooksQuery = "SELECT COUNT(*) FROM Issue_Book WHERE user_id = :userId AND return_date IS NULL";
		NativeQuery query = session.createSQLQuery(countReturnedBooksQuery);
		query.setParameter("userId", userId);
		userTotalNotReturnedBooks = (BigInteger) query.uniqueResult();
		
		session.getTransaction().commit();
		return userTotalNotReturnedBooks;
	}

}
