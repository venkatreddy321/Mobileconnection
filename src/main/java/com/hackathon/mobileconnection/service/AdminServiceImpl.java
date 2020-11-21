package com.hackathon.mobileconnection.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.mobileconnection.dto.ConnectionResponseDto;
import com.hackathon.mobileconnection.dto.UpdateResponseDTO;
import com.hackathon.mobileconnection.entity.CustomerRequest;
import com.hackathon.mobileconnection.repository.CustomerRepository;
import com.hackathon.mobileconnection.repository.CustomerRequestRepository;
import com.hackathon.mobileconnection.util.Connection;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	CustomerRequestRepository customerRequestRepository;
	List<ConnectionResponseDto> connectionList;

	@Override
	public List<ConnectionResponseDto> obtainConnectionRequests() {

		List<CustomerRequest> customerRequestList = customerRequestRepository.findAllByStatus(Connection.IN_PROGRESS);
		
		List<ConnectionResponseDto> connectionResponseDtos = customerRequestList.stream().map(customerRequest -> {
			ConnectionResponseDto connectionResponseDto = new ConnectionResponseDto();
			BeanUtils.copyProperties(customerRequest, connectionResponseDto);
			return connectionResponseDto;
		}).collect(Collectors.toList());

		return connectionResponseDtos;
	}
	@Override
    public  Optional<UpdateResponseDTO> updateRequests(Long requestId, String status){
       
        Optional<CustomerRequest> customerRequest = customerRequestRepository.findById(requestId);
       System.out.println("checking the status.."+status);
        CustomerRequest cusRequest = customerRequest.get();
        if(status.contains("approved")) {
            cusRequest.setStatus(Connection.APPROVED.toString());
        }else if(status.contains("rejected")){
            cusRequest.setStatus(Connection.REJECTED.toString());
        }else if(status.contains("referback")){
            cusRequest.setStatus(Connection.REFER_BACK.toString());
        }
        cusRequest.setUpdatedOn(LocalDateTime.now());
       
        customerRequestRepository.save(cusRequest);
   
        UpdateResponseDTO updateResponseDTO = new UpdateResponseDTO();
        updateResponseDTO.setMessage("Successfully Updated");
        updateResponseDTO.setStatusCode(200);
        return Optional.of(updateResponseDTO);
    }

}
