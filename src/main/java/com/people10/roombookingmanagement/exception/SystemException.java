package com.people10.roombookingmanagement.exception;

/**
 * The class represents an unchecked exception (by extending RuntimeException) thrown in the application to indicate the
 * runtime failure.
 * 
 * @author SatheeshB
 */
public class SystemException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8927825755830106139L;

	/**
	 * Default constructor
	 */
	public SystemException() {
	}

	/**
	 * Constructor with "message" and "cause" parameters
	 *
	 * @param message
	 *            exception message
	 * @param cause
	 *            Throwable instance
	 */
	public SystemException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor with "message" parameter
	 *
	 * @param message
	 *            exception message
	 */
	public SystemException(String message) {
		super(message);
	}

	/**
	 * Constructor with "cause" parameter
	 *
	 * @param cause
	 *            Throwable instance
	 */
	public SystemException(Throwable cause) {
		super(cause);
	}
}