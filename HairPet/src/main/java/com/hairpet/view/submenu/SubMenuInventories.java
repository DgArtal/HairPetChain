package com.hairpet.view.submenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import com.hairpet.controler.context.AppContext;

public class SubMenuInventories extends SubMenu {

	@Override
	public void configureAltaOption() {
		alta = new JMenuItem("Añadir Artículo");
		alta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				System.out.println("Has pulsado Añadir Artículo");
				AppContext.getInstance().fireEvent("alta_inventario", false, true);

			}
		});
	}

	@Override
	public void configureSearchOption() {
		search = new JMenuItem("Buscar Artículos");
		search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				System.out.println("Has pulsado Buscar Artículos");
				AppContext.getInstance().fireEvent("buscar_inventarios", false, true);

			}
		});
	}

}
