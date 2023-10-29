package com.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.entity.MyBookList;
import com.book.repository.MyBookRepository;

@Service
public class MyBookListService {

	@Autowired
	private MyBookRepository myBook;
	
	
	public void saveMyBook(MyBookList book)
	{
		myBook.save(book);
	}
	
	public List<MyBookList> getAllBooks()
	{
		return myBook.findAll();
	}
	
	public void deleteById(int id)
	{
		myBook.deleteById(id);
	}
}
