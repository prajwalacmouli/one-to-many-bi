import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.oneToMany.dto.Brand;
import com.ty.oneToMany.dto.Product;

public class AddMoreProducts {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("vikas");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		Brand brand = manager.find(Brand.class, 1);
		Product product1 = new Product();
		product1.setName("TV");
		product1.setCost(15000);
		product1.setBrand(brand);

		Product product2 = new Product();
		product2.setName("MicroOven");
		product2.setCost(6500);
		product2.setBrand(brand);

		List<Product> list = new ArrayList<Product>();
		list.add(product1);
		list.add(product2);
		List<Product> brands = brand.getProduct();
		brands.add(product1);
		brands.add(product2);
		brand.setProduct(brands);
		
		transaction.begin();
		manager.persist(product1);
		manager.persist(product2);
		transaction.commit();
		

	}

}
