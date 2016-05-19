package com.hairpet.controler.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.hairpet.controler.DBControler;
import com.hairpet.controler.context.Session;
import com.hairpet.model.Visit;

public class ServiceVisit implements DAO<Visit, Integer> {

	private DBControler dbcontroler;

	private final static String dbTable = "visits";
	private final static String identifierField = "idVisit";
	private final static String[] fields = { identifierField, "date", "idHaidresser", "idPet" };

	private final static Logger log = Logger.getLogger(ServiceVisit.class.getName());

	public ServiceVisit() {
		super();
		dbcontroler = Session.getDBControler();
	}

	@Override
	public boolean insert(Visit bean) throws Exception {
		log.info("Vamos a insertar Visita");
		String query = "INSERT INTO " + dbTable + "(date, idHaidresser, idPet) VALUES (?,?,?)";
		PreparedStatement ps = dbcontroler.getPrepareStatement(query);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = (Date) bean.getDate();

		ps.setString(1, sdf.format(date));
		ps.setInt(2, bean.getIdHaidresser());
		ps.setInt(3, bean.getIdPet());
		log.debug(ps.toString());
		ps.executeUpdate();
		return true;
	}

	@Override
	public Integer update(Visit bean) throws Exception {
		String query = "UPDATE " + dbTable + " SET date = ?, idHaidresser = ?, " + "idPet = ? " + "WHERE "
				+ identifierField + " = ?";
		PreparedStatement ps = dbcontroler.getPrepareStatement(query);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = (Date) bean.getDate();
		ps.setString(1, sdf.format(date));
		ps.setInt(2, bean.getIdHaidresser());
		ps.setInt(3, bean.getIdPet());
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
	public Visit find(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Visit> searchAll(Visit bean) throws Exception {
		String query = "SELECT * FROM " + dbTable;
		// TODO Establecer filtros con el bean
		ArrayList<Visit> list = new ArrayList<>();
		PreparedStatement ps = dbcontroler.getPrepareStatement(query);
		ResultSet rs = ps.executeQuery();
		rs.first();
		while (rs.next()) {
			Visit visit = new Visit();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			visit.setId(rs.getInt(identifierField));
			visit.setDate(sdf.parse(rs.getString(fields[1])));
			visit.setIdHairdresser(rs.getInt(fields[2]));
			visit.setIdPet(rs.getInt(fields[3]));
			list.add(visit);
		}
		rs.close();
		ps.close();
		return list;
	}

	@Override
	public Integer exists(Visit bean) throws Exception {
		String query = "SELECT * FROM " + dbTable + " WHERE date LIKE ? AND idHairdresser = ? AND idPet = ?;";
		PreparedStatement ps = dbcontroler.getPrepareStatement(query);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = (Date) bean.getDate();

		ps.setString(1, sdf.format(date));
		ps.setInt(2, bean.getIdHaidresser());
		ps.setInt(3, bean.getIdPet());
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
				+ " INT PRIMARY KEY AUTO_INCREMENT," + "date DATETIME, idHaidresser INT, idPet INT);";
		try {
			dbcontroler.execute(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Insertamos Datos
		Visit visit = new Visit();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			visit.setDate(sdf.parse("2016-05-20 18:30:00"));
			visit.setIdHairdresser(1);
			visit.setIdPet(2);
			insert(visit);
			visit.setDate(sdf.parse("2016-05-20 19:15:00"));
			visit.setIdHairdresser(2);
			visit.setIdPet(3);
			insert(visit);
			visit.setDate(sdf.parse("2016-05-20 11:45:00"));
			visit.setIdHairdresser(3);
			visit.setIdPet(1);
			insert(visit);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
