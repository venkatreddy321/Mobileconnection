package com.hackathon.mobileconnection.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hackathon.mobileconnection.entity.CustomerRequest;
import com.hackathon.mobileconnection.util.Connection;

@Repository
public interface CustomerRequestRepository extends JpaRepository<CustomerRequest, Long>{

	

	public List<CustomerRequest> findAllByStatus(Connection inProgress);
	@Modifying
    @Transactional
    @Query("update CustomerRequest cr set cr.status='CONNECTION_ENABLED', cr.updatedOn=now() "
            + "where cr.status='APPROVED'")
    void activateConnections();

}
