package fr.nimroad.gestcopro.app.model.dao;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import org.junit.Assert;
import org.junit.Test;

import fr.nimroad.gestcopro.app.model.entite.TypeVoie;

public class TypeVoieDaoTest {

	private TypeVoieDao instanceUnderTest = TypeVoieDao.getInstance();

	@Test
	public void testFindByLibelle() {
		for (TypeVoieEnum typeVoieEnum : TypeVoieEnum.values()) {
			TypeVoie typeVoie = instanceUnderTest.findByLibelle(typeVoieEnum.getLibelle());
			this.confirmationResultat(typeVoie, typeVoieEnum, "libelle");
		}
	}

	@Test
	public void testFindByAbbreviation() {
		for (TypeVoieEnum typeVoieEnum : TypeVoieEnum.values()) {
			TypeVoie typeVoie = instanceUnderTest.findByAbbreviation(typeVoieEnum.getAbbreviation());
			this.confirmationResultat(typeVoie, typeVoieEnum, "abbreviation");
		}
	}

	private void confirmationResultat(TypeVoie typeVoie, TypeVoieEnum typeVoieEnum, String method) {
		if ("abbreviation".equals(method)
				&& (typeVoieEnum.equals(TypeVoieEnum.SENTE) || typeVoieEnum.equals(TypeVoieEnum.SENTIER))) {
			Assert.assertNull("Test de nullité sur : " + typeVoieEnum.getLibelle(), typeVoie);
		} else {
			Assert.assertNotNull("Test de non-nullité sur : " + typeVoieEnum.getLibelle(), typeVoie);
			Assert.assertEquals("Test d'égalité sur : " + typeVoieEnum.getAbbreviation(),
					typeVoieEnum.getAbbreviation(), typeVoie.getAbbreviation());
			Assert.assertEquals("Test d'égalité sur : " + typeVoieEnum.getLibelle(), typeVoieEnum.getLibelle(),
					typeVoie.getLibelle());
			Assert.assertEquals("Test d'égalité sur : " + typeVoieEnum.getId(), typeVoieEnum.getId(), typeVoie.getId());
		}
	}

	@Getter
	@AllArgsConstructor(access = AccessLevel.PRIVATE)
	private enum TypeVoieEnum {

		ALLEE("Allée", "ALL", 47), //
		AVE("Avenue", "AV", 48), //
		BVD("Boulevard", "BD", 49), //
		CAR("Carrefour", "CAR", 50), //
		CHE("Chemin", "CHE", 51), //
		CHS("Chaussée", "CHS", 52), //
		CITE("Cité", "CITE", 53), //
		SENTIER("Sentier", "SEN", 83), //
		SENTE("Sente", "SEN", 84), //
		;

		private final String libelle;
		private final String abbreviation;
		private final Integer id;

	}
}
