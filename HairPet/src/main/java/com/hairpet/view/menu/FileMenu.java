package com.hairpet.view.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JMenuItem;

import com.hairpet.controler.context.AppContext;

public class FileMenu extends AbstractMenu {

	private static JMenuItem exit;

	public FileMenu() {
		super("Archivo");
		addMenuItems((List<JMenuItem>) menuItems);
	}


	@Override
	public void configure() {
		configureExitOption();
	}

	private void configureExitOption() {
		exit = new JMenuItem("Exit");
		exit.setBounds(0, 0, 20, 100);
		exit.setAlignmentX(CENTER_ALIGNMENT);
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AppContext.getInstance().fireEvent("close_aplication", false, true);
			}
		});
		menuItems.add((JMenuItem) exit);
	}


}
