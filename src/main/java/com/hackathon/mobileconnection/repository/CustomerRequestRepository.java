package com.hackathon.mobileconnection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.mobileconnection.entity.CustomerRequest;

@Repository
public interface CustomerRequestRepository extends JpaRepository<CustomerRequest, Long>{

}
