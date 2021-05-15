package com.example.jp_knife_manager.service;

import com.example.jp_knife_manager.model.Knife;
import com.example.jp_knife_manager.model.KnifeType;
import com.example.jp_knife_manager.repository.KnifeRepository;
import com.example.jp_knife_manager.repository.KnifeTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KnifeService {

    @Autowired
    private KnifeRepository repository;

    public List<Knife> findAll() {
        return repository.findAll();
    }

    public void save(Knife knife) {
        repository.save(knife);
    }

    public Knife findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public void remove(Integer id) {
        repository.deleteById(id);
    }
}
