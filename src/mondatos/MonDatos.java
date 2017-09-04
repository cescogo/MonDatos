/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mondatos;

import conexion.Conexion;
import java.util.ArrayList;
import ventanas.Vent1;



/**
 *
 * @author cesar
 */
public class MonDatos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        ArrayList<String> TabSpa;        
         Conexion c = new Conexion(); // crea la conexion con la base de datos 
        c.conectar();// conecta a la base 
        TabSpa=c.getSegmentos();
        
        Vent1 vent= new Vent1();
        vent.init(TabSpa);
        
    }
    
}
