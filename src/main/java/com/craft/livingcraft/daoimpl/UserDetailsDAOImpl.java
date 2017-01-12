package com.craft.livingcraft.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.craft.livingcraft.dao.UserDetailsDAO;
import com.craft.livingcraft.model.BillingAddress;
import com.craft.livingcraft.model.Cart;
import com.craft.livingcraft.model.ShippingAddress;
import com.craft.livingcraft.model.User;
import com.craft.livingcraft.model.UserDetails;
import com.craft.livingcraft.model.UserRole;

@Repository
public class UserDetailsDAOImpl implements UserDetailsDAO 
{

	@Autowired
	SessionFactory sessionFactory;
	
	public UserDetailsDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	public void addUserDetails( UserDetails userDetails) 
	{
		
		Session session =sessionFactory.getCurrentSession();
		User user=new User();
		user.setUserId(userDetails.getUserId());
		user.setUserName(userDetails.getUserName());
		user.setUserPassword(userDetails.getPassword());
		user.setEnabled(true);
		session.saveOrUpdate(user);
		
		Cart cart=new Cart();
		cart.setCartId(user.getUserId());
		cart.setUserId(user.getUserId());
		
		session.saveOrUpdate(cart);
		
		UserRole userRole=new UserRole();
		userRole.setUserId(user.getUserId());
		userRole.setRoleId(1);
		session.saveOrUpdate(userRole);
		
		
//		userDetails.getBillingAddress().setUserDetails(userDetails);
//		session.saveOrUpdate(userDetails.getBillingAddress());
//		
//		userDetails.getShippingAddress().setUserDetails(userDetails);
//		session.saveOrUpdate(userDetails.getShippingAddress());
//		
		userDetails.setUserId(user.getUserId());
		userDetails.setCartId(cart.getCartId());
		session.saveOrUpdate(userDetails);
		
		session.flush();
	}
	
	public void saveBillingAddress(BillingAddress billingAddress)
	{
		sessionFactory.getCurrentSession().saveOrUpdate(billingAddress);
	}
	
	public void saveShippingAddress(ShippingAddress shippingAddress)
	{
		sessionFactory.getCurrentSession().saveOrUpdate(shippingAddress);
	}
	
	public UserDetails getUserByName(String userName)
	{
		Session session=sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<UserDetails> userList=session.createQuery("from UserDetails where userName='"+userName+"'").getResultList();
		return userList.get(0);
	}
	

}
