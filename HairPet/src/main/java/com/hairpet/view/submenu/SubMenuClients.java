package com.hairpet.view.submenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import com.hairpet.controler.context.AppContext;

public class SubMenuClients extends SubMenu {

	@Override
	public void configureAltaOption() {
		alta = new JMenuItem("Nuevo Cliente");
		alta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				System.out.println("Has pulsado alta en cliente");
				AppContext.getInstance().fireEvent("alta_cliente", false, true);

			}
		});
	}

	@Override
	public void configureSearchOption() {
		search = new JMenuItem("Buscar Cliente");
		search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				System.out.println("Has pulsado Buscar en cliente");
				AppContext.getInstance().fireEvent("buscar_clientes", false, true);
			}
		});
	}

}
