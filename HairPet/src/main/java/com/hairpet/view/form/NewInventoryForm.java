package com.hairpet.view.form;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.hairpet.controler.context.AppContext;
import com.hairpet.view.OkCancelButtons;

public class NewInventoryForm extends JPanel {
	private JTextField inventoryQuantity;
	private JTextField inventoryCode;
	private JTextField inventoryName;

	public NewInventoryForm() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblArticulo = new JLabel("Art\u00EDculo");
		GridBagConstraints gbc_lblArticulo = new GridBagConstraints();
		gbc_lblArticulo.anchor = GridBagConstraints.WEST;
		gbc_lblArticulo.insets = new Insets(10, 15, 5, 5);
		gbc_lblArticulo.gridx = 1;
		gbc_lblArticulo.gridy = 1;
		add(lblArticulo, gbc_lblArticulo);

		inventoryName = new JTextField();
		GridBagConstraints gbc_inventoryName = new GridBagConstraints();
		gbc_inventoryName.gridwidth = 2;
		gbc_inventoryName.insets = new Insets(0, 10, 5, 20);
		gbc_inventoryName.fill = GridBagConstraints.HORIZONTAL;
		gbc_inventoryName.gridx = 1;
		gbc_inventoryName.gridy = 2;
		add(inventoryName, gbc_inventoryName);
		inventoryName.setColumns(10);

		JLabel lblCdigo = new JLabel("C\u00F3digo");
		GridBagConstraints gbc_lblCdigo = new GridBagConstraints();
		gbc_lblCdigo.anchor = GridBagConstraints.WEST;
		gbc_lblCdigo.insets = new Insets(0, 15, 5, 5);
		gbc_lblCdigo.gridx = 1;
		gbc_lblCdigo.gridy = 3;
		add(lblCdigo, gbc_lblCdigo);

		JLabel lblCantidad = new JLabel("Cantidad");
		GridBagConstraints gbc_lblCantidad = new GridBagConstraints();
		gbc_lblCantidad.anchor = GridBagConstraints.WEST;
		gbc_lblCantidad.insets = new Insets(0, 5, 5, 0);
		gbc_lblCantidad.gridx = 2;
		gbc_lblCantidad.gridy = 3;
		add(lblCantidad, gbc_lblCantidad);

		inventoryCode = new JTextField();
		GridBagConstraints gbc_inventoryCode = new GridBagConstraints();
		gbc_inventoryCode.anchor = GridBagConstraints.WEST;
		gbc_inventoryCode.insets = new Insets(0, 10, 0, 20);
		gbc_inventoryCode.gridx = 1;
		gbc_inventoryCode.gridy = 4;
		add(inventoryCode, gbc_inventoryCode);
		inventoryCode.setColumns(10);

		inventoryQuantity = new JTextField();
		GridBagConstraints gbc_inventoryQuantity = new GridBagConstraints();
		gbc_inventoryQuantity.insets = new Insets(0, 0, 0, 20);
		gbc_inventoryQuantity.anchor = GridBagConstraints.WEST;
		gbc_inventoryQuantity.gridx = 2;
		gbc_inventoryQuantity.gridy = 4;
		add(inventoryQuantity, gbc_inventoryQuantity);
		inventoryQuantity.setColumns(10);

		OkCancelButtons okCancel = new OkCancelButtons("Guardar", "Cancelar") {
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
						System.out.println("A guardar se ha dicho");
						// ArrayList<String[]> listParams = new ArrayList<>();
						// String[][] tuplaClaveValor = new String[5][2];
						// // TODO Comprobar que los campos esten completos y
						// // correctos
						// tuplaClaveValor[0][0] = "name";
						// tuplaClaveValor[0][1] = hairdresserName.getText();
						// listParams.add(tuplaClaveValor[0]);
						// tuplaClaveValor[1][0] = "password";
						// tuplaClaveValor[1][1] =
						// String.valueOf(userPass.getPassword());
						// listParams.add(tuplaClaveValor[1]);
						// AssemblingUser assemblingUser = new AssemblingUser();
						// if (assemblingUser.assembling(listParams)) {
						// JOptionPane.showMessageDialog(null, "El usuario se ha
						// registrado correctamente.");
						// }
						// else {
						// JOptionPane.showMessageDialog(null, "Se ha producido
						// un error. Inténtalo más tarde.");
						// }
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
