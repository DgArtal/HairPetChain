package com.hairpet.view.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JMenu;

import com.hairpet.view.submenu.SubMenuHairdressers;
import com.hairpet.view.submenu.SubMenuInventories;
import com.hairpet.view.submenu.SubMenuPets;
import com.hairpet.view.submenu.SubMenuVisits;

public class ModuleMenu extends AbstractMenu {

	private static JMenu visits;
	private static JMenu pets;
	private static JMenu hairdresser;
	private static JMenu inventory;

	public ModuleMenu() {
		super("Modulos");
		addMenus((List<JMenu>) menus);
	}

	@Override
	public void configure() {
		configureVisitsOption();
		configurePetsOption();
		configureHairdresserOption();
		configureInventoryOption();
	}

	private void configureVisitsOption() {
		visits = new JMenu("Visitas");
		visits.setBounds(0, 0, 20, 100);
		visits.setAlignmentX(CENTER_ALIGNMENT);
		visits.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// setVisible(false); //Se hace invisible el método
				// TODO lanzar evento para cerrar la ventana principal
			}
		});

		SubMenuVisits subMenuVisits = new SubMenuVisits();
		subMenuVisits.addComponents(visits);
		menus.add(visits);
	}

	private void configurePetsOption() {
		pets = new JMenu("Mascotas");
		pets.setBounds(0, 0, 20, 100);
		pets.setAlignmentX(CENTER_ALIGNMENT);
		pets.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Desde el listener del elemento");

			}
		});
		SubMenuPets subMenuPets = new SubMenuPets();
		subMenuPets.addComponents(pets);
		pets.addSeparator();
		menus.add(pets);
	}

	private void configureHairdresserOption() {
		hairdresser = new JMenu("Peluquería");
		hairdresser.setBounds(0, 0, 20, 100);
		hairdresser.setAlignmentX(CENTER_ALIGNMENT);
		hairdresser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// setVisible(false); //Se hace invisible el método
				// TODO lanzar evento para cerrar la ventana principal
			}
		});
		SubMenuHairdressers subMenuHairdressers = new SubMenuHairdressers();
		subMenuHairdressers.addComponents(hairdresser);
		menus.add(hairdresser);
	}


	private void configureInventoryOption() {
		inventory = new JMenu("Inventario");
		inventory.setBounds(0, 0, 20, 100);
		inventory.setAlignmentX(CENTER_ALIGNMENT);
		inventory.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// setVisible(false); //Se hace invisible el método
				// TODO lanzar evento para cerrar la ventana principal
			}
		});
		SubMenuInventories subMenuInventories = new SubMenuInventories();
		subMenuInventories.addComponents(inventory);
		menus.add(inventory);
	}

}
