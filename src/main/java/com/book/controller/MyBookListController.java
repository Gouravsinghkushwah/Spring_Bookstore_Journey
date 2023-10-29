package com.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
 
import com.book.service.MyBookListService;

@Controller
public class MyBookListController {

	
	@Autowired
	private MyBookListService service;
	
	@GetMapping("/deleteMyList/{id}")
	public String deleteMyList(@PathVariable("id") int id)
	{
		service.deleteById(id);
		return "redirect:/my_books";
	}
	
 
	
}
