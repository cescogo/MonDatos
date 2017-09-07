/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlite;

/**
 *
 * @author adan-
 */
import java.sql.*;
import java.util.Scanner;
/**/


public class SQLiteJDBC {
static Connection c = null;
static String dir = "org.sqlite.JDBC";
static String db = "test.db";
static Statement stmt = null;
/**/
   public static void main( String args[] ) throws SQLException {
 
   conectar();
   //query("CREATE TABLE TB_SPACES " + "(id INT PRIMARY KEY     NOT NULL,nombre   TEXT    NOT NULL, size            INT     NOT NULL )");
   //query("INSERT INTO TB_SPACES (id,nombre,size)VALUES (1, 'SYSTEM', 32);");
   //query("INSERT INTO TB_SPACES (id,nombre,size)VALUES (2, 'USERS', 41);");
   //query("INSERT INTO TB_SPACES (id,nombre,size)VALUES (3, 'TBPS01', 68);");
   select("select * from TB_SPACES;");
   Scanner leer = new Scanner(System.in);  // Reading from System.in
   System.out.println("Indique la tabla: ");
   String tabla = leer.next();
    System.out.println("Indique tamaño: ");
   String tam = leer.next();
   
   query("UPDATE TB_SPACES SET NOMBRE = '"+tabla+"' WHERE ID = 1;");
   select("select * from TB_SPACES;"); 
   System.out.println("FIN");
   }
  
   
   
   static void conectar(){
     
      try {
         Class.forName(dir);
         c = DriverManager.getConnection("jdbc:sqlite:"+db);
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.println("Conexion Correcta");
   }  
  static void query(String sql) throws SQLException{
    try {   stmt = c.createStatement();
          //sql = ""; 
         stmt.executeUpdate(sql);
         System.out.println("Ejecutada");  
   }catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
   }
   
   static void select(String sql) throws SQLException{
   try {
    
      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery(sql);
      
      while ( rs.next() ) {
          rs.getMetaData();
         int id = rs.getInt("id");
         String  name = rs.getString("NOMBRE");
         int size  = rs.getInt("size");
    
         
         System.out.println( "ID = " + id+" NOMBRE = " + name +" size = " + size );
         
         System.out.println();
      }
      rs.close();
      stmt.close();
      c.close();
   
   }catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
   }
   }
}