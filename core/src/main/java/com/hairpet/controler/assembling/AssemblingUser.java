package com.hairpet.controler.assembling;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.hairpet.controler.db.ServiceUser;
import com.hairpet.model.User;

public class AssemblingUser implements Assembling<User, List<String[]>> {

	private User user;
	private ArrayList<User> listUsers;
	private ServiceUser serviceUser = new ServiceUser();
	// Necesitamos los campos a mostrar en los resultados, Los dos últimos
	// campos reservados a la vista
	private final static String[] TABLE_FIELDS = { "id", "name", "upd", "del" };
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
		try {
			return serviceUser.insert(user);
		} catch (Exception e) {
			log.error("Se ha producido un error al insertar en la base de datos: " + e.getMessage());
			throw new RuntimeException(e);
		}
	}

	public String[][] allUsers() {
		try {
			listUsers = (ArrayList<User>) serviceUser.searchAll(null);
			int nRows = listUsers.size();
			int nCols = TABLE_FIELDS.length;
			String[][] result = new String[nRows][nCols];
			for (int i = 0; i < listUsers.size(); i++) {
				result[i][0] = String.valueOf(listUsers.get(i).getId());
				result[i][1] = listUsers.get(i).getName();
			}
			return result;
		} catch (Exception e) {
			log.error("No se puede obtener la lista de usuarios");
			throw new RuntimeException(e);
		}
	}
	
}
