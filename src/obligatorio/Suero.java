/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package obligatorio;

/**
 *
 * @author juana
 */
public class Suero {
    private int Id;
    private String Descripcion;

    public Suero(int id, String descripcion) {
        
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
        return ("\nIdentificador suero: " + Id + " Descripcion: "+ getDescripcion());
    }
    
    
}
