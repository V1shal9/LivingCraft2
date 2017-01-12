package com.craft.livingcraft.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class ProductDetails 
{
	 @Id
     private int productId;
     private String productName;
     private String productDetail;
     private String productDescripton;
     private int productPrice;
     private int productDiscount;
     
     @OneToOne
 	 @JoinColumn(name="productId",updatable=false,insertable=false,nullable=false)
     private Product product;
     
     @Transient
     MultipartFile productImage1;
     
     @Transient
     MultipartFile productImage2;
     
     @Transient
     MultipartFile productImage3;
     
  
     

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	
	public String getProductDetail() {
		return productDetail;
	}

	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}

	public String getProductDescripton() {
		return productDescripton;
	}

	public void setProductDescripton(String productDescripton) {
		this.productDescripton = productDescripton;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductDiscount() {
		return productDiscount;
	}

	public void setProductDiscount(int productDiscount) {
		this.productDiscount = productDiscount;
	}

	public MultipartFile getProductImage1() {
		return productImage1;
	}

	public void setProductImage1(MultipartFile productImage1) {
		this.productImage1 = productImage1;
	}

	public MultipartFile getProductImage2() {
		return productImage2;
	}

	public void setProductImage2(MultipartFile productImage2) {
		this.productImage2 = productImage2;
	}

	public MultipartFile getProductImage3() {
		return productImage3;
	}

	public void setProductImage3(MultipartFile productImage3) {
		this.productImage3 = productImage3;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}
     
     
     
     
     
     
}
