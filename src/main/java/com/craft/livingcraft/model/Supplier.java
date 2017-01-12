package com.craft.livingcraft.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.google.gson.annotations.Expose;

@Entity
public class Supplier {
	
	@Id
	@Expose
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int supplierId;
	@Expose
	@NotEmpty(message="*Name is Compulsory")
	private String supplierName;
	@Expose
	@NotEmpty(message="*Address is Compulsory")
	private String supplierAddress;
	@Expose
	@NotEmpty(message="*Contact is Compulsory")
	@Pattern(regexp="^[0-9+]*$", message="*Contact should contain only digits")
	private String supplierContact;
	
	
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getSupplierAddress() {
		return supplierAddress;
	}
	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}
	public String getSupplierContact() {
		return supplierContact;
	}
	public void setSupplierContact(String supplierContact) {
		this.supplierContact = supplierContact;
	}

	
	

}

