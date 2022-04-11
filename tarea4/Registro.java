package tarea4;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GraphicsConfiguration;

import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.awt.event.ActionListener;

public class Registro extends JFrame{
	Combos datos = new Combos();
	private JPanel contentPane;
	private JTextField tfNombre;
	private JTextField tfApellidp;
	private JTextField tfNombreUsuario;
	private JPasswordField passwordField;
	private JPasswordField pfConfirm;
	private JTextField tfCorreo;
	private JTextField tfNumero;
	protected static int sel;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro frame = new Registro(sel);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param datos 
	 */
	public Registro(int sel) {
		setTitle("Registro");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 383, 704);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistro = new JLabel("Registro");
		lblRegistro.setFont(new Font("NanumGothicExtraBold", Font.PLAIN, 35));
		lblRegistro.setBounds(10, 11, 142, 42);
		contentPane.add(lblRegistro);
		
		tfNombre = new JTextField();
		tfNombre.setHorizontalAlignment(SwingConstants.LEFT);
		tfNombre.setColumns(10);
		tfNombre.setBounds(62, 97, 242, 26);
		contentPane.add(tfNombre);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombre.setBounds(152, 60, 69, 31);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblApellido.setBounds(152, 134, 69, 31);
		contentPane.add(lblApellido);
		
		tfApellidp = new JTextField();
		tfApellidp.setHorizontalAlignment(SwingConstants.LEFT);
		tfApellidp.setColumns(10);
		tfApellidp.setBounds(62, 171, 242, 26);
		contentPane.add(tfApellidp);
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre de Usuario");
		lblNombreDeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombreDeUsuario.setBounds(109, 366, 152, 31);
		contentPane.add(lblNombreDeUsuario);
		
		tfNombreUsuario = new JTextField();
		tfNombreUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		tfNombreUsuario.setColumns(10);
		tfNombreUsuario.setBounds(62, 403, 242, 26);
		contentPane.add(tfNombreUsuario);
		
		JLabel lblPassword = new JLabel("Contrase\u00F1a");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(141, 435, 93, 31);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(62, 477, 242, 26);
		contentPane.add(passwordField);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRegistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//System.out.println(passwordField.getText());
				//System.out.println(pfConfirm.getText());
				if(passwordField.getText().length() == 0 || tfApellidp.getText().length() == 0 || tfNombre.getText().length() == 0 || tfNombreUsuario.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "No se pueden dejar campos vacios.", "Error", JOptionPane.ERROR_MESSAGE);
				}else {
					if (!Arrays.equals(passwordField.getPassword(), pfConfirm.getPassword())) {
						   JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden.", "Error", JOptionPane.ERROR_MESSAGE);
					}else {
						datos.addDatos(tfNombre.getText(), tfApellidp.getText(), tfNumero.getText(), tfCorreo.getText(), tfNombreUsuario.getText(), passwordField.getText());
						if(sel == 1) {
							dispose();
						}else {
							Login log = new Login();
							log.setVisible(true);
							dispose();
						}
					} 
				}
			}
		});
		btnRegistrar.setBounds(120, 623, 118, 31);
		contentPane.add(btnRegistrar);
		
		pfConfirm = new JPasswordField();
		pfConfirm.setBounds(62, 556, 242, 26);
		contentPane.add(pfConfirm);
		
		JLabel lblConfirmeLaContrasea = new JLabel("Confirme la contrase\u00F1a");
		lblConfirmeLaContrasea.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblConfirmeLaContrasea.setBounds(96, 514, 189, 31);
		contentPane.add(lblConfirmeLaContrasea);
		
		tfCorreo = new JTextField();
		tfCorreo.setHorizontalAlignment(SwingConstants.LEFT);
		tfCorreo.setColumns(10);
		tfCorreo.setBounds(62, 329, 242, 26);
		contentPane.add(tfCorreo);
		
		JLabel lblCorreoElectronico = new JLabel("Correo electronico");
		lblCorreoElectronico.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCorreoElectronico.setBounds(109, 292, 152, 31);
		contentPane.add(lblCorreoElectronico);
		
		tfNumero = new JTextField();
		tfNumero.setHorizontalAlignment(SwingConstants.LEFT);
		tfNumero.setColumns(10);
		tfNumero.setBounds(62, 255, 242, 26);
		contentPane.add(tfNumero);
		
		JLabel lblNumeroDeTelefono = new JLabel("Numero de telefono");
		lblNumeroDeTelefono.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNumeroDeTelefono.setBounds(109, 218, 161, 31);
		contentPane.add(lblNumeroDeTelefono);
	}
}
