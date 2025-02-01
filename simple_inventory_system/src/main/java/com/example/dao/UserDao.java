package com.example.dao;

import com.example.inventory.model.User;
import com.example.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class UserDao {

    public boolean validateUser(String username, String password) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "FROM User u WHERE u.username = :username AND u.password = :password";
        Query<?> query = session.createQuery(hql);
        query.setParameter("username", username);
        query.setParameter("password", password);
        User user = (User) query.uniqueResult();
        transaction.commit();
        session.close();
        return user != null;
    }
    public void insert(User user) {
    {
    	Transaction transaction=null;

    	try(Session session=HibernateUtil.getSessionFactory().openSession();)
    	{
    		transaction=session.beginTransaction();
      		
    		session.persist(user);
    		transaction.commit();
    		session.close();
    		
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	
    }
	
		// TODO Auto-generated method stub
		
	}

}
