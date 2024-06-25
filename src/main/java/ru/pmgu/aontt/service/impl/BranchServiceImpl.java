package ru.pmgu.aontt.service.impl;

import org.springframework.stereotype.Service;
import ru.pmgu.aontt.entity.Branch;
import ru.pmgu.aontt.repository.BranchRepository;
import ru.pmgu.aontt.service.BranchService;

import java.util.List;

@Service
public class BranchServiceImpl implements BranchService {

    private final BranchRepository branchRepository;

    public BranchServiceImpl(final BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    @Override
    public void saveBranch(final Branch branch) {
        branchRepository.save(branch);
    }

    @Override
    public List<Branch> getAllBranches() {
        return branchRepository.findAll();
    }

    @Override
    public Branch getBranchById(final Long id) {
        return branchRepository
                .findById(id)
                .orElseThrow(RuntimeException::new);
    }

}
