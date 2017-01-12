package com.craft.livingcraft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.craft.livingcraft.model.Category;
import com.craft.livingcraft.services.CategoryService;

@Controller
public class MainController 
{
 
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/")
	public String hello(Model model) {
		
		model.addAttribute("category", new Category());
		model.addAttribute("categoryList2", categoryService.getCategoryList());
		return "index";
	}
}
