package tarea4;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.JSeparator;
import java.awt.ScrollPane;
import java.awt.Button;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Home extends JFrame {
	Combos datos = new Combos();
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable table;

	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param filaID 
	 */
	public Home() {
		setTitle("Lista de usuarios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 731, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblClientesRegistrados = new JLabel("Clientes Registrados");
		lblClientesRegistrados.setFont(new Font("NanumGothicExtraBold", Font.PLAIN, 35));
		lblClientesRegistrados.setBounds(10, 11, 329, 53);
		contentPane.add(lblClientesRegistrados);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 75, 695, 242);
		contentPane.add(scrollPane);
		JTable table = new JTable(Combos.getModel());
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		scrollPane.setViewportView(table);
		
		Button btnCerrar = new Button("Cerrar seccion");
		btnCerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login lg = new Login();
				lg.setVisible(true);
				dispose();
			}
		});
		btnCerrar.setBounds(560, 334, 131, 48);
		contentPane.add(btnCerrar);
		
		Button btnEliminar = new Button("Eliminar");
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if(datos.eliminarDatos(table.getSelectedRow())) {
						dispose();
					}
				}catch(Exception a) {
					JOptionPane.showMessageDialog(null, "Debes seleccionar algo en la tabla.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnEliminar.setBounds(385, 334, 131, 48);
		contentPane.add(btnEliminar);
		
		Button btnAdd = new Button("A\u00F1adir");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Registro reg = new Registro(1);
				reg.setVisible(true);
			}
		});
		btnAdd.setBounds(38, 334, 131, 48);
		contentPane.add(btnAdd);
		
		Button btnActualizar = new Button("Actualizar");
		btnActualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Actualizar update = new Actualizar(table.getSelectedRow());
					update.setVisible(true);
				}catch(Exception a) {
					JOptionPane.showMessageDialog(null, "Debes seleccionar una fila.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnActualizar.setBounds(207, 334, 131, 48);
		contentPane.add(btnActualizar);
	}
}
