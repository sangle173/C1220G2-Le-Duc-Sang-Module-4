package com.example.demo_case.service.contract.impl;

import com.example.demo_case.model.contract.AttachService;
import com.example.demo_case.repositories.contract.AttachServiceRepository;
import com.example.demo_case.service.contract.AttachServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachServiceImpl implements AttachServiceService {

    @Autowired
    private AttachServiceRepository repository;

    @Override
    public List<AttachService> findAll() {
        return repository.findAll();
    }

    @Override
    public AttachService findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public AttachService save(AttachService attachService) {
        return repository.save(attachService);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
