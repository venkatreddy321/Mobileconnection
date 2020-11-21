
package com.hackathon.mobileconnection.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.hackathon.mobileconnection.dto.CustomerRequestDto;
import com.hackathon.mobileconnection.dto.ResponseDto;
import com.hackathon.mobileconnection.service.CustomerService;

@ExtendWith(MockitoExtension.class)

@TestInstance(Lifecycle.PER_CLASS)
public class CustomerControllerTest {

	@Mock
	CustomerService customerService;

	@InjectMocks
	CustomerController customerController;

	ResponseDto responseDto;
	CustomerRequestDto customerRequestDto;

	@BeforeAll
	public void setUp() {

		customerRequestDto = new CustomerRequestDto();
		customerRequestDto.setAddress("bangalore");
		customerRequestDto.setAltMobNumber("99999");
		customerRequestDto.setDateOfBirth(LocalDate.now());
		customerRequestDto.setEmailId("vensee@gmail.com");
		customerRequestDto.setIdProof("aadhaer");
		customerRequestDto.setIdProofType("doc");
		customerRequestDto.setMobNumber("56677");
		customerRequestDto.setName("vense");
		customerRequestDto.setPlanId(343L);
		

		responseDto = new ResponseDto();
		responseDto.setMessage("Successfully created..");
		responseDto.setStatusCode(200);
		responseDto.setRequestId(232L);

	}

	@Test
	public void getConnectionTest() {

		// Given
		Mockito.when(customerService.obtainConnection(customerRequestDto)).thenReturn(Optional.of(responseDto));
		// when
		ResponseEntity<Optional<ResponseDto>> result = customerController.createConnection(customerRequestDto);
		// then
		assertEquals("Successfully created..", result.getBody().get().getMessage());
	}

}
