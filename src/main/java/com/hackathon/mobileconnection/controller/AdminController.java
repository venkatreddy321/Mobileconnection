package com.hackathon.mobileconnection.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.mobileconnection.dto.ConnectionResponseDto;
import com.hackathon.mobileconnection.dto.UpdateResponseDTO;
import com.hackathon.mobileconnection.exception.CustomerRequestNotFoundException;
import com.hackathon.mobileconnection.service.AdminService;
import com.sun.istack.NotNull;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminService adminService;

	@GetMapping("/requests")
	public ResponseEntity<List<ConnectionResponseDto>> getConnectionRequests() {

		return new ResponseEntity<>(adminService.obtainConnectionRequests(), HttpStatus.OK);
	}

	@ApiOperation(value = "Approve/Reject/Refer Back by Admin based on request id", response = String.class)
	@PutMapping("requests/{id}")
	public ResponseEntity<UpdateResponseDTO> updateCustomerRequests(@PathVariable @NotNull Long id,
			@RequestParam String status) throws CustomerRequestNotFoundException {
		return new ResponseEntity<>(adminService.updateRequests(id, status).get(), HttpStatus.OK);
	}
}
