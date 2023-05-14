package ru.kpfu.itis.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.model.BookRaiting;
import ru.kpfu.itis.repository.WhatToReadRepository;
import ru.kpfu.itis.service.WhatToReadService;

import java.util.List;

@Service
@AllArgsConstructor
public class WhatToReadServiceImpl implements WhatToReadService {

    private final WhatToReadRepository whatToReadRepository;
    @Override
    public List<BookRaiting> getAll() {
        return whatToReadRepository.getAll();
    }
}