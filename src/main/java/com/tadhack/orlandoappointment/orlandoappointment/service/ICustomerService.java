package com.tadhack.orlandoappointment.orlandoappointment.service;

import com.tadhack.orlandoappointment.orlandoappointment.model.Customer;

public interface ICustomerService {
    Customer findCustomerByPhoneNumber(String number);
    Customer saveCustomer(Customer customer);
}
