package com.subs.management.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "Subscribers")
public class Subscriber implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "subs_id")
	private int subscriberId;
	private String name;
	private String email;
	private String status;

	@Version
	private Long version;

	@JsonManagedReference
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "subscriber", cascade = CascadeType.ALL)
	private List<SubscriberAddress> subscriberAddresses;
}
