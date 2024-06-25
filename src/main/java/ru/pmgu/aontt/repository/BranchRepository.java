package ru.pmgu.aontt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.pmgu.aontt.entity.Branch;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Long> {
}
