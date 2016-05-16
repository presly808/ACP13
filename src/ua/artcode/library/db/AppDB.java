package ua.artcode.library.db;

import ua.artcode.library.model.Book;
import ua.artcode.library.model.Reader;

import java.util.*;

/**
 * Created by serhii on 14.05.16.
 */
public class AppDB implements ReaderDao, BookDao{

    private Map<Reader, List<Book>> readerBooks;
    private Set<Reader> blackList;
    private List<Book> freeBooks;

    public AppDB() {
        readerBooks = new TreeMap<>();
        blackList = new HashSet<>();
        freeBooks = new ArrayList<>();
    }

    public Map<Reader, List<Book>> getReaderBooks() {
        return readerBooks;
    }

    public void setReaderBooks(Map<Reader, List<Book>> readerBooks) {
        this.readerBooks = readerBooks;
    }

    public Set<Reader> getBlackList() {
        return blackList;
    }

    public void setBlackList(Set<Reader> blackList) {
        this.blackList = blackList;
    }

    public List<Book> getFreeBooks() {
        return freeBooks;
    }

    public void setFreeBooks(List<Book> freeBooks) {
        this.freeBooks = freeBooks;
    }

    @Override
    public Book createBook(Book book) {
        return null;
    }

    @Override
    public boolean deleteBook(int id) {
        return false;
    }

    @Override
    public Book findBook(int id) {
        return null;
    }

    @Override
    public List<Book> allBooks() {
        return null;
    }

    @Override
    public Reader createReader(Reader reader) {
        return null;
    }

    @Override
    public boolean deleteReader(int readerId) {
        return false;
    }

    @Override
    public Reader findReader(int id) {
        return null;
    }

    @Override
    public List<Reader> allReaders() {
        return null;
    }
}
