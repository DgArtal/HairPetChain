package com.hairpet.controler.context;

import com.hairpet.controler.DBControler;

public class Session {

	private static DBControler instance = null;
	private static Integer sessionLoggedId = 0;
	private static String sessionLoggedName = null;

	private Session() {
	 // Exists only to defeat instantiation.
	 }

	// public static Session getSession(){
	// if (instance == null) {
	// instance = new DBControler();
	// }
	// return Session();
	// }

	public static DBControler getDBControler() {
		if (instance == null) {
			instance = new DBControler();
		}
		return instance;
	}


	public static Integer getSessionLoggedId() {
		return sessionLoggedId;
	}

	public static void setSessionLoggedId(Integer sessionLoggedId) {
		Session.sessionLoggedId = sessionLoggedId;
	}

	public static String getSessionLoggedName() {
		return sessionLoggedName;
	}

	public static void setSessionLoggedName(String sessionLoggedName) {
		Session.sessionLoggedName = sessionLoggedName;
	}
}
