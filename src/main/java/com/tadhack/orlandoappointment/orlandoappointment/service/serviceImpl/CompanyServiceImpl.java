package com.tadhack.orlandoappointment.orlandoappointment.service.serviceImpl;

import com.tadhack.orlandoappointment.orlandoappointment.model.Company;
import com.tadhack.orlandoappointment.orlandoappointment.repository.ICompanyRepository;
import com.tadhack.orlandoappointment.orlandoappointment.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CompanyServiceImpl implements ICompanyService {
    @Autowired
    private ICompanyRepository companyRepository;

    private List<Company> getCompanyByCategory(String categoryId) {
        return companyRepository.findCompanyByCategories(categoryId);
    }
}
