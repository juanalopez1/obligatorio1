/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package obligatorio;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



/**
 *
 * @author juana
 */
public class PreparadoTest {
    
    public PreparadoTest() {
    }
    
    /**
     * Test of preparadoViable method, of class Preparado.
     */
    @Test
    public void PreparadoViableNoListaBlanca() {
        Suero suero = new Suero ("1", "prueba");
        Farmaco farm1 = new Farmaco("3", "este farmaco no esta en la lista blanca");
        Lista<INodo> farmacos = new Lista();
        farmacos.insertar(new Nodo(farm1, "3"));
        Lista<Integer> blanca = new Lista();
        Lista<INodo> negra = new Lista();
        Preparado instance = new Preparado(blanca,negra);
        instance.preparadoViable(suero, farmacos);
        boolean expResult = false;
        boolean result = instance.preparadoViable(suero, farmacos);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
