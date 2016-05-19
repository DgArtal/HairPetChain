package com.hairpet.controler.assembling;

import java.util.List;

import org.apache.log4j.Logger;

import com.hairpet.controler.db.ServiceUser;
import com.hairpet.model.User;

public class AssemblingUser implements Assembling<User, List<String[]>> {

	private User user;
	private final static Logger log = Logger.getLogger(AssemblingUser.class.getName());

	public AssemblingUser() {
		super();
	}

	@Override
	public boolean assembling(List<String[]> list) {
		user = new User();
		for (String[] data : list) {
			if (data[0].equals("name")) {
				user.setName(data[1]);
			} else if (data[0].equals("password")) {
				user.setPassword(data[1]);
			}
		}
		return insertToDB(user);
	}

	@Override
	public boolean insertToDB(User user) {
		ServiceUser serviceUser = new ServiceUser();
		try {
			return serviceUser.insert(user);
		} catch (Exception e) {
			log.error("Se ha producido un error al insertar en la base de datos: " + e.getMessage());
			throw new RuntimeException(e);
		}
	}
	
}
