/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mondatos;

import sqlmon.conexion.Conexion;

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
         Conexion c = new Conexion(); // crea la conexion con la base de datos 
        c.conectar();// conecta a la base 
        c.getSegmentos("select tablespace_name from dba_tables group by tablespace_name;");
    }
    
}
