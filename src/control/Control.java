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
import java.util.Calendar;

import java.util.GregorianCalendar;


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
    private ArrayList<String> tabSpa;
    private ArrayList<TableSpace> ta;
    private TableSpace tab_graf;
    private Tabla tabla;
   private SQLiteJDBC sqlite;
   private Calendar fecha;
    public Control() throws SQLException
    {
        model= new Conexion();
        model.conectar();
        ventIni= new Vent1(this);
        tabSpa= new ArrayList<>();
        ta = new ArrayList<>();
         tab_graf= new TableSpace();
         sqlite= new SQLiteJDBC();
//         sqlite.conectar();
//         sqlite.query("drop table TB_SPACES");
//         sqlite.conectar();
//         sqlite.query("CREATE TABLE TB_SPACES " + "(id INT PRIMARY KEY NOT NULL, fecha TEXT not null,nombre TEXT NOT NULL, registros INT not null, size INT NOT NULL,TasaTrans INT not null )");
         fecha=  new GregorianCalendar(); 
 }
    
    public void iniciar() throws InterruptedException
    {        
        tabSpa= model.getSegmentos();
        ventIni.init(tabSpa);
        
    }
    
    public void iniciarVent2(String select) throws InterruptedException, SQLException 
    {
        String date="";
        tab_graf=model.getGrafica(select);
        graf= new Grafico(ventIni,this);
        graf.init(tab_graf);
        sqlite.conectar();
        ta=sqlite.select(select);        
        tab_graf=model.getTable(select);
       date=fecha.get(Calendar.DATE)+"-"+fecha.get(Calendar.MONTH)+"-"+fecha.get(Calendar.YEAR);
       tab_graf.setFecha(date);
       if(!ta.isEmpty())
       {
           tab_graf.setTasatrans(tab_graf.getUso()-ta.get(ta.size()-1).getUso());
       }
       sqlite.conectar();
       guardar(tab_graf,ta.size());
        tabla=new Tabla(ta,tab_graf,this);
        
        
    }
    
    public void guardar(TableSpace tab,int id) throws SQLException
    {
        sqlite.query("INSERT INTO TB_SPACES (id,fecha,nombre,registros,size,tasatrans)VALUES ("+id+",'"+tab.getFecha()
                +"','"+tab.getNombre()+"',"+tab.getUso()+","+tab.getTam_total()+","+tab.getTasatrans()+");");
    }
    
  
}
