package fr.nimroad.gestcopro.sso.model.dao;

import fr.nimroad.gestcopro.sso.model.entite.Token;
import fr.nimroad.gestcopro.sso.model.entite.Utilisateur;
import fr.nimroad.gestcopro.sso.model.entite.token.TypeToken;
import fr.nimroad.gestcopro.utils.model.dao.DataAccessObject;

public interface TokenDataAccess<T extends Token> extends DataAccessObject<Long, T> {

	Token findTokenByToken(String token);

	default void invalidatePreviousTokens(Utilisateur utilisateur) {
		// N'est pas n�cessaire pour toutes les DAOs..
		// Quoique (g�n�ralisable?)
	}

	static TokenDataAccess<?> getDataAccess(TypeToken typeToken) {
		return typeToken.getDao();
	}

}
