/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package balistica;

/**
 *
 * @author b01111
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Solucion prueba = new Solucion();
        Ambiente ambiente = new Ambiente(9.8, 1000, 1000);
        Ambiente ambiente2 = new Ambiente();
        prueba.debug();
        //ambiente.debug();
        System.out.println(ambiente.evaluar(prueba));
        //ambiente2.debug();
        System.out.println(ambiente2.evaluar(prueba));
    }
}
