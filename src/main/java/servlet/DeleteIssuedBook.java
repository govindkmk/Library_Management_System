package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IssueBookDAO;
import daoimpl.IssueBookDAOImp;
import model.IssueBook;

/**
 * Servlet implementation class DeleteIssuedBook
 */
@WebServlet("/DeleteIssuedBook")
public class DeleteIssuedBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteIssuedBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		IssueBookDAO issueBookDAO = new IssueBookDAOImp();
		String action = request.getParameter("action");
		if("DELETE".equals(action)) {
			int issuedBookId = Integer.parseInt(request.getParameter("issuedBookId"));
			
			IssueBook issueBook = new IssueBook();
			issueBook.setId(issuedBookId);
			
			try {
				boolean success = issueBookDAO.deleteIssueBook(issueBook);
				if(success) {
					response.sendRedirect("ManageIssuedBook.jsp");
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
