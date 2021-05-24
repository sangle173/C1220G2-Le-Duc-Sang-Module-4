package com.example.demo_case.model.contract;

import com.example.demo_case.model.customer.Customer;
import com.example.demo_case.model.employee.Employee;
import com.example.demo_case.model.service_hotel.ServiceHotel;
import com.example.demo_case.model.user.Role;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "contracts")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id")
    private Integer id;
    private String dateStart;
    private String dateEnd;
    private Double deposit;
    private Double totalPayment;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "service_hotel_id")
    private ServiceHotel serviceHotel;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "contract_detail",
            joinColumns = @JoinColumn(name = "contract_id"),
            inverseJoinColumns = @JoinColumn(name = "attach_service_id")
    )
    private Set<AttachService> attachServices = new HashSet<>();

    public Contract() {
    }

    public Contract(String dateStart, String dateEnd, Double deposit, Double totalPayment, Employee employee, Customer customer, ServiceHotel serviceHotel, Set<AttachService> attachServices) {
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.deposit = deposit;
        this.totalPayment = totalPayment;
        this.employee = employee;
        this.customer = customer;
        this.serviceHotel = serviceHotel;
        this.attachServices = attachServices;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(Double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ServiceHotel getServiceHotel() {
        return serviceHotel;
    }

    public void setServiceHotel(ServiceHotel serviceHotel) {
        this.serviceHotel = serviceHotel;
    }

    public Set<AttachService> getAttachServices() {
        return attachServices;
    }

    public void setAttachServices(Set<AttachService> attachServices) {
        this.attachServices = attachServices;
    }
}
