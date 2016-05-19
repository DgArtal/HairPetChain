package com.hairpet.view.form;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.hairpet.controler.assembling.AssemblingHairdresser;
import com.hairpet.controler.context.AppContext;
import com.hairpet.view.OkCancelButtons;

public class NewHairdresserForm extends JPanel {

	private JTextField hairdresserName;
	private JTextField hairdresserDirection;
	private JTextField hairdresserPhone;

	public NewHairdresserForm() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblNombre = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.WEST;
		gbc_lblNombre.insets = new Insets(10, 15, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 1;
		add(lblNombre, gbc_lblNombre);

		hairdresserName = new JTextField();
		GridBagConstraints gbc_hairdresserName = new GridBagConstraints();
		gbc_hairdresserName.gridwidth = 2;
		gbc_hairdresserName.insets = new Insets(0, 10, 5, 10);
		gbc_hairdresserName.fill = GridBagConstraints.HORIZONTAL;
		gbc_hairdresserName.gridx = 1;
		gbc_hairdresserName.gridy = 2;
		add(hairdresserName, gbc_hairdresserName);
		hairdresserName.setColumns(10);

		JLabel lblDirection = new JLabel("Direcci\u00F3n");
		GridBagConstraints gbc_lblDirection = new GridBagConstraints();
		gbc_lblDirection.anchor = GridBagConstraints.WEST;
		gbc_lblDirection.insets = new Insets(10, 15, 5, 5);
		gbc_lblDirection.gridx = 1;
		gbc_lblDirection.gridy = 3;
		add(lblDirection, gbc_lblDirection);

		hairdresserDirection = new JTextField();
		GridBagConstraints gbc_hairdresserDirection = new GridBagConstraints();
		gbc_hairdresserDirection.gridwidth = 2;
		gbc_hairdresserDirection.insets = new Insets(0, 10, 5, 10);
		gbc_hairdresserDirection.fill = GridBagConstraints.HORIZONTAL;
		gbc_hairdresserDirection.gridx = 1;
		gbc_hairdresserDirection.gridy = 4;
		add(hairdresserDirection, gbc_hairdresserDirection);
		hairdresserDirection.setColumns(10);

		JLabel lblTelefono = new JLabel("Tel\u00E9fono");
		GridBagConstraints gbc_lblTelefono = new GridBagConstraints();
		gbc_lblTelefono.anchor = GridBagConstraints.WEST;
		gbc_lblTelefono.insets = new Insets(10, 15, 5, 5);
		gbc_lblTelefono.gridx = 1;
		gbc_lblTelefono.gridy = 5;
		add(lblTelefono, gbc_lblTelefono);

		hairdresserPhone = new JTextField();
		GridBagConstraints gbc_hairdresserPhone = new GridBagConstraints();
		gbc_hairdresserPhone.gridwidth = 2;
		gbc_hairdresserPhone.insets = new Insets(0, 10, 5, 10);
		gbc_hairdresserPhone.fill = GridBagConstraints.HORIZONTAL;
		gbc_hairdresserPhone.gridx = 1;
		gbc_hairdresserPhone.gridy = 6;
		add(hairdresserPhone, gbc_hairdresserPhone);
		hairdresserPhone.setColumns(10);

		OkCancelButtons okCancel = new OkCancelButtons("Registrar", "Cancelar") {
			@Override
			public void addActionCancelButton() {
				this.getCancel().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						AppContext.getInstance().fireEvent("close_alta_form", false, true);
					}
				});
				GridBagConstraints gbc_cancelButton = new GridBagConstraints();
				gbc_cancelButton.anchor = GridBagConstraints.CENTER;
				// gbc_cancelButton.fill = GridBagConstraints.HORIZONTAL;
				gbc_cancelButton.insets = new Insets(20, 10, 20, 20);
				gbc_cancelButton.gridx = 2;
				gbc_cancelButton.gridy = 7;
				add(this.getCancel(), gbc_cancelButton);
			}

			@Override
			public void addActionAcceptButton() {
				this.getAccept().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						 ArrayList<String[]> listParams = new ArrayList<>();
						 String[][] tuplaClaveValor = new String[5][2];
						 // TODO Comprobar que los campos esten completos y
						 // correctos
						 tuplaClaveValor[0][0] = "name";
						 tuplaClaveValor[0][1] = hairdresserName.getText();
						 listParams.add(tuplaClaveValor[0]);
						tuplaClaveValor[1][0] = "phone";
						tuplaClaveValor[1][1] = hairdresserPhone.getText();
						 listParams.add(tuplaClaveValor[1]);
						tuplaClaveValor[2][0] = "direction";
						tuplaClaveValor[2][1] = hairdresserDirection.getText();
						listParams.add(tuplaClaveValor[2]);
						AssemblingHairdresser assemblingHairdresser = new AssemblingHairdresser();
						if (assemblingHairdresser.assembling(listParams)) {
							JOptionPane.showMessageDialog(null, "La Peluquería se ha registrado correctamente.");
						 }
						 else {
							JOptionPane.showMessageDialog(null, "Se ha producido un error. Inténtalo más tarde.");
						 }
						AppContext.getInstance().fireEvent("close_alta_form", false, true);
					}
				});
				GridBagConstraints gbc_acceptButton = new GridBagConstraints();
				gbc_acceptButton.anchor = GridBagConstraints.CENTER;
				// gbc_acceptButton.fill = GridBagConstraints.HORIZONTAL;
				gbc_acceptButton.insets = new Insets(20, 10, 20, 20);
				gbc_acceptButton.gridx = 1;
				gbc_acceptButton.gridy = 7;
				add(this.getAccept(), gbc_acceptButton);
			}
		};
		okCancel.addActions();
	}


}
