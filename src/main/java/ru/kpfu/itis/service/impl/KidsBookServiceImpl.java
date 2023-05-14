package ru.kpfu.itis.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.model.KidsBook;
import ru.kpfu.itis.repository.KidsBookRepository;
import ru.kpfu.itis.service.KidsBookService;

import java.util.List;

@Service
@AllArgsConstructor
public class KidsBookServiceImpl implements KidsBookService {

    private final KidsBookRepository kidsBookRepository;
    @Override
    public List<KidsBook> getAll() {
        return kidsBookRepository.getAll();
    }
}
