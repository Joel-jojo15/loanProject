package com.project.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.customer.entity.CustomerEntity;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity , Long> {

}
