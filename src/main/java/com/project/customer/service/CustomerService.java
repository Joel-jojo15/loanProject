package com.project.customer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.customer.entity.CustomerEntity;
import com.project.customer.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepo;
	
	public CustomerEntity addCustomer(CustomerEntity customer) {
		customerRepo.saveAndFlush(customer);
		return customer;
	}
	public List<CustomerEntity> getAllCustomers(){
		return customerRepo.findAll();
	}
	public CustomerEntity getACustomer(Long customerId) {
		Optional opt = customerRepo.findById(customerId);
		if(opt.get()!=null) {
		}
		
		CustomerEntity customer = (CustomerEntity) opt.get();
		return customer;
		
//		else {
//			throw new customerNotFoundException;
//		}
	}
	public String deleteACustomer(Long customerId) {
		customerRepo.deleteById(customerId);
	// if id does not exist throw error
		return "Deleted Successfully";
	}
	public CustomerEntity updateACustomer(CustomerEntity customer) {
		CustomerEntity c = getACustomer(customer.getCustomerId());
		BeanUtils.copyProperties(customer , c);
		deleteACustomer(customer.getCustomerId());
		return customerRepo.save(c);
		// need to verify
		
	}
	
	// hello thid id is good

}
