/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package balistica;

/**
 *
 * @author Joshua
 */
public class Hijos {
    public Solucion hijo1;
    public Solucion hijo2;
    
    public Hijos(){
        this.hijo1 = null;
        this.hijo2 = null;
    }
    
    public Hijos(Solucion hijo1,Solucion hijo2){
        this.hijo1 = hijo1;
        this.hijo2 = hijo2;
    }
}
