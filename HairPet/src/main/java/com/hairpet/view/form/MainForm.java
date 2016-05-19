package com.hairpet.view.form;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import com.hairpet.controler.context.AppContext;
import com.hairpet.controler.context.Context;
import com.hairpet.controler.context.Session;
import com.hairpet.view.ShowCloseFunctions;
import com.hairpet.view.menu.AdministrationMenu;
import com.hairpet.view.menu.FileMenu;
import com.hairpet.view.menu.ModuleMenu;

public class MainForm extends JFrame {

	private JMenuBar barMenu;
	private JMenu fileMenu = new FileMenu();
	private JMenu moduleMenu = new ModuleMenu();
	private JMenu administrationMenu = new AdministrationMenu();
	private JDesktopPane mainDesktop = new JDesktopPane();
	private AltaForm altaForm;
	private SearchForm searchForm;

	public MainForm() {
		super();
		initFrame();
	}

	private void initFrame() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		setTitle("Bienvenido " + Session.getSessionLoggedName());
		// setExtendedState(MAXIMIZED_BOTH);
		initMenuBar();

		// Añadir Imagen Fondo
		// BufferedImage imageBackground = null;
		// try {
		// imageBackground = ImageIO.read(new File("src/img/Gato_de_Tig.png"));
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// JLabel imageLabel = new JLabel();
		// imageLabel.setIcon((Icon) imageBackground);
		// getContentPane().add(imageLabel);

		add(mainDesktop);
		// Añadimos un escuchador de los eventos de ventana
		Context context = AppContext.getInstance();
		final JFrame mainFrame = this;
		PropertyChangeListener pcl = new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if (evt.getPropertyName().equals("alta_usuario")) {
					ShowCloseFunctions.showAltaForm(mainFrame, altaForm, "user");
				} else if (evt.getPropertyName().equals("alta_cliente")) {
					ShowCloseFunctions.showAltaForm(mainFrame, altaForm, "client");
				} else if (evt.getPropertyName().equals("alta_peluqueria")) {
					ShowCloseFunctions.showAltaForm(mainFrame, altaForm, "hairdresser");
				} else if (evt.getPropertyName().equals("alta_mascota")) {
					ShowCloseFunctions.showAltaForm(mainFrame, altaForm, "pet");
				} else if (evt.getPropertyName().equals("alta_inventario")) {
					ShowCloseFunctions.showAltaForm(mainFrame, altaForm, "inventory");
				} else if (evt.getPropertyName().equals("alta_visita")) {
					ShowCloseFunctions.showAltaForm(mainFrame, altaForm, "visit");
				} else if (evt.getPropertyName().equals("close_aplication")) {
					ShowCloseFunctions.closeFrame(mainFrame);
				} else if (evt.getPropertyName().equals("buscar_usuarios")) {
					ShowCloseFunctions.showSearchForm(mainFrame, searchForm, "user");
				} else if (evt.getPropertyName().equals("buscar_clientes")) {
					ShowCloseFunctions.showSearchForm(mainFrame, searchForm, "client");
				} else if (evt.getPropertyName().equals("buscar_peluqerias")) {
					ShowCloseFunctions.showSearchForm(mainFrame, searchForm, "hairdresser");
				} else if (evt.getPropertyName().equals("buscar_mascotas")) {
					ShowCloseFunctions.showSearchForm(mainFrame, searchForm, "pet");
				} else if (evt.getPropertyName().equals("buscar_inventarios")) {
					ShowCloseFunctions.showSearchForm(mainFrame, searchForm, "inventory");
				} else if (evt.getPropertyName().equals("buscar_visitas")) {
					ShowCloseFunctions.showSearchForm(mainFrame, searchForm, "visit");
				}
				// LA VENTANA LA CERRAMOS DESDE EL PROPIO ALTAFORM
				// else if (evt.getPropertyName().equals("close_alta_form")) {
				// ShowCloseFunctions.closeInternalFrame(altaForm);
				// }
			}

		};
		context.addPropertyChangeListener(pcl);

		setVisible(true);
		// PRUEBA ventana alta usuarios
		// add(new AltaForm(new NewUserForm()));

	}

	private void initMenuBar() {
		setLayout(null);
		barMenu = new JMenuBar();
		setJMenuBar(barMenu);

		barMenu.add(fileMenu);
		barMenu.add(moduleMenu);
		barMenu.add(administrationMenu);

	}

}
