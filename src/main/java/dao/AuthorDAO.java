package dao;

import java.sql.SQLException;
import java.util.List;

import model.Author;

public interface AuthorDAO {
	
	boolean addAuthor(Author author) throws SQLException;
	boolean updateAuthor(Author author) throws SQLException;
	Author getAuthorById(Integer id) throws SQLException;
	List<Author> getAllAuthors() throws SQLException;
	Author getAuthorByName(String authorName) throws SQLException;
	boolean deleteAuthor(Author author) throws SQLException;
	

}
