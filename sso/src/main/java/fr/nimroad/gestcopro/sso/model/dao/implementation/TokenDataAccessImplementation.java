package fr.nimroad.gestcopro.sso.model.dao.implementation;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import lombok.Cleanup;
import fr.nimroad.gestcopro.sso.model.dao.TokenDataAccess;
import fr.nimroad.gestcopro.sso.model.entite.Token;

public abstract class TokenDataAccessImplementation<T extends Token> implements TokenDataAccess<T> {

	@SuppressWarnings("unchecked")
    @Override
    public T findTokenByToken(String token) {
		
        @Cleanup
        EntityManager entityManager = FACTORY.createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("Select t From Token t Where t.token = :token");
        query.setParameter("token", token);

        T tokenObject = (T) query.getResultList().stream().findFirst().orElse(null);

        entityManager.getTransaction().commit();
        
        return tokenObject;
    }

}
