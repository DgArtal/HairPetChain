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

import com.hairpet.controler.assembling.AssemblingVisit;
import com.hairpet.controler.context.AppContext;
import com.hairpet.view.OkCancelButtons;

public class NewVisitForm extends JPanel {
	private JTextField visitDate;
	private JTextField visitTime;
	private JComboBox visitPet;

	public NewVisitForm() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblDate = new JLabel("Fecha");
		GridBagConstraints gbc_lblDate = new GridBagConstraints();
		gbc_lblDate.anchor = GridBagConstraints.EAST;
		gbc_lblDate.insets = new Insets(10, 10, 5, 5);
		gbc_lblDate.gridx = 1;
		gbc_lblDate.gridy = 1;
		add(lblDate, gbc_lblDate);

		visitDate = new JTextField();
		GridBagConstraints gbc_visitDate = new GridBagConstraints();
		gbc_visitDate.insets = new Insets(10, 5, 5, 20);
		gbc_visitDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_visitDate.gridx = 2;
		gbc_visitDate.gridy = 1;
		add(visitDate, gbc_visitDate);
		visitDate.setColumns(10);

		JLabel lblTime = new JLabel("Hora");
		GridBagConstraints gbc_lblTime = new GridBagConstraints();
		gbc_lblTime.anchor = GridBagConstraints.EAST;
		gbc_lblTime.insets = new Insets(0, 0, 5, 5);
		gbc_lblTime.gridx = 1;
		gbc_lblTime.gridy = 2;
		add(lblTime, gbc_lblTime);

		visitTime = new JTextField();
		GridBagConstraints gbc_visitTime = new GridBagConstraints();
		gbc_visitTime.insets = new Insets(0, 5, 5, 20);
		gbc_visitTime.fill = GridBagConstraints.HORIZONTAL;
		gbc_visitTime.gridx = 2;
		gbc_visitTime.gridy = 2;
		add(visitTime, gbc_visitTime);
		visitTime.setColumns(10);

		JLabel lblMascota = new JLabel("Mascota");
		GridBagConstraints gbc_lblMascota = new GridBagConstraints();
		gbc_lblMascota.anchor = GridBagConstraints.EAST;
		gbc_lblMascota.insets = new Insets(0, 10, 10, 5);
		gbc_lblMascota.gridx = 1;
		gbc_lblMascota.gridy = 3;
		add(lblMascota, gbc_lblMascota);

		visitPet = new JComboBox();
		GridBagConstraints gbc_visitPet = new GridBagConstraints();
		gbc_visitPet.insets = new Insets(0, 5, 10, 20);
		gbc_visitPet.fill = GridBagConstraints.HORIZONTAL;
		gbc_visitPet.gridx = 2;
		gbc_visitPet.gridy = 3;
		add(visitPet, gbc_visitPet);

		OkCancelButtons okCancel = new OkCancelButtons("Reservar", "Cancelar") {
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
						// TODO Comprobar que los campos esten completos y
						// correctos
						String dateTime = visitDate.getText() + " " + visitTime.getText();
						listParams.add(new String[] { "date", dateTime });
						// listParams.add(new String[] { "idPet",
						// String.valueOf(visitPet.getSelectedIndex()) });
						listParams.add(new String[] { "idHairdresser", "1" });
						listParams.add(new String[] { "idPet", "2" });
						AssemblingVisit assemblingVisit = new AssemblingVisit();
						if (assemblingVisit.assembling(listParams)) {
							JOptionPane.showMessageDialog(null, "La visita se ha registrado correctamente.");
						} else {
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
