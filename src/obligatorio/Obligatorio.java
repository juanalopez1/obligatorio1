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
        
        // inicializamos y cargamos datos en la lista de farmacos
        Lista<Farmaco> farmacos = new Lista<>();
        farmacos.insertar(new Nodo(1, 1));
        farmacos.insertar(new Nodo(2, 2));
        
        // creamos un suero para usar de ejemplo
        Suero algunSuero = new Suero(12, "Algun suero random");

        // cargamos las listaas negra y blanca de los archivos
        Lista<Integer> listaBlanca = new Lista<>();
        Lista<INodo> listaNegra = new Lista<>();
           
        String[] archivoListaBlanca = ManejadorArchivosGenerico.leerArchivo("src\\listablanca.txt");
        String[] archivoListaNegra = ManejadorArchivosGenerico.leerArchivo("src\\listanegra.txt");
        
        for (int i = 0; i < archivoListaBlanca.length; i++) {
            listaBlanca.insertar(new Nodo(archivoListaBlanca[i],archivoListaBlanca[i]));  
        }
        
        for (int i = 0; i < archivoListaNegra.length; i++) {
            String[] parts = archivoListaNegra[i].split(",");
            listaNegra.insertar(new Nodo(parts[1],parts[0]));  
        }
        
        //////////////////////////
        /* Hacemos una prueba...*/
        //////////////////////////
        
        Preparado prueba = new Preparado(listaBlanca, listaNegra);
        
        boolean esViable = prueba.preparadoViable(algunSuero, farmacos);
        System.out.println("Es viable el suerinho de pruebinha? " + esViable);
    }
    
}
