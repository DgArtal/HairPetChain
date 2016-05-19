package com.hairpet.controler;

import com.hairpet.controler.db.ServiceUser;
import com.hairpet.model.User;

public class LoginControler {

	private ServiceUser serviceUser = new ServiceUser();

	public LoginControler() {
		super();
	}

	public Integer checkUser(String name, String password) {
		User user = new User();
		user.setName(name);
		user.setPassword(password);
		try {
			return (Integer) serviceUser.exists(user);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
