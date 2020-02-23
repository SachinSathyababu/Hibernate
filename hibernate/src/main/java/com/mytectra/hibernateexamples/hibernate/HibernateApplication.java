package com.mytectra.hibernateexamples.hibernate;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.TransactionManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EntityScan
public class HibernateApplication {

	public static void main(String[] args) throws NotSupportedException, SystemException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException {
		
		ConfigurableApplicationContext ctx = SpringApplication.run(HibernateApplication.class, args);
		
		//EntityManager manager = ctx.getBean(EntityManager.class);
		//TransactionManager txm = ctx.getBean(TransactionManager.class);
		/*
		Employee employee = new Employee("Jram");
		Employee employee2 = new Employee("Krishna");
		
		Depart depart = new Depart("CSE");
		depart.setEmployees(Arrays.asList(employee , employee2));
		manager.getTransaction().begin();
		System.out.println("TXn ");
		manager.persist(depart);
		manager.getTransaction().commit();*/

		HibernateService service = ctx.getBean(HibernateService.class);
		//service.saveEmployee();
		//service.saveDepart();
		//service.getDepart();
		//service.getEmployee();
		//service.saveLaptop();
		//service.saveMac();
		//service.savePizza();
		//service.saveAddons();
		//service.saveProject();
		//service.saveEngineer();
		//service.getLaptop();
		//service.getMacAddress();
		//service.getEngineer();
		//service.getProject();
		//service.getEngineerQuery();
		//service.saveOrder();
		//service.getEngineerCrteriaQuery();
		//service.getEngineerfromRepository();
		//service.getEngineerfromPageRepositoryByName();
		service.getEngineerfromPageRepositoryByCustomName();
	}

}
