package com.hackathon.mobileconnection.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.hackathon.mobileconnection.repository.CustomerRequestRepository;

@Component
public class ActivateConnection {

	@Autowired
	CustomerRequestRepository customerRequestRepository;

	@Scheduled(cron = "0 0/2 * * * ?")
	public void activateConnection() {
		customerRequestRepository.activateConnections();
	}

}
