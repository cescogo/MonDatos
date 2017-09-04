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
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author cesar
 */
public class Vent1 extends JFrame implements ActionListener, ItemListener{
    
    private JPanel panel;
    private ArrayList<String> sele;
    private Button aceptar;
    private Control gestor;
    
    public Vent1(Control c)
    {
        super("tablespace");
        gestor=c;
        panel= new JPanel();   
        sele= new ArrayList<>();
        
        
    }
    
    public void init(ArrayList<String> TaSpa)
    {
         
        GridBagLayout tb= new GridBagLayout();
        panel.setLayout(tb);
        sele=TaSpa;
       
        
        GridBagConstraints gc = new GridBagConstraints();

        gc.insets=new Insets(10,10,0,50);
        
        for(int i=0;i<TaSpa.size();i++)
        {
            gc.gridx=0;
            gc.gridy=i;
            JCheckBox ch=new JCheckBox(TaSpa.get(i));
            ch.addItemListener((ItemListener) this);
            panel.add(ch,gc);
            
        }
        sele=TaSpa;
        aceptar=new Button("aceptar");
        aceptar.addActionListener(this);
        aceptar.setActionCommand("aceptar");
        gc.gridx=5;
        gc.gridy=10;
        panel.add(aceptar,gc);
        add(panel,BorderLayout.CENTER);
       setSize(500,500);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand()== "aceptar")
        {
            gestor.iniciarVent2(sele);
        }
       
        
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    @Override
    public void itemStateChanged(ItemEvent e) {
        
        for(int i=0;i<sele.size();i++){
            String aux="";
            for(int j=461;j<(sele.get(i).length()+461);j++)
            {
                aux=aux+(char)e.paramString().codePointAt(j);
            }
            
                
            for(int k=0;k<sele.size();k++)
            {
                if(sele.get(k).equals(aux))
                {
                    System.out.println("sirvio con:"+aux+" "+k);
                }
            }
            
        }
       
//            System.out.println((char)e.paramString().codePointAt(462));
//        System.out.println(e.paramString().lastIndexOf("SYSAUX"));
//        System.out.println(e.paramString().lastIndexOf("USERS"));
        
            
        
            
            
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
