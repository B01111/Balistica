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

    @Override
    public int compareTo(Par o) {
        return Double.compare(this.puntaje, o.puntaje);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + (int) (Double.doubleToLongBits(this.puntaje) ^ (Double.doubleToLongBits(this.puntaje) >>> 32));
        return hash;
    }
    
    @Override
    public boolean equals(Object o){
        boolean resultado = true;
        if(this.compareTo((Par)o) != 0){
            resultado = false;
        }
        return resultado;
    }
}
