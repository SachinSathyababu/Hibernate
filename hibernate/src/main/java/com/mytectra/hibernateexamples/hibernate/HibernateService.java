package com.mytectra.hibernateexamples.hibernate;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import com.mytectra.hibernateexamples.hibernate.Order.Size;

@Component
public class HibernateService {
	
	@Autowired
	EntityManager manager;
	
	@Autowired
	EngineerDao engineerRepository;

	@Transactional()
	public void saveEmployee() {

		Employee employee = new Employee("Jram");
		Employee employee2 = new Employee("Sachin");
		
		Depart depart = new Depart("CSE");
		depart.setId(5);
		//manager.getTransaction().begin();
		depart = manager.merge(depart);
		//manager.persist(depart);
		employee2.setDp(depart);

		manager.persist(employee2);
		//manager.getTransaction().commit();
	}
	@Transactional
	public void saveDepart() {

		Employee employee3 = new Employee("Smith");
		Employee employee4 = new Employee("Scott");
		Employee employee5= new Employee("Jack");
		Employee employee6 = new Employee("Dimitry");
		
		Depart depart = new Depart("ISE");
		depart.setEmployees(Arrays.asList(employee3, employee4, employee5, employee6));
		
		employee3.setDp(depart);
		employee4.setDp(depart);
		employee5.setDp(depart);
		employee6.setDp(depart);
		
		manager.persist(depart);
		
	}
	
	@Transactional
	public void getDepart() {


		Depart depart = manager.find(Depart.class, 21);
		
		for(Employee emp: depart.getEmployees()) {
			System.out.println("Employee Name "+emp.getName());
		} 
	
		System.out.println("Depart id "+depart.getId());
		System.out.println("Depart Name "+depart.getName());
		System.out.println("Depart No of Employees: "+depart.getEmployees().size());
	}
	
	@Transactional
	public void getEmployee() {


		 Employee emp = manager.find(Employee.class, 22);
	
		System.out.println("Employee id "+emp.getId());
		System.out.println("Employee Name "+emp.getName());
		System.out.println("Depart Name is : "+emp.getDp().getName());
	}
	
	@Transactional
	public void saveLaptop() {
		
		Laptop l1= new Laptop("Hp");
		MacAddress m1=new MacAddress("234");
		
		l1.setMac(m1);
		
		manager.persist(l1);
	}
	
	@Transactional
	public void getLaptop() {


		Laptop lap = manager.find(Laptop.class, 35);
	
		System.out.println("Laptop id "+lap.getId());
		System.out.println("Laptop Name "+lap.getName());
		System.out.println("Mac Name is : "+lap.getMac().getName());
	}
	
	
	@Transactional
	public void saveMac() {
		
		Laptop l1= new Laptop("Dell");
		MacAddress m1=new MacAddress("789");
		l1.setMac(m1);
		m1.setLap(l1);
		
		
		manager.persist(m1);
	}
	
	@Transactional
	public void getMacAddress() {


		MacAddress mac = manager.find(MacAddress.class, 34);
	
		System.out.println("Mac id "+mac.getId());
		System.out.println("Mac Name "+mac.getName());
		System.out.println("Laptop Name is : "+mac.getLap().getName());
	}
	
	@Transactional
	public void savePizza() {
		
		Pizza pizza=new Pizza("Corn Pizza", "Spicy Pizza", 450);
		
		manager.persist(pizza);
	}
	
	@Transactional
	public void saveAddons() {
		
		AddOns addons=new AddOns("Coke", "Cool Drink", 45);
		
		manager.persist(addons);
	}
	
	@Transactional
	public void saveProject() {
		
		Engineer eng1= new Engineer("Krishna");
		Engineer eng2= new Engineer("Smith");
		Engineer eng3= new Engineer("Scott");
		
		Project proj1= new Project("CNO");
		proj1.setEngineers(Arrays.asList(eng1, eng2, eng3));
		
		manager.persist(proj1);
		
	}
	
	@Transactional
	public void getProject() {


		Project proj = manager.find(Project.class, 48);
	
		System.out.println("Project id "+proj.getId());
		System.out.println("Project Name "+proj.getName());
		
		for(Engineer eng: proj.getEngineers()) {
		System.out.println("Engineer Name is : "+eng.getName());
		}
	}
	
	@Transactional
	public void saveEngineer() {
		
		Engineer eng1= new Engineer("Krishna");
		
		Project proj1= new Project("CNO");
		Project proj2= new Project("LGB");
		Project proj3= new Project("MTL");
		
		eng1.setProjects(Arrays.asList(proj1,proj2,proj3));
		
		manager.persist(eng1);
		
	}
	

	@Transactional
	public void getEngineer() {
	
		Engineer eng = manager.find(Engineer.class, 9);
	
		System.out.println("Eng id "+eng.getId());
		System.out.println("Eng Name "+eng.getName());
		
		for(Project proj: eng.getProjects()) {
		System.out.println("Project Name is : "+proj.getName());
		}
	}
	
	@Transactional
	public void getEngineerQuery() {


		Query query = manager.createNamedQuery("eng1");
		 List results = query.getResultList();
		 for(Object obj: results) {
			 Object[] slist= (Object[]) obj;
			 for(Object s:slist) {
		System.out.println("Each Value: "+ s.toString());
			 }
		 }
	}
	
	@Transactional
	public void getEngineerCrteriaQuery() {

		CriteriaBuilder builder= manager.getCriteriaBuilder();
		CriteriaQuery<Engineer> query = builder.createQuery(Engineer.class);
		Root<Engineer> path= query.from(Engineer.class);
		
		//query.where(builder.equal(path.get("name"), "Krishna"));
	
		query.where(builder.isNotNull(path.get("name")));
		
		 List<Engineer> results = manager.createQuery(query).getResultList();
		 for(Engineer obj: results) {
			 System.out.println("Engineer Id is "+obj.getId());
			System.out.println("Engineer Name is "+obj.getName());
		 }
	}
	
	@Transactional
	public void saveOrder() {
		
		Order order= new Order();
		order.setSize(Size.LARGE);
		order.setOrderDate(new Date());
		manager.persist(order);
		
	}
	
	@Transactional
	public void getEngineerfromRepository() {
	
		Optional<Engineer> eng= engineerRepository.findById(9);
	
		System.out.println("Eng id "+eng.get().getId());
		System.out.println("Eng Name "+eng.get().getName());
		
		for(Project proj: eng.get().getProjects()) {
		System.out.println("Project Name is : "+proj.getName());
		}
	}
	
	@Transactional
	public void getEngineerfromPageRepositoryByName() {
		
		Pageable firstPageWithTwoElements = PageRequest.of(0, 4, Sort.by("name"));
	
		Page<Engineer> eng= engineerRepository.findAll(firstPageWithTwoElements);
		
		for(Engineer e: eng) {
		System.out.println("Eng id "+e.getId());
		System.out.println("Eng Name "+e.getName());
		
		for(Project proj: e.getProjects()) {
		System.out.println("Project Name is : "+proj.getName());
		}
		}
	}
	
	@Transactional
	public void getEngineerfromPageRepositoryByCustomName() {
		
		Pageable firstPageWithOneElements = PageRequest.of(0, 1, Sort.by("name"));
	
		Page<Engineer> eng= engineerRepository.findEnggByName("Krishna", firstPageWithOneElements);
		
		for(Engineer e: eng) {
		System.out.println("Eng id "+e.getId());
		System.out.println("Eng Name "+e.getName());
		
		for(Project proj: e.getProjects()) {
		System.out.println("Project Name is : "+proj.getName());
		}
		}
	}
}
