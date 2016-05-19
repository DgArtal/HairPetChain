package com.hairpet.view.submenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import com.hairpet.controler.context.AppContext;

public class SubMenuVisits extends SubMenu {

	@Override
	public void configureAltaOption() {
		alta = new JMenuItem("Generar Visita");
		alta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				System.out.println("Has pulsado alta en visitas");
				AppContext.getInstance().fireEvent("alta_visita", false, true);

			}
		});
	}

	@Override
	public void configureSearchOption() {
		search = new JMenuItem("Buscar Visitas");
		search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				System.out.println("Has pulsado Buscar en visita");
				AppContext.getInstance().fireEvent("buscar_visitas", false, true);

			}
		});
	}

}
