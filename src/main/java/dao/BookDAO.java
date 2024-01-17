package dao;

import java.sql.SQLException;
import java.util.List;

import model.Book;

public interface BookDAO {
	
	boolean addBook(Book book) throws SQLException;
	boolean updateBook(Book book) throws SQLException;
	Book getBookById(Integer id) throws SQLException;
	List<Book> getAllBooks() throws SQLException;
	boolean deleteBook(Book book) throws SQLException;
	Book getBookByName(String bookName) throws SQLException;
	
}
