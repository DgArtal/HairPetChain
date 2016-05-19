package com.hairpet.controler.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hairpet.controler.DBControler;
import com.hairpet.controler.context.Session;
import com.hairpet.model.Hairdresser;

public class ServiceHairdresser implements DAO<Hairdresser, Integer> {

	private DBControler dbcontroler;

	private final static String dbTable = "hairdressers";
	private final static String identifierField = "idHairdresser";

	public ServiceHairdresser() {
		super();
		this.dbcontroler = Session.getDBControler();
	}

	@Override
	public boolean insert(Hairdresser bean) throws Exception {
		String query = "INSERT INTO " + dbTable + "(name, phone, direction) VALUES (?,?,?)";
		PreparedStatement ps = dbcontroler.getPrepareStatement(query);
		ps.setString(1, bean.getName());
		ps.setString(2, bean.getPhone());
		ps.setString(3, bean.getDirection());
		ps.execute();
		return true;
	}

	@Override
	public Integer update(Hairdresser bean) throws Exception {
		// String query = "UPDATE " + dbTable + " SET ";
		// query += "name = '" + bean.getName() + "', ";
		// query += "phone = '" + bean.getPhone() + "', ";
		// query += "direction = '" + bean.getDirection() + "' ";
		// query += "WHERE " + identifierField + " = " + bean.getId();
		// return dbcontroler.execute(query);

		String query = "UPDATE " + dbTable + " SET name = ?, phone = ?, " + "direction = ? " + "WHERE "
				+ identifierField + " = ?";
		PreparedStatement ps = dbcontroler.getPrepareStatement(query);
		ps.setString(1, bean.getName());
		ps.setString(2, bean.getPhone());
		ps.setString(3, bean.getDirection());
		ps.setInt(4, bean.getId());
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
	public Hairdresser find(Integer id) throws Exception {
		Hairdresser hairdresser = new Hairdresser();
		String query = "SELECT * FROM " + dbTable + " ";
		query += "WHERE " + identifierField + " = " + id;
		// TODO Realizar query y obtener resultado
		return null;
	}

	@Override
	public List<Hairdresser> searchAll(Hairdresser bean) throws Exception {
		String query = "SELECT * FROM " + dbTable;
		// TODO Establecer filtros con el bean
		ArrayList<Hairdresser> list = new ArrayList<>();
		PreparedStatement ps = dbcontroler.getPrepareStatement(query);
		ResultSet rs = ps.executeQuery();
		rs.first();
		while (rs.next()) {
			Hairdresser hairdresser = new Hairdresser();
			hairdresser.setId(rs.getInt(identifierField));
			hairdresser.setName(rs.getString("name"));
			hairdresser.setDirection(rs.getString("direction"));
			hairdresser.setDirection(rs.getString("phone"));
			list.add(hairdresser);
		}
		rs.close();
		ps.close();
		return list;
	}

	@Override
	public Integer exists(Hairdresser bean) throws Exception {
		String query = "SELECT * FROM " + dbTable + " WHERE name = ?;";
		PreparedStatement ps = dbcontroler.getPrepareStatement(query);
		ps.setString(1, bean.getName());
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
				+ " INT PRIMARY KEY AUTO_INCREMENT,"
				+ "name VARCHAR(50), " + "phone VARCHAR(9), direction VARCHAR(100));";
		try {
			dbcontroler.execute(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Insertamos Datos
		Hairdresser hairdresser = new Hairdresser();
		try {
			hairdresser.setName("El perro alegre");
			hairdresser.setPhone("555123123");
			hairdresser.setDirection("Calle Mayor, 5");
			insert(hairdresser);
			hairdresser.setName("Corta y ladra");
			hairdresser.setPhone("555988988");
			hairdresser.setDirection("C/Trotamundos, 17");
			insert(hairdresser);
			hairdresser.setName("CutCan");
			hairdresser.setPhone("555445566");
			hairdresser.setDirection("Avenida América, 98");
			insert(hairdresser);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
