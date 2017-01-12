package com.craft.livingcraft.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import com.craft.livingcraft.model.BillingAddress;
import com.craft.livingcraft.model.ShippingAddress;
import com.craft.livingcraft.model.UserDetails;
import com.craft.livingcraft.services.UserDetailsService;



@Component
public class WebFlowHandler 
{
	
	@Autowired
	BillingAddress billingAddress;
	
	@Autowired
	ShippingAddress shippingAddress;
	
	@Autowired
	UserDetailsService userDetailsService;
	
	
   public UserDetails initFlow()
   {
	   return new UserDetails();
   }
   
   public String validateDetails(UserDetails userDetails,MessageContext messageContext)
   {
	   
	   String status="success";
	   if(userDetails.getUserName().isEmpty())
	   {
		   messageContext.addMessage(new MessageBuilder().error().source("userName")
	      .defaultText("*username can not be empty").build());
		   status="failure";
	   }
	   if(userDetails.getPassword().isEmpty())
	   {
		   messageContext.addMessage(new MessageBuilder().error().source("password")
	      .defaultText("*password can not be empty").build());
		   status="failure";
	   }
	   else if(userDetails.getPassword().length()<6||userDetails.getPassword().length()>10)
	   {
		   messageContext.addMessage(new MessageBuilder().error().source("password")
				   .defaultText("*password has to be more than 6 letters and less than 10").build());
		   status="failure";
	   }
	   
	   if(userDetails.getFname().isEmpty())
	   {
		   messageContext.addMessage(new MessageBuilder().error().source("fname")
	      .defaultText("*first name can not be empty").build());
		   status="failure";
	   }
	   if(userDetails.getLname().isEmpty())
	   {
		   messageContext.addMessage(new MessageBuilder().error().source("lname")
	      .defaultText("*last name can not b empty").build());
		   status="failure";
	   }
	   if(userDetails.getContact().isEmpty())
	   {
		   messageContext.addMessage(new MessageBuilder().error().source("contact")
	      .defaultText("*contact number can not b empty").build());
		   status="failure";
	   }
	   else if(userDetails.getContact().length()!=10)
	   {
		   messageContext.addMessage(new MessageBuilder().error().source("contact")
	       .defaultText("*contact number hs to be 10 digits").build());
		   status="failure";
	   }
	   if(userDetails.getEmail().isEmpty())
	   {
		   messageContext.addMessage(new MessageBuilder().error().source("email")
	      .defaultText("*email address can not b empty").build());
		   status="failure";
	   }
//	   else if(userDetails.getEmail().contains("@")&&userDetails.getEmail().contains(".com"))
//	   {
//		   messageContext.addMessage(new MessageBuilder().error().source("email")
//		   .defaultText("*email address is not valid").build());
//		   status="failure";
//	   }
	   
	   
	   return status;
   }
   
   public String addBillingAddress(BillingAddress billingAddress)
   {
	    this.billingAddress.setBillingId(billingAddress.getBillingId());	    
	    this.billingAddress.setCity(billingAddress.getCity());
	    this.billingAddress.setStreetAddress(billingAddress.getStreetAddress());
	    this.billingAddress.setState(billingAddress.getState());
	    this.billingAddress.setPostalCode(billingAddress.getPostalCode());
	    
	    return "submit";
   }
   
   public String addShippingAddress(ShippingAddress shippingAddress)
   {
	    this.shippingAddress.setShippingId(shippingAddress.getShippingId());	    
	    this.shippingAddress.setCity(shippingAddress.getCity());
	    this.shippingAddress.setStreetAddress(shippingAddress.getStreetAddress());
	    this.shippingAddress.setState(shippingAddress.getState());
	    this.shippingAddress.setPostalCode(shippingAddress.getPostalCode());
	    
	    return "submit";
   }
   
   public String AddDetails(UserDetails userDetails,BillingAddress billingAddress, ShippingAddress shippingAddress)
   {
	   userDetailsService.addUserDetails(userDetails);
	   
	   shippingAddress.setUserDetails(userDetails);
	   userDetails.setShippingAddress(shippingAddress);
	   this.shippingAddress.setUserDetails(userDetails);
	   
	   billingAddress.setUserDetails(userDetails);
	   userDetails.setBillingAddress(billingAddress);
	   this.billingAddress.setUserDetails(userDetails);
	   
	   userDetails.setBillingAddress(billingAddress);
	   userDetails.setShippingAddress(shippingAddress);
	   
       userDetailsService.saveBillingAddress(billingAddress);
       userDetailsService.saveShippingAddress(shippingAddress);
       
	   userDetailsService.addUserDetails(userDetails);

       
	   return "submit";
	   
   }
   
   
}
