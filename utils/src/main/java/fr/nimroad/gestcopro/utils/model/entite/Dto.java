package fr.nimroad.gestcopro.utils.model.entite;

import java.io.Serializable;

public interface Dto<N> extends Serializable {

	N getId();

	void setId(N id);
}
