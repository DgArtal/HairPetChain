package com.hairpet.view.submenu;

import javax.swing.JMenuItem;

import com.hairpet.view.menu.AbstractMenu;

public abstract class SubMenu extends AbstractMenu {

	protected JMenuItem alta;
	protected JMenuItem search;

	public SubMenu() {
		super();
		configure();
	}

	@Override
	public void configure() {
		configureAltaOption();
		configureSearchOption();

	}

	public abstract void configureAltaOption();

	public abstract void configureSearchOption();

	public void addComponents(JMenuItem menu) {
		menu.add(alta);
		menu.add(search);
	}

}
