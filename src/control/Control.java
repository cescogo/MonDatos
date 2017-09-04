/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import modelo.Conexion;
import java.util.ArrayList;
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
    
    public Control()
    {
        model= new Conexion();
        model.conectar();
        ventIni= new Vent1(this);
        tabSpa= new ArrayList<>();
        
    }
    
    public void iniciar() throws InterruptedException
    {        
        tabSpa= model.getSegmentos();
        ventIni.init(tabSpa);
    }
    
    public void iniciarVent2(ArrayList<String> selects)
    {
        
        for(int k=0;k<selects.size();k++)
            {
                System.out.println("seleccionados: "+selects.get(k));
                
            }
        graf= new Grafico(ventIni,this);
        
    }
}
