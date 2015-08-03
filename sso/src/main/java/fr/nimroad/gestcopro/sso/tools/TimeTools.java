package fr.nimroad.gestcopro.sso.tools;

import java.time.Duration;
import java.time.LocalDateTime;

public enum TimeTools {

INSTANCE;
    
    public boolean validateExpirationTime(LocalDateTime dateOfCreation, Duration durationOfValidity){
        return dateOfCreation.isBefore(dateOfCreation.plus(durationOfValidity));
    }
    
}
