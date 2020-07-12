package com.people10.roombookingmanagement.helper.data.transformer;

import java.text.SimpleDateFormat;

import com.people10.roombookingmanagement.entity.Customer;
import com.people10.roombookingmanagement.vo.CustomerVO;

/**
 * 
 * This file represents / responsible for transforming Customer entity into customer value object
 *
 * @author: SatheeshB
 *
 */
public class CustomerTransformer {
	final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

	public CustomerVO transform(final Customer input) {
		if (input != null) {
			final CustomerVO customer = new CustomerVO();

			customer.setId(input.getId());
			customer.setFirstName(input.getFirstName());
			customer.setLastName(input.getLastName());
			if (input.getDob() != null) {
				customer.setDob(formatter.format(input.getDob()));
			}
			customer.setEmail(input.getEmail());

			return customer;
		}
		return null;
	}
}
