package com.hackathon.mobileconnection.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.hackathon.mobileconnection.dto.CustomerResponseDto;
import com.hackathon.mobileconnection.entity.CustomerRequest;
import com.hackathon.mobileconnection.exception.CustomerRequestNotFoundException;
import com.hackathon.mobileconnection.repository.CustomerRequestRepository;

@ExtendWith(MockitoExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
public class CustomerServiceTest {
	
	@Mock
	CustomerRequestRepository customerRequestRepository;
	
	@InjectMocks
	CustomerServiceImpl customerServiceImpl;
	
	CustomerRequest customerRequest;
	
	CustomerResponseDto customerResponseDto;
	
	@BeforeAll
	public void setUp() {
		customerRequest=new CustomerRequest();
		customerRequest.setCustomerId(1l);
		customerRequest.setComments("pending for approve");
		customerRequest.setPlanId(1l);
		customerRequest.setRequestId(1l);
		customerRequest.setStatus("In progress");
		customerRequest.setUpdatedOn(LocalDateTime.now());
		
		customerResponseDto=new CustomerResponseDto();
		customerResponseDto.setStatus("In progress");
		customerRequest.setUpdatedOn(LocalDateTime.now());
	}

	@Test
	public void getCustomerRequestsTest() throws CustomerRequestNotFoundException {
		
		//GIVEN
		when(customerRequestRepository.findById(1l)).thenReturn(Optional.of(customerRequest));
		
		//WHEN
		CustomerResponseDto actual=customerServiceImpl.getCustomerRequests(1l);
		
		//THEN
		assertEquals(customerResponseDto.getStatus(), actual.getStatus());
	}
	
	@Test
	public void getCustomerRequestNotFoundTest() throws CustomerRequestNotFoundException {
		
		//GIVEN
		when(customerRequestRepository.findById(2l)).thenReturn(Optional.empty());
		
		//WHEN
		assertThrows(CustomerRequestNotFoundException.class, () -> {
			customerServiceImpl.getCustomerRequests(2l);
		  });
	}
}
