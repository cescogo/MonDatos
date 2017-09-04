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
import java.awt.event.ItemListener;
import java.util.ArrayList;
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
public class Grafico extends JFrame {
     private JPanel panel,pan_prc;
     private Control gestor;
     private JLabel porcent;
     private String[] numb;
     ArrayList<TableSpace> ts;
      int[] param;
    public Grafico(Vent1 ven,Control c)
    {
        super("tablespace");
     ven.dispose();   
     panel= new JPanel(); 
     pan_prc= new JPanel(); 
     gestor=c;
      
       setSize(700,400);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void init(ArrayList<TableSpace> tab_graf)
    {
        ts=tab_graf;
        numb= new String[]{"0%","10%","20%","30%","40%","50%","60%","70%","80%","90%","100%"};
        int j=0;
        GridBagLayout tb= new GridBagLayout();
        panel.setLayout(new BorderLayout());
       pan_prc.setLayout(tb);
       
        
        GridBagConstraints gc = new GridBagConstraints();

   

         gc.insets=new Insets(10,10,10,10);
        for(int i=0;i<11;i++)
        {
            gc.gridx=i;
            gc.gridy=0;
            
           JLabel ch=new JLabel(numb[j]);

            pan_prc.add(ch,gc);     
            j++;
        }
       
        
//        add(panel,BorderLayout.CENTER);
        add(pan_prc,BorderLayout.SOUTH);
    }
    public void paint( Graphics g )
{
    super.paint( g );  // llamar al método paint de la superclase
 
   param=new int[]{130,165,210,250,295,340,380,425,465,510,555};
    g.setColor(Color.LIGHT_GRAY);
    for(int i=0;i<11;i++)
    {
        g.drawLine(param[i],60, param[i], 400);
    }
    g.setColor(Color.RED);
    g.drawLine(488,60, 488, 400);
    int y=65;
    for(int i=0;i<ts.size();i++)
    {
    g.setColor(Color.RED);
    g.fillRect(130,y, locuse((int)ts.get(i).porcent_use()), 30);
    g.setColor(Color.BLACK);
        System.out.println(locfree((int)ts.get(i).porcent_free()));
    g.drawRect((int)g.getClipBounds().getMaxX()-145,y,locfree((int)ts.get(i).porcent_free()), 29);// ver eje x
        
//    g.drawRect(545, y, 9, 29);
        y+=45;
    }
   
} 
 
    private int locuse(int porc)
    {
        int aux=((426*porc)/100)+1;
        System.out.println(aux);
        return aux;
    }
    
    private int locfree(int porc)
    {
        int aux=param[(int)(porc/10)+1]-param[(int)(porc/10)];
        
        return (porc*aux)/10;
    }


}
