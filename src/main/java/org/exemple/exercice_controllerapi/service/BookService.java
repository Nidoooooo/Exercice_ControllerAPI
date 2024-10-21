package org.exemple.exercice_controllerapi.service;

import org.exemple.exercice_controllerapi.classes.Book;

import java.util.List;

public class BookService implements BookUseCase {
    private BookPort bookPort;

    public BookService(BookPort bookPort) {this.bookPort = bookPort;}
    @Override
    public Book findByID(Long id) {
        return bookPort.findByID(id);
    }

    @Override
    public List<Book> findAll() {
        return List.of();
    }

    @Override
    public void save(Book book) {
        bookPort.saveBook(book);
    }

    @Override
    public void delete(Book book) {

    }
}
