package cz.nguyen;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import cz.nguyen.entity.Product;

public class MainJavaSe {
	private static EntityManagerFactory emf;

	public static void main(String[] args) throws SQLException {

		emf = Persistence.createEntityManagerFactory("default");
		EntityManager em = emf.createEntityManager();

		Product p = new Product();
		em.persist(p);
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		System.out.println(em.find(Product.class, p.getId()));
		
		em.close();
		emf.close();
	}


}
