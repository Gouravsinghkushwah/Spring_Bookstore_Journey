package com.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.book.entity.Book;
import com.book.entity.MyBookList;
import com.book.service.BookService;
import com.book.service.MyBookListService;

  
@Controller
public class BookContoller     {
	
	@Autowired
	private BookService service;
	
	@Autowired
	private MyBookListService myBookService;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	@GetMapping("/book_register")
	public String bookRegister()
	{
		return "bookRegsiter";
		
	} 
	@GetMapping("/available_books")
	public ModelAndView getAllBooks()
	{
		List<Book> list = service.getAllBook();
//		ModelAndView model = new ModelAndView();
//		model.setViewName("Book List");
//		model.addObject("Book", list);
		
	 
		return  new ModelAndView("bookList","book",list);
 	}
	
	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b)
	{
		service.save(b);
		
		return "redirect:/available_books";
	}
	
	@GetMapping("/my_books")
	public String getMyBooks(org.springframework.ui.Model m)
	{
		List<MyBookList> list = myBookService.getAllBooks();
	    m.addAttribute("book",list);
		return "myBooks";
	}
	 	
    @GetMapping("/myList/{id}")
    public String getMyList(@PathVariable("id") int id)
    {
    	Book b= service.getBookById(id);
    	MyBookList mb = new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
    	myBookService.saveMyBook(mb);
    	return "redirect:/my_books";
    }
	
	
    
    @GetMapping("/editBook/{id}")
    public String editBoook(@PathVariable("id") int id, Model model) 
    {
    Book b =service.getBookById(id);
    model.addAttribute("book", b);
    	return "bookEdit";
    	
    }
       
    @GetMapping("/deleteBppk/{id}")
    public String deleteBook(@PathVariable("id") int id)
    { 
    	service.deleteBookById(id);
    	return "redirect:/available_books";
    }
	
}
