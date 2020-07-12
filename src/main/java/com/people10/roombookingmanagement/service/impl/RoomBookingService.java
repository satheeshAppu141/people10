package com.people10.roombookingmanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.people10.roombookingmanagement.dao.IRoomBookingDAO;
import com.people10.roombookingmanagement.entity.Customer;
import com.people10.roombookingmanagement.exception.ApplicationException;
import com.people10.roombookingmanagement.service.IRoomBookingService;

@Service
public class RoomBookingService implements IRoomBookingService {

	@Autowired
	private IRoomBookingDAO roomBookingDAO;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Customer getCustomerById(final Long customerId) throws ApplicationException {
	
		final Customer customer = roomBookingDAO.getCustomerById(customerId);

		// Should return HTTP response 404 (resource not found) for non matching user name
		if (customer == null) {
			throw new ApplicationException();
		}
		// Should return HTTP response 200 with retrieved customer information for successful match
		return customer;
	}
}
