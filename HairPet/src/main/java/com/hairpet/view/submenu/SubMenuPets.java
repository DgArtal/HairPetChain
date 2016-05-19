package com.hairpet.view.submenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import com.hairpet.controler.context.AppContext;

public class SubMenuPets extends SubMenu {

	@Override
	public void configureAltaOption() {
		alta = new JMenuItem("Nueva Mascota");
		alta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AppContext.getInstance().fireEvent("alta_mascota", false, true);

			}
		});
	}

	@Override
	public void configureSearchOption() {
		search = new JMenuItem("Buscar Mascota");
		search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AppContext.getInstance().fireEvent("buscar_mascotas", false, true);

			}
		});
	}

}
