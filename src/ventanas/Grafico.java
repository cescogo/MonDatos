/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import control.Control;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author cesar
 */
public class Grafico extends JFrame {
     private JPanel panel;
     private Control gestor;
    public Grafico(Vent1 ven,Control c)
    {
        super("tablespace");
     ven.dispose();   
     panel= new JPanel(); 
     gestor=c;
      add(panel,BorderLayout.CENTER);
       setSize(500,500);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
