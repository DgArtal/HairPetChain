package com.hairpet.view.menu;

import java.util.List;

import javax.swing.JMenu;

import com.hairpet.view.submenu.SubMenuClients;
import com.hairpet.view.submenu.SubMenuUsers;

public class AdministrationMenu extends AbstractMenu {

	private static JMenu users;
	private static JMenu clients;

	public AdministrationMenu() {
		super("Administración");
		addMenus((List<JMenu>) menus);
	}

	@Override
	public void configure() {
		configureUsersOption();
		configureClientsOption();
	}

	private void configureUsersOption() {
		users = new JMenu("Usuarios");
		users.setBounds(0, 0, 20, 100);
		users.setAlignmentX(CENTER_ALIGNMENT);

		menus.add(users);
		SubMenuUsers subMenuUsuarios = new SubMenuUsers();
		subMenuUsuarios.addComponents(users);
	}

	private void configureClientsOption() {
		clients = new JMenu("Clientes");
		clients.setBounds(0, 0, 20, 100);
		clients.setAlignmentX(CENTER_ALIGNMENT);

		menus.add(clients);
		SubMenuClients subMenuClients = new SubMenuClients();
		subMenuClients.addComponents(clients);
	}


}
