package com.people10.roombookingmanagement.handler.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.people10.roombookingmanagement.entity.Customer;
import com.people10.roombookingmanagement.exception.ApplicationException;
import com.people10.roombookingmanagement.exception.SystemException;
import com.people10.roombookingmanagement.handler.IRoomBookingHandler;
import com.people10.roombookingmanagement.helper.data.transformer.CustomerTransformer;
import com.people10.roombookingmanagement.service.IRoomBookingService;
import com.people10.roombookingmanagement.vo.BaseResponseVO;
import com.people10.roombookingmanagement.vo.CustomerResponse;
import com.people10.roombookingmanagement.vo.ErrorInfoVO;

@Component
public class RoomBookingHandler implements IRoomBookingHandler {

	private static final Logger log = LoggerFactory.getLogger(RoomBookingHandler.class);

	@Autowired
	private IRoomBookingService roomBookingService;

	@Override
	public CustomerResponse getCustomerInfoById(final Long customerId) {
		log.debug("Inside getCustomerInfoById() - id: {}", customerId);

		final CustomerResponse customerResponse = new CustomerResponse();
		try {
			Customer customer = roomBookingService.getCustomerById(customerId);
			if (customer != null) {
				customerResponse.setCustomer(new CustomerTransformer().transform(customer));
			}

		} catch (ApplicationException | SystemException ex) {
			setErrorInfo(customerResponse, ex);
			return customerResponse;
		}
		return customerResponse;
	}

	private void setErrorInfo(final BaseResponseVO response, final Throwable ex) {
		response.setResponseType(BaseResponseVO.RESPONSE_TYPE_FAILURE);
		response.setErrorInfo(new ErrorInfoVO(ex.getMessage(), ex));
	}

}
