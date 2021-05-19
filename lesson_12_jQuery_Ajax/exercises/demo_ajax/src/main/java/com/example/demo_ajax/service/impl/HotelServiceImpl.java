package com.example.demo_ajax.service.impl;

import com.example.demo_ajax.exeption.GuestFoundException;
import com.example.demo_ajax.model.Guest;
import com.example.demo_ajax.model.HotelData;
import com.example.demo_ajax.repositories.HotelRepository;
import com.example.demo_ajax.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public HotelData getHotelData() {
        HotelData data = new HotelData();
        data.setAddress("Da Nang city, 225-Hoang Dieu");
        data.setName("Hilton Hotel");
        return data;
    }

    @Override
    public List<Guest> getGuestsList() {
        return hotelRepository.findAll();
    }

    @Override
    public List<Guest> getGuestsList(String surname) {
        return hotelRepository.findGuestsBySurname(surname);
    }

    @Override
    public void insertNewGuest(Guest newGuest) {
//        if (hotelRepository.exists(newGuest.getId())) {
//            throw new GuestFoundException();
//        }
        hotelRepository.save(newGuest);
    }
}
