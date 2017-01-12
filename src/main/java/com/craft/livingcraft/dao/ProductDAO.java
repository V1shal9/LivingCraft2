package com.craft.livingcraft.dao;

import java.util.List;

import com.craft.livingcraft.model.Product;
import com.craft.livingcraft.model.ViewProduct;


public interface ProductDAO {

	public void addProduct(Product product);
	public List<Product> getProductList();
	public Product getProductById(int productId);
	public void deleteProduct(int productId);
	public String getJsonList();
	public ViewProduct getViewProductById(int productId);


	
}
