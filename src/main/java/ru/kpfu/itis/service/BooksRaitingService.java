package ru.kpfu.itis.service;

public interface BooksRaitingService {
    void updateRaiting(Integer number_of_reviews, Double mark, String name);
    Integer getNumberByName(String name);

    Double getMarkByName(String name);
}
