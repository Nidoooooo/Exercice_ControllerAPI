package org.exemple.exercice_controllerapi.controllers;

import jakarta.validation.Valid;
import org.exemple.exercice_controllerapi.classes.Book;
import org.exemple.exercice_controllerapi.classes.BookRequest;
import org.exemple.exercice_controllerapi.classes.BookResponse;
import org.exemple.exercice_controllerapi.classes.Shelf;
import org.exemple.exercice_controllerapi.service.BookUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;     


@RestController
public class Controller {

    Shelf shelf = new Shelf();


    //private final BookUseCase bookUseCase;

    @DeleteMapping(path = "/books/{bookname}")
    public ResponseEntity<Void> deleteBook(@Valid @PathVariable String bookname){
        for (Book book : shelf.getBooks()) {
            if (book.getName() == bookname) {
                List<Book> listtemp = new ArrayList<>();
                listtemp = shelf.getBooks();
                listtemp.remove(book);
                shelf.setBooks(listtemp);
                book = null;
            }
        }
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
    @PostMapping(path = "/books")
    public ResponseEntity<Void> addBook(@Valid @RequestBody BookRequest bookRequest){
        Book book = bookRequest.toEntity();
        shelf.addBook(book);
        String url = "http://localhost:8090/books/"+book.getName();
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Location",url)
                .build();
    }
    @GetMapping("/books")
    public ResponseEntity<List<BookResponse>> books(){
        List<BookResponse> listBook = shelf.getBooks().stream()
                .map(BookResponse::fromEntity)
                .toList();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(listBook);
    }

    @GetMapping("/books/{bookname}")
    public ResponseEntity<BookResponse> book(@PathVariable String bookname){
        for (Book book : shelf.getBooks()){
            if(Objects.equals(bookname, book.getName())){
                BookResponse bookResponse = BookResponse.fromEntity(book);
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(bookResponse);
            }
        }
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(null);
    }
}
