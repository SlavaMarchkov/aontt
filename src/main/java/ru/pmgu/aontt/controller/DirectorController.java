package ru.pmgu.aontt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.pmgu.aontt.entity.Director;
import ru.pmgu.aontt.service.DirectorService;

import java.util.List;

@RestController
public class DirectorController {

    private final DirectorService directorService;

    @Autowired
    public DirectorController(final DirectorService directorService) {
        this.directorService = directorService;
    }

    @GetMapping(path = "/directors") // GET http://localhost:8080/directors
    public ResponseEntity<List<Director>> getAllDirectors() {
        return ResponseEntity.ok(directorService.getAllDirectors());
    }

    @GetMapping("/directors/{id}") // GET http://localhost:8080/directors/1
    public ResponseEntity<Director> getDirectorById(@PathVariable Long id) {
        Director director = directorService.getDirectorById(id);
        if (director == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(director);
    }

}
