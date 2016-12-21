package com.demo.pizza.repo;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.pizza.domain.Customer;

@Repository
public class CustomerRepoImpl implements CustomerRepo{


	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean register(Customer customer) throws Exception {

		if(!isUserExists(customer)){
			try {
				Session session = this.sessionFactory.getCurrentSession();
				session.persist(customer);
			    return true;
			}catch(Exception ex){
				 ex.printStackTrace();
				 return false;
			}
			
		}else{
			 return false;
		}
	}

	
	public boolean isUserExists(Customer customer){

		Session session = sessionFactory.getCurrentSession();
		 boolean result = false;
		 try{
			 Query query = session.createQuery("from Customer where custId='"+customer.getCustId()+"'");
			 if(query.list().size()>0){
				 System.out.println("Not null");
				 result = true;
			 }
		 }catch(Exception ex){
			 result = false;
		 }
		 return result;
	}
	
	
	public boolean authenticateUser(Customer customer) throws Exception {
		if(!isUserExists(customer)){
			return false;
		}else{
			return true;
		}
		
	}
		
	
	 public Customer getCustomerByID(Customer customer) throws Exception  { 

		 Session session = sessionFactory.getCurrentSession();
	        try {
	            Query query = session.createQuery("from Customer where custId='"+customer.getCustId()+"'");
	            customer = (Customer)query.uniqueResult();
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	            
	        } 
	        return customer;
	    }
}

