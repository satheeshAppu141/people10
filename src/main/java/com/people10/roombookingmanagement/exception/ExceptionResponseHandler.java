/**
 * 
 */
package com.people10.roombookingmanagement.exception;

import java.lang.reflect.UndeclaredThrowableException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.people10.roombookingmanagement.vo.BaseResponseVO;
import com.people10.roombookingmanagement.vo.ErrorInfoVO;

/**
 * 
 * This file responsible to override the http status code as 500 when exception occurred
 *
 * @author: SatheeshB
 *
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
@ControllerAdvice
public class ExceptionResponseHandler extends ResponseEntityExceptionHandler {

	/**
	 * Method to handle the exception and override the response status
	 * 
	 * @param exception
	 *            which contains exception object
	 * 
	 * @return {@code ResponseEntity}) contains response entity
	 */
	@ExceptionHandler(Exception.class)
	public final ResponseEntity handleAllExceptions(Exception exception) {

		// Handle the exception if audit is enabled
		if (exception instanceof UndeclaredThrowableException) {
			final UndeclaredThrowableException ex = (UndeclaredThrowableException) exception;
			final Throwable t = ex.getUndeclaredThrowable();

			if (t instanceof ApplicationException) {
				return handleApplicationException((ApplicationException) t);
			} else if (t instanceof SystemException) {
				return handleSystemException((SystemException) t);
			}
		}

		// Check and Set error info
		if (exception instanceof ApplicationException) {
			return handleApplicationException((ApplicationException) exception);
		}

		// Check and Set error info
		if (exception instanceof SystemException) {
			return handleSystemException((SystemException) exception);
		}

		return handleUnexpectedException(exception);
	}

	/**
	 * Method to handle application exception
	 * 
	 * @param ex
	 *            which contains edgewood application exception
	 * @return ({@code ResponseEntity}) contains response entity
	 */
	private ResponseEntity handleApplicationException(final ApplicationException ex) {
		final BaseResponseVO response = new BaseResponseVO();
		response.setResponseType(BaseResponseVO.RESPONSE_TYPE_FAILURE);
		return new ResponseEntity(response, HttpStatus.NOT_FOUND);
	}

	/**
	 * Method to handle system exception
	 * 
	 * @param ex
	 *            which contains edgewood system exception
	 * @return ({@code ResponseEntity}) contains response entity
	 */
	private ResponseEntity handleSystemException(final SystemException ex) {
		final BaseResponseVO response = new BaseResponseVO();
		response.setResponseType(BaseResponseVO.RESPONSE_TYPE_FAILURE);
		final ErrorInfoVO errorInfo = new ErrorInfoVO();
		errorInfo.setErrorMessage(ex.getMessage());
		response.setErrorInfo(errorInfo);
		return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * Method to handle unexpected exception
	 * 
	 * @param ex
	 *            which contains exception
	 * 
	 * @return ({@code ResponseEntity}) contains response entity
	 */
	private ResponseEntity handleUnexpectedException(final Exception ex) {
		final BaseResponseVO response = new BaseResponseVO();
		response.setResponseType(BaseResponseVO.RESPONSE_TYPE_FAILURE);
		final ErrorInfoVO errorInfo = new ErrorInfoVO();
		errorInfo.setErrorMessage(ex.getMessage());
		response.setErrorInfo(errorInfo);
		return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}