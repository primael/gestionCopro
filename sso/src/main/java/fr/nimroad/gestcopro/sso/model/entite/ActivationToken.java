package fr.nimroad.gestcopro.sso.model.entite;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@DiscriminatorValue("activation")
public class ActivationToken extends Token {

    public ActivationToken(Utilisateur utilisateur) {
        super(utilisateur);
    }

}