package com.example.demo_ajax.repositories;


import com.example.demo_ajax.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository extends JpaRepository<Guest, Long> {
    List<Guest> findGuestsBySurname(String surname);

}
