package com.ty.oneToMany.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.oneToMany.dto.Mobile;
import com.ty.oneToMany.dto.Sim;

public class TestSave {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("vikas");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		Mobile mobile = new Mobile();
		mobile.setName("Samsung");
		mobile.setCost(350000);

		Sim s1 = new Sim();
		s1.setImrc(12343459);
		s1.setProvider("Airtel");
		s1.setMobile(mobile);

		Sim s2 = new Sim();
		s2.setImrc(443245667);
		s2.setProvider("Vodafone");
		s2.setMobile(mobile);

		List<Sim> list = new ArrayList<Sim>();
		list.add(s1);
		list.add(s2);
		mobile.setSim(list);

		transaction.begin();
		manager.persist(mobile);
		manager.persist(s1);
		manager.persist(s2);
		transaction.commit();
		System.out.println("------------------data stored--------------");
	}

}
