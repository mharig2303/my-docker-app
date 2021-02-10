package com.subs.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.subs.management.entity.Subscriber;

@Repository
public interface SubscriberRepository extends JpaRepository<Subscriber, Integer> {
	
	List<Subscriber> findByStatus(String status);
	
}
