package ru.kpfu.itis.service;

import ru.kpfu.itis.model.Book;

import java.util.List;

public interface BooksService {

    List<Book> getAll();

    List<Book> findBooksByGenre(String genre);

    Book findBookByName(String name);
}