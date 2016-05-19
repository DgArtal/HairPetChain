package com.hairpet.controler.assembling;

import java.util.List;

import org.apache.log4j.Logger;

import com.hairpet.controler.db.ServiceClient;
import com.hairpet.model.Client;

public class AssemblingClient implements Assembling<Client, List<String[]>> {

	private Client client;
	private final static Logger log = Logger.getLogger(AssemblingClient.class.getName());

	public AssemblingClient() {
		super();
	}

	@Override
	public boolean assembling(List<String[]> list) {
		client = new Client();
		for (String[] data : list) {
			if (data[0].equals("name")) {
				client.setName(data[1]);
			} else if (data[0].equals("dni")) {
				client.setDni(data[1]);
			}
		}
		return insertToDB(client);
	}

	@Override
	public boolean insertToDB(Client bean) {
		ServiceClient serviceClient = new ServiceClient();
		try {
			return serviceClient.insert(bean);
		} catch (Exception e) {
			log.error("Se ha producido un error al insertar en la base de datos: " + e.getMessage());
			throw new RuntimeException(e);
		}

	}


}
