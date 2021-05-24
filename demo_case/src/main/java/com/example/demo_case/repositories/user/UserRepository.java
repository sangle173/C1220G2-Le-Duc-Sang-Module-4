package com.example.demo_case.repositories.user;


import com.example.demo_case.model.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User getUserByUsername(String username);
}
