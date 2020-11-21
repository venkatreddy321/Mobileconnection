package com.hackathon.mobileconnection.service;

import com.hackathon.mobileconnection.dto.CustomerResponseDto;
import com.hackathon.mobileconnection.exception.CustomerRequestNotFoundException;

/**
 * 
 * Service interface to get the customer request details.
 * The preferred implementation is {@code CustomerServiceImpl}.
 * @author Kiruthika
 * @since 2020/11/21
 *
 */
public interface CustomerService {

	/**
	 * Method to call service Implementations to check the status of the request
	 * @param id request id of the customer .
	 * @return CustomerResponseDto which consist the status and last updated date.
	 * @throws CustomerRequestNotFoundException will throw if the request not found.
	 */
	public CustomerResponseDto getCustomerRequests(Long requestId) throws CustomerRequestNotFoundException;
}
