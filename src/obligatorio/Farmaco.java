/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package obligatorio;

/**
 *
 * @author juana
 */
public class Farmaco {
    private int Id;
    private String Descripcion;

    public Farmaco(int id, String descripcion) {
        
        this.Id = id;
        this.Descripcion = descripcion;
    }

    
    public int getId() {
        return this.Id;
    }

    public String getDescripcion() {
        return this.Descripcion;
    }
    
    public String imprimir() {
        return ("Identificador farmaco: " + Id + " Descripcion: "+ getDescripcion());
    }
}
