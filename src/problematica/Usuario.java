/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problematica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;


/**
 *
 * @author alberto
 */
public class Usuario {
        private String userName;
	private String pass;
	private ConsumoCigarros consumoUsuario;

        
   

        
        
        
        public boolean comprobarUsuarioExistente(String user){
            try{
                File archivo = new File ("c:/users/public/nms/users/"+user+".txt");
                FileReader  fr = new FileReader (archivo);
                return true;
            }catch(Exception e){
                return false;
            }
        }
	
        
        public void crearUsuario(String user, String contraseña){
            FileWriter fichero = null;
            PrintWriter pw = null;
        
             try
        {
            /*CREA EL FICHERO CON EL NOMBRE DEL USUARIO REGISTRADO*/
           fichero = new FileWriter("c:/users/public/nms/users/"+user+".txt");
           pw = new PrintWriter(fichero);
           /*ESCRIBE LA CONTRASEÑA EN EL PRINCIPIO Y LUEGO PONE UN ;*/
           pw.print(contraseña+";");
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
            
        }
        
	/**
	 * 
	 * @param contraseña
	 */
	public boolean comprobarContraseña(String user, String contraseña) {
            try{
		File archivo = new File ("c:/users/public/nms/users/"+user+".txt");
                FileReader  fr = new FileReader (archivo);
                BufferedReader br = new BufferedReader(fr);
                String linea;
                linea=br.readLine();
                
                int n = linea.indexOf(';');
                String password = linea.substring(0,n);
                
                if(password.equals(contraseña)){
                    return true;
                }else{
                    return false;
                }
                
            }catch(Exception e){
            return false;
        }  
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
	public String getInformacion(String userName) {
		// TODO - implement User.getInformacion
		consumoUsuario = new ConsumoCigarros();
                return consumoUsuario.getInformacion(userName);
	}

        
        
        
	/**
	 * 
	 * @param cant
	 * @param userName
	 */
	public void addCigarros(String cant, String userName) {
		// TODO - implement User.addCigarros
                consumoUsuario = new ConsumoCigarros();
		consumoUsuario.modificarConsumo(cant, userName);
	}

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
       
        /*METODOS AGREGADOS POR SI LLEGASEN A SER NECESARIOS */
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

