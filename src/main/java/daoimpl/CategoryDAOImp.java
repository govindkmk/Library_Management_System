package daoimpl;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import configuration.HibernateConfiguration;
import dao.CategoryDAO;
import model.Category;

public class CategoryDAOImp implements CategoryDAO{

	@Override
	public boolean addCategory(Category category) throws SQLException {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(category);
		session.getTransaction().commit();
		return true;
	}

	@Override
	public boolean updateCategory(Category category) throws SQLException {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(category);
		session.getTransaction().commit();
		return true;
	}

	@Override
	public Category getCategoryById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Category category = session.get(Category.class, id);
		session.getTransaction().commit();
		return category;
	}

	@Override
	public List<Category> getAllCategories() throws SQLException {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Category> categories = session.createQuery("FROM Category").list();
		session.getTransaction().commit();
		return categories;
	}

	@Override
	public boolean deleteCategory(Category category) throws SQLException {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(category);
		session.getTransaction().commit();
		return true;
	}

	@Override
	public Category getCategoryByName(String categoryName) throws SQLException {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		String getByNameQuery = "FROM Category WHERE name=:cname";
		Query query = session.createQuery(getByNameQuery);
		query.setParameter("cname", categoryName);
		
		Category category = (Category) query.getSingleResult();
		
		System.out.println("Category : "+category);
		session.getTransaction().commit();
		return category;
	}

}
