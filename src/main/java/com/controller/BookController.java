package com.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Book;
import com.service.BookService;

@RestController
@RequestMapping("/v1/api/books")
@CrossOrigin(origins = "*") // Permitir las peticiones desde otro puertos
public class BookController {
	
	// Injectar bean de servicio con operaciones de negocio
	@Autowired
	private BookService service;
	
	@PostMapping
	public ResponseEntity<Book> createBook(@RequestBody Book book) {
		return new ResponseEntity<Book>(
				service.createBook(book),
				HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Book> updateBook(@RequestBody Book book) {
		return new ResponseEntity<Book>(
				service.updateBook(book),
				HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Book> readBook(@PathVariable("id") String id){
		return new ResponseEntity<Book>(
				service.readBook(id),
				HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable String id) {
		service.deleteBook(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping
	public ResponseEntity<Collection<Book>> loadBooks(){
		return new ResponseEntity<Collection<Book>>(
				service.loadBooks(),
				HttpStatus.OK);
	}
}
