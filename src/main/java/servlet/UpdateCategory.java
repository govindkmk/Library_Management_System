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

import dao.CategoryDAO;
import daoimpl.CategoryDAOImp;
import model.Category;
/**
 * Servlet implementation class UpdateCategory
 */
@WebServlet("/UpdateCategory")
public class UpdateCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCategory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CategoryDAO categoryDAO = new CategoryDAOImp();
		
		HttpSession hs = request.getSession();
		int categoryId = (int) hs.getAttribute("categoryId");
		String name = request.getParameter("name");
		String status = request.getParameter("status");
		
		long millis=System.currentTimeMillis();  
		java.sql.Date date = new java.sql.Date(millis);
		
		Category category = new Category();
		category.setId(categoryId);
		category.setName(name);
		category.setStatus(status);
		category.setUpdationDate(date);
		
		System.out.println(category.getId());
		System.out.println(category.getName());
		
		try {
			boolean success = categoryDAO.updateCategory(category);
			if(success) {
				response.sendRedirect("ManageCategory.jsp");
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
