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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author alberto
 */
public class Informacion {
    private Cigarros cig;

	/**
	 * 
	 * @param cantCigarros
	 */
    
    
        public double getPromedioCig(String nombreArchivo){
          
      File archivo = null;
      FileReader fr = null;
      BufferedReader br = null;
 
      try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         archivo = new File ("c:/users/public/nms/info/"+nombreArchivo+".txt");
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);
 
         
         
         
         // Lectura del fichero
         String linea;
         linea=br.readLine();
         
                int n2 = linea.indexOf('-');
                int n3 = linea.indexOf(';');
                
                
                String linea2 = linea.substring(n2+1,n3);
                
                int n = linea2.indexOf('.');
                
                String promedioCigarrosMensuales = linea2.substring(44,n);
                
                
         return Integer.parseInt(promedioCigarrosMensuales);
         
         
      }catch(Exception e){
         e.printStackTrace();
         return 0;
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
      }
      
      
        }
    
        
        
        
    
	private void createInformacion(ArrayList<ArrayList<String>> datos, String nombreArchivo) {
		/*DATOS ES UN ARRAY QUE CONTIENE 3 COLUMNAS(CIGARROS, MES Y AÑO)
                 Y TIENE TANTAS FILAS COMO MESES Y AÑOS DIFERENTES HAYAN
                */
            FileWriter fichero = null;
            PrintWriter pw = null;
                
                
        
             try
        {
            /*CREA EL FICHERO CON EL NOMBRE DEL USUARIO REGISTRADO*/
           fichero = new FileWriter("c:/users/public/nms/info/"+nombreArchivo+".txt");
           pw = new PrintWriter(fichero);
           
           
           /*CANTIDAD TOTAL DE CIGARROS*/
             int cantCig=0;
            for(int i=0; i<datos.size();i++){
                cantCig=  Integer.parseInt(datos.get(i).get(0))+cantCig;
                
            }
             
            pw.print(nombreArchivo+", usted lleva un total de "+cantCig+" cigarros consumidos desde su registro._");
            
            /*CIGARROS POR D*/
            for(int i=0; i<datos.size();i++){
                 pw.print("Dia"+(i+1)+": Para este dia usted lleva un total de "+datos.get(i).get(0)+" cigarros consumidos (Fecha "+datos.get(i).get(1)+"/"+datos.get(i).get(2)+"/"+datos.get(i).get(3)+"). ");
                    
            }
            pw.print("-");
            
            /*PROMEDIO DE CIGARROS POR DIA*/
            
            double promedioCigMes=0;
            promedioCigMes= cantCig/datos.size();
            pw.print("Hasta la fecha lleva un consumo promedio de "+promedioCigMes+" cigarros diarios.;");
          
            
            /*GASTO EN CIGARROS SEGUN EL PROMEDIO MENSUAL*/
            
            double gastoCig=0;
            gastoCig= promedioCigMes*110;
            pw.print("Hasta la fecha lleva un gasto diario promedio de $"+gastoCig+", en cigarros.+");
            
             /*INFORMACION DE SALUD SEGUN EL PROMEDIO MENSUAL*/
            
            if(promedioCigMes>=0 && promedioCigMes<=5){
            pw.print("Usted tiene un consumo de entre 0 y 5 cigarros diarios, los riesgos a los que usted se enfrenta no son tantos.!");
            }else{
                if(promedioCigMes>5 && promedioCigMes<=10){
                    pw.print("Usted tiene un consumo de entre 6 y 10 cigarros diarios, los riesgos a los que usted se enfrenta ya abarcan cansancio.!");
                }else{
                    if(promedioCigMes>10 && promedioCigMes<=15){
                        pw.print("Usted tiene un consumo de entre 11 y 15 cigarros diarios, los riesgos a los que usted se enfrenta a sentir posible necesidad.!"); 
                        
                    }else{
                         if(promedioCigMes>15 && promedioCigMes<=20){
                         pw.print("Usted tiene un consumo de entre 16 y 20 cigarros diarios, los riesgos a los que usted se enfrenta ya abarcan dolores de cabeza, cansancio y necesidad de fumar.!");
                         }else{
                              if(promedioCigMes>20 && promedioCigMes<=30){
                             pw.print("Usted tiene un consumo de entre 21 y 30 cigarros diarios, los riesgos a los que usted se enfrenta ya abarcan posibles mareos, y hablamos directamente de una adiccion.!");
                              }else{
                                  if(promedioCigMes>30 && promedioCigMes<=40){
                                      pw.print("Usted tiene un consumo de entre 31 y 40 cigarros diarios, ya hablamos de 2 cajetillas mensuales, usted se puede ver enfrentado a un infarto cere.!");
                                  }else{
                                     if(promedioCigMes>40){
                                        pw.print("Usted tiene un consumo mayor a 40 cigarros diarios, hablamos de mas de 2 cajetillas mensuales, los riesgos a los que usted se enfrenta son infartos.!");  
                                     }
                                  }
                              }
                         }
                    }
                }
            }
            
            
            
            
            
            
            
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
	 * @param nombreArchivo
	 */
	public String setInformacionVisible(String nombreArchivo) {
		// TODO - implement Informacion.setInformacionVisible
		cig = new Cigarros("",nombreArchivo);
                createInformacion(cig.getTotalCigarros(),nombreArchivo);
                File archivo = null;
                FileReader fr = null;
                BufferedReader br = null;
      
                try{
                archivo = new File ("c:/users/public/nms/info/"+nombreArchivo+".txt");
                fr = new FileReader (archivo);
                br = new BufferedReader(fr);
                String linea;
                linea=br.readLine();
                
                int n = linea.indexOf('_');
                int n2 = linea.indexOf('-');
                int n3 = linea.indexOf(';');
                int n4 = linea.indexOf('+');
                int n5 = linea.indexOf('!');
                String totalCigarros = linea.substring(0,n);
                String cigarrosMensuales = linea.substring(n+1,n2);
                String promedioCigarrosMensuales = linea.substring(n2+1,n3);
                String gastoCigarrosMensuales = linea.substring(n3+1,n4);
                String infoSalud = linea.substring(n4+1,n5);
                
                String lineaOrdenada = totalCigarros+"\n"+cigarrosMensuales+"\n"+promedioCigarrosMensuales+"\n"+gastoCigarrosMensuales+"\n"+infoSalud;
                
                return lineaOrdenada;
                }catch(Exception e){
                    System.out.println("hola");
                    return null;
                }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }}
	}

}

