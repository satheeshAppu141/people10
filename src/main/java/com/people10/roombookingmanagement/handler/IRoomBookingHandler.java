package com.people10.roombookingmanagement.handler;

import org.springframework.stereotype.Component;

import com.people10.roombookingmanagement.vo.CustomerResponse;

/**
 * 
 * This handler responsible for providing functionality to perform room booking related operations
 *
 * @author: SatheeshB
 *
 */
@Component
public interface IRoomBookingHandler {

	/**
	 * Method to get customer information for the given id
	 * 
	 * @param customerId
	 *            customer id
	 * @return CustomerResponse object
	 */
	CustomerResponse getCustomerInfoById(final Long customerId);

}
