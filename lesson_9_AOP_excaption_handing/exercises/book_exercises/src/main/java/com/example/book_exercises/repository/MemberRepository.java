package com.example.book_exercises.repository;


import com.example.book_exercises.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
	List<Member> findByMemberName(String memberName);
}
