package com.hairpet.view.form;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;

import com.hairpet.controler.context.AppContext;

public class AltaForm extends JInternalFrame {

	private JPanel panel;

	public AltaForm(JPanel panel) {
		super();
		initForm(panel);

	}

	private void initForm(JPanel panel) {
		this.panel = panel;
		add(panel);
		setBounds(100, 100, 300, 200);
		setResizable(true);
		setClosable(true);
		setVisible(true);
		pack();
		// Añadimos Escuchador para cerrar la ventana
		AppContext.getInstance().addPropertyChangeListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if (evt.getPropertyName().equals("close_alta_form")) {
					dispose();
				}

			}
		});
	}

}
