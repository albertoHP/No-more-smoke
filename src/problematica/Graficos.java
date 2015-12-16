/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problematica;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author alberto
 */
public class Graficos {
    private Cigarros cig;

	/**
	 * 
	 * @param cantCigarros
	 */
	
          public static void createGrafico(ArrayList<ArrayList<String>> datos, String nombreArchivo){
    
        
        XYSeries series = new XYSeries("Linea de consumo");
        //como su nombre lo indica el primer valor sera asignado al eje X
        //y el segundo al eje Y
         
        for(int i=0; i<datos.size();i++){
                         
        series.add((i+1), Integer.parseInt(datos.get(i).get(0)));
     
        }
        
        
        //se crea un objeto XYDataset requerido mas adelante por el metodo que grafica
        XYDataset juegoDatos= new XYSeriesCollection(series);
        
                /*aqui se hace la instancia de la nueva grafica invocando al metodo de ChartFactory
                que nos dibujara una grafica de lineas este metodo como casi todos los demas
                recibe los siguientes argumentos:
                
                tipo              valor
                String            nombre de la grafica , aparecera en la parte superior centro
                String            tutulo del eje X
                String            titulo del eje Y
                XYDataset         el conjunto de datos X y Y del tipo XYDataset (aqui cambian el parametro
                                  dependiendo del tipo de grafica que se quiere pueden ver todos los parametros
                                  en la documentacion aqui <a href="http://www.jfree.org/jfreechart/api/javadoc/index.html
" title="http://www.jfree.org/jfreechart/api/javadoc/index.html
">http://www.jfree.org/jfreechart/api/javadoc/index.html
</a>                              iremos notando los cambios mas adelante..
                 PlotOrientation  la orientacion del grafico puede ser PlotOrientation.VERTICAL o PlotOrientation.HORIZONTAL
                 boolean                  muestra u oculta leyendas     
                 boolean                  muestra u oculta tooltips
                 boolean                  muestra u oculta urls (esta opcion aun no la entiendo del todo)
                
                generalmente solo necesitaremos cambiar los primeros 3 parametros lo demas puede quedarse asi
                
                */
        JFreeChart chart = ChartFactory.createXYLineChart  ("Grafico de consumo",
        "dias","cantidad cigarrillos",juegoDatos,PlotOrientation.VERTICAL,
        true,
        false,
        true                // Show legend
        );
        //donde guardaremos la imagen?? pues en un bufer jeje
        BufferedImage image = chart.createBufferedImage(500,500);
        
         try {
           ImageIO.write(image, "jpg", new File("c:/users/public/nms/grafico/"+nombreArchivo+".jpg"));
          } catch (IOException e) {
         System.out.println("Error de escritura");
    }
        
    
    } 
          
	/**
	 * 
	 * @param nombreArchivo
	 */
	public void setGraficoVisible(String nombreArchivo) {
		// TODO - implement Graficos.setGraficoVisible
		cig = new Cigarros("",nombreArchivo);
                
                createGrafico(cig.getTotalCigarros(),nombreArchivo);
                
	}

}
