package com.example.case_study.repositories.employee;

import com.example.case_study.model.employee.EducationDegree;
import com.example.case_study.model.employee.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationDegreeRepository extends JpaRepository<EducationDegree, Integer> {
}
