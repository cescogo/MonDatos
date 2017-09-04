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
    private ArrayList<String> temp;
    private Button aceptar;
    private Control gestor;
    
    public Vent1(Control c)
    {
        super("tablespace");
        gestor=c;
        panel= new JPanel();   
        sele= new ArrayList<>();
        temp= new ArrayList<>();
        
    }
    
    public void init(ArrayList<String> TaSpa)
    {
         
        GridBagLayout tb= new GridBagLayout();
        panel.setLayout(tb);
        temp=TaSpa;
       
        
        GridBagConstraints gc = new GridBagConstraints();

        gc.insets=new Insets(10,10,0,50);
        
        for(int i=0;i<temp.size();i++)
        {
            gc.gridx=0;
            gc.gridy=i;
            JCheckBox ch=new JCheckBox(temp.get(i));
            ch.addItemListener((ItemListener) this);
            panel.add(ch,gc);            
        }
        
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
             System.out.println(sele.size());
        
            //gestor.iniciarVent2(sele);
        }
       
        
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    @Override
    public void itemStateChanged(ItemEvent e) {
        String aux="";
        for(int i=0;i<temp.size();i++){
            
            for(int j=461;j<(temp.get(i).length()+461);j++)
            {
                aux=aux+(char)e.paramString().codePointAt(j);
            }
            
            for(int k=0;k<temp.size();k++)
            {
                System.out.println(aux);
                if(temp.get(k).equals(aux))
                {
                    sele.add(aux);
                    return;
                }
            }
            aux="";
        }
          
        
     }

    
    
}
