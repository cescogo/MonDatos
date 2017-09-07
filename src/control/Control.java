/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.List;
import java.sql.SQLException;
import modelo.*;
import java.util.ArrayList;
import java.util.Arrays;

import ventanas.*;

// query("INSERT INTO TB_SPACES (id,fecha,nombre,registros,size,tasatrans)VALUES (1,'12-10-17', 'SYSTEM', 32,15,0);");

/**
 *
 * @author cesar
 */
public class Control {
    private Conexion model;
    private Vent1 ventIni;
    private Grafico graf;
    ArrayList<String> tabSpa;
    ArrayList<TableSpace> ta;
    TableSpace tab_graf;
    private Tabla tabla;
   SQLiteJDBC sqlite;
    public Control() throws SQLException
    {
        model= new Conexion();
        model.conectar();
        ventIni= new Vent1(this);
        tabSpa= new ArrayList<>();
        ta = new ArrayList<>();
         tab_graf= new TableSpace();
         sqlite= new SQLiteJDBC();
        
//         sqlite.query("INSERT INTO TB_SPACES (id,fecha,nombre,registros,size,tasatrans)VALUES (1,'12-10-17', 'USERS', 32,15,0);");
//         sqlite.query("INSERT INTO TB_SPACES (id,fecha,nombre,registros,size,tasatrans)VALUES (2,'13-10-17', 'USERS', 34,15,2);");
//         
    }
    
    public void iniciar() throws InterruptedException
    {        
        tabSpa= model.getSegmentos();
        ventIni.init(tabSpa);
        
    }
    
    public void iniciarVent2(String select) throws InterruptedException, SQLException 
    {
        tab_graf=model.getGrafica(select);
        sqlite.conectar();
        ta=sqlite.select(select);
        graf= new Grafico(ventIni,this);
        graf.init(tab_graf);
        tabla=new Tabla(ta);
        
        
    }
    
  
}
