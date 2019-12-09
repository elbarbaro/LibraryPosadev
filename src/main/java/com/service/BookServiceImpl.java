package com.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.BookRepository;
import com.model.Book;

@Service // Bean de logica de negocios
public class BookServiceImpl implements BookService {

	@Autowired // Necesito un bean que se llama con este nombre de clase (DAMELOOO SPRING)
	private BookRepository repository;
	
	@Override
	public Book createBook(Book book) {
		return repository.insert(book);
	}

	@Override
	public Book updateBook(Book book) {
		// ObjectId es controlado por la anotacion @Id
		//Manejo de Optionals (NullPointerException)
		
		Book existingBook = repository.findById(book.getId()).get();
		
		// Version documento
		existingBook.setAuthor(book.getAuthor());
		existingBook.setName(book.getName());
		existingBook.setEditorial(book.getEditorial());
		existingBook.setISBN(book.getISBN());
		existingBook.setReleaseDate(book.getReleaseDate());
		
		return repository.save(existingBook);
	}

	@Override
	public Book readBook(String id) {
		return repository.findById(id).get();
	}

	@Override
	public void deleteBook(String id) {
		repository.deleteById(id);
		
	}

	@Override
	public Collection<Book> loadBooks() {
		//Regresar toda la coleccion
		return repository.findAll();
	}

}
