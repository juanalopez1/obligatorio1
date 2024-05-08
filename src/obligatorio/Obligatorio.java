/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package obligatorio;

/**
 *
 * @author juana
 */
public class Obligatorio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Lista<Farmaco> farmacos = new Lista<>();
        Lista<Suero> suero = new Lista<>();
        
        Lista<Integer> listaBlanca = new Lista<>();
        Lista<INodo> listaNegra = new Lista<>();
           
        String[] archivoListaBlanca = ManejadorArchivosGenerico.leerArchivo("src\\listablanca.txt");
        String[] archivoListaNegra = ManejadorArchivosGenerico.leerArchivo("src\\listanegra.txt");
        
//        String[] parts = archivo[i].split(",");
        for (int i = 0; i < archivoListaBlanca.length; i++) {
//            String[] parts = archivo[i].split(",");
            listaBlanca.insertar(new Nodo(archivoListaBlanca[i],archivoListaBlanca[i]));  
        }
        
        for (int i = 0; i < archivoListaNegra.length; i++) {
            String[] parts = archivoListaNegra[i].split(",");
            listaNegra.insertar(new Nodo(parts[0],parts[1]));  
        }
    }
    
}
