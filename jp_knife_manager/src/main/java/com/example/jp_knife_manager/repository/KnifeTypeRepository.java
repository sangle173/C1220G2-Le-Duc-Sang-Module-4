package com.example.jp_knife_manager.repository;

import com.example.jp_knife_manager.model.KnifeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KnifeTypeRepository extends JpaRepository<KnifeType, Integer> {
}
