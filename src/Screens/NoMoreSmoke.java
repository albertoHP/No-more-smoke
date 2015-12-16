/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Screens;

import java.io.File;

/**
 *
 * @author alberto
 */
public class NoMoreSmoke {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*CREACION DE DIRECTORIOS*/
        File mainFolder = new File("c:\\users\\public\\nms");
        mainFolder.mkdir();
        File usersFolder = new File("c:\\users\\public\\nms\\users");
        usersFolder.mkdir();
        File infoFolder = new File("c:\\users\\public\\nms\\info");
        infoFolder.mkdir();
         File graphicFolder = new File("c:\\users\\public\\nms\\grafico");
         graphicFolder.mkdir();
        
        /*SETEO DE PANTALLA PRINCIPAL*/
        LoginScreen noMoreSmoke = new LoginScreen();
        noMoreSmoke.usuario.setText("");
        noMoreSmoke.pass.setText("");
        noMoreSmoke.setVisible(true);
        
        
        
        
        
        
        
        
    }
    
}
