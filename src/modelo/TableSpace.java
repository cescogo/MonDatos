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
    private float tam_total;
    private float uso;
    public float free;
    DecimalFormat format;

    public TableSpace(String nombre, float tam_total, float free) {
        this.nombre = nombre;
        this.tam_total = tam_total;
        this.uso = tam_total-free;
        this.free= free;
        format = new DecimalFormat("00.00");
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

    @Override
    public String toString() {
        return "TableSpace{" + "nombre=" + nombre + ", tam_total=" + tam_total + ", uso=" + porcent_use() + ", free=" + porcent_free() + '}';
    }
 
    
}
