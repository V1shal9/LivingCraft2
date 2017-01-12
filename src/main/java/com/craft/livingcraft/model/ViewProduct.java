package com.craft.livingcraft.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import com.google.gson.annotations.Expose;

@Entity
public class ViewProduct 
{
   @Id
   @Expose
   private int productId;
   @Expose
   private String categoryName;
   @Expose
   private String subCategoryName;
   @Expose
   private String supplierName;
   @Expose
   private String productName;
   @Expose
   private String productDescription;
   @Expose
   private float productPrice;
   @Expose
   private int productDiscount;
   @Expose
   private int productQuantity;
   
 
public int getProductId() {
	return productId;
}

public void setProductId(int productId) {
	this.productId = productId;
}

public String getCategoryName() {
	return categoryName;
}

public void setCategoryName(String categoryName) {
	this.categoryName = categoryName;
}

public String getSubCategoryName() {
	return subCategoryName;
}

public void setSubCategoryName(String subCategoryName) {
	this.subCategoryName = subCategoryName;
}

public String getSupplierName() {
	return supplierName;
}

public void setSupplierName(String supplierName) {
	this.supplierName = supplierName;
}

public String getProductName() {
	return productName;
}

public void setProductName(String productName) {
	this.productName = productName;
}

public String getProductDescription() {
	return productDescription;
}

public void setProductDescription(String productDescription) {
	this.productDescription = productDescription;
}

public float getProductPrice() {
	return productPrice;
}

public void setProductPrice(float productPrice) {
	this.productPrice = productPrice;
}

public int getProductDiscount() {
	return productDiscount;
}

public void setProductDiscount(int productDiscount) {
	this.productDiscount = productDiscount;
}

public int getProductQuantity() {
	return productQuantity;
}

public void setProductQuantity(int productQuantity) {
	this.productQuantity = productQuantity;
}


   
}
