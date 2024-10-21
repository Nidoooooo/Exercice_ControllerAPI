package org.exemple.exercice_controllerapi.service;

import org.exemple.exercice_controllerapi.classes.Book;

import java.util.List;

public interface BookUseCase {
    Book findBookByName(String name);
    List<Book> findAll();
    Book save(Book book);
    void delete(Book book);
}
