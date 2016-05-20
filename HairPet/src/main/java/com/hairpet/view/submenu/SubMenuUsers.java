package com.hairpet.view.submenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import com.hairpet.controler.context.AppContext;

public class SubMenuUsers extends SubMenu {

	@Override
	public void configureAltaOption() {
		alta = new JMenuItem("Nuevo Usuario");

		alta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AppContext.getInstance().fireEvent("alta_usuario", false, true);
			}
		});
	}

	@Override
	public void configureSearchOption() {
		search = new JMenuItem("Buscar Usuario");
		search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AppContext.getInstance().fireEvent("buscar_usuarios", false, true);
			}
		});
	}


}
