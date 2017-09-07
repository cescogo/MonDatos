/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.List;
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
    ArrayList<Table> ta;
    TableSpace tab_graf;
    private Tabla tabla;
   // SQLiteJDBC sqlite;
    public Control()
    {
        model= new Conexion();
        model.conectar();
        ventIni= new Vent1(this);
        tabSpa= new ArrayList<>();
        ta = new ArrayList<>();
         tab_graf= new TableSpace();
         //sqlite= new SQLiteJDBC();
    }
    
    public void iniciar() throws InterruptedException
    {        
        tabSpa= model.getSegmentos();
        ventIni.init(tabSpa);
        
    }
    
    public void iniciarVent2(String select) throws InterruptedException 
    {
        tab_graf=model.getGrafica(select);
        graf= new Grafico(ventIni,this);
        graf.init(tab_graf);
        
    }
     public void iniciarVent3( String ts) throws InterruptedException
    {
       ta = model.getTable(ts);
       
        tabla = new Tabla(ta);
         
        
        
        
    }
     
  
}
