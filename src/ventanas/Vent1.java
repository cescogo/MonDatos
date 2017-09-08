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
        JPanel p_opc=new JPanel();
        JButton b_config= new JButton("conf. HWM");
        b_config.setActionCommand("conf");
        b_config.addActionListener(this);
        p_opc.add(b_config,BorderLayout.CENTER);
        b_config= new JButton("Hist. HWM");
        b_config.setActionCommand("hist");
        b_config.addActionListener(this);
        p_opc.add(b_config,BorderLayout.CENTER);
        add(panel,BorderLayout.CENTER);
        add(p_opc,BorderLayout.SOUTH);
       setSize(500,300);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            if(e.getActionCommand().endsWith("conf"))
            {
                this.dispose();
                Confi con= new Confi(gestor);
            }
            else
                if(e.getActionCommand().endsWith("hist"))
                {
                    this.dispose();
                    Historial his= new Historial(gestor);
                }
            else
            {
            gestor.iniciarVent2(e.getActionCommand());
            }
        } catch (Exception ex) {
            Logger.getLogger(Vent1.class.getName()).log(Level.SEVERE, null, ex);
        }
				
    }
    

  
    
    
}
