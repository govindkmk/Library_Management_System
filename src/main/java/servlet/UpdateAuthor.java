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

import dao.AuthorDAO;
import daoimpl.AuthorDAOImp;
import model.Author;

/**
 * Servlet implementation class UpdateAuthor
 */
@WebServlet("/UpdateAuthor")
public class UpdateAuthor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAuthor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AuthorDAO authorDAO = new AuthorDAOImp();
		Author author = new Author();
		
		HttpSession hs = request.getSession();
		int authorId = (int) hs.getAttribute("authorId");
		String name = request.getParameter("name");
		
		
		long millis=System.currentTimeMillis();  
		java.sql.Date date = new java.sql.Date(millis);
		
		author.setId(authorId);
		author.setName(name);
		author.setUpdationDate(date);
		
		try {
			boolean success = authorDAO.updateAuthor(author);
			if(success) {
				response.sendRedirect("ManageAuthor.jsp");
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
