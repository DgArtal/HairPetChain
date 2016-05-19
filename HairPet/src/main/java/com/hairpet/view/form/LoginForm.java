package com.hairpet.view.form;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.apache.log4j.Logger;

import com.hairpet.controler.LoginControler;
import com.hairpet.controler.context.Session;
import com.hairpet.view.OkCancelButtons;

public class LoginForm extends JFrame {

	private JLabel login;
	private JLabel user;
	private JLabel pass;

	private JTextField inputUser;
	private JPasswordField inputPass;

	private OkCancelButtons onlyAcceptButton;

	private final static Logger log = Logger.getLogger(LoginForm.class.getName());

	public LoginForm() {
		super();
		initFrame();
	}

	private void initFrame() {
		setBounds(400, 300, 300, 200);
		setTitle("login");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel loginFormPanel = new JPanel();
		GridBagLayout loginFormLayout = new GridBagLayout();
		loginFormPanel.setLayout(loginFormLayout);

		initComponents();
		drawPanel(loginFormPanel);

		add(loginFormPanel);
		setVisible(true); // Al final para mostrar el Frame
		// pack(); //Redimensiona al tamaño más pequeño
	}

	private void initComponents() {
		login = new JLabel("login".toUpperCase());
		login.setFont(new Font("Arial", Font.BOLD, 14));
		user = new JLabel("user:");
		pass = new JLabel("pass:");

		inputUser = new JTextField();
		inputPass = new JPasswordField();

		onlyAcceptButton = new OkCancelButtons("Aceptar", null) {

			@Override
			public void addActionCancelButton() {
				// No Action
			}

			@Override
			public void addActionAcceptButton() {
				onlyAcceptButton.getAccept().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
						boolean produccion = false;

						if(produccion){
							// PRODUCCION
							dispose();
							initSession();
						}else{
							// ENTORNO DE PRUEBAS, DESHABILITAMOS INICIO SESIÓN
							 dispose();
							 new MainForm();
							log.info("Inicio Sesión --- Pruebas ---. Sin usuario.");
						}
						
					}

					private void initSession() {
						LoginControler loginControler = new LoginControler();
						Integer idSession;
						idSession = loginControler.checkUser(inputUser.getText(),
								String.valueOf(inputPass.getPassword()));
						if (idSession > 0) {
							Session.setSessionLoggedId(idSession);
							Session.setSessionLoggedName(inputUser.getText());
							setVisible(false);
							dispose();
							log.info("Inicio Sesión idUser = " + idSession);
							new MainForm();
						} else {
							JOptionPane.showMessageDialog(null, "Los datos no son correctos");
							log.warn("datos introducidos incorrectos.");
							log.warn("usuario: " + inputUser.getText());
						}
					}
				});

			}
		};
		onlyAcceptButton.addActions();

	}

	private void drawPanel(JPanel loginFormPanel) {
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.insets = new Insets(10, 10, 5, 10);
		
		gbc.gridx = gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		loginFormPanel.add(login, gbc);

		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.EAST;
		loginFormPanel.add(user, gbc);
		gbc.gridy = 2;
		loginFormPanel.add(pass, gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		loginFormPanel.add(inputUser, gbc);
		gbc.gridy = 2;
		loginFormPanel.add(inputPass, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.weightx = 0.0;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridwidth = 2;
		loginFormPanel.add(onlyAcceptButton.getAccept(), gbc);
	}
}
