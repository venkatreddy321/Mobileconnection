package com.hackathon.mobileconnection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.mobileconnection.entity.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
