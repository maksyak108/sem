package ru.kpfu.itis.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.repository.BooksRaitingRepository;
import ru.kpfu.itis.service.BooksRaitingService;

@Service
@AllArgsConstructor
public class BooksRaitingServiceImpl implements BooksRaitingService {

    private final BooksRaitingRepository booksRaitingRepository;
    @Override
    public void updateRaiting(Integer number_of_reviews, Double mark, String name) {
        booksRaitingRepository.updateRaiting(number_of_reviews, mark, name);
    }
    @Override
    public Integer getNumberByName(String name) {
        return booksRaitingRepository.getNumberByName(name);
    }

    @Override
    public Double getMarkByName(String name) {
        return booksRaitingRepository.getMarkByName(name);
    }
}