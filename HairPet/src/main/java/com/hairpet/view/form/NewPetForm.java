package com.hairpet.view.form;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.log4j.Logger;

import com.hairpet.controler.assembling.AssemblingPet;
import com.hairpet.controler.context.AppContext;
import com.hairpet.view.OkCancelButtons;

public class NewPetForm extends JPanel {

	private JTextField petName;
	private JTextField petSpecies;
	private JTextField petAge;
	private JLabel lblCliente;
	private JComboBox petClient;

	private final static Logger log = Logger.getLogger(NewPetForm.class.getName());

	public NewPetForm() {
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

		petName = new JTextField();
		GridBagConstraints gbc_petName = new GridBagConstraints();
		gbc_petName.fill = GridBagConstraints.HORIZONTAL;
		gbc_petName.gridwidth = 2;
		gbc_petName.insets = new Insets(0, 10, 5, 10);
		gbc_petName.gridx = 1;
		gbc_petName.gridy = 2;
		add(petName, gbc_petName);
		petName.setColumns(10);

		JLabel lblSpecies = new JLabel("Especie");
		GridBagConstraints gbc_lblSpecies = new GridBagConstraints();
		gbc_lblSpecies.anchor = GridBagConstraints.WEST;
		gbc_lblSpecies.insets = new Insets(10, 15, 5, 5);
		gbc_lblSpecies.gridx = 1;
		gbc_lblSpecies.gridy = 3;
		add(lblSpecies, gbc_lblSpecies);

		petSpecies = new JTextField();
		GridBagConstraints gbc_petSpecies = new GridBagConstraints();
		gbc_petSpecies.gridwidth = 2;
		gbc_petSpecies.insets = new Insets(0, 10, 5, 10);
		gbc_petSpecies.fill = GridBagConstraints.HORIZONTAL;
		gbc_petSpecies.gridx = 1;
		gbc_petSpecies.gridy = 4;
		add(petSpecies, gbc_petSpecies);
		petSpecies.setColumns(10);

		JLabel lblAge = new JLabel("Edad");
		GridBagConstraints gbc_lblAge = new GridBagConstraints();
		gbc_lblAge.anchor = GridBagConstraints.WEST;
		gbc_lblAge.insets = new Insets(10, 15, 5, 5);
		gbc_lblAge.gridx = 1;
		gbc_lblAge.gridy = 5;
		add(lblAge, gbc_lblAge);

		lblCliente = new JLabel("Due\u00F1o");
		GridBagConstraints gbc_lblCliente = new GridBagConstraints();
		gbc_lblCliente.anchor = GridBagConstraints.WEST;
		gbc_lblCliente.insets = new Insets(10, 15, 5, 0);
		gbc_lblCliente.gridx = 2;
		gbc_lblCliente.gridy = 5;
		add(lblCliente, gbc_lblCliente);

		petAge = new JTextField();
		GridBagConstraints gbc_petAge = new GridBagConstraints();
		gbc_petAge.anchor = GridBagConstraints.WEST;
		gbc_petAge.insets = new Insets(0, 10, 0, 10);
		gbc_petAge.gridx = 1;
		gbc_petAge.gridy = 6;
		add(petAge, gbc_petAge);
		petAge.setColumns(10);

		petClient = new JComboBox();
		GridBagConstraints gbc_petClient = new GridBagConstraints();
		gbc_petClient.insets = new Insets(0, 10, 5, 10);
		gbc_petClient.fill = GridBagConstraints.HORIZONTAL;
		gbc_petClient.gridx = 2;
		gbc_petClient.gridy = 6;
		add(petClient, gbc_petClient);

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
						tuplaClaveValor[0][1] = petName.getText();
						listParams.add(tuplaClaveValor[0]);
						tuplaClaveValor[1][0] = "species";
						tuplaClaveValor[1][1] = petSpecies.getText();
						listParams.add(tuplaClaveValor[1]);
						tuplaClaveValor[2][0] = "age";
						tuplaClaveValor[2][1] = petAge.getText();
						listParams.add(tuplaClaveValor[2]);
						tuplaClaveValor[3][0] = "idClient";
						tuplaClaveValor[3][1] = String.valueOf(petClient.getSelectedItem());
						listParams.add(tuplaClaveValor[3]);
						AssemblingPet assemblingPets = new AssemblingPet();
						if (assemblingPets.assembling(listParams)) {
							JOptionPane.showMessageDialog(null, "La mascota se ha registrado correctamente.");
							log.info("Registro mascota correcto!");
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
