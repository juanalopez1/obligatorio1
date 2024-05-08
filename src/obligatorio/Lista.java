package PARCIAL1;

public class Lista<E> implements ILista<E> {

    private INodo<E> primero;

    public Lista() {
        primero = null;
    }

    public Lista(INodo<E> unNodo) {
        this.primero = unNodo;
    }
 
    
    public String imprimir() {
        String aux = "";
        if (!esVacia()) {
            INodo<E> temp = primero;
            while (temp != null) {
                temp.imprimirEtiqueta();
                aux += temp.getEtiqueta();
                temp = temp.getSiguiente();
            }
        }
        return aux;
    }
   
    public boolean esVacia() {
        return primero == null;
    }

    public INodo<E> getPrimero() {
        return primero;
    }

    @Override
    public void insertar(INodo<E> nodo) {
        if (esVacia()){
            this.primero = nodo;
        } else {
            INodo<E> aux = getPrimero();
            while (aux.getSiguiente() != null){
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nodo);
        }
    }

    @Override
    public INodo buscar(Comparable clave) {
        if (esVacia()){
            return null;
        } else{
            INodo<E> aux = getPrimero();
            while (aux!=null){
                if(aux.getEtiqueta().equals(clave)){
                    return aux;
                }
                aux = aux.getSiguiente();
                
            }
        }
        return null;
    }

    @Override
    public boolean enlazaEnEquipos(Lista<Equipo> listaEquipos) {
        Alumno alumnoAux;
        Equipo equipoAux;
        INodo nodoAux;
        if (!esVacia()) {
            INodo temp = primero;
            while (temp != null) {
                alumnoAux = (Alumno) temp.getDato();
                System.out.print(alumnoAux.getNombre());
                nodoAux = listaEquipos.buscar(alumnoAux.getEquipo());
                equipoAux=(Equipo) nodoAux.getDato();
                INodo nodo1 = new Nodo(alumnoAux, alumnoAux.getEquipo());
                equipoAux.getListaAlumnos().insertar(nodo1);
                temp = temp.getSiguiente();
            }
             return true;
        }else {return false;}
       
    }
                
        

    @Override
    public void insertarOrdenado(INodo<E> nodo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}
