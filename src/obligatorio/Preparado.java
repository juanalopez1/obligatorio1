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
            
            /* en caso de que esta condicion retorne null, significa que este
             * farmaco NO esta en la lista blanca, por lo que no es viable...
            */
            if (farmacos.buscar(i).getDato() == null){
                return false;
            } else {
                // si no esta adentro de la lista blanca, entonces no es viable...
                if (listaBlanca.buscar(farmacos.buscar(i).getEtiqueta()) == null){
                    return false;
                }

                /* aca validamos que el farmaco actual este dentro de la lista negra...
                 * si no esta, significa que cumple con lo siguiente:
                 * Esta dentro de la lista blanca
                 * NO esta dentro de la negra
                */
                if (listaNegra.buscar(farmacos.buscar(i).getEtiqueta()) != null){
                    
                    int idSueroActual = (int) listaNegra.buscar(farmacos.buscar(i).getEtiqueta()).getDato();
                    int idFarmacoActual = (int) listaNegra.buscar(farmacos.buscar(i).getEtiqueta()).getEtiqueta();
                    
                    // validamos si el suero y farmaco actuales estan dentro de la negra, si lo estan, retornamos FALSE
                    if (suero.getId() == idSueroActual && (int) farmacos.buscar(i).getEtiqueta() == idFarmacoActual) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}