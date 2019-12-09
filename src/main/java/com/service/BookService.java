package com.service;

import java.util.Collection;

import com.model.Book;

public interface BookService /* INJECCION DE DEPENDENCIAS*/ {

	// Definir operaciones de negocio CRUD basicas
	
	public Book createBook(Book book);
	public Book updateBook(Book book);
	public Book readBook(String id);
	public void deleteBook(String id);
	public Collection<Book> loadBooks();
}
