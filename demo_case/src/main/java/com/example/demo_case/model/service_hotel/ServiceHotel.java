package com.example.demo_case.model.service_hotel;

import com.example.demo_case.model.contract.Contract;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "services")
public class ServiceHotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private Integer id;
    private String code;
    private String name;
    private Double area;
    private Double price;
    private int capacity;
    private String standardRoom;
    private String amenity;
    private Double poolArea;
    private int noOfFloor;

    @ManyToOne
    @JoinColumn(name = "rental_type_id")
    private RentalType rentalType;

    @ManyToOne
    @JoinColumn(name = "service_type_id")
    private ServiceType serviceType;

    @OneToMany(mappedBy = "serviceHotel", targetEntity = Contract.class, cascade = CascadeType.ALL)
    private List<Contract> contracts;

    public ServiceHotel() {
    }

    public ServiceHotel(String code, String name, Double area, Double price, int capacity, String standardRoom, String amenity, Double poolArea, int noOfFloor, RentalType rentalType, ServiceType serviceType, List<Contract> contracts) {
        this.code = code;
        this.name = name;
        this.area = area;
        this.price = price;
        this.capacity = capacity;
        this.standardRoom = standardRoom;
        this.amenity = amenity;
        this.poolArea = poolArea;
        this.noOfFloor = noOfFloor;
        this.rentalType = rentalType;
        this.serviceType = serviceType;
        this.contracts = contracts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getAmenity() {
        return amenity;
    }

    public void setAmenity(String amenity) {
        this.amenity = amenity;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNoOfFloor() {
        return noOfFloor;
    }

    public void setNoOfFloor(int noOfFloor) {
        this.noOfFloor = noOfFloor;
    }

    public RentalType getRentalType() {
        return rentalType;
    }

    public void setRentalType(RentalType rentalType) {
        this.rentalType = rentalType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
}
