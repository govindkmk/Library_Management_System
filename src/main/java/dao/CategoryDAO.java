package dao;

import java.sql.SQLException;
import java.util.List;

import model.Category;

public interface CategoryDAO {
	
	boolean addCategory(Category category) throws SQLException;
	boolean updateCategory(Category category) throws SQLException;
	Category getCategoryById(Integer id) throws SQLException;
	List<Category> getAllCategories() throws SQLException;
	Category getCategoryByName(String categoryName) throws SQLException;
	boolean deleteCategory(Category category) throws SQLException;

}
