package org.exemple.exercice_controllerapi.classes;


import jakarta.validation.constraints.NotNull;
import lombok.*;

import javax.management.ConstructorParameters;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Book {
    @NotNull
    private String name;
    @NotNull
    private String author;

    public String toString() {
        return "Book [name=" + name + ", author=" + author + "]";
    }
}
