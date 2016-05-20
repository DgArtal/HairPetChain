package com.hairpet.controler.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hairpet.controler.DBControler;
import com.hairpet.controler.context.Session;
import com.hairpet.model.Client;

public class ServiceClient implements DAO<Client, Integer> {

	private DBControler dbcontroler;

	private final static String dbTable = "clients";
	private final static String identifierField = "idClient";
	private final static String[] fields = { identifierField, "name", "dni" };

	public ServiceClient() {
		super();
		this.dbcontroler = Session.getDBControler();
	}

	@Override
	public boolean insert(Client bean) throws Exception {
		String query = "INSERT INTO " + dbTable + "(name, dni) VALUES (?,?)";
		PreparedStatement ps = dbcontroler.getPrepareStatement(query);
		ps.setString(1, bean.getName());
		ps.setString(2, bean.getDni());
		ps.execute();
		return true; // Si hay fallo, lanzará una excepción y no devuelve true
	}

	@Override
	public Integer update(Client bean) throws Exception {
		String query = "UPDATE " + dbTable + " SET name = ?, dni = ? WHERE " + identifierField + " = ?;";
		PreparedStatement ps = dbcontroler.getPrepareStatement(query);
		ps.setString(1, bean.getName());
		ps.setString(2, String.valueOf(bean.getDni()));
		ps.setInt(3, bean.getId());
		return ps.executeUpdate();
	}

	@Override
	public boolean delete(Integer id) throws Exception {
		String query = "DELETE FROM " + dbTable + " WHERE " + identifierField + " = ?;";
		PreparedStatement ps = dbcontroler.getPrepareStatement(query);
		ps.setInt(1, id);
		ps.execute();
		return true;
	}

	@Override
	public Client find(Integer id) throws Exception {
		Client client = null;
		String query = "SELECT * FROM " + dbTable + " WHERE " + identifierField + " = ?;";
		PreparedStatement ps = dbcontroler.getPrepareStatement(query);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.first()) {
			client.setId(id);
			client.setName(rs.getString(fields[1]));
			client.setDni(rs.getString(fields[2]));
		}
		rs.close();
		ps.close();
		return client;
	}

	@Override
	public List<Client> searchAll(Client bean) throws Exception {
		String query = "SELECT * FROM " + dbTable;
		// TODO Establecer filtros con el bean
		ArrayList<Client> list = new ArrayList<>();
		PreparedStatement ps = dbcontroler.getPrepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Client client = new Client();
			client.setId(rs.getInt(identifierField));
			client.setName(rs.getString(fields[1]));
			client.setDni(rs.getString(fields[2]));
			list.add(client);
		}
		rs.close();
		ps.close();
		return list;
	}

	@Override
	public Integer exists(Client bean) throws Exception {
		String query = "SELECT * FROM " + dbTable + " WHERE name = ? AND dni = ?;";
		PreparedStatement ps = dbcontroler.getPrepareStatement(query);
		ps.setString(1, bean.getName());
		ps.setString(2, bean.getDni());
		ResultSet rs = ps.executeQuery();
		if (rs.first()) {
			bean.setId(rs.getInt(identifierField));
		} else {
			bean.setId(-1);
		}
		rs.close();
		ps.close();
		return bean.getId();
	}

	// **************** METODOS CREACION DATOS PRUEBA **************************

	public void datosPrueba() {

		String query = "CREATE TABLE IF NOT EXISTS " + dbTable + "(" + identifierField
				+ " INT PRIMARY KEY AUTO_INCREMENT," + "name VARCHAR(50)," + "dni VARCHAR(9));";
		try {
			dbcontroler.execute(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Insertamos Datos
		Client client = new Client();
		try {
			client.setName("Juan");
			client.setDni("11111111H");
			insert(client);
			client.setName("Sofía");
			client.setDni("12345678Z");
			insert(client);
			client.setName("Rebeca");
			client.setDni("65425812F");
			insert(client);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
