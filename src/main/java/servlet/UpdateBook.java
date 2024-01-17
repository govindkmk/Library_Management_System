package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BookDAO;
import daoimpl.BookDAOImp;
import model.*;

/**
 * Servlet implementation class UpdateBook
 */
@WebServlet("/UpdateBook")
public class UpdateBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BookDAO bookDAO = new BookDAOImp();
		Book book = new Book();
		
		HttpSession hs = request.getSession();
		int bookId = (int) hs.getAttribute("bookId");
		
		String name = request.getParameter("name");
		String categoryName = request.getParameter("category");
		String authorName = request.getParameter("author");
		int isbnNumber = Integer.parseInt(request.getParameter("isbn"));
		double price = Double.parseDouble(request.getParameter("price"));
		
		long millis=System.currentTimeMillis();  
		java.sql.Date date = new java.sql.Date(millis);		
		
		book.setId(bookId);
		book.setName(name);
		Category category = new Category();
		category.setName(categoryName);
		book.setCategory(category);
		Author author = new Author();
		author.setName(authorName);
		book.setAuthor(author);
		book.setIsbnNumber(isbnNumber);
		book.setPrice(price);
		book.setUpdationDate(date);
		
		try {
			boolean success = bookDAO.updateBook(book);
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
