package com.people10.roombookingmanagement.vo;

/**
 * 
 * This file represents / responsible for containing customer information
 *
 * @author: SatheeshB
 *
 */
public class CustomerVO {

	private Long id;
	private String firstName;
	private String lastName;
	private String dob;
	private String email;
	private String password;

	/**
	 * Getter method for id
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Setter method for id
	 *
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Getter method for firstName
	 *
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Setter method for firstName
	 *
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Getter method for lastName
	 *
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Setter method for lastName
	 *
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Getter method for dob
	 *
	 * @return the dob
	 */
	public String getDob() {
		return dob;
	}

	/**
	 * Setter method for dob
	 *
	 * @param dob
	 *            the dob to set
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}

	/**
	 * Getter method for email
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Setter method for email
	 *
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Getter method for password
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Setter method for password
	 *
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "CustomerVO [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob
			+ ", email=" + email + ", password=" + password + "]";
	}

}
