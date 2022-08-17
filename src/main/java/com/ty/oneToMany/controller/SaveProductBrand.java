package com.ty.oneToMany.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.oneToMany.dto.Brand;
import com.ty.oneToMany.dto.Product;

public class SaveProductBrand {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("vikas");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		Brand brand1 = new Brand();
		brand1.setName("IFB");
		brand1.setRating("4.5 star");

		Brand brand2 = new Brand();
		brand2.setName("Samsung");
		brand2.setRating("5 star");

		Product product1 = new Product();
		product1.setName("TV");
		product1.setCost(650000);
		product1.setBrand(brand1);

		Product product2 = new Product();
		product2.setName("Mobile");
		product2.setCost(15000);
		product2.setBrand(brand1);

		Product product3 = new Product();
		product3.setName("Refrigirator");
		product3.setCost(450000);
		product3.setBrand(brand2);

		Product product4 = new Product();
		product4.setName("Mobile");
		product4.setCost(15000);
		product4.setBrand(brand2);

		transaction.begin();
		manager.persist(product1);
		manager.persist(product2);
		manager.persist(product3);
		manager.persist(product4);
		manager.persist(brand1);
		manager.persist(brand2);
		transaction.commit();

	}

}
