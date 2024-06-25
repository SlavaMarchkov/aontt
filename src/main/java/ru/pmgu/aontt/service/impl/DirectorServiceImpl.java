package ru.pmgu.aontt.service.impl;

import org.springframework.stereotype.Service;
import ru.pmgu.aontt.entity.Director;
import ru.pmgu.aontt.repository.DirectorRepository;
import ru.pmgu.aontt.service.DirectorService;

import java.util.List;

@Service
public class DirectorServiceImpl implements DirectorService {

    private final DirectorRepository directorRepository;

    public DirectorServiceImpl(final DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    @Override
    public void saveDirector(final Director director) {
        directorRepository.save(director);
    }

    @Override
    public List<Director> getAllDirectors() {
        return directorRepository.findAll();
    }

    @Override
    public Director getDirectorById(final Long id) {
        return directorRepository
                .findById(id)
                .orElseThrow(RuntimeException::new);
    }

}
