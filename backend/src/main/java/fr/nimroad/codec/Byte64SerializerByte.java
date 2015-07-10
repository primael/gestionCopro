package fr.nimroad.codec;

import java.util.Base64;

public enum Byte64SerializerByte implements Serializer<byte[], byte[]> {

	INSTANCE;
	
	@Override
	public byte[] encode(byte[] object) {
		return Base64.getEncoder().encode(object);
	}

	@Override
	public byte[] decode(byte[] object) {
		return Base64.getDecoder().decode(object);
	}

}
