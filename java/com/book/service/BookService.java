package com.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.entity.Book;
import com.book.repository.BookRepository;

@Service
public class BookService {

	
	@Autowired
	private BookRepository BRepo;
	
	public void save(Book b)
	{
		BRepo.save(b);
	}
	
	
	
	
	public List<Book> getAllBook()
	{
		return BRepo.findAll();
	}
	
	
	public Book getBookById(int id)
	{
		return BRepo.findById(id).get();
	}
	
	public void deleteBookById(int id)
	{
		  BRepo.deleteById(id);
	}
 
	
}


