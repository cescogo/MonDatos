/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import control.Control;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import modelo.TableSpace;

/**
 *
 * @author cesar
 */
public class Grafico extends JFrame implements ActionListener{
     private JPanel pan_prc,pan_nam,pan_button;
     private Control gestor;
     private JLabel porcent,ch;
     private String[] numb;
     private JButton boton;
     ArrayList<TableSpace> ts;
     Color[] colors;
      int[] param;
    public Grafico(Vent1 ven,Control c)
    {
        super("tablespace");
     ven.dispose();   
     pan_nam= new JPanel(); 
     pan_button= new JPanel();
     pan_prc= new JPanel(); 
     boton= new JButton();
     gestor=c;
      colors= new  Color[]{Color.BLUE,Color.CYAN,Color.GREEN,Color.MAGENTA,Color.ORANGE,Color.RED,Color.YELLOW};
      numb= new String[]{"0%","10%","20%","30%","40%","50%","60%","70%","80%","90%","100%"};
       setSize(850,430);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }
    
    public void init(ArrayList<TableSpace> tab_graf)
    {
        ts=tab_graf;
        
        int j=0;
        GridBagLayout tb= new GridBagLayout();
        pan_prc.setLayout(tb);
        pan_nam.setLayout(tb);
        pan_button.setLayout(tb);        
        GridBagConstraints gc = new GridBagConstraints();
        gc.insets=new Insets(10,10,10,10);
        for(int i=0;i<11;i++)
        {
            gc.gridx=i;
            gc.gridy=0;
            
           ch=new JLabel(numb[j]);

            pan_prc.add(ch,gc);     
            j++;
        }
        gc.insets=new Insets(10,0,0,10);
            gc.gridx=0;
            gc.gridy=0;            
           ch=new JLabel("TableSpaces");
           pan_nam.add(ch,gc);
           porcent= new JLabel("porcent uso");
           pan_button.add(porcent,gc);
           gc.gridx=1;
           ch=new JLabel("Boton");
           pan_button.add(ch,gc);
           j=1;
       for(int i=0;i<ts.size();i++)
        {
            gc.gridx=0;
            gc.gridy=j;
           ch=new JLabel(ts.get(i).getNombre());
           ch.setForeground(colors[i]);
            pan_nam.add(ch,gc);  
           porcent=new JLabel(Float.toString(ts.get(i).porcent_use())+"%");
           porcent.setForeground(colors[i]);
           pan_button.add(porcent,gc);
           gc.gridx=1;
           boton= new JButton(ts.get(i).getNombre());
           boton.setActionCommand(ts.get(i).getNombre());
           boton.addActionListener(this);
            pan_button.add(boton,gc);           
              
            j++;
        }
        add(pan_button,BorderLayout.EAST);
        add(pan_nam,BorderLayout.WEST);
        add(pan_prc,BorderLayout.SOUTH);
    }
    public void paint( Graphics g )
{
    super.paint( g );  // llamar al método paint de la superclase
 
   param=new int[]{205,240,285,330,370,415,455,500,540,585,635};
    g.setColor(Color.LIGHT_GRAY);
    for(int i=0;i<11;i++)
    {
        g.drawLine(param[i],60, param[i], 400);
    }
    g.setColor(Color.RED);
    g.drawLine(562,60, 562, 400);
    int y=180;
    int aux;
    for(int i=0;i<ts.size();i++)
    {
    g.setColor(colors[i]);
    g.drawRect(205,y,430, 20);// ver eje x
    aux=locuse((int)ts.get(i).porcent_use());
    g.fillRect(205,y, aux, 20);
    
    y+=35;
    }
   
} 
 
    private int locuse(int porc)
    {
        int aux=((430*porc)/100)+1;
        System.out.println(aux);
        return aux;
    }
    
   

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<ts.size();i++)
        {
        if(e.getActionCommand()== ts.get(i).getNombre())
        {
            try {
                gestor.iniciarVent3(ts.get(i).getNombre());
            } catch (InterruptedException ex) {
                Logger.getLogger(Vent1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
    }


}
