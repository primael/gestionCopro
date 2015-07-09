package fr.nimroad.codec;

import java.util.Base64;

public enum Byte64Serializer implements Serializer<String, byte[]> {

	INSTANCE;
	
	@Override
	public String encode(byte[] object) {
		return Base64.getEncoder().encodeToString(object);
	}

	@Override
	public byte[] decode(String object) {
		// TODO Auto-generated method stub
		return Base64.getDecoder().decode(object);
	}

}
