package com.example.user_validate.repository;

import com.example.user_validate.model.Profession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProfessionRepository extends JpaRepository<Profession, Integer> {
}
