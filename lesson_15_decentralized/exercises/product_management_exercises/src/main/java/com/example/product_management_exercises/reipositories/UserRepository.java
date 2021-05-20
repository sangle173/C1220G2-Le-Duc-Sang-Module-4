package com.example.product_management_exercises.reipositories;

import com.example.product_management_exercises.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User getUserByUsername(String username);
}
