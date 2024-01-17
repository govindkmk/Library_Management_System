package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.IssueBookDAO;
import daoimpl.IssueBookDAOImp;
import model.IssueBook;


/**
 * Servlet implementation class UpdateIssuedBook
 */
@WebServlet("/UpdateIssuedBook")
public class UpdateIssuedBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateIssuedBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession hs = request.getSession();
		int issuedBookId = (int) hs.getAttribute("issuedBookId");
		
		double fine = Double.parseDouble(request.getParameter("fine"));
		
		IssueBookDAO issueBookDAO = new IssueBookDAOImp();
		IssueBook issueBook = new IssueBook();
		
		long millis=System.currentTimeMillis();  
		Date date = new Date(millis);
		
		issueBook.setId(issuedBookId);
		issueBook.setReturnDate(date);
		issueBook.setFine(fine);
		
		try {
			boolean success = issueBookDAO.updateIssueBook(issueBook);
			if(success) {
				response.sendRedirect("ManageIssuedBook.jsp");
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
