package com.people10.roombookingmanagement.dao.impl;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.people10.roombookingmanagement.dao.BaseDAO;
import com.people10.roombookingmanagement.dao.IRoomBookingDAO;
import com.people10.roombookingmanagement.entity.Customer;
import com.people10.roombookingmanagement.exception.SystemException;
import com.people10.roombookingmanagement.util.HibernateUtil;

@Repository
public class RoomBookingDAO extends BaseDAO implements IRoomBookingDAO {

	private static final Logger log = LoggerFactory.getLogger(RoomBookingDAO.class);

	/**
	 * Constant to hold the error message to throw the exception when getting customer by id
	 **/
	private static final String GET_CUSTOMER__BY_ID_ERROR = "error while getting customer by id";

	@Override
	public Customer getCustomerById(final Long customerId) {
		Customer customer = null;
		Session session = null;
		try {
			session = getHibernateTemplate().getSessionFactory().openSession();

			/**
			 * Note: Open a new hibernate session, which is not participated in any transaction, execute and close. It
			 * should be used by any service class, which does not use transaction for service api.
			 */
			session = getHibernateTemplate().getSessionFactory().openSession();
			customer = (Customer) session.createQuery("select c from Customer c where c.id=:customerId")
				.setParameter("customerId", customerId).uniqueResult();

		} catch (SystemException ex) {
			log.error(GET_CUSTOMER__BY_ID_ERROR, ex);
			throw new SystemException(GET_CUSTOMER__BY_ID_ERROR, ex);
		} finally {
			HibernateUtil.closeSession(session);
		}
		return customer;
	}
}
