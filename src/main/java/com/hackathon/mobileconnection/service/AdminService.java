package com.hackathon.mobileconnection.service;

import java.util.List;
import java.util.Optional;

import com.hackathon.mobileconnection.dto.ConnectionResponseDto;
import com.hackathon.mobileconnection.dto.UpdateResponseDTO;

public interface AdminService {
	
	public List< ConnectionResponseDto> obtainConnectionRequests();
	public  Optional<UpdateResponseDTO> updateRequests(Long requestId, String status);

}
