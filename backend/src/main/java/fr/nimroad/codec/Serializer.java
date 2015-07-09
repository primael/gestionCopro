package fr.nimroad.codec;

public interface Serializer<TO, FROM> {

	public TO encode(FROM object);
	
	public FROM decode(TO object);
}
