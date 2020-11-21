package com.hackathon.mobileconnection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.mobileconnection.entity.Plan;
@Repository
public interface PlanRepository extends JpaRepository<Plan, Long>{

}
