package com.people10.roombookingmanagement.service;

import com.people10.roombookingmanagement.entity.Customer;
import com.people10.roombookingmanagement.exception.ApplicationException;

public interface IRoomBookingService {

	/**
	 * Method to get Customer info by id
	 * 
	 * @param customerId
	 *            customer id
	 * @return a Customer object
	 * @throws ApplicationException
	 *             if any validation error occurs
	 */
	Customer getCustomerById(Long customerId) throws ApplicationException;

}
