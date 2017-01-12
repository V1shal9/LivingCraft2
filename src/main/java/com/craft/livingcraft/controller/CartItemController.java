package com.craft.livingcraft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.craft.livingcraft.model.CartItem;
import com.craft.livingcraft.model.Product;
import com.craft.livingcraft.services.CartItemService;
import com.craft.livingcraft.services.ProductService;
import com.craft.livingcraft.services.UserDetailsService;

@Controller
public class CartItemController 
{
	@Autowired
	CartItemService cartItemService;
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	ProductService productService;
	
	@RequestMapping("buynow-{productId}")
	public String buyNow(@PathVariable("productId")int productId,@ModelAttribute("cartItem")CartItem cartItem,Model model,@RequestParam("userId")int userId,Product product )
	{
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		String userName=auth.getName();
		userId=userDetailsService.getUserByName(userName).getUserId();
		cartItem.setCartId(userId);
		cartItem.setUserId(userId);
		cartItem.setProductId(productId);
		cartItem.setFlag(false);
		cartItem.setProductQuantity(1);
		
		String productName=productService.getProductById(productId).getProductName();
		cartItem.setProductName(productName);
		
		float productPrice=productService.getProductById(productId).getProductPrice();
		cartItem.setProductPrice(productPrice);
		
		int productDiscount=productService.getProductById(productId).getProductDiscount();
		cartItem.setProductDiscount(productDiscount);
		
		cartItem.setFlag(false);
		cartItem.setProductQuantity(1);
	
		cartItemService.addCartItem(cartItem);
		
		cartItemService.updateProductQuantity(productId);
	
		return "buynow";
	}
	
//	@RequestMapping("cartlist-cartItemId")
//	public String CartList(@RequestParam("userId")int userId)
//	{
//		
//	}

}
