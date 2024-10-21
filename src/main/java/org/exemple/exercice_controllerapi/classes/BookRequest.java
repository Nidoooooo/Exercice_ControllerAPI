package org.exemple.exercice_controllerapi.classes;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BookRequest {
    @NotNull
    private String name;
    @NotNull
    private String author;

    public Book toEntity() {
        return Book.builder().name(name).author(author).build();
    }
}
