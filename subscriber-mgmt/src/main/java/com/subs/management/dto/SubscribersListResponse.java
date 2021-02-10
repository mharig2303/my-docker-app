package com.subs.management.dto;

import java.util.List;

import com.subs.management.entity.Subscriber;

import lombok.Data;

@Data
public class SubscribersListResponse {
	
	private List<Subscriber> subscribers;

}
