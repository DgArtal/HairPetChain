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

import com.hairpet.controler.assembling.AssemblingClient;
import com.hairpet.controler.context.AppContext;
import com.hairpet.view.OkCancelButtons;

public class NewClientForm extends JPanel {

	private JTextField clientName;
	private JTextField clientDNI;

	public NewClientForm() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblNombre = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.WEST;
		gbc_lblNombre.insets = new Insets(10, 15, 0, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 1;
		add(lblNombre, gbc_lblNombre);

		clientName = new JTextField();
		GridBagConstraints gbc_clientName = new GridBagConstraints();
		gbc_clientName.gridwidth = 2;
		gbc_clientName.insets = new Insets(5, 10, 5, 10);
		gbc_clientName.fill = GridBagConstraints.HORIZONTAL;
		gbc_clientName.gridx = 1;
		gbc_clientName.gridy = 2;
		add(clientName, gbc_clientName);
		clientName.setColumns(10);

		JLabel lblDNI = new JLabel("D.N.I.");
		GridBagConstraints gbc_lblDNI = new GridBagConstraints();
		gbc_lblDNI.anchor = GridBagConstraints.WEST;
		gbc_lblDNI.insets = new Insets(0, 15, 5, 5);
		gbc_lblDNI.gridx = 1;
		gbc_lblDNI.gridy = 3;
		add(lblDNI, gbc_lblDNI);

		clientDNI = new JTextField();
		GridBagConstraints gbc_clientDNI = new GridBagConstraints();
		gbc_clientDNI.gridwidth = 2;
		gbc_clientDNI.insets = new Insets(0, 10, 5, 10);
		gbc_clientDNI.fill = GridBagConstraints.HORIZONTAL;
		gbc_clientDNI.gridx = 1;
		gbc_clientDNI.gridy = 4;
		add(clientDNI, gbc_clientDNI);
		clientDNI.setColumns(10);

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
				gbc_cancelButton.gridy = 5;
				add(this.getCancel(), gbc_cancelButton);
			}

			@Override
			public void addActionAcceptButton() {
				this.getAccept().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						System.out.println("A guardar se ha dicho");
						ArrayList<String[]> listParams = new ArrayList<>();
						String[][] tuplaClaveValor = new String[5][2];
						// TODO Comprobar que los campos esten completos y
						// correctos
						tuplaClaveValor[0][0] = "name";
						tuplaClaveValor[0][1] = clientName.getText();
						listParams.add(tuplaClaveValor[0]);
						tuplaClaveValor[1][0] = "dni";
						tuplaClaveValor[1][1] = String.valueOf(clientDNI.getText());
						listParams.add(tuplaClaveValor[1]);
						AssemblingClient assemblingClient = new AssemblingClient();
						if (assemblingClient.assembling(listParams)) {
							JOptionPane.showMessageDialog(null, "El Cliente se ha registrado correctamente.");
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
				gbc_acceptButton.gridy = 5;
				add(this.getAccept(), gbc_acceptButton);
			}
		};
		okCancel.addActions();
	}


}
