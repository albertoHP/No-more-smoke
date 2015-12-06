/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problematica;


/**
 *
 * @author alberto
 */
public class Usuario {
        private String userName;
	private String pass;
	private ConsumoCigarros consumoUsuario;

	/**
	 * 
	 * @param nombre
	 */
	public boolean comprobarUsuario(String user){
    if(userName.equals(user)){
        return true;
    }else{
        return false;
    }
}

	/**
	 * 
	 * @param contraseña
	 */
	public boolean comprobarContraseña(String contraseña) {
		// TODO - implement User.comprobarContraseña
		throw new UnsupportedOperationException();
	}

	/**
	 * consumoUsuario.getGrafico;
	 * @param userName
	 */
	public void getGraficos(String userName) {
		// TODO - implement User.getGraficos
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param userName
	 */
	public void getInformacion(String userName) {
		// TODO - implement User.getInformacion
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param cant
	 * @param userName
	 */
	public void addCigarros(int cant, String userName) {
		// TODO - implement User.addCigarros
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 
	 * @param pass
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getUserName() {
		return this.userName;
	}







    
    
}

