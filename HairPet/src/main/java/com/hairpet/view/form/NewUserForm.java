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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.apache.log4j.Logger;

import com.hairpet.controler.assembling.AssemblingUser;
import com.hairpet.controler.context.AppContext;
import com.hairpet.view.OkCancelButtons;

public class NewUserForm extends JPanel {

	private JTextField userName;
	private JPasswordField userPass;

	private final static Logger log = Logger.getLogger(NewUserForm.class.getName());

	public NewUserForm() {
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

		userName = new JTextField();
		GridBagConstraints gbc_userName = new GridBagConstraints();
		gbc_userName.gridwidth = 2;
		gbc_userName.insets = new Insets(5, 10, 5, 10);
		gbc_userName.fill = GridBagConstraints.HORIZONTAL;
		gbc_userName.gridx = 1;
		gbc_userName.gridy = 2;
		add(userName, gbc_userName);
		userName.setColumns(10);

		JLabel lblPasword = new JLabel("Pasword");
		GridBagConstraints gbc_lblPasword = new GridBagConstraints();
		gbc_lblPasword.anchor = GridBagConstraints.WEST;
		gbc_lblPasword.insets = new Insets(0, 15, 5, 5);
		gbc_lblPasword.gridx = 1;
		gbc_lblPasword.gridy = 3;
		add(lblPasword, gbc_lblPasword);

		userPass = new JPasswordField();
		GridBagConstraints gbc_userPass = new GridBagConstraints();
		gbc_userPass.gridwidth = 2;
		gbc_userPass.insets = new Insets(0, 10, 5, 10);
		gbc_userPass.fill = GridBagConstraints.HORIZONTAL;
		gbc_userPass.gridx = 1;
		gbc_userPass.gridy = 4;
		add(userPass, gbc_userPass);
		userPass.setColumns(10);

		OkCancelButtons okCancel = new OkCancelButtons("Registrar", "Cancelar") {
			@Override
			public void addActionCancelButton() {
				this.getCancel().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						log.info("Ha cancelado. Se ha cerrado la ventana");
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
						ArrayList<String[]> listParams = new ArrayList<>();
						String[][] tuplaClaveValor = new String[5][2];
						// TODO Comprobar que los campos esten completos y
						// correctos
						tuplaClaveValor[0][0] = "name";
						tuplaClaveValor[0][1] = userName.getText();
						listParams.add(tuplaClaveValor[0]);
						tuplaClaveValor[1][0] = "password";
						tuplaClaveValor[1][1] = String.valueOf(userPass.getPassword());
						listParams.add(tuplaClaveValor[1]);
						AssemblingUser assemblingUser = new AssemblingUser();
						if (assemblingUser.assembling(listParams)) {
							JOptionPane.showMessageDialog(null, "El usuario se ha registrado correctamente.");
							log.info("Usuario Registrado Correctamente");
						}
						else {
							JOptionPane.showMessageDialog(null, "Se ha producido un error. Inténtalo más tarde.");
							log.error("No se ha podido guardar en la base de datos");
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
