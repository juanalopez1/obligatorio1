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
        
        // cargamos las listaas negra y blanca de los archivos
        Lista<Integer> listaBlanca = new Lista<>();
        Lista<INodo> listaNegra = new Lista<>();
        Lista<INodo> listaSueros = new Lista<>();
        Lista<INodo> listaFarmacos = new Lista<>();
           
        String[] archivoListaBlanca = ManejadorArchivosGenerico.leerArchivo("src\\listablanca.txt");
        String[] archivoListaNegra = ManejadorArchivosGenerico.leerArchivo("src\\listanegra.txt");
        String[] archivoSueros = ManejadorArchivosGenerico.leerArchivo("src\\Sueros.txt");
        String[] archivoFarmacos = ManejadorArchivosGenerico.leerArchivo("src\\farmacos.txt");
        
        for (int i = 0; i < archivoListaBlanca.length; i++) {
            listaBlanca.insertar(new Nodo(archivoListaBlanca[i],archivoListaBlanca[i]));  
            System.out.println(archivoListaBlanca[i]);
        }
        
        for (int i = 0; i < archivoListaNegra.length; i++) {
            String[] parts = archivoListaNegra[i].split(",");
            listaNegra.insertar(new Nodo(parts[1].trim(),parts[0].trim()));  
        }
        
        for (int i = 0; i < archivoSueros.length; i++) {
            String[] parts = archivoSueros[i].split(",");
            int id = Integer.parseInt(parts[0]);
            listaSueros.insertar(new Nodo(new Suero (id, parts[1].trim()), id));  
        }
        
        for (int i = 0; i < archivoFarmacos.length; i++) {
            String[] parts = archivoFarmacos[i].split(",");
            int id = Integer.parseInt(parts[0]);
            listaFarmacos.insertar(new Nodo(new Farmaco (id, parts[1].trim()), id)); 
        }
        
        Preparado preparado = new Preparado(listaBlanca, listaNegra);
        Suero miSuero = (Suero) listaSueros.buscar(12).getDato();   
        // esto lo puse asi porque en realidad las instancias de los sueros ya estan creadas dentro 
        // de la lista de sueros ahi arriba
        Lista<INodo> farmacosElegidos = new Lista<>();
        // no se que es mas conveniente en el metodo de preparado, si Lista<INodo>
        // o Lista<Farmaco>
        Farmaco farmaco1 = (Farmaco) listaFarmacos.buscar(13).getDato();
        farmacosElegidos.insertar((new Nodo(farmaco1, 13)));
        //////////////////////////
        /* Hacemos una prueba...*/
        //////////////////////////
        
//        Preparado prueba = new Preparado(listaBlanca, listaNegra);
          System.out.println(miSuero.imprimir());   // se imprime el suero a usar
          System.out.println(farmacosElegidos.imprimirLista()); // se imprime la lista de farmacos a usar
          if (preparado.preparadoViable(miSuero, farmacosElegidos)){    // se imprime si es viable o no
              System.out.println("Preparado viable");
          }
          else{
              System.out.println("Preparado no viable");
          }
//        boolean esViable = prueba.preparadoViable(algunSuero, farmacos);
//        System.out.println("Es viable el suerinho de pruebinha? " + esViable);
    }
    
}
