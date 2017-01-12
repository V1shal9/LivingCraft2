package com.craft.livingcraft.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.annotations.Expose;

@Entity
public class Product {
	
	@Id
	@Expose
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	@Expose
	private int categoryId;
	@Expose
	private int subCategoryId;
	@Expose
	private int supplierId;
	@Expose
	@NotEmpty(message="*Name is Compulsory")
	private String productName;
	@Expose
	@NotEmpty(message="Description is Compulsory")
	private String productDescription;
	@Expose
	private int productQuantity;
	@Expose
	private float productPrice;
	@Expose
    private int productDiscount;
    
    @Transient
    List<MultipartFile> productImage;
    
    @ManyToOne
	@JoinColumn(name="categoryId",updatable=false,insertable=false,nullable=false)
	private Category category;
    
    @ManyToOne
	@JoinColumn(name="subCategoryId",updatable=false,insertable=false,nullable=false)
	private SubCategory subCategory;
    

	public List<MultipartFile> getProductImage() {
		return productImage;
	}

	public void setProductImage(List<MultipartFile> productImage) {
		this.productImage = productImage;
	}

	@ManyToOne
	@JoinColumn(name="supplierId",updatable=false,insertable=false,nullable=false)
	private Supplier supplier;
    

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
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

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public SubCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}


}
