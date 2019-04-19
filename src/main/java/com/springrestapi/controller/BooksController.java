package com.springrestapi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrestapi.dao.BooksInfoDAO;
import com.springrestapi.model.BooksInfo;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController { /*Controller class here we define all the necessary routing for API and URL mappings */
	
	@Autowired
	BooksInfoDAO booksDao;
	
	/*
	 * @RequestMapping("/") public String home(){ return "Hello World!"; }
	 */
	
	/*1) To Save an Book*/
	@PostMapping("/add")
	public BooksInfo createBook(@Valid @RequestBody BooksInfo bks) {
		return booksDao.save(bks);
	}
	
	/*2) delete a book by barcode*/
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<BooksInfo> deleteBook(@PathVariable(value = "id") Long barCode) {
		
		BooksInfo bks = booksDao.findOne(barCode);
		if(bks == null) {
			return ResponseEntity.notFound().build();
		}
		booksDao.delete(bks);
		
		return ResponseEntity.ok().build();		
	}
	
	/*3) Get Book By barcode */
	@GetMapping("/search/{id}")
	public ResponseEntity<BooksInfo> getBookByBarCode(@PathVariable(value="id") Long barCode){
		BooksInfo bks = booksDao.findOne(barCode);
		if(bks == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(bks);
	}
	
	/*get all books*/
	@GetMapping("/allbooks")
	public List<BooksInfo> getAllBooks(){
		return booksDao.findAll();
	}
}
