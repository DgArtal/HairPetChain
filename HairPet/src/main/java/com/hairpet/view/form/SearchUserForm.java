package com.hairpet.view.form;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import org.apache.log4j.Logger;

import com.hairpet.controler.assembling.AssemblingUser;
import com.hairpet.controler.context.AppContext;
import com.hairpet.controler.context.Context;

public class SearchUserForm extends JPanel {

	private JTable tableUsers;
	private final static String[] TABLE_FIELDS = { "id", "name", "upd", "del" };
	private final static Class[] TYPE_FIELDS = new Class[] { java.lang.Integer.class, java.lang.String.class,
			JButton.class,
			JButton.class };
	private Object[][] result;
	private JButton[] buttonEdit;
	private JButton[] buttonDelete;
	private static Logger log = Logger.getLogger(SearchUserForm.class.getName());

	public SearchUserForm() {
		setLayout(new GridLayout(1, 0, 0, 0));

		// AL INICIO MOSTRAR TODOS LOS USUARIOS, Y HABILITAR BUSQUEDA
		AssemblingUser assemblingUser = new AssemblingUser();
		String[][] listUsers = assemblingUser.allUsers();
		int nRows = listUsers.length;
		configureEditAndDeleteButtons(nRows);

		result = new Object[nRows][TABLE_FIELDS.length];
		for (int i = 0; i < nRows; i++) {
			result[i][0] = listUsers[i][0];
			result[i][1] = listUsers[i][1];
			result[i][2] = buttonEdit[i];
			result[i][3] = buttonDelete[i];
		}

		tableUsers = new JTable();
		tableUsers.setModel(new DefaultTableModel(result, TABLE_FIELDS) {
			Class[] tipos = TYPE_FIELDS;

			@Override
			public Class getColumnClass(int columnIndex) {
				// Este método es invocado por el CellRenderer para saber que
				// dibujar en la celda,
				// observen que estamos retornando la clase que definimos de
				// antemano.
				return tipos[columnIndex];
			}

			@Override
			public boolean isCellEditable(int row, int column) {
				// Sobrescribimos este método para evitar que la columna que
				// contiene los botones sea editada.
				return !(this.getColumnClass(column).equals(JButton.class));
			}
		});

		tableUsers.setDefaultRenderer(JButton.class, new TableCellRenderer() {

			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				return (Component) value;
			}
		});

		// tableUsers = new JTable(result, TABLE_FIELDS);
		add(tableUsers);

		// Realizar búsqueda. En caso de Users sólo por nombre
		Context context = AppContext.getInstance();
		PropertyChangeListener pcl = new PropertyChangeListener() {
			
			 @Override
			 public void propertyChange(PropertyChangeEvent evt) {
				 String searchName = (String) evt.getNewValue();
				 if (evt.getPropertyName().equals("search") && searchName != "") {
					// Llamada al Assembling
					log.debug("Realizar búsqueda");
				}
			 }
		};
		context.addPropertyChangeListener(pcl);

	}

	private void configureEditAndDeleteButtons(int nRows) {
		buttonEdit = new JButton[nRows];
		buttonDelete = new JButton[nRows];
		for (int i = 0; i < nRows; i++) {
			final Integer indice = new Integer(i);
			// EDIT BUTTON
			buttonEdit[i] = new JButton();
			buttonEdit[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "Pulsaste el botón EDITAR Linea" + indice);

				}
			});

			BufferedImage imgEdit;
			try {
				imgEdit = ImageIO.read(new File("src/main/resources/img/edit.png"));
				buttonEdit[i].setIcon(new ImageIcon(imgEdit.getScaledInstance(16, 16, Image.SCALE_SMOOTH)));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			// DELETE BUTTON
			buttonDelete[i] = new JButton();
			buttonDelete[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "Pulsaste el botón BORRADO Linea" + indice);

				}
			});

			BufferedImage imgDelete;
			try {
				imgDelete = ImageIO.read(new File("src/main/resources/img/delete.png"));
				buttonDelete[i].setIcon(new ImageIcon(imgDelete.getScaledInstance(16, 16, Image.SCALE_SMOOTH)));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}
