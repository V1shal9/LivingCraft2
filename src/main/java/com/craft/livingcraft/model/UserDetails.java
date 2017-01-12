package com.craft.livingcraft.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.google.gson.annotations.Expose;

@Entity
public class UserDetails implements Serializable
{
    @Id
    @Expose
    private int userId;
    @Expose
    private int cartId;
    @Expose
    private String userName;
    @Expose
    private String password;
    @Expose
    private String fname;
    @Expose
    private String lname;
    @Expose
    private String contact;
    @Expose
    private String email;
	
    
    @OneToOne
	@JoinColumn(name="shippingId")
    private ShippingAddress shippingAddress;
    
    @OneToOne
	@JoinColumn(name="billingId")
    private BillingAddress billingAddress;
    
    @OneToOne
	@JoinColumn(name="cartId",updatable=false,insertable=false,nullable=false)
    private Cart cart;
    
    @OneToOne
	@JoinColumn(name="userId",updatable=false,insertable=false,nullable=false)
    private User user;
    
    
    
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public BillingAddress getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
    
    

}
