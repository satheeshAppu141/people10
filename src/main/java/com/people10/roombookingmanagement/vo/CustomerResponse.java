package com.people10.roombookingmanagement.vo;

public class CustomerResponse extends BaseResponseVO {

	private CustomerVO customer;

	/**
	 * Getter method for customer
	 *
	 * @return the customer
	 */
	public CustomerVO getCustomer() {
		return customer;
	}

	/**
	 * Setter method for customer
	 *
	 * @param customer
	 *            the customer to set
	 */
	public void setCustomer(CustomerVO customer) {
		this.customer = customer;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "CustomerResponse [customer=" + customer + "]";
	}
}
