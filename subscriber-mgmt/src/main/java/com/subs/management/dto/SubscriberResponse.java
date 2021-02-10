package com.subs.management.dto;

import com.subs.management.entity.Subscriber;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SubscriberResponse {
	
	private Subscriber subscriber;

}
