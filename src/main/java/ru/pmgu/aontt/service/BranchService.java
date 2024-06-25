package ru.pmgu.aontt.service;

import ru.pmgu.aontt.entity.Branch;

import java.util.List;

public interface BranchService {

    void saveBranch(Branch branch);

    List<Branch> getAllBranches();

    Branch getBranchById(Long id);

}
