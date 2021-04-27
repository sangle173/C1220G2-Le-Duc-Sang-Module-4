package model.service;

import model.bean.Customer;

public class CustomerServiceFactory {
    private static CustomerService singleton;
    public static synchronized CustomerService getInstance(){
        if (singleton==null){
            singleton= new SimpleCustomerServiceImpl();
        }
        return singleton;
    }
}
