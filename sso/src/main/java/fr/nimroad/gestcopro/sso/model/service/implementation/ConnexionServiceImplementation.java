package fr.nimroad.gestcopro.sso.model.service.implementation;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

import lombok.SneakyThrows;
import fr.nimroad.gestcopro.sso.model.dao.UtilisateurDao;
import fr.nimroad.gestcopro.sso.model.entite.Utilisateur;
import fr.nimroad.gestcopro.sso.model.service.ConnexionService;
import fr.nimroad.gestcopro.utils.codec.Base64Helper;

public enum ConnexionServiceImplementation implements ConnexionService {

	INSTANCE;

	private final UtilisateurDao utilisateurDao = UtilisateurDao.getInstance();

	private final int ITERATION_NUMBER = 1000;

	@Override
	@SneakyThrows
	public boolean connected(String identifiant, String password) {

		// Controle des entrées
		boolean userExist = true;
		String digest;
		String salt;

		if (identifiant == null || password == null) {
			userExist = false;
			identifiant = "";
			password = "";
		}

		
		Utilisateur utilisateur = utilisateurDao.findByIdentifiant(identifiant);
		
		// TODO add consistency control on salt and digest (hashPassword)

		// Protection over time attack
		if (utilisateur == null) {
			digest = "000000000000000000000000000=";
			salt = "00000000000=";
			userExist = false;
		} else {
			digest = utilisateur.getHashPassword();
			salt = utilisateur.getSalt();
		}

		byte[] bDigest = Base64Helper.INSTANCE.base64ToByte(digest);
		byte[] bSalt = Base64Helper.INSTANCE.base64ToByte(salt);

		byte[] proposedDigest = getHash(ITERATION_NUMBER, password, bSalt);

		return Arrays.equals(proposedDigest, bDigest) && userExist;
	}

	@Override
	@SneakyThrows
	public Utilisateur createUSer(String identifiant, String password, String email) {
		  // Uses a secure Random not a simple Random
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        // Salt generation 64 bits long
        byte[] bSalt = new byte[8];
        random.nextBytes(bSalt);
        // Digest computation
        byte[] bDigest = getHash(ITERATION_NUMBER,password,bSalt);
        String sDigest = Base64Helper.INSTANCE.byteToBase64(bDigest);
        String sSalt = Base64Helper.INSTANCE.byteToBase64(bSalt);
        
        //Construction de l'objet utilisateur
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setIdentifiant(identifiant);
        utilisateur.setEmail(email);
        utilisateur.setHashPassword(sDigest);
        utilisateur.setSalt(sSalt);
        
        utilisateurDao.save(utilisateur);
        
        return utilisateur;
	}
	
	private byte[] getHash(int iterationNb, String password, byte[] salt) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest digest = MessageDigest.getInstance("SHA-1");
		digest.reset();
		digest.update(salt);
		byte[] input = digest.digest(password.getBytes("UTF-8"));
		for (int i = 0; i < iterationNb; i++) {
			digest.reset();
			input = digest.digest(input);
		}
		return input;
	}


}
