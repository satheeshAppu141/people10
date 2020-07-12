package com.people10.roombookingmanagement.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class is responsible to support hibernate specific utility methods (ex: closing the given session).
 *
 * @author: SatheeshB
 */
public final class HibernateUtil {
	private static final Logger log = LoggerFactory.getLogger(HibernateUtil.class);

	/**
	 * Private default constructor
	 */
	private HibernateUtil() {
	}

	/**
	 * Method to close the hibernate session.
	 * 
	 * @param session
	 *            Hibernate session (Session object)
	 */
	public static void closeSession(final Session session) {
		log.debug("Closing Hibernate Session ..");
		if (session != null && session.isOpen()) {
			try {
				session.close();
			} catch (HibernateException ex) {
				log.error("Could not close Hibernate Session", ex);
			} catch (Throwable ex) {
				log.error("Unexpected exception on closing Hibernate Session", ex);
			}
		}
	}
}
