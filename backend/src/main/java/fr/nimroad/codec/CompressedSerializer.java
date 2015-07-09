package fr.nimroad.codec;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.zip.Deflater;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import lombok.Cleanup;
import lombok.SneakyThrows;

public enum CompressedSerializer implements Serializer<byte[], Object> {
	
	INSTANCE;

	@Override
	@SneakyThrows
	public byte[] encode(Object object) {
		final ByteArrayOutputStream baos = new ByteArrayOutputStream();
		final GZIPOutputStream gos = new GZIPOutputStream(baos){
			{
				def.setLevel(Deflater.BEST_COMPRESSION);
			}
		};
		
		ObjectOutputStream oos = new ObjectOutputStream(gos);
		oos.writeObject(object);
		
		oos.flush();
		oos.close();
		gos.close();
		baos.close();
		
		return baos.toByteArray();
	}

	@Override
	@SneakyThrows
	public Object decode(byte[] object) {
		@Cleanup final InputStream is = new ByteArrayInputStream(object);
		@Cleanup final GZIPInputStream gos = new GZIPInputStream(is);
		@Cleanup final ObjectInputStream ois = new ObjectInputStream(gos);
		
		return ois.readObject();
	}

}
