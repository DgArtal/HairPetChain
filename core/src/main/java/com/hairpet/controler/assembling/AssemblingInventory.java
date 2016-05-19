package com.hairpet.controler.assembling;

import java.util.List;

import org.apache.log4j.Logger;

import com.hairpet.controler.db.ServiceInventory;
import com.hairpet.model.Inventory;

public class AssemblingInventory implements Assembling<Inventory, List<String[]>> {

	private Inventory inventory;
	private final static Logger log = Logger.getLogger(AssemblingInventory.class.getName());

	public AssemblingInventory() {
		super();
	}

	@Override
	public boolean assembling(List<String[]> list) {
		inventory = new Inventory();
		for (String[] data : list) {
			if (data[0].equals("name")) {
				inventory.setName(data[1]);
			} else if (data[0].equals("articleCode")) {
				inventory.setArticleCode(data[1]);
			} else if (data[0].equals("quantity")) {
				inventory.setQuantity(Integer.valueOf(data[1]));
			} else if (data[0].equals("idHairdresser")) {
				inventory.setIdHairdresser(Integer.valueOf(data[1]));
			}
		}
		return insertToDB(inventory);
	}

	@Override
	public boolean insertToDB(Inventory bean) {
		ServiceInventory serviceInventory = new ServiceInventory();
		try {
			return serviceInventory.insert(bean);
		} catch (Exception e) {
			log.error("Se ha producido un error al insertar en la base de datos: " + e.getMessage());
			throw new RuntimeException(e);
		}
	}

}
