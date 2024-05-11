/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package obligatorio;

import java.util.Scanner;

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
        Lista<INodo> listaFarmacosConsulta = new Lista<>();
           
        String[] archivoListaBlanca = ManejadorArchivosGenerico.leerArchivo("src\\listablanca.txt");
        String[] archivoListaNegra = ManejadorArchivosGenerico.leerArchivo("src\\listanegra.txt");
        String[] archivoSueros = ManejadorArchivosGenerico.leerArchivo("src\\Sueros.txt");
        String[] archivoFarmacos = ManejadorArchivosGenerico.leerArchivo("src\\farmacos.txt");
        String[] archivoConsulta = ManejadorArchivosGenerico.leerArchivo("src\\consulta.txt");
        
        for (int i = 0; i < archivoSueros.length; i++) {
            String[] parts = archivoSueros[i].split(",");
            listaSueros.insertar(new Nodo(new Suero (parts[0].trim(), parts[1].trim()), parts[0].trim()));  
        }
        
        for (int i = 0; i < archivoFarmacos.length; i++) {
            String[] parts = archivoFarmacos[i].split(",");
            listaFarmacos.insertar(new Nodo(new Farmaco (parts[0].trim(), parts[1].trim()), parts[0].trim())); 
        }
        
        for (int i = 0; i < archivoListaBlanca.length; i++) {
            String[] parts = archivoListaBlanca[i].split(",");
            String idFarmaco = parts[0].trim();
            if (listaFarmacos.buscar(idFarmaco) != null){
                listaBlanca.insertar(new Nodo(archivoListaBlanca[i],archivoListaBlanca[i])); 
            }
            else{
                System.out.println("No existe el farmaco " + archivoListaBlanca[i]);
            }
        }
        
        for (int i = 0; i < archivoListaNegra.length; i++) {
            String[] parts = archivoListaNegra[i].split(",");
            String idSuero = parts[0].trim();
            String idFarmaco = parts[1].trim();
            if (listaSueros.buscar(idSuero) != null && listaFarmacos.buscar(idFarmaco) != null ){
                listaNegra.insertar(new Nodo(parts[0].trim(),parts[1].trim())); 
            }
            else{
                System.out.println("No existe suero " + parts[0].trim()+ " y/o farmaco " + parts[1].trim());
            }
        }
        
        for (int i = 0; i < archivoConsulta.length; i++) {
            String[] parts = archivoConsulta[i].split(",");
            listaFarmacosConsulta.insertar(new Nodo(new Farmaco (parts[0].trim(), parts[1].trim()), parts[0].trim())); 
        }
        
        Preparado preparado = new Preparado(listaBlanca, listaNegra);
        System.out.print("Ingrese id del suero que desea en el preparado: ");
        Scanner input = new Scanner(System.in);

        String idSuero = input.nextLine(); 
        if (listaSueros.buscar(idSuero) == null){
            System.out.println("No existe suero con ese id");
        }
        Suero miSuero = (Suero) listaSueros.buscar(idSuero).getDato();  
        
        // esto lo puse asi porque en realidad las instancias de los sueros ya estan creadas dentro 
        // de la lista de sueros ahi arriba
        // no se que es mas conveniente en el metodo de preparado, si Lista<INodo>
        // o Lista<Farmaco>
        //////////////////////////
        /* Hacemos una prueba...*/
        //////////////////////////
        
//        Preparado prueba = new Preparado(listaBlanca, listaNegra);
          System.out.println(miSuero.imprimir());   // se imprime el suero a usar
          System.out.println(listaFarmacosConsulta.imprimirLista()); // se imprime la lista de farmacos a usar
          if (preparado.preparadoViable(miSuero, listaFarmacosConsulta)){    // se imprime si es viable o no
              System.out.println("Preparado viable");
          }
          else{
              System.out.println("Preparado no viable");
          }
    }
    
}
