/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import control.Control;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author cesar
 */
public class Vent1 extends JFrame implements ActionListener{
    
    private JPanel panel;
     private Button aceptar;
    private Control gestor;
    
    public Vent1(Control c)
    {
        super("tablespace");
        gestor=c;
        panel= new JPanel();   
     
        
        
    }
    
    public void init(ArrayList<String> TaSpa)
    {
         
        GridBagLayout tb= new GridBagLayout();
        panel.setLayout(tb);
        
       
        
        GridBagConstraints gc = new GridBagConstraints();

        gc.insets=new Insets(10,10,0,50);
        
        for(int i=0;i<TaSpa.size();i++)
        {
            gc.gridx=0;
            gc.gridy=i;
            JButton ch=new JButton(TaSpa.get(i));
            ch.setActionCommand(TaSpa.get(i));
            ch.addActionListener(this);

            panel.add(ch,gc);            
        }

        gc.gridx=5;
        gc.gridy=10;
        add(panel,BorderLayout.CENTER);
       setSize(500,300);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            gestor.iniciarVent2(e.getActionCommand());
        } catch (Exception ex) {
            Logger.getLogger(Vent1.class.getName()).log(Level.SEVERE, null, ex);
        }
				
    }
    

  
    
    
}
