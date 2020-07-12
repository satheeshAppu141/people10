package com.people10.roombookingmanagement.vo;

import org.apache.commons.lang.exception.ExceptionUtils;

/**
 * This value object class represents error information for UI.
 * 
 * @author SatheeshB
 */
public class ErrorInfoVO {
	private String errorMessage;
	private String exceptionStackTrace;

	/**
	 * Default Constructor
	 *
	 */
	public ErrorInfoVO() {

	}

	/**
	 * Constructor with parameters "errorMessage" and "exception"
	 * 
	 * @param errorMessage
	 *            Error message
	 * @param exception
	 *            Throwable object
	 */
	public ErrorInfoVO(String errorMessage, Throwable exception) {
		this.errorMessage = errorMessage;
		if (exception != null) {
			this.exceptionStackTrace = ExceptionUtils.getStackTrace(exception);
			throwable(exception);
		}
	}

	/**
	 * Constructor with parameters "errorMessage" and "exceptionStackTrace"
	 * 
	 * @param errorMessage
	 *            Error message
	 * @param exceptionStackTrace
	 *            Exception stacktrace
	 */
	public ErrorInfoVO(String errorMessage, String exceptionStackTrace) {
		this.errorMessage = errorMessage;
		this.exceptionStackTrace = exceptionStackTrace;
		throwable(new IllegalArgumentException(errorMessage));
	}

	/**
	 * Getter method for errorMessage
	 * 
	 * @return the error message
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * Setter method for errorMessage
	 * 
	 * @param errorMessage
	 *            the error message
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * Getter method for exceptionStackTrace
	 * 
	 * @return the exception stacktrace
	 */
	public String getExceptionStackTrace() {
		return exceptionStackTrace;
	}

	/**
	 * Setter method for exceptionStackTrace
	 * 
	 * @param exceptionStackTrace
	 *            the exception stacktrace
	 */
	public void setExceptionStackTrace(String exceptionStackTrace) {
		this.exceptionStackTrace = exceptionStackTrace;
	}

	/**
	 * Method to convert exception into throwable object
	 * 
	 * @param exception
	 *            which contains exception object
	 * @throws T
	 *             which throw exception
	 */
	@SuppressWarnings("unchecked")
	private static <T extends Throwable> void throwable(Throwable exception) throws T {
		throw (T) exception;
	}

}
