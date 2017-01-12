package com.craft.livingcraft.controller;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.craft.livingcraft.model.Category;
import com.craft.livingcraft.model.SubCategory;
import com.craft.livingcraft.model.Supplier;
import com.craft.livingcraft.model.ViewProduct;
import com.craft.livingcraft.model.Product;
import com.craft.livingcraft.services.CategoryService;
import com.craft.livingcraft.services.ProductService;
import com.craft.livingcraft.services.SubCategoryService;
import com.craft.livingcraft.services.SupplierService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@Controller
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	SubCategoryService subCategoryService;
	
	@Autowired
	SupplierService supplierService;
	
	@RequestMapping(value = "/product")
	   public String Product(Model model) {
		
		model.addAttribute("product",new Product());
		model.addAttribute("category", new Category());
		model.addAttribute("subCategory",new SubCategory());
		model.addAttribute("supplier",new Supplier());

//		model.addAttribute("productList",productService.getProductList());
		model.addAttribute("categoryList",categoryService.getCategoryList());
		model.addAttribute("subCategoryList",subCategoryService.getSubCategoryList());
		model.addAttribute("supplierList",supplierService.getSupplierList());
		
		//to add category dropdown in a subcategory page
				model.addAttribute("categoryList2", categoryService.getCategoryList());

		model.addAttribute("productList",productService.getJsonList());
//		model.addAttribute("categoryList",categoryService.getJsonList());
//	    model.addAttribute("subCategoryList",subCategoryService.getJsonList());
//		model.addAttribute("supplierList",supplierService.getJsonList());

	
	    return "product";
	      
	      
	   }
	
	
	   
	   @RequestMapping(value = "/addProduct")
	   public String addProduct(@Valid @ModelAttribute("product")Product product, BindingResult bindingResult, Model model,@RequestParam("file") List<MultipartFile> productImage) {
		   if(bindingResult.hasErrors())
		   {
			   model.addAttribute("productList", productService.getJsonList());
			   return "product";
		   }
		   else
		   {
			Category category=categoryService.getCategoryByName(product.getCategory().getCategoryName());
			SubCategory subCategory=subCategoryService.getSubCategoryByName(product.getSubCategory().getSubCategoryName());
			Supplier supplier=supplierService.getSupplierByName(product.getSupplier().getSupplierName());

			product.setCategory(category);
			product.setCategoryId(category.getCategoryId());
			
			product.setSubCategory(subCategory);
			product.setSubCategoryId(subCategory.getSubCategoryId());
		
			product.setSupplier(supplier);
			product.setSupplierId(supplier.getSupplierId());
			
	
	        productService.addProduct(product);
	            List<MultipartFile> file=productImage;
	            for(int i=0;i<=file.size();i++)
	            	
	            try
	            {
	            	
	            	MultipartFile filedetails=file.get(i);
	            	String path="F:\\DTproject\\LivingCraft\\src\\main\\webapp\\resources\\images\\";
		            path=path+String.valueOf(product.getProductId())+"-"+i+".jpg";
		            File f=new File(path);
	               	byte[] bytes=filedetails.getBytes();
	            	FileOutputStream fos=new FileOutputStream(f);
	            	BufferedOutputStream bos=new BufferedOutputStream(fos);
	            	bos.write(bytes);
	            	bos.close();
	            	System.out.println("File Uploaded succesfully");
	            	
	            }
	            catch (Exception e) {
	            	e.printStackTrace();
  				}
	        
	      	      return "redirect:product";
		   }
	   }
	   
	   @RequestMapping(value ="editProduct-{productId}")
	   
	   public String editProduct(Model model,@PathVariable("productId")int productId)
	   {
		   model.addAttribute("product",productService.getProductById(productId));
		   model.addAttribute("categoryList",categoryService.getCategoryList());
		   model.addAttribute("subCategoryList",subCategoryService.getSubCategoryList());
		   model.addAttribute("supplierList",supplierService.getSupplierList());

		   return "product";
	   }
	   	   
	   @RequestMapping(value="deleteProduct-{productId}")
	   public String deleteProduct(@PathVariable("productId") int productId)
	   {
		   productService.deleteProduct(productId);
		   return "redirect:/product";
	   }
	   
	   @RequestMapping(value="viewproduct--{productId}")
	   public String viewProduct(Model model, @PathVariable("productId")int productId)
	   {
			model.addAttribute("categoryList2", categoryService.getCategoryList());
			
			//ViewProduct viewProduct=productService.getViewProductById(productId);
		   Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		   String prd=gson.toJson(productService.getViewProductById(productId));
		   model.addAttribute("product", prd);
//         model.addAttribute("p",p);
		   return "viewproduct";
	   }
	   
	
}

