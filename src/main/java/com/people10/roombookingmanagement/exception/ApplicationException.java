package com.people10.roombookingmanagement.exception;

/**
 * The class represents a checked exception (by extending Exception) thrown in the application to indicate the
 * conditional failure.
 * 
 * @author SatheeshB
 */
public class ApplicationException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 160807129047222553L;

	/**
	 * Default constructor
	 */
	public ApplicationException() {
	}

	/**
	 * Constructor with "message" and "cause" parameters
	 *
	 * @param message
	 *            exception message
	 * @param cause
	 *            Throwable instance
	 */
	public ApplicationException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor with "message" parameter
	 *
	 * @param message
	 *            exception message
	 */
	public ApplicationException(String message) {
		super(message);
	}

	/**
	 * Constructor with "cause" parameter
	 *
	 * @param cause
	 *            Throwable instance
	 */
	public ApplicationException(Throwable cause) {
		super(cause);
	}

}
