/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import modelo.TableSpace;

/**
 *
 * @author carmc_000
 */
public class Tabla extends JFrame {

    public Tabla(ArrayList<TableSpace> ts) {
        //headers for the table
        String[] columns = new String[]{
            //"Id", "N", "Hourly Rate", "Part Time" 
            "Fecha","Nombre","Registros", "Size", "T.transaccion"
        };
        
        Object[][] data = new Object[ts.size()][];
        for (int i = 0; i < ts.size(); i++) {
            data[i]
                    = new Object[]{
                        ts.get(i).getFecha(),
                        ts.get(i).getNombre(),
                        ts.get(i).getUso(),
                        ts.get(i).getTam_total(),
                        ts.get(i).getTasatrans()                       
                    };
            //Dba_tablespaces, que indices tiene una tabla ,la tabla q dice q columnas tiene los indeces de una tabla sugerencias
            //
            // dele ud a los sql y los calculos para meterlos\el\jueves a l;a vista 
        }

        //create table with data
        JTable table = new JTable(data, columns);

        //add the table to the frame
        this.add(new JScrollPane(table));

        this.setTitle("Tabla");
        this.setSize(600, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }

    public String fecha() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String sDate = sdf.format(date);
        return sDate;
    }

}
