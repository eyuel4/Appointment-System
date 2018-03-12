package com.tadhack.orlandoappointment.orlandoappointment.service.serviceImpl;

import com.tadhack.orlandoappointment.orlandoappointment.model.Customer;
import com.tadhack.orlandoappointment.orlandoappointment.repository.ICustomerRepository;
import com.tadhack.orlandoappointment.orlandoappointment.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Customer findCustomerByPhoneNumber(String number) {
        return customerRepository.findCustomerByPhone(number);
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
