package com.subs.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.subs.management.dto.SubscriberRequest;
import com.subs.management.dto.SubscriberResponse;
import com.subs.management.dto.SubscribersListResponse;
import com.subs.management.entity.Subscriber;
import com.subs.management.service.SubscriberService;

@RestController
public class SubscriberController {
	
	@Autowired
	private SubscriberService subscriberService;
	
	@GetMapping(value = "/listSubscriber",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SubscribersListResponse> listSubscriber(){
		
		List<Subscriber> result = subscriberService.listAllActiveSubscribers();
		
		SubscribersListResponse response = new SubscribersListResponse();
		response.setSubscribers(result);
		
		return ResponseEntity.ok(response);
	}
	
	@PostMapping(value = "/addSubscriber")
	public ResponseEntity<SubscriberResponse> addSubscriber(@RequestBody SubscriberRequest request){
		
		Subscriber result = subscriberService.addSubscriber(request.getSubscriber());
		
		SubscriberResponse response = new SubscriberResponse();
		response.setSubscriber(result);
		
		return ResponseEntity.ok(response);
	}
	
	@PutMapping(value = "/updateSubscriber")
	public ResponseEntity<SubscriberResponse> updateSubscriber(@RequestBody SubscriberRequest request){
		
		Subscriber result = subscriberService.editSubscriber(request.getSubscriber());
		
		SubscriberResponse response = new SubscriberResponse();
		response.setSubscriber(result);
		
		return ResponseEntity.ok(response);
	}

	@PostMapping(value = "/deleteSubscriber")
	public ResponseEntity<HttpStatus> deleteSubscriber(@RequestBody SubscriberRequest request){
		
		subscriberService.deleteSubscriber(request.getSubscriber());
				
		return ResponseEntity.ok(HttpStatus.OK);
	}
}
