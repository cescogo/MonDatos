/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.text.DecimalFormat;

/**
 *
 * @author cesar
 */
public class TableSpace {
    private String nombre;
    private String fecha;
    private float tam_total;
    private float uso;
    private float free;
    private float size;
    private float tasatrans;
    DecimalFormat format;

    public TableSpace() {
         this.nombre = "";
        this.tam_total = 0;
        this.uso = 0;
        this.free= 0;
        fecha="";
    }

    public TableSpace(String fecha,String nombre, float tam_total, float free) {
        this.fecha=fecha;
        this.nombre = nombre;
        this.tam_total = tam_total;
        this.uso = tam_total-free;
        this.free= free;
        format = new DecimalFormat("00.00");
    }
    
     public TableSpace(String fecha,String nombre, int uso,int size,int tasatran) {
        this.fecha=fecha;
        this.nombre = nombre;
        this.tam_total = tam_total;
        this.uso = tam_total-free;
        this.free= free;
        this.size=size;
        this.tasatrans=tasatrans;
        format = new DecimalFormat("00.00");
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public float getTasatrans() {
        return tasatrans;
    }

    public void setTasatrans(float tasatrans) {
        this.tasatrans = tasatrans;
    }

     
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getTam_total() {
        return tam_total;
    }

    public void setTam_total(float tam_total) {
        this.tam_total = tam_total;
    }

    public float getUso() {
        return uso;
    }

    public void setUso(float uso) {
        this.uso = uso;
    }

    public float getFree() {
        return free;
    }

    public void setFree(float free) {
        this.free = free;
    }


    
    public float porcent_use()
    {
        return Float.valueOf(format.format((uso/tam_total)*100).replaceAll(",", "."));
    }
    
    public float porcent_free()
    {
        return Float.valueOf(format.format((free/tam_total)*100).replaceAll(",", "."));
    }

    
 
    
}
