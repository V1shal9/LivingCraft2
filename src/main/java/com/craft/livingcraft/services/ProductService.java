package com.craft.livingcraft.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.craft.livingcraft.daoimpl.ProductDAOImpl;
import com.craft.livingcraft.model.Product;
import com.craft.livingcraft.model.ViewProduct;


@Service
@Transactional

public class ProductService {
	@Autowired
	ProductDAOImpl productDAOImpl;
	
	public void addProduct(Product product)
	{
		productDAOImpl.addProduct(product);
	}
	public List<Product> getProductList()
	{
		return productDAOImpl.getProductList();
	}
	public Product getProductById(int productId)
	{
		return productDAOImpl.getProductById(productId);
	}
	
	public void deleteProduct(int productId)
	{
		productDAOImpl.deleteProduct(productId);
	}

	public String getJsonList()
	{
		return productDAOImpl.getJsonList();
	}
	
	public ViewProduct getViewProductById(int productId)
	{
		return productDAOImpl.getViewProductById(productId);
	}


	
	
}
