package fr.nimroad.gestcopro.utils.model.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import lombok.Cleanup;

import com.google.common.base.Preconditions;

import fr.nimroad.gestcopro.exception.GestCoproException;
import fr.nimroad.gestcopro.exception.technical.TechnicalException;
import fr.nimroad.gestcopro.utils.model.entite.Dto;

public interface DataAccessObject<PK extends Serializable, E extends Dto<?>> {

	static final String ENTITY_NAME = "gestcoprosso";

	public static final EntityManagerFactory FACTORY = Persistence .createEntityManagerFactory(ENTITY_NAME);

	//String getTypeEntity();
	
	@SuppressWarnings("unchecked")
	default Class<E> getClassObject() {
		return (Class<E>) this.getClass().getGenericInterfaces()[0].getClass();
	}

	default E save(E entity) throws GestCoproException {
		Preconditions.checkNotNull(entity, "Got unexpected null 'entity' passed to the method.");
		
		try {
			@Cleanup
			EntityManager entityManager = FACTORY.createEntityManager();

			entityManager.getTransaction().begin();

			if(entity.getId() == null) {
				entityManager.persist(entity);
			} else {
				entityManager.merge(entity);
			}

			entityManager.getTransaction().commit();

			return entity;
		} catch (PersistenceException exception) {
			throw new TechnicalException(exception);
		}
	}

	default List<E> getAll() {
		@Cleanup
		final EntityManager entityManager = FACTORY.createEntityManager();
		
		final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<E> criteriaQuery = criteriaBuilder.createQuery(getClassObject());
		final Root<E> root = criteriaQuery.from(getClassObject());
		criteriaQuery.select(root);
		
		final TypedQuery<E> query = entityManager.createQuery(criteriaQuery);
		
		return new ArrayList<E>(query.getResultList());
	}

	default E update(E entity) throws GestCoproException {
		try {
			@Cleanup
			EntityManager entityManager = FACTORY.createEntityManager();

			entityManager.getTransaction().begin();
			entity = entityManager.merge(entity);
			entityManager.getTransaction().commit();
			return entity;

		} catch (PersistenceException exception) {
			throw new TechnicalException(exception);
		}
	}

	default void delete(E entity) {
		@Cleanup
		EntityManager entityManager = FACTORY.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.remove(entity);
		entityManager.getTransaction().commit();
	}

	default E get(PK id) throws TechnicalException {
		Preconditions.checkNotNull(id, "Got unexpected null 'id' passed to the method.");
		E entity;
		try {
			@Cleanup
			EntityManager entityManager = FACTORY.createEntityManager();

			entityManager.getTransaction().begin();
			entity = entityManager.find(getClassObject(), id);
			entityManager.getTransaction().commit();
			return entity;

		} catch (PersistenceException exception) {
			throw new TechnicalException(exception);
		}
	}

	@SuppressWarnings("unchecked")
	default List<E> findWhithNamedQuery(String namedQuery) {
		@Cleanup
		EntityManager entityManager = FACTORY.createEntityManager();
		return entityManager.createNamedQuery(namedQuery).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	default List<E> findWhithNamedQuery(String namedQuery, int resultLimit) {
		
		List<E> toReturn;
		@Cleanup
		EntityManager entityManager = FACTORY.createEntityManager();
		
		final List<E> result = entityManager.createNamedQuery(namedQuery).getResultList();
		
		if(resultLimit < result.size()){
			toReturn = result.subList(0, resultLimit);
		} else {
			toReturn = result;
		}
		
		return toReturn;
	}
	
	default List<E> findWhithNamedQuery(String namedQuery, Map<String, Object> parameters) {
		return findWhithNamedQuery(namedQuery, parameters, 0);
	}
	
	default List<E> findWhithNamedQuery(String namedQuery, Map<String, Object> parameters, int resultLimits) {
		TypedQuery<E> requete = getRequest(namedQuery, parameters);
		
		if(resultLimits > 0){
			requete.setMaxResults(resultLimits);
		}
		
		return requete.getResultList();
	}

	default E findOneWhithNamedQuery(String namedQuery, Map<String, Object> parameters) {
		TypedQuery<E> requete = getRequest(namedQuery, parameters);
		
		return (E) requete.getSingleResult();
    }
	
	default TypedQuery<E> getRequest(String namedQuery, Map<String, Object> parameters){
		
		@Cleanup
		EntityManager entityManager = FACTORY.createEntityManager();
		Set<Entry<String, Object>> rawParameters = parameters.entrySet();
		TypedQuery<E> requete = entityManager.createNamedQuery(namedQuery, getClassObject());
		
		for(Entry<String, Object> entry : rawParameters){
			requete.setParameter(entry.getKey(), entry.getValue());
		}
		
		return requete;
	}
}
