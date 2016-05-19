package com.hairpet.controler.assembling;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.log4j.Logger;

import com.hairpet.controler.db.ServiceVisit;
import com.hairpet.model.Visit;

public class AssemblingVisit implements Assembling<Visit, List<String[]>> {

	private Visit visit;
	private final static Logger log = Logger.getLogger(AssemblingVisit.class.getName());

	public AssemblingVisit() {
		super();
	}

	@Override
	public boolean assembling(List<String[]> list) {
		visit = new Visit();
		String dateTime = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (String[] data : list) {
			try {
				if (data[0].equals("date")) {
					dateTime = data[1];
					log.info("Formato de fecha correcto: " + dateTime);
					visit.setDate(sdf.parse(dateTime));
					log.info("Formato de fecha correcto. " + dateTime);
				} else if (data[0].equals("idHairdresser")) {
					visit.setIdHairdresser(Integer.valueOf(data[1]));
				} else if (data[0].equals("idPet")) {
					visit.setIdPet(Integer.valueOf(data[1]));
				}
			} catch (ParseException e) {
				log.info("Error al convertir la fecha.");
				e.printStackTrace();
			}
		}
		return insertToDB(visit);
	}

	@Override
	public boolean insertToDB(Visit bean) {
		ServiceVisit serviceVisit = new ServiceVisit();
		try {
			return serviceVisit.insert(bean);
		} catch (Exception e) {
			log.error("Se ha producido un error al insertar en la base de datos: " + e.getMessage());
			throw new RuntimeException(e);
		}
	}

}
