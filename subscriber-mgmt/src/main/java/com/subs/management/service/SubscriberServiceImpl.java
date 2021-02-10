package com.subs.management.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.subs.management.entity.Subscriber;
import com.subs.management.entity.SubscriberAddress;
import com.subs.management.repository.SubscriberRepository;

import lombok.Data;

@Service
@Data
@Transactional
public class SubscriberServiceImpl implements SubscriberService {

	@Autowired
	private SubscriberRepository subscriberRepository;
	
	@Override
	public List<Subscriber> listAllSubscribers() {
		return subscriberRepository.findAll();
	}
	
	@Override
	public List<Subscriber> listAllActiveSubscribers() {
		return subscriberRepository.findByStatus("A");
	}

	@Override
	public Subscriber addSubscriber(Subscriber subscriber) {
		List<SubscriberAddress> newAddressList = new ArrayList<>();
		
		subscriber.getSubscriberAddresses().forEach(subsAddress -> {
			/*SubscriberAddress address = new SubscriberAddress(subsAddress.getAddressId(), subscriber, subsAddress.getAddress(), 
					subsAddress.getCity(), subsAddress.getCountry());
			newAddress.add(address);*/
			SubscriberAddress newAddress = new SubscriberAddress(); 
			BeanUtils.copyProperties(subsAddress,newAddress);
			newAddressList.add(newAddress);
		});
		
		subscriber.setSubscriberAddresses(newAddressList);
		
		return subscriberRepository.save(subscriber);
	}

	@Override
	public Subscriber editSubscriber(Subscriber subscriber) {
		Optional<Subscriber> optional = subscriberRepository.findById(subscriber.getSubscriberId());
		if(optional.isPresent()) {
			Subscriber dbSubscriber = optional.get();
			BeanUtils.copyProperties(subscriber, dbSubscriber);
		}
		
		return subscriberRepository.save(subscriber);
	}
	
	@Override
	public void deleteSubscriber(Subscriber subscriber) {
		subscriberRepository.deleteById(subscriber.getSubscriberId());
	}
	
}
