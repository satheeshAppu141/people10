package com.people10.roombookingmanagement.controller;

import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.people10.roombookingmanagement.handler.IRoomBookingHandler;
import com.people10.roombookingmanagement.vo.CustomerResponse;

@RestController
@RequestMapping("/api/customer")
public class RoomBookingController {
	private static final Logger log = LoggerFactory.getLogger(RoomBookingController.class);

	@Autowired
	private IRoomBookingHandler roomBookingHandler;

	/**
	 * REST API to get customer information by id and return the success JSON response. If any failure happens, error
	 * information will be returned as part of JSON response.
	 *
	 * @param id
	 *            customer id
	 * @return EdgeBaseResponseVO
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public CustomerResponse getCustomerInfoById(@PathVariable(name = "id") final Long customerId) {

		log.debug("Inside getCustomerInfoById() - id: {}", customerId);

		final CustomerResponse customerResponse = roomBookingHandler.getCustomerInfoById(customerId);

		log.debug("Inside getCustomerInfoById() - customerResponse: {}", customerResponse);

		return customerResponse;

	}
}
