package com.hackathon.mobileconnection.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.mobileconnection.dto.CustomerRequestDto;
import com.hackathon.mobileconnection.dto.CustomerResponseDto;
import com.hackathon.mobileconnection.dto.ResponseDto;
import com.hackathon.mobileconnection.entity.Customer;
import com.hackathon.mobileconnection.entity.CustomerRequest;
import com.hackathon.mobileconnection.exception.CustomerRequestNotFoundException;
import com.hackathon.mobileconnection.repository.CustomerRepository;
import com.hackathon.mobileconnection.repository.CustomerRequestRepository;
import com.hackathon.mobileconnection.util.MobileConstants;

import lombok.extern.slf4j.Slf4j;

/**
 * Implementation of CustomerService which will give the customer request details.
 * @author Kiruthika
 * @since 2020/11/21
 */
@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	CustomerRequestRepository customerRequestRepository;

	/**
	 * Method to check the status of the request
	 * @param id request id of the customer .
	 * @return CustomerResponseDto which consist the status and last updated date.
	 * @throws CustomerRequestNotFoundException will throw if the request not found.
	 */
	@Override
	public CustomerResponseDto getCustomerRequests(Long requestId) throws CustomerRequestNotFoundException {

		CustomerResponseDto customerResponseDto = new CustomerResponseDto();

		Optional<CustomerRequest> customerRequest = customerRequestRepository.findById(requestId);
		if (!customerRequest.isPresent()) {
			throw new CustomerRequestNotFoundException(MobileConstants.CUSTOMER_REQUEST_NOT_FOUND);
		}
		BeanUtils.copyProperties(customerRequest.get(), customerResponseDto);

		return customerResponseDto;

	}

	@Override
	public Optional<ResponseDto> obtainConnection(CustomerRequestDto CustomerDto) {
		Customer customer = new Customer();
		BeanUtils.copyProperties(CustomerDto, customer);
		Customer cust = customerRepository.save(customer);
		CustomerRequest customerRequest = new CustomerRequest();
		customerRequest.setPlanId(CustomerDto.getPlanId());
		customerRequest.setStatus("In Progress");
		customerRequest.setUpdatedOn(LocalDateTime.now());
		customerRequest.setCustomerId(cust.getCustomerId());
		customerRequest.setRequestDate(LocalDateTime.now());
		CustomerRequest customerRequestresult = customerRequestRepository.save(customerRequest);
		
		ResponseDto responseDto = new ResponseDto();
		responseDto.setMessage("Successfully created..");
		responseDto.setRequestId(customerRequestresult.getRequestId());
		responseDto.setStatusCode(200);
		
		return Optional.of(responseDto);

	}

}
