package com.hairpet.view.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public class SubMenu extends AbstractMenu {

	private JMenuItem alta;
	private JMenuItem search;

	public SubMenu() {
		super();
		configure();
	}

	@Override
	public void configure() {
		configureAltaOption();
		configureSearchOption();

	}

	private void configureAltaOption() {
		alta = new JMenuItem("Alta");
		alta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// setVisible(false); //Se hace invisible el método
				// TODO lanzar evento para cerrar la ventana principal

			}
		});

	}

	private void configureSearchOption() {
		search = new JMenuItem("Buscar");
		search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// setVisible(false); //Se hace invisible el método
				// TODO lanzar evento para cerrar la ventana principal

			}
		});// TODO Auto-generated method stub

	}

	protected void addComponents(JMenuItem menu) {
		menu.add(alta);
		menu.add(search);
	}

}
