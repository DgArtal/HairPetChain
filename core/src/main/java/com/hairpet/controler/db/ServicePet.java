package com.hairpet.controler.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.hairpet.controler.DBControler;
import com.hairpet.controler.context.Session;
import com.hairpet.model.Pet;

public class ServicePet implements DAO<Pet, Integer> {

	private DBControler dbcontroler;

	private final static String dbTable = "pets";
	private final static String identifierField = "idPet";
	private final static String[] fields = { identifierField, "name", "species", "age", "idClient" };

	public ServicePet() {
		super();
		this.dbcontroler = Session.getDBControler();
	}

	@Override
	public boolean insert(Pet bean) throws Exception {
		String query = "INSERT INTO " + dbTable + "(name, species, age, idClient) VALUES (?,?,?,?)";
		PreparedStatement ps = dbcontroler.getPrepareStatement(query);
		ps.setString(1, bean.getName());
		ps.setString(2, bean.getSpecies());
		ps.setInt(3, bean.getAge());
		ps.setInt(4, bean.getIdClient());
		ps.execute();
		return true;
	}

	@Override
	public Integer update(Pet bean) throws Exception {
		String query = "UPDATE " + dbTable + " SET name = ?, idClient = ? WHERE " + identifierField + " = ?";
		PreparedStatement ps = dbcontroler.getPrepareStatement(query);
		ps.setString(1, bean.getName());
		ps.setInt(2, bean.getIdClient());
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
	public Pet find(Integer id) throws Exception {
		Pet pet = null;
		String query = "SELECT * FROM " + dbTable + " WHERE " + identifierField + " = ?;";
		PreparedStatement ps = dbcontroler.getPrepareStatement(query);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.first()) {
			pet.setId(id);
			pet.setName(rs.getString("name"));
			pet.setSpecies(rs.getString("species"));
			pet.setAge(Integer.valueOf(rs.getString("age")));
			pet.setIdClient(Integer.valueOf(rs.getString("idClient")));
		}
		rs.close();
		ps.close();
		return pet;
	}

	@Override
	public List<Pet> searchAll(Pet bean) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer exists(Pet bean) throws Exception {
		String query = "SELECT * FROM " + dbTable + " WHERE name = ? AND idClient = ?;";
		PreparedStatement ps = dbcontroler.getPrepareStatement(query);
		ps.setString(1, bean.getName());
		ps.setInt(2, bean.getIdClient());
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
				+ " INT PRIMARY KEY AUTO_INCREMENT," + "name VARCHAR(50), "
				+ "species VARCHAR(20), age INT, idClient INT);";
		try {
			dbcontroler.execute(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Insertamos Datos
		Pet pet = new Pet();
		try {
			pet.setName("Chispas");
			pet.setSpecies("gato");
			pet.setAge(15);
			pet.setIdClient(1);
			insert(pet);
			pet.setName("Sulfuroso");
			pet.setSpecies("gato");
			pet.setAge(15);
			pet.setIdClient(2);
			insert(pet);
			pet.setName("Scalibur");
			pet.setSpecies("perro");
			pet.setAge(14);
			pet.setIdClient(3);
			insert(pet);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
