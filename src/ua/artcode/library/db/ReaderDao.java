package ua.artcode.library.db;

import ua.artcode.library.model.Reader;

import java.util.List;

/**
 * Created by serhii on 14.05.16.
 */
public interface ReaderDao {

    Reader createReader(Reader reader);
    boolean deleteReader(int readerId);
    Reader findReader(int id);
    List<Reader> allReaders();

}
