package fr.nimroad.codec;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import lombok.Cleanup;
import lombok.SneakyThrows;

public enum SimpleByteSerializer implements Serializer<byte[], Object>{

	INSTANCE;
	
	@Override
	@SneakyThrows
	public byte[] encode(Object object) {
		@Cleanup final ByteArrayOutputStream baos = new ByteArrayOutputStream();
		@Cleanup final ObjectOutputStream oos = new ObjectOutputStream(baos);
		
		oos.writeObject(object);
		oos.flush();
		
		return baos.toByteArray();
	}

	@Override
	@SneakyThrows
	public Object decode(byte[] object) {
		@Cleanup final InputStream bais = new ByteArrayInputStream(object);
		@Cleanup final ObjectInputStream ois = new ObjectInputStream(bais);

		return ois.readObject();
	}

}
