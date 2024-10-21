package org.exemple.exercice_controllerapi.controllers;

import jakarta.validation.Valid;
import org.exemple.exercice_controllerapi.classes.Book;
import org.exemple.exercice_controllerapi.classes.BookRequest;
import org.exemple.exercice_controllerapi.classes.BookResponse;
import org.exemple.exercice_controllerapi.service.BookUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class Controller {
private List<Book> books = new ArrayList<>();
private BookUseCase bookUseCase;



    @DeleteMapping(path = "/books/{id}")
    public ResponseEntity<Void> deleteBook(@Valid @PathVariable Long id) {
        books.remove(id-1);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
    @PostMapping(path = "/books")
    public ResponseEntity<Void> addBook(@Valid @RequestBody BookRequest bookRequest){
        Book book = bookRequest.toEntity();
        bookUseCase.save(book);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }
    @GetMapping("/books")
    public ResponseEntity<List<BookResponse>> books(){
        List<BookResponse> listBook = books.stream()
                .map(BookResponse::fromEntity)
                .toList();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(listBook);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<BookResponse> book(@PathVariable Long id){
        Book book = bookUseCase.findByID(id);

        BookResponse bookResponse = BookResponse.fromEntity(book);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(bookResponse);
    }
}
