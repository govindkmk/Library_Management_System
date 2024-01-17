package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.*;
import daoimpl.*;
import model.*;

/**
 * Servlet implementation class AddBook
 */
@WebServlet("/AddBook")
public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String bookName = request.getParameter("bookName");
		String categoryName = request.getParameter("category");
		String authorName = request.getParameter("author");
		String isbn = request.getParameter("isbnNumber");
		String price = request.getParameter("price");
		
		BookDAO bookDAO = new BookDAOImp();
		CategoryDAO categoryDAO = new CategoryDAOImp();
		AuthorDAO authorDAO = new AuthorDAOImp();
		Book book = new Book();
		
		long millis=System.currentTimeMillis();  
		java.sql.Date date = new java.sql.Date(millis);
		
		book.setName(bookName);
		
		try {
			Category category = categoryDAO.getCategoryByName(categoryName);
			book.setCategory(category);
			Author author = authorDAO.getAuthorByName(authorName);
			book.setAuthor(author);
			book.setIsbnNumber(Integer.parseInt(isbn));
			book.setPrice(Double.parseDouble(price));
			book.setCreationDate(date);
			
			boolean success = bookDAO.addBook(book);
			if(success) {
				response.sendRedirect("ManageBook.jsp");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
