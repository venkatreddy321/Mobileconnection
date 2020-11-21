package com.hackathon.mobileconnection.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.mobileconnection.dto.CustomerRequestDto;
import com.hackathon.mobileconnection.dto.ResponseDto;
import com.hackathon.mobileconnection.entity.Customer;
import com.hackathon.mobileconnection.entity.CustomerRequest;
import com.hackathon.mobileconnection.repository.CustomerRepository;
import com.hackathon.mobileconnection.repository.CustomerRequestRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	CustomerRequestRepository customerRequestRepository;
	@Override
	public Optional<ResponseDto> obtainConnection(CustomerRequestDto CustomerDto) {
		Customer customer = new Customer();
		BeanUtils.copyProperties(CustomerDto, customer);
		Customer cust = customerRepository.save(customer);
		CustomerRequest customerRequest = new CustomerRequest();
		customerRequest.setPlanId(CustomerDto.getPlanId());
		customerRequest.setStatus("in progress");
		customerRequest.setUpdatedOn(LocalDateTime.now());
		customerRequest.setCustomerId(cust.getCustomerId());
		CustomerRequest customerRequestresult = customerRequestRepository.save(customerRequest);
		
		ResponseDto responseDto = new ResponseDto();
		responseDto.setMessage("Successfully created..");
		responseDto.setRequestId(customerRequestresult.getRequestId());
		responseDto.setStatusCode(200);
		
		return Optional.of(responseDto);
	}

}
