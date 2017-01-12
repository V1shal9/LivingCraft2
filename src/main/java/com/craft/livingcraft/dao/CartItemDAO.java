package com.craft.livingcraft.dao;

import com.craft.livingcraft.model.CartItem;

public interface CartItemDAO 
{
    public void addCartItem(CartItem cartItem);
	public CartItem getCartItemById(int cartItemId);

}
