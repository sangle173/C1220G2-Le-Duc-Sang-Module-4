package com.example.demo_ajax.service;

import com.example.demo_ajax.model.Guest;
import com.example.demo_ajax.model.HotelData;

import java.util.List;

public interface HotelService {

    HotelData getHotelData();

    List<Guest> getGuestsList();

    List<Guest> getGuestsList(String surname);

    void insertNewGuest(Guest newGuest);
}
