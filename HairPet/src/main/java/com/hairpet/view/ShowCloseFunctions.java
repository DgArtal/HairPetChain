package com.hairpet.view;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

import com.hairpet.view.form.AltaForm;
import com.hairpet.view.form.NewClientForm;
import com.hairpet.view.form.NewHairdresserForm;
import com.hairpet.view.form.NewInventoryForm;
import com.hairpet.view.form.NewPetForm;
import com.hairpet.view.form.NewUserForm;
import com.hairpet.view.form.NewVisitForm;
import com.hairpet.view.form.SearchForm;

public final class ShowCloseFunctions {

	public static void showAltaForm(JFrame mainForm, JInternalFrame altaForm, String entity) {
		JPanel altaPanel = null;
		if (entity.equals("user")) {
			altaPanel = new NewUserForm();
		} else if (entity.equals("client")) {
			altaPanel = new NewClientForm();
		} else if (entity.equals("hairdresser")) {
			altaPanel = new NewHairdresserForm();
		} else if (entity.equals("pet")) {
			altaPanel = new NewPetForm();
		} else if (entity.equals("inventory")) {
			altaPanel = new NewInventoryForm();
		} else if (entity.equals("visit")) {
			altaPanel = new NewVisitForm();
		}

		altaForm = new AltaForm(altaPanel);
		mainForm.add(altaForm);
		mainForm.setVisible(true);
	}

	public static void closeInternalFrame(JInternalFrame internalFrame) {
		internalFrame.dispose();
	}

	public static void closeFrame(JFrame mainFrame) {
		mainFrame.dispose();
	}

	public static void showSearchForm(JFrame mainForm, SearchForm searchForm, String entity) {
		// JPanel searchPanel = null;
		// if (entity.equals("user")) {
		// searchPanel = new NewUserForm();
		// } else if (entity.equals("client")) {
		// searchPanel = new NewClientForm();
		// } else if (entity.equals("hairdresser")) {
		// searchPanel = new NewHairdresserForm();
		// } else if (entity.equals("pet")) {
		// searchPanel = new NewPetForm();
		// } else if (entity.equals("inventory")) {
		// searchPanel = new NewInventoryForm();
		// } else if (entity.equals("visit")) {
		// searchPanel = new NewVisitForm();
		// }
		//
		// searchForm = new SearchForm(searchPanel);
		mainForm.add(searchForm);
		mainForm.setVisible(true);

	}
}
