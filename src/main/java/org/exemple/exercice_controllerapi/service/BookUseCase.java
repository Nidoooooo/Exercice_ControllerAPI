package org.exemple.exercice_controllerapi.service;

import org.exemple.exercice_controllerapi.classes.Book;

import java.util.List;

public interface BookUseCase {
    Book findByID(Long id);
    List<Book> findAll();
    void save(Book book);
    void delete(Book book);
}
