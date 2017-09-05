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
import modelo.Table;

/**
 *
 * @author carmc_000
 */
public class Tabla extends JFrame {

    public Tabla(ArrayList<Table> ts) {
        //headers for the table
        String[] columns = new String[]{
            //"Id", "N", "Hourly Rate", "Part Time" 
            "Table", "Size", "T.transaccion"
        };
        Table tab;
        Object[][] data = new Object[ts.size()][];
        for (int i = 0; i < ts.size(); i++) {
            tab = ts.get(i);
            data[i]
                    = new Object[]{
                        tab.getName(),
                        tab.getBytes(),
                        tab.getCount()
                    };
        }

        //create table with data
        JTable table = new JTable(data, columns);

        //add the table to the frame
        this.add(new JScrollPane(table));

        this.setTitle("Tabla");
        this.setSize(1000, 400);
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
