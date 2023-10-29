package com.book.repository;

 import org.springframework.data.jpa.repository.JpaRepository;
 
import com.book.entity.MyBookList;

public interface MyBookRepository extends JpaRepository<MyBookList, Integer> {

}
