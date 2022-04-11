package tarea4;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

import javax.swing.JTextField;

public class Login extends JFrame {
	Combos datos = new Combos();
	private JPanel contentPane;
	private JTextField txUser;
	private JPasswordField JPasswordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 383, 461);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("NanumGothicExtraBold", Font.PLAIN, 35));
		lblLogin.setBounds(40, 31, 100, 42);
		contentPane.add(lblLogin);
		
		txUser = new JTextField();
		txUser.setHorizontalAlignment(SwingConstants.LEFT);
		txUser.setBounds(55, 136, 242, 26);
		contentPane.add(txUser);
		txUser.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsuario.setBounds(145, 99, 69, 31);
		contentPane.add(lblUsuario);
		
		JPasswordField = new JPasswordField();
		JPasswordField.setHorizontalAlignment(SwingConstants.LEFT);
		JPasswordField.setColumns(10);
		JPasswordField.setBounds(55, 245, 242, 26);
		contentPane.add(JPasswordField);
		
		JLabel lblContraseña = new JLabel("Contrase\u00F1a");
		lblContraseña.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblContraseña.setBounds(129, 208, 100, 31);
		contentPane.add(lblContraseña);
		
		JButton btnLogin = new JButton("Entrar");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txUser.getText().length() == 0 || JPasswordField.getText().trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "No se pueden dejar campos vacios.", "Error", JOptionPane.ERROR_MESSAGE);
				}else {
					if(datos.getDatos(txUser.getText(), JPasswordField.getText())) {
						dispose();
					}else {
						JOptionPane.showMessageDialog(null, "La contraseña o usuario esta mal colocado. Si en cambio no tiene un usuario y contraseña, cree unos.", "Error", JOptionPane.ERROR_MESSAGE);
					}
					
				}
			}
		});
		btnLogin.setBounds(129, 314, 89, 23);
		contentPane.add(btnLogin);
		
		JLabel lblRegistro = new JLabel("Registrarse");
		lblRegistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Registro reg = new Registro(0);
				reg.setVisible(true);
				dispose();
				//setVisible(false);
			}
			
		});
		lblRegistro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRegistro.setBounds(145, 348, 69, 31);
		contentPane.add(lblRegistro);
	}
}
