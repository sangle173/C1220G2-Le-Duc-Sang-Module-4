package com.example.demo_case.service.contract.impl;

import com.example.demo_case.model.contract.AttachService;
import com.example.demo_case.model.contract.Contract;
import com.example.demo_case.repositories.contract.AttachServiceRepository;
import com.example.demo_case.repositories.contract.ContractRepository;
import com.example.demo_case.service.contract.AttachServiceService;
import com.example.demo_case.service.contract.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractRepository repository;

    @Override
    public List<Contract> findAll() {
        return repository.findAll();
    }

    @Override
    public Contract findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Contract save(Contract contract) {
        return repository.save(contract);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
