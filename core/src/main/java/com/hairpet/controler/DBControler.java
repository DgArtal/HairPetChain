package com.hairpet.controler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

public class DBControler {

	private static Connection conn;
	private static final String driverNameDatabase = "org.h2.Driver";
	private static String dataBaseName = "jdbc:h2:~/Documents/HairPet/data/hairpet";
	//Crear conexion según usuario y contraseña
	private String dataBaseUser = "sa";
	private String dataBasePassword = "";
	private Integer idUser;

	private final static Logger log = Logger.getLogger(DBControler.class.getName());

	public DBControler() {
		super();
		try {
			Class.forName(driverNameDatabase);
			conn = DriverManager.getConnection(dataBaseName, dataBaseUser, dataBasePassword);
			log.info("Conexión a la base de datos realizada con éxito");
		} catch (ClassNotFoundException | SQLException e) {
			log.error("Mensaje: " + e.getMessage());
			log.error("Causa: " + e.getCause());
			throw new RuntimeException(e);
		}
	}

	public boolean isConnection() {
		return (conn != null ? true : false);
	}

	public void closeConnection(){
		if(conn != null){
			try {
				conn.close();
				log.info("Conexión cerrada");
			} catch (SQLException e) {
				log.error("Mensaje: " + e.getMessage());
				throw new RuntimeException(e);
			}
		}
	}

	public ArrayList executeQuery(String query) throws SQLException {
		// TODO Trabajar la lista
		ArrayList<Object> list = null;
		ResultSet rs = null;
		Statement stm = null;
		try {
			stm = conn.createStatement();
			rs = stm.executeQuery(query);
			rs.first();
			do {
				log.info("//TODO Hay que serializar la clase");
				// SErializar la clase
			} while (rs.next());
			return list;
		} catch (SQLException e) {
			log.error("Mensaje: " + e.getMessage());
			throw e;
		} finally {
			closeStatement(stm);
		}
	}

	public boolean execute(String query) throws SQLException {
		Statement stm = null;
		try {
			stm = conn.createStatement();
			return stm.execute(query);
		} catch (SQLException e) {
			log.error("Mensaje: " + e.getMessage());
			log.error("Causa: " + e.getCause());
			throw new RuntimeException(e);
		} finally {
			closeStatement(stm);
		}
	}

	public void closeStatement(Statement stm) {
		try {
			if (stm != null) {
				stm.close();
			}
		} catch (SQLException e) {
			log.error("Mensaje: " + e.getMessage());
			new RuntimeException(e);
		}
	}

	public void closeResultSet(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			log.error("Mensaje: " + e.getMessage());
			new RuntimeException(e);
		}
	}

	public void setDataBaseUser(String dataBaseUser) {
		this.dataBaseUser = dataBaseUser;
	}

	public void setDataBasePassword(String dataBasePassword) {
		this.dataBasePassword = dataBasePassword;
	}

	public PreparedStatement getPrepareStatement(String query) throws SQLException {
		return conn.prepareStatement(query);
	}

}
