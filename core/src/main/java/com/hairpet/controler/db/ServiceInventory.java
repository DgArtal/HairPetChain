package com.hairpet.controler.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.hairpet.controler.DBControler;
import com.hairpet.controler.context.Session;
import com.hairpet.model.Inventory;

public class ServiceInventory implements DAO<Inventory, Integer> {

	private DBControler dbcontroler;

	private final static String dbTable = "inventories";
	private final static String identifierField = "idInventory";
	private final static String[] fields = { identifierField, "name", "articleCode", "quantity", "idHairdresser" };

	public ServiceInventory() {
		super();
		dbcontroler = Session.getDBControler();
	}

	@Override
	public boolean insert(Inventory bean) throws Exception {
		String query = "INSERT INTO " + dbTable + "(name, articleCode, quantity, idHairdresser) VALUES (?,?,?,?)";

		PreparedStatement ps = dbcontroler.getPrepareStatement(query);
		ps.setString(1, bean.getName());
		ps.setString(2, bean.getArticleCode());
		ps.setInt(3, bean.getQuantity());
		ps.setInt(4, bean.getIdHairdresser());
		ps.executeUpdate();
		return true;
	}

	@Override
	public Integer update(Inventory bean) throws Exception {
		String query = "UPDATE " + dbTable + " SET name = ?, articleCode = ?, " + "quantity = ? , "
				+ "idHairdresser = ? " + "WHERE " + identifierField + " = ?";
		PreparedStatement ps = dbcontroler.getPrepareStatement(query);

		ps.setString(1, bean.getName());
		ps.setString(2, bean.getArticleCode());
		ps.setInt(3, bean.getQuantity());
		ps.setInt(4, bean.getIdHairdresser());
		ps.setInt(5, bean.getId());
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
	public Inventory find(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Inventory> searchAll(Inventory bean) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer exists(Inventory bean) throws Exception {
		String query = "SELECT * FROM " + dbTable + " WHERE articleCode LIKE ?;";
		PreparedStatement ps = dbcontroler.getPrepareStatement(query);

		ps.setString(3, bean.getArticleCode());
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
				+ "name VARCHAR(50), articleCode VARCHAR(10), quantity INT, idHairdresser INT);";
		try {
			dbcontroler.execute(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Insertamos Datos
		Inventory inventory = new Inventory();
		try {
			inventory.setName("Tijeras");
			inventory.setArticleCode("MC001");
			inventory.setQuantity(8);
			inventory.setIdHairdresser(2);
			insert(inventory);
			inventory.setName("Cepillo");
			inventory.setArticleCode("MP004");
			inventory.setQuantity(4);
			inventory.setIdHairdresser(1);
			insert(inventory);
			inventory.setName("Secador");
			inventory.setArticleCode("ES012");
			inventory.setQuantity(2);
			inventory.setIdHairdresser(3);
			insert(inventory);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
