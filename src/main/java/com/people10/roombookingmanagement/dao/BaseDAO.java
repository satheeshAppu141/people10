package com.people10.roombookingmanagement.dao;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

/**
 * This base DAO class holds hibernate template and supports CRUD operations, which subclasses can utilize.
 * 
 * @author SatheeshB
 */
public abstract class BaseDAO {

	/** HibenrateTemplate instance used for CRUD operations */
	@Autowired
	private HibernateTemplate hibernateTemplate;

	/**
	 * Protected constructor
	 */
	protected BaseDAO() {
	}

	/**
	 * Method to get the HibernateTemplate object
	 * 
	 * @return the current HibernateTemplate object
	 */
	protected HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	/**
	 * Method to get the SessionFactory object
	 * 
	 * @return the current SessionFactory object
	 */
	protected SessionFactory getSessionFactory() {
		return this.hibernateTemplate.getSessionFactory();
	}

	/**
	 * Method to get Entity / Persistence Class by id
	 * 
	 * @param <T>
	 *            The type parameter for entity class
	 * @param persistenceClass
	 *            Class type of enitty
	 * @param id
	 *            identifier of the entity
	 * @return the Entity class
	 */
	protected <T> T getById(Class<T> persistenceClass, Serializable id) {
		return hibernateTemplate.get(persistenceClass, id);
	}

	/**
	 * Method to load Entity / Persistence Class by id
	 * 
	 * @param <T>
	 *            The type parameter for entity class
	 * @param persistenceClass
	 *            Class type of enitty
	 * @param id
	 *            identifier of the entity
	 * @return the Entity class
	 */
	protected <T> T loadById(Class<T> persistenceClass, Serializable id) {
		return hibernateTemplate.load(persistenceClass, id);
	}

	/**
	 * Method to persist the given entity object.
	 * 
	 * @param entity
	 *            entity object to be saved
	 */
	protected void persist(Object entity) {
		hibernateTemplate.persist(entity);
	}

	/**
	 * Method to save the given entity object. It returns the id of newly saved object.
	 * 
	 * @param entity
	 *            entity object to be saved
	 * @return the persisted entity identifier
	 */
	protected Serializable save(Object entity) {
		return hibernateTemplate.save(entity);
	}

	/**
	 * Method to update the given entity object.
	 * 
	 * @param entity
	 *            entity object to be updated
	 */
	protected void update(Object entity) {
		hibernateTemplate.update(entity);
	}

	/**
	 * Method to save/update the given entity object.
	 * 
	 * @param entity
	 *            entity object to be saved/updated
	 */
	protected void saveOrUpdate(Object entity) {
		hibernateTemplate.saveOrUpdate(entity);
	}

	/**
	 * Method to delete the given entity object.
	 * 
	 * @param entity
	 *            entity object to be deleted
	 */
	protected void delete(Object entity) {
		hibernateTemplate.delete(entity);
	}
}
