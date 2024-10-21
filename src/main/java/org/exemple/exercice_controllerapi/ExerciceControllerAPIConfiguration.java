package org.exemple.exercice_controllerapi;

import org.exemple.exercice_controllerapi.service.BookPort;
import org.exemple.exercice_controllerapi.service.BookService;
import org.exemple.exercice_controllerapi.service.BookUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExerciceControllerAPIConfiguration {
    @Autowired
    private BookPort bookPort;

    @Bean
    BookUseCase bookUseCase() {
        return new BookService(bookPort);
    }
}
