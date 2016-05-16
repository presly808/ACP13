package ua.artcode.library.test;

import ua.artcode.library.controller.LibraryController;
import ua.artcode.library.model.Book;

/**
 * Created by serhii on 14.05.16.
 */
public class TestController {


    public static void main(String[] args) {
        LibraryController controller = null;

        System.out.println("add book test " +
                controller.addBook(new Book("Java 8", 2012, "Bloch")));
        System.out.println("add book test negative " +
                controller.addBook(null));
    }
}
