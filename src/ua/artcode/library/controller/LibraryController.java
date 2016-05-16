package ua.artcode.library.controller;

import ua.artcode.library.exception.LibraryException;
import ua.artcode.library.exception.NoUserFoundException;
import ua.artcode.library.model.Book;
import ua.artcode.library.model.Reader;

import java.util.Date;
import java.util.List;

/**
 * 1) посмотреть список читателей
 2) посмотреть список доступных книг
 3) добавить книгу в библиотеку
 4) добавить читателя в список читателей
 5) выдать книгу читателю (если книга есть в наличии).
 Читателю запрещается брать больше 3-х книг.
 6) посмотреть список книг, которые находятся у читателей
 7) посмотреть список книг, которые находятся у конкретного читателя
 8) добавить читателя в черный список (ему нельзя выдавать книги)
 9) посмотреть книги конкретного автора
 10) посмотреть новые книги (год издания выше 2013)
 */
public interface LibraryController {

    List<Reader> getReaders();
    List<Book> getAvailableBooks();
    boolean addBook(Book book);
    boolean addReader(Reader reader);
    boolean giveBookToReader(int bookId, int readerId) throws LibraryException;
    List<Book> getTakenBooks();
    List<Book> getReaderBooks(int readerId) throws NoUserFoundException;
    boolean addToBlackList(int readerId) throws NoUserFoundException;
    List<Book> search(String author);
    List<Book> search(Date from, Date to);

}
