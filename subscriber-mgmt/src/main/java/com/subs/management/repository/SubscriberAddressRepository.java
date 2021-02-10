package com.subs.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.subs.management.entity.SubscriberAddress;

public interface SubscriberAddressRepository extends JpaRepository<SubscriberAddress, Integer> {

}
