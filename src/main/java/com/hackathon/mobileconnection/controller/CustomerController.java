package com.hackathon.mobileconnection.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.mobileconnection.dto.CustomerRequestDto;
import com.hackathon.mobileconnection.dto.CustomerResponseDto;
import com.hackathon.mobileconnection.dto.ResponseDto;
import com.hackathon.mobileconnection.exception.CustomerRequestNotFoundException;
import com.hackathon.mobileconnection.service.CustomerService;
import com.sun.istack.NotNull;

import lombok.extern.slf4j.Slf4j;


/**
 * Controller for handling the requests and responses related with customers.
 * 
 * @author saravana
 * @since 2020/11/21
 *
 */
@Slf4j
@RestController
@RequestMapping("/")
public class CustomerController {

	@Autowired
    private CustomerService customerService;
	
	/**
	 * Method to call service method to check the status of the request
	 * @param id request id of the customer .
	 * @return CustomerResponseDto which consist the status and last updated date.
	 * @throws CustomerRequestNotFoundException will throw if the request not found.
	 */
    @GetMapping("requests/{id}")
    public ResponseEntity<CustomerResponseDto> getCustomerRequests(@PathVariable @NotNull Long id) throws CustomerRequestNotFoundException{
       
        return new ResponseEntity<>(customerService.getCustomerRequests(id), HttpStatus.OK);
    }

	@PostMapping("/connection")
	public ResponseEntity<Optional<ResponseDto>>createConnection(@RequestBody CustomerRequestDto customerRequestDto){
		return new ResponseEntity<>(customerService.obtainConnection(customerRequestDto),HttpStatus.OK);
	}

}
