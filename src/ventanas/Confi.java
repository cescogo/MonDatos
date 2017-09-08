/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import control.Control;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author cesar
 */
public class Confi extends JFrame implements ActionListener{

    private Control gestor;
    JTextField porce;
    public Confi(Control ges) {
        
        gestor=ges;
        JPanel cen= new JPanel();
        JLabel leg= new JLabel("inserte el porcentaje de High Warning Mark que desea en los tablespace: ");
         porce= new JTextField(10);
        cen.add(leg,BorderLayout.CENTER);
        cen.add(porce,BorderLayout.CENTER);
        JPanel p_atras= new JPanel();
        JButton aceptar= new JButton("aceptar");
        aceptar.setActionCommand("aceptar");
        aceptar.addActionListener(this);
        p_atras.add(aceptar,BorderLayout.CENTER);
        JButton atras= new JButton("atras");
        
        atras.setActionCommand("atras");
        atras.addActionListener(this);
        p_atras.add(atras,BorderLayout.CENTER);
        add(p_atras,BorderLayout.SOUTH);
        add(cen,BorderLayout.CENTER);
         this.setTitle("Configuracion HWM");
        this.setSize(800, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("atras"))
        {
            this.dispose();
            try {
                gestor.atras('c');
            } catch (InterruptedException ex) {
                Logger.getLogger(Confi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
            if(e.getActionCommand().equals("aceptar"))
            {
            try {
                gestor.guardarHWM(porce.getText());
                this.dispose();
                gestor.atras('c');
            } catch (IOException ex) {
                Logger.getLogger(Confi.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(Confi.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
   
    }
    
    
    
}
