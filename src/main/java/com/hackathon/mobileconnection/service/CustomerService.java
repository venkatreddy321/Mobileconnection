package com.hackathon.mobileconnection.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hackathon.mobileconnection.dto.CustomerRequestDto;
import com.hackathon.mobileconnection.dto.ResponseDto;

@Service
public interface CustomerService {

	public Optional<ResponseDto> obtainConnection(CustomerRequestDto CustomerDto);
}
