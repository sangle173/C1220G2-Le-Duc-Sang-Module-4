package com.example.jp_knife_manager.service;

import com.example.jp_knife_manager.model.KnifeType;
import com.example.jp_knife_manager.repository.KnifeTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KnifeTypeService {

    @Autowired
    private KnifeTypeRepository repository;

    public List<KnifeType> findAll() {
        return repository.findAll();
    }

    public void save(KnifeType knifeType) {
        repository.save(knifeType);
    }

    public static void main(String[] args) {
        KnifeTypeService knifeType = new KnifeTypeService();
        List<KnifeType> knifeTypes = knifeType.findAll();
        for (KnifeType k : knifeTypes) {
            System.out.println(k);
        }
    }

    public KnifeType findById(Integer id) {
        return repository.findById(id).orElse(null);
    }
}
