package com.hairpet.controler.context;

public class AppContext {
	
	 private static Context INSTANCE = new Context();

	    // El constructor privado no permite que se genere un constructor por defecto.
	    // (con mismo modificador de acceso que la definición de la clase) 
	    private AppContext() {}

	    public static Context getInstance() {
	        return INSTANCE;
	    }
	
}

