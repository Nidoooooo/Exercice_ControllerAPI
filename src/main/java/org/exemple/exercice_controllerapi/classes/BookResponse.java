package org.exemple.exercice_controllerapi.classes;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@JsonInclude(NON_NULL)
public class BookResponse {
    private String title;
    private String author;
    public static BookResponse fromEntity(Book book) {
        return BookResponse.builder()
                .title(book.getName())
                .author(book.getAuthor())
                .build();
    }
}
