package com.ty.oneToMany.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.oneToMany.dto.Mobile;
import com.ty.oneToMany.dto.Sim;

public class GetSimById {
	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("vikas");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		Sim sim = manager.find(Sim.class, 1);
		System.out.println(sim);
		System.out.println("-----------------Data Saved-----------------------");



	}

}
