package com.subs.management.service;

import java.util.List;

import com.subs.management.entity.Subscriber;

public interface SubscriberService {
	
	List<Subscriber> listAllSubscribers();
	
	List<Subscriber> listAllActiveSubscribers();
	
	Subscriber addSubscriber(Subscriber subscriber);
	
	Subscriber editSubscriber(Subscriber subscriber);
	
	void deleteSubscriber(Subscriber subscriber);

}
