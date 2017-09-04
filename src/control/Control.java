/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import modelo.Conexion;
import java.util.ArrayList;
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
    ArrayList<TableSpace> tab_graf;
    public Control()
    {
        model= new Conexion();
        model.conectar();
        ventIni= new Vent1(this);
        tabSpa= new ArrayList<>();
         tab_graf= new ArrayList<>();
        
    }
    
    public void iniciar() throws InterruptedException
    {        
        tabSpa= model.getSegmentos();
        ventIni.init(tabSpa);
    }
    
    public void iniciarVent2(ArrayList<String> selects) throws InterruptedException
    {
        tab_graf=model.getGrafica(selects);
        for(int k=0;k<selects.size();k++)
            {
                System.out.println(tab_graf.get(k).toString());
                
            }
        graf= new Grafico(ventIni,this);
        
    }
}
