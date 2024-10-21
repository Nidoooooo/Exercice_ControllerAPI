package org.exemple.exercice_controllerapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.exemple.exercice_controllerapi.classes.Book;
import org.exemple.exercice_controllerapi.controllers.Controller;
import org.exemple.exercice_controllerapi.service.BookUseCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


//@SpringBootTest
@WebMvcTest(controllers = Controller.class)
class ExerciceControllerApiApplicationTests {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    BookUseCase bookUseCase;

    @Test
    @DisplayName("GET http://localhost:8090/books/b0")
    void getBook() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/books/b0"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("b0"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.author").value("a0"));
    }

    @Test
    @DisplayName("POST Book2")
    void postBook() throws Exception {
        Book book = new Book("b2","a2");

        String bookjson = new ObjectMapper().writeValueAsString(book);
        String url = "http://localhost:8090/books/b2";
        mockMvc.perform(MockMvcRequestBuilders.post("/books")
                .content(bookjson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    @DisplayName("DELETE http://localhost:8090/books/b1")
    void deleteBook() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/books/b1"))
                .andExpect(MockMvcResultMatchers.status().isNoContent());

    }

    @Test
    @DisplayName("POST Book2 - Error")
    public void postBookError() throws Exception {
        String bookjson = "{\"name\":\"b3\"}";
        String url = "http://localhost:8090/books/b2";
        mockMvc.perform(MockMvcRequestBuilders.post("/books")
                        .content(bookjson)
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(MockMvcResultMatchers.status().isBadRequest())
                        .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("400"))
                        //.andExpect(MockMvcResultMatchers.jsonPath("$.errors").value("{fieldName=author, message=must not be null, rejectedValue=null}"))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.errors[0].fieldName").value("author"))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.errors[0].message").value("must not be null"));


    }
}
