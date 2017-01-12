package com.craft.livingcraft.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.craft.livingcraft.daoimpl.CartItemDAOImpl;
import com.craft.livingcraft.model.CartItem;

@Service
@Transactional
public class CartItemService 
{
	@Autowired
	CartItemDAOImpl cartItemDAOImpl;
	
	public void addCartItem(CartItem cartItem) 
	{
		cartItemDAOImpl.addCartItem(cartItem);
	}
	public CartItem getCartItemById(int cartItemId)
	{
		return cartItemDAOImpl.getCartItemById(cartItemId);
	}
	public void updateProductQuantity(int productId)
	{
		cartItemDAOImpl.updateProductQuantity(productId);
	}
	
		

}
