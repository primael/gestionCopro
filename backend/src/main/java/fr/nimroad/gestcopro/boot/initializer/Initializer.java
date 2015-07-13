package fr.nimroad.gestcopro.boot.initializer;

import javax.servlet.http.HttpServlet;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Initializer extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void init(){
		this.splashScreen();
	}
	
	private void splashScreen(){
		log.info("");
	}
}
