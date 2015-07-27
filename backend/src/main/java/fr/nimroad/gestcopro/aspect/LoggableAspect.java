package fr.nimroad.gestcopro.aspect;

import lombok.extern.log4j.Log4j2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
@Log4j2
public class LoggableAspect {
	
	@Before("execution(* *.*(..)) && @annotation(loggable) ")
	public void parseParams(JoinPoint jointPoint, Loggable loggable){
		log.info("Entered JoinPoint : {}", jointPoint.getSignature());
	}
}
