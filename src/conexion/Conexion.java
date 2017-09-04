/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import control.Control;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author cesar
 */
public class Conexion {
    
    private Connection conexion;
    static String url = "jdbc:oracle:thin:@localhost:1521/XE"; //Descargar ojdbc6.jar e incluirlo en la libreria
    static String user = "system";
    static String password = "root";
    private boolean exito;
    private Control gestor;
   
    private ArrayList<String> resultados = new ArrayList<String>();

    
    
    /*Metodos*/
     public String getUser() {
        return user;
    }

    public void setUser(String user) {
        Conexion.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        Conexion.password = password;
    }
    
    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }


    
    public void conectar(){
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            exito = true;
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            conexion = DriverManager.getConnection(url, user, password);
            System.out.println("Conectado");
            exito = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
           

                   System.out.println(e.getMessage());
            exito = false;
        }
    }

   
    /*Ejecutar Querys*/
    //aqui va el cod del grafico 
        public ArrayList<String> getSegmentos() throws InterruptedException {
            ArrayList<String> vec=new ArrayList<>();
            
                 
        try {
            Statement stm = conexion.createStatement();
            ResultSet rs = stm.executeQuery("select tablespace_name from dba_tables where tablespace_name is not null group by tablespace_name");
           // System.out.println("Ejecutando");
             getColumnNames(rs);
            while (rs.next()) {
              
               String a = rs.getString("TABLESPACE_NAME");//Aqui deberia jalar el nombre de la columna
            
               
              
                System.out.println("tabla: "+a);   
                vec.add(a);
                
                
               
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        
        
       
        }
        
        return vec ;  
    }
     
        public String [] getTable (String seg) throws InterruptedException {
            
            String [] vec = new String[20];
          int i=0;
                 
        try {
            Statement stm = conexion.createStatement();
            ResultSet rs = stm.executeQuery("");
           // System.out.println("Ejecutando");
             getColumnNames(rs);
            while (rs.next()) {
              
               String a = rs.getString("TABLESPACE_NAME");//Aqui deberia jalar el nombre de la columna
                //String b = rs.getString("FREE_MEMORY_IN_MB");// valor columnas 
               
              
                System.out.println("tabla: "+a);   
                vec[i]=a;
               
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        
        
       
        }
        return vec;
        
    }
        /*Devuelve columna*/
   public static void getColumnNames(ResultSet rs) throws SQLException {
    if (rs == null) {
      return;
    }
    // get result set meta data
    ResultSetMetaData rsMetaData = rs.getMetaData();
    int numberOfColumns = rsMetaData.getColumnCount();
    
    // get the column names; column indexes start from 1
    for (int i = 1; i < numberOfColumns + 1; i++) {
      String columnName = rsMetaData.getColumnName(i);
      // Get the name of the column's table name
      String tableName = rsMetaData.getTableName(i);
    
      //System.out.println("column name=" + columnName + " table=" + tableName + "");
      System.out.println(columnName);
    }
  }
}


