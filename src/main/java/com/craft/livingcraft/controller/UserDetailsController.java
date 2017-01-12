package com.craft.livingcraft.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.craft.livingcraft.model.BillingAddress;
import com.craft.livingcraft.model.ShippingAddress;
import com.craft.livingcraft.model.UserDetails;
import com.craft.livingcraft.services.CategoryService;
import com.craft.livingcraft.services.UserDetailsService;

@Controller
public class UserDetailsController
{
	
	@Autowired
	CategoryService categoryService;
	
//	@RequestMapping("/registration")
//	public String registarion(Model model)
//	{
//		//model.addAttribute("userDetails", new UserDetails());
//		UserDetails userDetails=new UserDetails();
//		BillingAddress billingAddress =new BillingAddress();
//		ShippingAddress shippingAddress= new ShippingAddress();
//		
//		userDetails.setBillingAddress(billingAddress);
//		userDetails.setShippingAddress(shippingAddress);
//		model.addAttribute("userDetails",new UserDetails());
//		
//		return "registration";
//	}
//	
//	@RequestMapping("/addUserDetails")
//	public String addUserDetails(@ModelAttribute ("userDetails") UserDetails userDetails)
//	{
// 	
//		userDetailsService.addUserDetails(userDetails);
//		return "redirect:/registration";
//	}
	
	@RequestMapping("/login")
	public String Login(Model model)
	{
		//to add category dropdown in a subcategory page
				model.addAttribute("categoryList2", categoryService.getCategoryList());
		return "login";
	}
    
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/index";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
	}
}
