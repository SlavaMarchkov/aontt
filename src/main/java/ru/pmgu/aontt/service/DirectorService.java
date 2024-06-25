package ru.pmgu.aontt.service;

import ru.pmgu.aontt.entity.Director;

import java.util.List;

public interface DirectorService {

    void saveDirector(Director director);

    List<Director> getAllDirectors();

    Director getDirectorById(Long id);

}
