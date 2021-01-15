package com.csi.jpa;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Service {
	
	public static SessionFactory factory = new Configuration().configure().buildSessionFactory();
	
	
	public static void main(String[] args) {
		
		saveData();
		getData();
		
	}
	public static void saveData()
	{
		Session session = factory.openSession();
		Transaction transaction= session.beginTransaction();
		Customer c1 = new Customer();
		c1.setCustId(101);
		c1.setCustName("Manish");
		c1.setCustPhnno(123465487l);
		session.save(c1);
		transaction.commit();
	}
	
	public static void getData()
	{
		Session session = factory.openSession();
		List<Customer> customerList = session.createQuery("from Customer").list();
		customerList.forEach(cust -> System.out.println(cust));
	}

}
