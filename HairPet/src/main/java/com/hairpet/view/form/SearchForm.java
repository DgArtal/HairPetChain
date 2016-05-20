package com.hairpet.view.form;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.log4j.Logger;

import com.hairpet.controler.context.AppContext;

public class SearchForm extends JInternalFrame {
	private JPanel panel = new JPanel();
	private JTextField textField;
	private static Logger log = Logger.getLogger(SearchForm.class.getName());

	public SearchForm(JPanel modelForm) {
		setBounds(100, 100, 300, 200);
		setResizable(true);
		setClosable(true);
		drawForm(modelForm);
		add(panel);
		setVisible(true);
		try {
			setSelected(true);
		} catch (PropertyVetoException e) {
			log.error("no se puede poner el foco en esta pantalla");
			log.error("Mensaje: " + e.getMessage());
			throw new RuntimeException(e);
		}
		// pack();
	}

	private void drawForm(JPanel modelForm) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		panel.setLayout(gridBagLayout);

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 0;
		panel.add(textField, gbc_textField);
		textField.setColumns(10);

		JButton btnSearch = new JButton("Buscar");
		GridBagConstraints gbc_btnSearch = new GridBagConstraints();
		gbc_btnSearch.insets = new Insets(0, 0, 5, 0);
		gbc_btnSearch.gridx = 1;
		gbc_btnSearch.gridy = 0;
		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				log.info("Pulsado el botón buscar");
				AppContext.getInstance().fireEvent("search", null, textField.getText());
			}
		});
		panel.add(btnSearch, gbc_btnSearch);

		// JPanel resultPanel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		panel.add(modelForm, gbc_panel);
	}

}
