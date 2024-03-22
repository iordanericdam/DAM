package gestionBiblioteca;

public abstract class Usuario {

	protected String nombreUsuario,contraseña;

	
	protected Usuario(String nombreUsuario,String contraseña){
		
		this.nombreUsuario=nombreUsuario;
		this.contraseña=contraseña;
	}
	
	
	protected String getNombreUsuario() {
		return nombreUsuario;
	}

	protected void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	protected String getContraseña() {
		return contraseña;
	}

	protected void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	
}
