package com.demo.pizza.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.pizza.domain.Order;
import com.demo.pizza.domain.Pizza;
import com.demo.pizza.domain.Topping;

@Repository
public class OrderRepoImpl implements OrderRepo{
	
	@Autowired
	private SessionFactory sessionFactory;

	
	public boolean placeOrder(Order order) throws Exception {

		Session session = this.sessionFactory.getCurrentSession();
			try {
				Random rnd = new Random();
				 int n = 100000 + rnd.nextInt(900000);
				 order.setOrderNo(String.valueOf(n));
				 session.persist(order);
				/* 
				 */
				
				/*Query query = session.createSQLQuery("INSERT INTO order (Oid,orderStatus,shipmentCharge,pizzaId,custId) VALUES (?,?,?,?,?)");
				query.setInteger(0,n);
				query.setString(1,orderDTO.getOrderStatus());
				query.setInteger(2, orderDTO.getShipmentCharge());
				query.setInteger(3, orderDTO.getPizzaId());
				query.setInteger(4, orderDTO.getCustId());
				query.executeUpdate();
				 tx.commit();*/
			}catch(Exception ex){
				 ex.printStackTrace();
				 return false;
			}
			return true;
	}

	
	public List<Pizza> getPizzaList() throws Exception {
		List<Pizza> list = new ArrayList<Pizza>();
        Session session = sessionFactory.getCurrentSession();      
        try {
            list =(List<Pizza>)session.createQuery("from Pizza").list();    
            System.out.println("getPizzaList method called list size"+list.size());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return list;
	}

	
	public List<Topping> getToppingList() throws Exception {
		List<Topping> list = new ArrayList<Topping>();
        Session session = sessionFactory.getCurrentSession();      
        try {
            list =(List<Topping>)session.createQuery("from Topping").list();   
            System.out.println("getToppingList method called list size"+list.size());                     
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return list;
	}


	public List<Order> getOrderDetails(Order order) throws Exception {
		List<Order> list = new ArrayList<Order>();
        Session session = sessionFactory.getCurrentSession();      
        try {
            list =(List<Order>)session.createQuery("from Order where orderNo='"+order.getOrderNo()+"'").list();   
            System.out.println("getOrderDetails method called list size"+list.size());                     
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return list;
	}
	
	

}
