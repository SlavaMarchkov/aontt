package ru.pmgu.aontt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.pmgu.aontt.entity.Director;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Long> {
}
