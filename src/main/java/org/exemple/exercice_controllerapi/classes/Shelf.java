package org.exemple.exercice_controllerapi.classes;

import java.util.ArrayList;
import java.util.List;

public class Shelf {
    private List<Book> books = new ArrayList<>();

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        this.books.add(book);
    }
    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Shelf(){
        books.add(new Book("b0","a0"));
        books.add(new Book("b1","a1"));
        books.add(new Book("b2","a2"));
    }
}
