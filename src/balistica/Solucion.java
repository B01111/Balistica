/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package balistica;

/**
 *
 * @author b01111
 */
public class Solucion {
    private double angulo;
    private double vi;
    private double m;
    
    public Solucion(double angulo, double vi, double m){
        this.angulo = angulo;
        this.vi = vi;
        this.m = m;
    }    
    
    public Solucion(){
        this.angulo = 45.0;
        this.vi = 100;
    }
    
    public double getAngulo(){
        return angulo;
    }
    
    public double getVelocidadInicial(){
        return vi;
    }
        
    public double getMasa(){
        return m;
    }
}
