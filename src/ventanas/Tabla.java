/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
/**
 *
 * @author carmc_000
 */
public class Tabla extends JFrame {
    public Tabla(){
    super("Prueba 1");
    this.setSize(500, 500);
    
    Vector col = new Vector();
    col.add("Date");
    col.add("TableSpace");
    col.add("Tabla");
    col.add("Registro");
    col.add("T.transaccional");
    col.add("T.total");
    
    Vector filas = new Vector();
    
    
     Vector fil = new Vector();
    fil.add("Val prueba");
    fil.add("val ");
    
    filas.add(fil);
    
    
    JTable tb1 = new JTable(filas,col);
    
    JScrollPane panel = new JScrollPane(tb1);
    this.getContentPane().add(panel);
    this.setVisible(true);
    
    }
   // String[] columnNames = {"Date", "TablaSpace", "Tabla", "Registro", "size", "T.transferida","T.Total"};
    

}
