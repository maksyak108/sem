package ru.kpfu.itis.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.model.Book;
import ru.kpfu.itis.repository.BooksRepository;
import ru.kpfu.itis.service.BooksService;

import java.util.List;
@Service
@AllArgsConstructor
public class BooksServiceImpl implements BooksService {

    private final BooksRepository booksRepository;
    @Override
    public List<Book> getAll() {
        return booksRepository.getAll();
    }

    @Override
    public  List<Book> findBooksByGenre(String genre){ return  booksRepository.findBooksByGenre(genre); }

    @Override
    public  Book findBookByName(String name){ return  booksRepository.findBookByName(name); }
}