package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AuthorDAO;
import daoimpl.AuthorDAOImp;
import model.Author;

/**
 * Servlet implementation class DeleteAuthor
 */
@WebServlet("/DeleteAuthor")
public class DeleteAuthor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAuthor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		AuthorDAO authorDAO = new AuthorDAOImp();
		
		String action = request.getParameter("action");
		if("DELETE".equals(action)) {
			int authorId = Integer.parseInt(request.getParameter("authorId"));
			
			Author author = new Author();
			author.setId(authorId);
			
			try {
				boolean success = authorDAO.deleteAuthor(author);
				if(success) {
					response.sendRedirect("ManageAuthor.jsp");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
