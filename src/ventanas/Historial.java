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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author cesar
 */
public class Historial extends JFrame implements ActionListener {
    private Control gestor;
    public  Historial(Control ges)
    {
        gestor=ges;
          String[] columns = new String[]{
            
            "Fecha","Nombre","Registros", "Size", "T.transaccion"
        };
        
//        Object[][] data = new Object[ts.size()+1][];
//        for (int i = 0; i < ts.size(); i++) {
//            data[i]
//                    = new Object[]{
//                        ts.get(i).getFecha(),
//                        ts.get(i).getNombre(),
//                        ts.get(i).getUso(),
//                        ts.get(i).getTam_total(),
//                        ts.get(i).getTasatrans()                       
//                    };
//          
//        }
//           data[ts.size()]
//                    = new Object[]{
//                        tab.getFecha(),
//                        tab.getNombre(),
//                        tab.getUso(),
//                        tab.getTam_total(),
//                        tab.getTasatrans()                       
//                    };
           

        //create table with data
//        JTable table = new JTable(data, columns);

        JButton atras= new JButton("atras");
        JPanel p_atras= new JPanel();
        atras.setActionCommand("atras");
        atras.addActionListener(this);
        p_atras.add(atras,BorderLayout.CENTER);
        add(p_atras,BorderLayout.SOUTH);
        //add the table to the frame
//        this.add(new JScrollPane(table));

        this.setTitle("Historial HWM");
        this.setSize(600, 400);
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
                gestor.atras('h');
            } catch (InterruptedException ex) {
                Logger.getLogger(Historial.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
}
