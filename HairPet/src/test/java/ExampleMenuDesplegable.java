

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;

	public class ExampleMenuDesplegable extends JFrame {

	    private JMenuBar barra1;
	    private JMenu menu1;
	    private JMenuItem item1, item2, item3, item4;

	    public ExampleMenuDesplegable() {
	        setLayout(null);
	        barra1 = new JMenuBar();
	        setJMenuBar(barra1);

	        menu1 = new JMenu("Editar");
	        barra1.add(menu1);

	        item1 = new JMenuItem("Copiar");
	        item1.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                JFileChooser fc = new JFileChooser();
	                FileNameExtensionFilter filtro = 
	                             new FileNameExtensionFilter("Archivos PDF", "pdf");
	                fc.setFileFilter(filtro);
	                int val = fc.showOpenDialog(null);
	               
	                if (val == JFileChooser.APPROVE_OPTION) {
	                    File file = fc.getSelectedFile();
	                    // Código...
	                }
	            }
	        });
	        menu1.add(item1);

	        item2 = new JMenuItem("Cortar");
	        menu1.add(item2);

	        item3 = new JMenuItem("Pegar");
	        menu1.add(item3);

	        item4 = new JMenuItem("Eliminar");
	        menu1.add(item4);
	    }

	    public static void main(String[] args) {
		final ExampleMenuDesplegable marco = new ExampleMenuDesplegable();
	        marco.setBounds(20, 20, 400, 300);
	        marco.setVisible(true);

	        /* Mostrar Aplicación */
	        java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                marco.setVisible(true);
	            }
	        });
	    }
	}

