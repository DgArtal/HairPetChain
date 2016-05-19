package com.hairpet.controler.assembling;

import java.util.List;

import org.apache.log4j.Logger;

import com.hairpet.controler.db.ServiceHairdresser;
import com.hairpet.model.Hairdresser;

public class AssemblingHairdresser implements Assembling<Hairdresser, List<String[]>> {

	private Hairdresser hairdresser;
	private final static Logger log = Logger.getLogger(AssemblingHairdresser.class.getName());


	public AssemblingHairdresser() {
		super();
	}

	@Override
	public boolean assembling(List<String[]> list) {
		hairdresser = new Hairdresser();
		for (String[] data : list) {
			if (data[0].equals("name")) {
				hairdresser.setName(data[1]);
			} else if (data[0].equals("phone")) {
				hairdresser.setPhone(data[1]);
			} else if (data[0].equals("direction")) {
				hairdresser.setDirection(data[1]);
			}
		}
		return insertToDB(hairdresser);
	}

	@Override
	public boolean insertToDB(Hairdresser bean) {
		ServiceHairdresser serviceHairdresser = new ServiceHairdresser();
		try {
			return serviceHairdresser.insert(bean);
		} catch (Exception e) {
			log.error("Se ha producido un error al insertar en la base de datos: " + e.getMessage());
			throw new RuntimeException(e);
		}

	}
}
