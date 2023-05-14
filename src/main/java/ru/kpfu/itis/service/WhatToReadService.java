package ru.kpfu.itis.service;

import ru.kpfu.itis.model.BookRaiting;

import java.util.List;

public interface WhatToReadService {
    List<BookRaiting> getAll();
}
