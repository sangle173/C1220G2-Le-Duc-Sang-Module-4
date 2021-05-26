package com.example.demo_case.service;

import org.springframework.data.domain.Page;


public interface IPageGeneralService<E> {

    Page<E> findAll(int pageNum, String sortField, String sortDir, String keyword);


}
