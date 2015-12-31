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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author alberto
 */
public class Cigarros {
        private String cantidad;
	private Calendar date;
	private String archivo;

        
        /* SEARCH ES UN METODO EXCLUSIVO DE CIGARROS QUE PERMITE BUSCAR PATRONES REGULARES EN TXT*/
        private String[] search(String regex, String onText)
    {
        Pattern regPatt = Pattern.compile(regex);
        Matcher regMatch = regPatt.matcher(onText);
        ArrayList<String> matches = new ArrayList<>();
        String[] matchesArray;

        while(regMatch.find())
        {
            String match = regMatch.group();
            matches.add(match);
        }
       
        matchesArray = new String[matches.size()];
        matches.toArray(matchesArray);
        return matchesArray;
    }
   
        
    
        /*GETTOTALCIGARROS ES UN METODO QUE BUSCA LOS CIGARROS POR MES Y/O AÑO
        PARA GUARDARLOS EN UN ARRAY Y ENTREGARSELO A QUIEN LO SOLICITE
        */
	public ArrayList<ArrayList<String>> getTotalCigarros() {
		
            File archivo = null;
      FileReader fr = null;
      BufferedReader br = null;
            
		try{
            
            /*SE BUSCA EL ARCHIVO*/
         archivo = new File ("c:/users/public/nms/users/"+this.archivo+".txt");
         fr = new FileReader (archivo);
          br = new BufferedReader(fr);
 
         /*SE METE EN UN STRING LO QUE HAYA EN EL ARCHIVO*/
         String linea;
         linea=br.readLine();
         
        /*LLAMAMOS A SEARCH PARA ENTREGARLE EL PATRON(BUSCA ENTRE 1 Y 3 DIGITOS QUE ESTEN ENTRE un _ y un -)
         Y EL STRING QUE CREAMOS ANTES (LINEA)*/
        
         
        String[] cigarros = search("_\\d{1,3}-",linea);
        
        
        /*CREAMOS UN STRINGBUFFER, POR QUE SEARCH NOS DEVUELVE UN VECTOR DE STRING,
        PERO NECESITAMOS UNA SOLA CADENA STRING Y CON .TOSTRING() PODEMOS HACERLO*/
        StringBuffer cadena = new StringBuffer();
        for (int x=0;x<cigarros.length;x++){
        cadena =cadena.append(cigarros[x]);
        }
        
        
        /*CON EL BLOQUE ANTERIOR LOGRAMOS TENER UNA CADENA CON LO QUE NOS INTERESABA, AHORA
            REPETIMOS EL PROCESO PARA ELIMINAR ESOS GIONES Y DEJAR SOLO LOS NUMEROS PARA FINALMENTE
            CONVERTIRLOS EN NUMERO, Y REPETIRLO PARA ENCONTRAR CIGARROS, DIAS, MESES Y AÑOS
            */
            
         cigarros = search("\\d{1,3}",cadena.toString());
         
            
            /*¨Proceso para encontrar dias */
            
            
            
              /*LLAMAMOS A SEARCH PARA ENTREGARLE EL PATRON(para buscar dias, busca entre 1 y 2 digitos
                que esten entre un - y un _) Y EL STRING QUE CREAMOS ANTES (LINEA)*/
            
        String[] dias = search("-\\d{1,2}_",linea);
        
        
        /*CREAMOS UN STRINGBUFFER, POR QUE SEARCH NOS DEVUELVE UN VECTOR DE STRING, PERO NECESITAMOS UNA SOLA CADENA STRING*/
        StringBuffer cadena2 = new StringBuffer();
        for (int x=0;x<dias.length;x++){
        cadena2 =cadena2.append(dias[x]);
        }
       
        /*CON EL BLOQUE ANTERIOR LOGRAMOS TENER UNA CADENA CON LO QUE NOS INTERESABA, AHORA
            REPETIMOS EL PROCESO PARA ELIMINAR ESOS GIONES Y DEJAR SOLO LOS NUMEROS PARA FINALMENTE
            CONVERTIRLOS EN NUMERO 
            */
            
         dias = search("\\d{1,2}",cadena2.toString());
         
         
            
            /*¨Proceso para encontrar  meses */
            
            
            
              /*LLAMAMOS A SEARCH PARA ENTREGARLE EL PATRON Y EL STRING QUE CREAMOS ANTES (LINEA)*/
            
        String[] meses = search("_\\d{1,2}/",linea);
        
        
        /*CREAMOS UN STRINGBUFFER, POR QUE SEARCH NOS DEVUELVE UN VECTOR DE STRING, PERO NECESITAMOS UNA SOLA CADENA STRING*/
        StringBuffer cadena3 = new StringBuffer();
        for (int x=0;x<meses.length;x++){
        cadena3 =cadena3.append(meses[x]);
        }
       
        
        
        /*CON EL BLOQUE ANTERIOR LOGRAMOS TENER UNA CADENA CON LO QUE NOS INTERESABA, AHORA
            REPETIMOS EL PROCESO PARA ELIMINAR ESOS GIONES Y DEJAR SOLO LOS NUMEROS PARA FINALMENTE
            CONVERTIRLOS EN NUMERO Y HACER LA SUMA FINAL
            */
            
         meses = search("\\d{1,2}",cadena3.toString());
        
         
         
         /*¨Proceso para encontrar  años */
            
            
            
              /*LLAMAMOS A SEARCH PARA ENTREGARLE EL PATRON Y EL STRING QUE CREAMOS ANTES (LINEA)*/
            
        String[] anos = search("/\\d{1,4}",linea);
        
        
        /*CREAMOS UN STRINGBUFFER, POR QUE SEARCH NOS DEVUELVE UN VECTOR DE STRING, PERO NECESITAMOS UNA SOLA CADENA STRING*/
        StringBuffer cadena4 = new StringBuffer();
        for (int x=0;x<anos.length;x++){
        cadena4 =cadena4.append(anos[x]);
        }
       
        
        
        /*CON EL BLOQUE ANTERIOR LOGRAMOS TENER UNA CADENA CON LO QUE NOS INTERESABA, AHORA
            REPETIMOS EL PROCESO PARA ELIMINAR ESOS GIONES Y DEJAR SOLO LOS NUMEROS PARA FINALMENTE
            CONVERTIRLOS EN NUMERO Y HACER LA SUMA FINAL
            */
            
         anos = search("\\d{1,4}",cadena4.toString());
         
         
         
         /*FINALMENTE DEJAMOS TODO EN UNA SOLA MATRIZ DE TANTAS FILAS COMO CIGARROS HAYAN*/
         String[][] datos = new String[cigarros.length][4];
         
         for (int x=0;x<cigarros.length;x++){
            datos[x][0]=cigarros[x];
            datos[x][1]=dias[x];
            datos[x][2]=meses[x];
            datos[x][3]=anos[x];
        }
         
            
         ArrayList<ArrayList<String>> datosfiltrados = new ArrayList<ArrayList<String>>();
            
            
            /*SE INICIALIZAN LAS VARIABLES CONT QUE IRA VIENDO SI AGREGAR UN NUEVO ARRAY DENTRO DEL ARRAY,
                SUMAAUX QUE ACUMULARA CIGARROS EN CASO DE PERTENECER AL MISMO AÑO O MES
                MESACTUAL Y ANOACTUAL SON VARIABLES AUXILIARES QUE LE DICEN AL CICLO EN QUE MES VAN Y SI CAMBIAN 
                AGREGA 1 AL CONTADOR PARA PODER CREAR OTRO ARRAY EN EL ARRAY
                FINALMENTE SE INICIALIZAN LAS COLUMNAS DENTRO DEL ARRAY PARA SER SETEADOS EN EL CICLO
                */
            
            int cont=0;
            int sumaAux= Integer.parseInt(datos[0][0]);
            
            datosfiltrados.add(new ArrayList<String>());
            datosfiltrados.get(cont).add(datos[0][0]);
            datosfiltrados.get(cont).add(datos[0][1]);
            datosfiltrados.get(cont).add(datos[0][2]);
            datosfiltrados.get(cont).add(datos[0][3]);
            
            
                
                /* DENTRO DE ESTE CICLO RECORREMOS TODOS LOS DATOS ENTREGADOS POR EL ARCHIVO LEIDO ARRIBA,
                PARA POSTERIORMENTE COMPARAR EL AÑO Y LUEGO EL MES Y SI COINCIDEN LO AGREGAMOS AL ARRAY
                DE MANERA QUE TODOS LOS CIGARROS PERTENECIENTES A UN MISMO MES O AÑO QUEDARAN EN UN SOLO ARRAY
                Y SE PUEDE CREAR INFORMACION POR MES Y/O AÑO
                
                */
           for(int i=0; i<cigarros.length-1; i++){
                
                
                    if(datos[i][3].equals(datos[i+1][3])){
                        if(datos[i][2].equals(datos[i+1][2])){
                            if(datos[i][1].equals(datos[i+1][1])){
                                sumaAux= sumaAux + Integer.parseInt(datos[i+1][0]);
                            datosfiltrados.get(cont).set(0, Integer.toString(sumaAux));
                            datosfiltrados.get(cont).set(1, datos[i][1]);
                            datosfiltrados.get(cont).set(2, datos[i][2]);
                            datosfiltrados.get(cont).set(3, datos[i][3]);
                           
                                //cont++;
                                //sumaAux=Integer.parseInt(datos[i][0]);
                                //datosfiltrados.add(new ArrayList<String>());
                                //datosfiltrados.get(cont).add("");
                                //datosfiltrados.get(cont).add("");
                                //datosfiltrados.get(cont).add("");
                            }else{
                                cont++;
                                sumaAux=Integer.parseInt(datos[i+1][0]);;
                                datosfiltrados.add(new ArrayList<String>());
                                datosfiltrados.get(cont).add("");
                                datosfiltrados.get(cont).add("");
                                datosfiltrados.get(cont).add("");
                                datosfiltrados.get(cont).add("");
                                
                                datosfiltrados.get(cont).set(0, Integer.toString(sumaAux));
                                datosfiltrados.get(cont).set(1, datos[i+1][1]);
                            datosfiltrados.get(cont).set(2, datos[i+1][2]);
                            datosfiltrados.get(cont).set(3, datos[i+1][3]);
                            } 
                        }else{
                            cont++;
                                sumaAux=Integer.parseInt(datos[i+1][0]);;
                                datosfiltrados.add(new ArrayList<String>());
                                datosfiltrados.get(cont).add("");
                                datosfiltrados.get(cont).add("");
                                datosfiltrados.get(cont).add("");
                                datosfiltrados.get(cont).add("");
                                datosfiltrados.get(cont).set(0, Integer.toString(sumaAux));
                            datosfiltrados.get(cont).set(1, datos[i+1][1]);
                            datosfiltrados.get(cont).set(2, datos[i+1][2]);
                            datosfiltrados.get(cont).set(3, datos[i+1][3]);
                        }
                    }else{
                                cont++;
                                sumaAux=Integer.parseInt(datos[i+1][0]);
                                
                                datosfiltrados.add(new ArrayList<String>());
                                datosfiltrados.get(cont).add("");
                                datosfiltrados.get(cont).add("");
                                datosfiltrados.get(cont).add("");
                                datosfiltrados.get(cont).add("");
                                
                                datosfiltrados.get(cont).set(0, Integer.toString(sumaAux));
                            datosfiltrados.get(cont).set(1, datos[i+1][1]);
                            datosfiltrados.get(cont).set(2, datos[i+1][2]);
                            datosfiltrados.get(cont).set(3, datos[i+1][3]);
                    }
                       
                
            } 
         
         
            
            
         
             return datosfiltrados;
        }catch(Exception e){
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
         }
      }
                
                
                
	}
        
        
        
        
        
        
        

	public void addCigarro() {
		FileWriter fichero = null;
                PrintWriter pw = null;
                Calendar date = Calendar.getInstance();
                SimpleDateFormat dateformatter = new SimpleDateFormat("dd/MM/yyyy");
        
             try
        {
            /*CREA EL FICHERO CON EL NOMBRE DEL USUARIO REGISTRADO*/
           fichero = new FileWriter("c:/users/public/nms/users/"+archivo+".txt",true);
           pw = new PrintWriter(fichero);
           /*ESCRIBE LA CONTRASEÑA EN EL PRINCIPIO Y LUEGO PONE UN ;*/
            pw.print("_"+cantidad+"-"+date.get(Calendar.DAY_OF_MONTH)+"_"+date.get(Calendar.MONTH)+"/"+date.get(Calendar.YEAR)+"-");
 
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
	 * @param cant
	 * @param archivoDestino
	 */
	public Cigarros(String cantidad, String archivoDestino) {
		this.cantidad = cantidad;
                this.archivo = archivoDestino;
                
	}
}
