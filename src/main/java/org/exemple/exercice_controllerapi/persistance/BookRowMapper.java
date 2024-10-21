package org.exemple.exercice_controllerapi.persistance;

import org.exemple.exercice_controllerapi.classes.Book;


import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRowMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Book(
                rs.getLong("id")
                ,rs.getString("name"),
                rs.getString("author"));
    }

}
