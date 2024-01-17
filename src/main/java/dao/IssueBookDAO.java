package dao;

import java.math.BigInteger;
import java.sql.SQLException;
import java.util.List;

import model.IssueBook;

public interface IssueBookDAO {
	
	boolean issueBook(IssueBook issueBook) throws SQLException;
	boolean updateIssueBook(IssueBook issueBook) throws SQLException;
	IssueBook getIssueBookById(Integer id) throws SQLException;
	List<IssueBook> getAllIssueBooks() throws SQLException;
	boolean deleteIssueBook(IssueBook issueBook) throws SQLException;
	List<IssueBook> getUserIssuedBooks(Integer userId) throws SQLException;
	BigInteger returnedBooks() throws SQLException;
	BigInteger userNotReturnedBooks(int userId) throws SQLException;
	List<IssueBook> getUserTotalIssuedBooks(Integer userId) throws SQLException;

}
