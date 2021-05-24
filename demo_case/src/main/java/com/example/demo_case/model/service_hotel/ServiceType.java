package com.example.demo_case.model.service_hotel;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "service_types")
public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_type_id")
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "serviceType", cascade = CascadeType.ALL, targetEntity = ServiceHotel.class)
    private List<ServiceHotel> serviceHotels;

    public ServiceType() {
    }

    public ServiceType(String name, List<ServiceHotel> serviceHotels) {
        this.name = name;
        this.serviceHotels = serviceHotels;
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

    public List<ServiceHotel> getServiceHotels() {
        return serviceHotels;
    }

    public void setServiceHotels(List<ServiceHotel> serviceHotels) {
        this.serviceHotels = serviceHotels;
    }
}
