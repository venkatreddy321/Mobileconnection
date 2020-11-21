package com.hackathon.mobileconnection.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.mobileconnection.dto.CustomerRequestDto;
import com.hackathon.mobileconnection.dto.ResponseDto;
import com.hackathon.mobileconnection.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@PostMapping("/connection")
	public ResponseEntity<Optional<ResponseDto>>createConnection(@RequestBody CustomerRequestDto customerRequestDto){
		return new ResponseEntity<>(customerService.obtainConnection(customerRequestDto),HttpStatus.OK);
	}
}
