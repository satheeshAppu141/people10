package com.people10.roombookingmanagement.dao;

import com.people10.roombookingmanagement.entity.Customer;
/**
 * 
 * This DAO responsible for providing functionality to perform room booking related operations
 *
 * @author: SatheeshB
 *
 */
public interface IRoomBookingDAO {
	
	/**
	 * Method to get Customer info by id
	 * 
	 * @param customerId
	 *            customer id
	 * @return a Customer object
	 */
	Customer getCustomerById(final Long customerId);
	
}
