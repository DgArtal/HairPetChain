package com.hairpet.view.submenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import com.hairpet.controler.context.AppContext;

public class SubMenuHairdressers extends SubMenu {

	@Override
	public void configureAltaOption() {
		alta = new JMenuItem("Nueva Peluquería");
		alta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				System.out.println("Has pulsado alta en Peluquería");
				AppContext.getInstance().fireEvent("alta_peluqueria", false, true);

			}
		});
	}

	@Override
	public void configureSearchOption() {
		search = new JMenuItem("Buscar Peluquería");
		search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				System.out.println("Has pulsado Buscar en Peluquería");
				AppContext.getInstance().fireEvent("buscar_peluquerias", false, true);

			}
		});
	}

}
