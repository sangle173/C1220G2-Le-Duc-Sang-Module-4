package com.example.demo_case.service.service_hotel.service_hotel_impl;

import com.example.demo_case.model.service_hotel.ServiceType;
import com.example.demo_case.repositories.service_hotel.ServiceTypeRepository;
import com.example.demo_case.service.service_hotel.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeServiceImpl implements ServiceTypeService {
    @Autowired
    private ServiceTypeRepository repository;


    @Override
    public List<ServiceType> findAll() {
        return repository.findAll();
    }

    @Override
    public ServiceType findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public ServiceType save(ServiceType serviceType) {
        return repository.save(serviceType);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
