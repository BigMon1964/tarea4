package tarea4;

abstract class Datos {
	abstract boolean getDatos(String usuario, String password);

	abstract boolean eliminarDatos(int fila);
	
	abstract boolean editarDatos(String nombre, String apellido, String telefono, String Correo, String usuario, String password, int fila);

	abstract void addDatos(String nombre, String apellido, String telefono, String correo, String usuario, String password);
}

