/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package obligatorio;

import obligatorio.Lista;

/**
 *
 * @author juana
 */
public class Preparado {
    
    public Lista<Integer> listaBlanca = new Lista();
    public Lista<INodo> listaNegra = new Lista();
    
    public Preparado(Lista<Integer> listaBlanca, Lista<INodo> listaNegra) {
        this.listaBlanca = listaBlanca;
        this.listaNegra = listaNegra;
    }
    
    public boolean preparadoViable (Suero suero, Lista<Farmaco> farmacos) {
        
        for (int i = 0; i < farmacos.getLargo(); i++) {
            if (farmacos.buscar(i).getDato() != null && listaBlanca.buscar(farmacos.buscar(i).getEtiqueta()) != null){
                return true;
            }
            
            if (farmacos.buscar(i).getDato() != null && listaBlanca.buscar(farmacos.buscar(i).getEtiqueta()) != null){
                return true;
            }
        }
        return false;
        
        
        
        
//        if (listaBlanca.contains(farmaco.getId()))
//        if idfarmaaco in listablanca return true
//        else if idsuero and id farmaco in listanegra return false
    }
}
