package fr.nimroad.gestcopro.utils.codec;

import java.io.IOException;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public enum Base64Helper {

	INSTANCE;
	
	 /**
	    * From a base 64 representation, returns the corresponding byte[] 
	    * @param data String The base64 representation
	    * @return byte[]
	    * @throws IOException
	    */
	   public byte[] base64ToByte(String data) throws IOException {
	       Decoder decoder = Base64.getDecoder();
	       return decoder.decode(data);
	   }
	 
	   /**
	    * From a byte[] returns a base 64 representation
	    * @param data byte[]
	    * @return String
	    * @throws IOException
	    */
	   public String byteToBase64(byte[] data){
	       Encoder encoder = Base64.getEncoder();
	       return encoder.encodeToString(data);
	   }
}
