package com.hairpet.view.menu;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public abstract class AbstractMenu extends JMenu {

	public ArrayList<JMenuItem> menuItems = new ArrayList<JMenuItem>();
	public ArrayList<JMenu> menus = new ArrayList<JMenu>();

	public AbstractMenu() {
		super();
		configure();
	}

	public AbstractMenu(String string) {
		super(string);
		configure();
	}

	public abstract void configure();

	public void addMenuItems(List<JMenuItem> menuItems) {
		for (JMenuItem jmi : menuItems) {
			add(jmi);
		}
	}

	public void addMenus(List<JMenu> menus) {
		for (JMenu jm : menus) {
			add(jm);
		}
	}
}
