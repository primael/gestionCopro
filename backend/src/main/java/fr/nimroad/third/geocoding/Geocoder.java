package fr.nimroad.third.geocoding;

import lombok.SneakyThrows;

import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderRequest;

import fr.nimroad.gestcopro.app.model.entite.Adresse;

public enum Geocoder {

	INSTANCE;
	
	@SneakyThrows
	public void geocodeAdress(Adresse adresse){
		
		final com.google.code.geocoder.Geocoder geocoder = new com.google.code.geocoder.Geocoder();
		
		
		GeocoderRequest geocoderRequest = new GeocoderRequestBuilder() //
			.setAddress(adresseToString(adresse)) //
			.setLanguage("fr") //
			.getGeocoderRequest();
		
		GeocodeResponse geocoderResponse = geocoder.geocode(geocoderRequest);
		adresse.setLattitude(geocoderResponse.getResults().get(0).getGeometry().getLocation().getLat());
		adresse.setLongitude(geocoderResponse.getResults().get(0).getGeometry().getLocation().getLng());
	}
	
	private String adresseToString(Adresse adresse){
		
		String toReturn = adresse.getNumero() + " " + adresse.getTypeVoie().getLibelle() + " " + adresse.getNomVoie() + " " + adresse.getCommune().getCodePostal() + " " + adresse.getCommune().getNom();
		return toReturn;
	}
}
