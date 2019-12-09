package com.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.model.Book;

// Otras opciones
//JPARepositories
//CrudRepositories


@Repository //Un bean para el DAO
public interface BookRepository extends MongoRepository<Book, String> {
	
	
}
