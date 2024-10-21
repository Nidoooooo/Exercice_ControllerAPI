package org.exemple.exercice_controllerapi.persistance;


import org.exemple.exercice_controllerapi.classes.Book;
import org.exemple.exercice_controllerapi.service.BookPort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class BookSQLAdapter implements BookPort {

    private final JdbcTemplate jdbc;
    public BookSQLAdapter(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public void saveBook(Book book) {
        String sql ="INSERT INTO book (name, author) VALUES (?, ?)";
        jdbc.update(sql,
                book.getName(),
                book.getAuthor());

    }

    @Override
    public Book findByID(Long id) {
        String sql = "SELECT * FROM book WHERE id = ?";
        return jdbc.queryForObject(sql, new BookRowMapper(),id);
    }

}