package dao;

import java.sql.SQLException;
import java.util.List;

import model.User;

public interface UserDAO {
	
	boolean addUser(User user) throws SQLException;
	boolean updateUser(User user) throws SQLException;
	User getUserById(Integer id) throws SQLException;
	List<User> getAllUsers() throws SQLException;
	boolean deleteUser(User user) throws SQLException;
	User loginUser(String email, String password) throws SQLException;
	User getUserByName(String userName) throws SQLException;
	boolean updateUserPassword(User user) throws SQLException;
	User getUserByEmail(String email) throws SQLException;
}
