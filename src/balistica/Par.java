/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package balistica;

/**
 *
 * @author Joshua
 */
public class Par implements Comparable<Par>{
    public Solucion solucion;
    public double puntaje;
    
    public Par(){
        this.solucion = null;
        this.puntaje = 0.0;
    }
    
    public Par(Solucion solucion,double puntaje){
        this.solucion = solucion;
        this.puntaje = puntaje;
    }
    
    public boolean equals(Par p){
        boolean resultado = false;
        if(this.solucion.equals(p.solucion)){
            resultado = true;
        }
        return resultado;
    }

    @Override
    public int compareTo(Par o) {
        int resultado = 0;
        if(this.puntaje < o.puntaje){
            resultado = -1;
        }else if(this.puntaje > o.puntaje){
            resultado = 1;
        }
        return resultado;
    }
}
