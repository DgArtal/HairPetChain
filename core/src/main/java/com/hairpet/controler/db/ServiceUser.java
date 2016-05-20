package com.hairpet.controler.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.hairpet.controler.DBControler;
import com.hairpet.controler.context.Session;
import com.hairpet.model.User;

public class ServiceUser implements DAO<User, Integer> {

	private DBControler dbcontroler;

	private final static String DB_TABLE = "users";
	private final static String IDENTIFIER_FIELD = "idUser";
	private final static String[] FIELDS = { IDENTIFIER_FIELD, "name", "password" };

	private static Logger log = Logger.getLogger(ServiceUser.class.getName());

	public ServiceUser() {
		super();
		this.dbcontroler = Session.getDBControler();
	}

	@Override
	public boolean insert(User bean) throws Exception {
		if (exists(bean) == -1) {
			String query = "INSERT INTO " + DB_TABLE + "(name, password) VALUES (?,?)";
			PreparedStatement ps = dbcontroler.getPrepareStatement(query);
			ps.setString(1, bean.getName());
			ps.setString(2, bean.getPassword());
			ps.executeUpdate();
			return true;
		} else {
			log.error("El usuario ya está registrado");
			return false;
		}
	}

	@Override
	public Integer update(User bean) throws Exception {
		String query = "UPDATE " + DB_TABLE + " SET name = ?, password = ? WHERE " + IDENTIFIER_FIELD + " = ?;";
		PreparedStatement ps = dbcontroler.getPrepareStatement(query);
		ps.setString(1, bean.getName());
		ps.setString(2, String.valueOf(bean.getPassword()));
		ps.setInt(3, bean.getId());
		return ps.executeUpdate();
	}

	@Override
	public boolean delete(Integer id) throws Exception {
		String query = "DELETE FROM " + DB_TABLE + " WHERE " + IDENTIFIER_FIELD + " = ?;";
		PreparedStatement ps = dbcontroler.getPrepareStatement(query);
		ps.setInt(1, id);
		ps.execute();
		return true;
	}

	@Override
	public User find(Integer id) throws Exception {
		User user = null;
		String query = "SELECT * FROM " + DB_TABLE + " WHERE " + IDENTIFIER_FIELD + " = ?;";
		PreparedStatement ps = dbcontroler.getPrepareStatement(query);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.first()) {
			user.setId(id);
			user.setName(rs.getString("name"));
			user.setPassword(rs.getString("password"));
		}
		rs.close();
		ps.close();
		return user;
	}

	@Override
	public List<User> searchAll(User bean) throws Exception {
		String query = "SELECT * FROM " + DB_TABLE;
		// TODO Establecer filtros con el bean
		ArrayList<User> list = new ArrayList<>();
		PreparedStatement ps = dbcontroler.getPrepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			User user = new User();
			user.setId(rs.getInt(IDENTIFIER_FIELD));
			user.setName(rs.getString(FIELDS[1]));
			user.setPassword(rs.getString(FIELDS[2]));
			list.add(user);
		}
		rs.close();
		ps.close();
		return list;
	}

	@Override
	public Integer exists(User bean) throws Exception {
		// TODO Codificar password
		String query = "SELECT * FROM " + DB_TABLE + " WHERE name = ? AND password = ?;";
		PreparedStatement ps = dbcontroler.getPrepareStatement(query);
		ps.setString(1, bean.getName());
		ps.setString(2, bean.getPassword());
		ResultSet rs = ps.executeQuery();
		if (rs.first()) {
			bean.setId(rs.getInt(IDENTIFIER_FIELD));
		} else {
			bean.setId(-1);
		}
		rs.close();
		ps.close();
		return bean.getId();
	}

	// **************** METODOS CREACION DATOS PRUEBA **************************

	public void datosPrueba() {

		String query = "CREATE TABLE IF NOT EXISTS " + DB_TABLE + "(" + IDENTIFIER_FIELD
				+ " INT PRIMARY KEY AUTO_INCREMENT,"
				+ "name VARCHAR(50)," + "password VARCHAR(32));";
		try {
			dbcontroler.execute(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Insertamos Datos
		User user = new User();
		try {
			user.setName("admin");
			user.setPassword("1234");
			insert(user);
			user.setName("Pablo");
			user.setPassword("olbap");
			insert(user);
			user.setName("Laura");
			user.setPassword("arual");
			insert(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
