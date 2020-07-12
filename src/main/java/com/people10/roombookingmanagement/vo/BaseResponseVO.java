package com.people10.roombookingmanagement.vo;

/**
 * This base value object class holds response type to indicate whether it is Success or Failure. If the response type
 * is Failure, it holds error information as well for UI. All response value object classes will extend this class to
 * set the response type and error information to be sent to UI.
 * 
 * @author SatheeshB
 */
public class BaseResponseVO {
	public static final String RESPONSE_TYPE_SUCCESS = "Success";
	public static final String RESPONSE_TYPE_FAILURE = "Failure";

	private String responseType = RESPONSE_TYPE_SUCCESS;
	private ErrorInfoVO errorInfo;

	/**
	 * Default constructor
	 */
	public BaseResponseVO() {
	}

	/**
	 * Constructor with parameters "responseType" and "errorInfo"
	 * 
	 * @param errorInfo
	 *            ErrorInfoVO object which contains error message and exception.
	 */
	public BaseResponseVO(String responseType) {
		this.responseType = responseType;

	}

	/**
	 * Getter method for responseType
	 * 
	 * @return the response type
	 */
	public String getResponseType() {
		return responseType;
	}

	/**
	 * Setter method for responseType.
	 * 
	 * @param responseType
	 *            the response type
	 */
	public void setResponseType(String responseType) {
		this.responseType = responseType;
	}

	/**
	 * Getter method for errorInfo
	 *
	 * @return the errorInfo
	 */
	public ErrorInfoVO getErrorInfo() {
		return errorInfo;
	}

	/**
	 * Setter method for errorInfo
	 *
	 * @param errorInfo
	 *            the errorInfo to set
	 */
	public void setErrorInfo(ErrorInfoVO errorInfo) {
		this.errorInfo = errorInfo;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "BaseResponseVO [responseType=" + responseType + ", errorInfo=" + errorInfo + "]";
	}

}
