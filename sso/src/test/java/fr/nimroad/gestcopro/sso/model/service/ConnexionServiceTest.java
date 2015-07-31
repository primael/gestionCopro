package fr.nimroad.gestcopro.sso.model.service;

import org.junit.Assert;
import org.junit.Test;

import fr.nimroad.gestcopro.sso.model.entite.Utilisateur;
import fr.nimroad.gestcopro.sso.model.service.implementation.ConnexionServiceImplementation;

public class ConnexionServiceTest {

	private ConnexionService instanceUnderTest = ConnexionService.getInstance();
	
	@Test
	public void testInstance(){
		Assert.assertNotNull("Instance de connexionService", instanceUnderTest);
		
		ConnexionService instanceUnderTest2 = ConnexionService.getInstance();
		
		Assert.assertEquals("Même instance, différentes variables",  instanceUnderTest, instanceUnderTest2);
		
		ConnexionService instanceUnderTest3 = ConnexionServiceImplementation.INSTANCE;
		
		Assert.assertEquals("Même instance, appels différents",  instanceUnderTest, instanceUnderTest3);
	}
	
	@Test
	public void testCreationUtilisateur(){
				
		final Utilisateur utilisateur = instanceUnderTest.createUSer("primael", "aqwzsx123", "primael@l-infini.fr", "BRUANT", "Primaël");
		
		Assert.assertNotNull("Utilisateur créer", utilisateur);
		
		Assert.assertNotNull("Utilisateur id", utilisateur.getId());
		
		Assert.assertNotEquals("Utilisateur id value", 0l, utilisateur.getId().longValue());
		
		Assert.assertNotNull("Utilisateur identifiant", utilisateur.getIdentifiant());
		
		Assert.assertEquals("Utilisateur identifiant value", "primael", utilisateur.getIdentifiant());
		
		Assert.assertNotNull("Utilisateur password", utilisateur.getHashPassword());
		
		Assert.assertNotEquals("Utilisateur password value", "aqwzsx123", utilisateur.getHashPassword());
		
		Assert.assertNotNull("Utilisateur salt", utilisateur.getSalt());
		
		Assert.assertNotNull("Utilisateur eMail", utilisateur.getEmail());
		
		Assert.assertEquals("Utilisateur eMail value", "primael@l-infini.fr", utilisateur.getEmail());
	}
	
	@Test
	public void testConnexionUtilisateur(){
		Assert.assertTrue(instanceUnderTest.connected("primael", "aqwzsx123"));
		Assert.assertFalse(instanceUnderTest.connected("primael", "aqwzsx123*"));
		Assert.assertFalse(instanceUnderTest.connected("primaela", "aqwzsx123"));
	}
	
}
