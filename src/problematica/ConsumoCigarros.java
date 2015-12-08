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
public class ConsumoCigarros {
    private Graficos graficos;
	private Informacion informacion;
	private Cigarros cig;

	/**
	 * 
	 * @param nombreArchivo
	 */
	public void getGraficos(String nombreArchivo) {
		// TODO - implement ConsumoCigarros.getGraficos
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nombreArchivo
	 */
	public String getInformacion(String nombreArchivo) {
		// TODO - implement ConsumoCigarros.getInformacion
		informacion = new Informacion();
                return informacion.setInformacionVisible(nombreArchivo);
	}

	/**
	 * 
	 * @param cant
	 * @param nombreArchivo
	 */
	public void modificarConsumo(String cant, String nombreArchivo) {
		cig = new Cigarros(cant, nombreArchivo);
                cig.addCigarro();
	}
}
