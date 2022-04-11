package tarea4;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Combos extends Datos{
	private static DefaultTableModel model = new DefaultTableModel(); 
	private static ArrayList<String> password = new ArrayList<String>();
	private static int filaID;
	
	public Combos(){
		if(model.getColumnCount() ==0) {
			model.addColumn("nombre");model.addColumn("apellido");model.addColumn("telefono");model.addColumn("correo electronico");model.addColumn("usuario");
		}
	}
	
	static DefaultTableModel getModel() {
		return model;
	}
	
	@Override
	boolean eliminarDatos(int fila) {
		model.removeRow(fila);
		if(fila == filaID) {
			JOptionPane.showMessageDialog(null, "Acabas de borrar el usuario actual.", "Error", JOptionPane.ERROR_MESSAGE);
			Login lg = new Login();
			lg.setVisible(true);
			return true;
		}else if(fila < filaID) {
			filaID = filaID-1;
		}
		return false;
	}

	@Override
	boolean editarDatos(String nombre, String apellido, String telefono, String Correo, String usuario, String password, int fila) {
		model.setValueAt(nombre, fila, 0);
		model.setValueAt(apellido, fila, 1);
		model.setValueAt(telefono, fila, 2);
		model.setValueAt(Correo, fila, 3);
		model.setValueAt(usuario, fila, 4);
		this.password.set(fila, password);
		return true;
	}

	@Override
	void addDatos(String nombre, String apellido, String telefono, String correo, String usuario, String password) {
		model.addRow(new Object[]{nombre, apellido, telefono, correo, usuario});
		this.password.add(password);
		//System.out.println(this.password.size());
	}

	@Override
	boolean getDatos(String usuario, String password) {
		for (int i = 0; i<model.getRowCount(); i++) {
			//System.out.println(this.password.get(0) + " e primerp");
			if((model.getValueAt(i, 4)).toString().equals(usuario) && this.password.get(i).equals(password)) {
				//System.out.println("soy igual");
				Home inicio = new Home();
				filaID=i;
				inicio.setVisible(true);
				return true;
			}
		}
		return false;
		
	}


}
