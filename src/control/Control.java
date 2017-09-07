/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.List;
import modelo.Conexion;
import java.util.ArrayList;
import java.util.Arrays;
import modelo.Table;
import modelo.TableSpace;
import ventanas.*;



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
    public Control()
    {
        model= new Conexion();
        model.conectar();
        ventIni= new Vent1(this);
        tabSpa= new ArrayList<>();
        ta = new ArrayList<>();
         tab_graf= new TableSpace();
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
