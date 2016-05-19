package com.hairpet.view.submenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import com.hairpet.controler.context.AppContext;

public class SubMenuInventories extends SubMenu {

	@Override
	public void configureAltaOption() {
		alta = new JMenuItem("A�adir Art�culo");
		alta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				System.out.println("Has pulsado A�adir Art�culo");
				AppContext.getInstance().fireEvent("alta_inventario", false, true);

			}
		});
	}

	@Override
	public void configureSearchOption() {
		search = new JMenuItem("Buscar Art�culos");
		search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				System.out.println("Has pulsado Buscar Art�culos");
				AppContext.getInstance().fireEvent("buscar_inventarios", false, true);

			}
		});
	}

}
