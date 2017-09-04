/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author cesar
 */
public class TableSpace {
    private String nombre;
    private float tam_total;
    private float uso;
    public float free;

    public TableSpace(String nombre, float tam_total, float uso) {
        this.nombre = nombre;
        this.tam_total = tam_total;
        this.uso = uso;
        free= tam_total-uso;
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
    
    public float porcent_use()
    {
        return (uso/tam_total)*100;
    }
    
    public float porcent_free()
    {
        return (free/tam_total)*100;
    }
    
}
