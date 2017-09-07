/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

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

    public void conectar() {
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

    // se obtienen los segmentos de la base de datos
    public ArrayList<String> getSegmentos() throws InterruptedException {
        ArrayList<String> vec = new ArrayList<>();

        try {
            Statement stm = conexion.createStatement();
            ResultSet rs = stm.executeQuery("select tablespace_name from dba_tables where tablespace_name is not null AND tablespace_name != 'SYSTEM' group by tablespace_name;");

            getColumnNames(rs);
            while (rs.next()) {

                String a = rs.getString("TABLESPACE_NAME");//Aqui deberia jalar el nombre de la columna

                vec.add(a);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return vec;
    }
    // se obtienen las tablas de cada tablespace
    // se obtienen las tablas de la base de datos

    public ArrayList<Table> getTable(String tablespace) throws InterruptedException {
        ArrayList<Table> vec = new ArrayList<>();
        Statement stm;
        ResultSet rs, rs2;
        String a, b;
        Table table;
        try {
            stm = conexion.createStatement();
            rs = stm.executeQuery("select TABLE_NAME,OWNER from all_tables where tablespace_name = '" + tablespace + "'");
            getColumnNames(rs);
            while (rs.next()) {
                a = rs.getString("TABLE_NAME");//Aqui deberia jalar el nombre de la columna               
                b = rs.getString("OWNER");
                vec.add(new Table(a, b));
            }
            for (int i = 0; i < vec.size(); i++) {
                table = vec.get(i);
                try {
                    rs2 = stm.executeQuery("select a.bytes, b.count from\n"
                            + "(SELECT sum(data_length) bytes FROM all_tab_columns where table_name = '" + table.getName() + "' group by table_name) a,\n"
                            + "(select count(*) count from " + table.getOwner() + "." + table.getName() + ") b");
                    rs2.next();
                    table.setBytes(rs2.getInt("BYTES"));
                    table.setCount(rs2.getInt("COUNT"));
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return vec;
    }
//obtener los byte

    public ArrayList<String> getByte(String t) throws InterruptedException {
        ArrayList<String> vec = new ArrayList<>();

        try {
            Statement stm = conexion.createStatement();
            ResultSet rs = stm.executeQuery("");

            getColumnNames(rs);
            while (rs.next()) {

                String a = rs.getString("TABLE_NAME");//Aqui deberia jalar el nombre de la columna

                vec.add(a);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return vec;
    }
    // se obtiene la informacion de cada table space para ser graficado

    public TableSpace getGrafica(String selec) throws InterruptedException {
        
        TableSpace table = null;

        try {
            Statement stm = conexion.createStatement();
            ResultSet rs = stm.executeQuery("select\n"
                    + "  a.tablespace_name,\n"
                    + "  sum(a.bytes)/(1024*1024) total_space_MB,\n"
                    + "  round(b.free,2) Free_space_MB,\n"
                    + "  round(b.free/(sum(a.bytes)/(1024*1024))* 100,2) percent_free\n"
                    + " from dba_data_files a,\n"
                    + "  (select tablespace_name,sum(bytes)/(1024*1024) free  from dba_free_space\n"
                    + "  group by tablespace_name) b\n"
                    + " where a.tablespace_name = b.tablespace_name(+)\n"
                    + "  group by a.tablespace_name,b.free");

            getColumnNames(rs);
            while (rs.next()) {

                String a = rs.getString("TABLESPACE_NAME");//Aqui deberia jalar el nombre de la columna

                
                    if (selec.equals(a)) {
                        table = new TableSpace("",a, Float.parseFloat(rs.getString("TOTAL_SPACE_MB")), Float.parseFloat(rs.getString("FREE_SPACE_MB")));
                        
                    }
                

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return table;
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

        }
    }
}
