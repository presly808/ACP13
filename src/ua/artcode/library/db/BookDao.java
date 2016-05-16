package ua.artcode.library.db;

import ua.artcode.library.model.Book;

import java.util.List;

/**
 * Created by serhii on 14.05.16.
 */
public interface BookDao {

    Book createBook(Book book);
    boolean deleteBook(int id);
    Book findBook(int id);
    List<Book> allBooks();

    List<Book> getAvailableBooks();

}
