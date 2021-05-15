package com.example.jp_knife_manager.repository;

import com.example.jp_knife_manager.model.Knife;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KnifeRepository extends JpaRepository<Knife, Integer> {
}
