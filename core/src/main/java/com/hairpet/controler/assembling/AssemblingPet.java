package com.hairpet.controler.assembling;

import java.util.List;

import org.apache.log4j.Logger;

import com.hairpet.controler.db.ServicePet;
import com.hairpet.model.Pet;

public class AssemblingPet implements Assembling<Pet, List<String[]>> {

	private Pet pet;
	private final static Logger log = Logger.getLogger(AssemblingPet.class.getName());

	public AssemblingPet() {
		super();
	}

	@Override
	public boolean assembling(List<String[]> list) {
		pet = new Pet();
		for (String[] data : list) {
			if (data[0].equals("name")) {
				pet.setName(data[1]);
			} else if (data[0].equals("species")) {
				pet.setSpecies(data[1]);
			} else if (data[0].equals("age")) {
				pet.setAge(Integer.valueOf(data[1]));
			} else if (data[0].equals("idClient")) {
				// Integer.valueOf(data[3])
				pet.setIdClient(2);
			}
		}
		return insertToDB(pet);
	}

	@Override
	public boolean insertToDB(Pet bean) {
		ServicePet servicePet = new ServicePet();
		try {
			servicePet.insert(bean);
			return true;
		} catch (Exception e) {
			log.error("Error al intentar insertar en la Base de Datos: " + e.getMessage());
			throw new RuntimeException(e);
		}
	}

}
