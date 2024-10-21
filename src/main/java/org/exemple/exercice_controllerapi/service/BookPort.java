package org.exemple.exercice_controllerapi.service;

import org.exemple.exercice_controllerapi.classes.Book;

public interface BookPort {
    void saveBook(Book book);
    Book findByID(Long id);
}
