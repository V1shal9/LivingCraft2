package com.craft.livingcraft.daoimpl;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.craft.livingcraft.dao.ProductDAO;
import com.craft.livingcraft.model.Product;
import com.craft.livingcraft.model.ViewProduct;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Repository
public class ProductDAOImpl implements ProductDAO{
	@Autowired
	SessionFactory sessionFactory;

	public ProductDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	

	public void addProduct(Product product) {
		sessionFactory.getCurrentSession().saveOrUpdate(product);
		
	}

	public List<Product> getProductList() {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Product";
		@SuppressWarnings("unchecked")
		List<Product> plist=session.createQuery(hql).getResultList();
		return plist;	}

	public Product getProductById(int productId) {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Product where productId="+productId;
		@SuppressWarnings("unchecked")
		List<Product> plist=session.createQuery(hql).getResultList();
		return plist.get(0);

	}

	public ViewProduct getViewProductById(int productId) {
		Session session=sessionFactory.getCurrentSession();
		String hql="from ViewProduct where productId="+productId;
		@SuppressWarnings("unchecked")
		List<ViewProduct> plist=session.createQuery(hql).getResultList();
		return plist.get(0);

	}

	public void deleteProduct(int productId) {
		Product producttodelete=new Product();
		producttodelete.setProductId(productId);
		sessionFactory.getCurrentSession().delete(producttodelete);
	}


	public String getJsonList() {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Product";
		@SuppressWarnings("unchecked")
		List<Product> plist=session.createQuery(hql).getResultList();
		Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String jsonList=gson.toJson(plist);
		
		return jsonList;
		
	}
	
	

}



