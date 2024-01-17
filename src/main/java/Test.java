import java.math.BigInteger;
import java.sql.SQLException;
import java.util.List;

import dao.*;
import daoimpl.*;
import model.*;
public class Test {
	public static void main(String[] args) {
		
		
		CategoryDAO categoryDAO = new CategoryDAOImp();
		AuthorDAO authorDAO = new AuthorDAOImp();
		UserDAO userDAO = new UserDAOImp();
		BookDAO bookDAO = new BookDAOImp();
		IssueBookDAO issueBookDAO = new IssueBookDAOImp();
		try {
			/*
			 * Category category = new Category(); category.setName("Test");
			 * category.setStatus("Active");
			 * 
			 * categoryDAO.addCategory(category);
			 */
			
			Category category = categoryDAO.getCategoryByName("Test");
			System.out.println("Name : "+category.getName());
			
			Author author = authorDAO.getAuthorByName("Ahmad S");
			System.out.println("Id : "+author.getId());
			
			User user = userDAO.getUserByName("Govind Kumar");
			System.out.println("Id : "+user.getId());
			
			User user1 = userDAO.getUserByEmail("govindkk152@gmail.com");
			System.out.println("Id : "+user1.getId());
			
			User user2 = userDAO.loginUser("wasay@gmail.com", "wasay1234");
			System.out.println("Id : "+user2.getId());
			
			Book book = bookDAO.getBookByName("CPC");
			System.out.println("Id : "+book.getCategory().getName());
			
			BigInteger total = issueBookDAO.returnedBooks();
			System.out.println(total);
			
			BigInteger totalNotReturnedBooks = issueBookDAO.userNotReturnedBooks(5);
			System.out.println(totalNotReturnedBooks);
			
			List<IssueBook> userTotal = issueBookDAO.getUserIssuedBooks(5);
			System.out.println(userTotal.size());
			
			List<IssueBook> ib = issueBookDAO.getAllIssueBooks();
			for(IssueBook ibook : ib) {
				System.out.println(ibook.getBook().getName());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
