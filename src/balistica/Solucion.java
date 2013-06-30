/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package balistica;

import java.math.BigInteger;

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
        this.angulo = Math.PI/4;
        this.vi = 100;
        this.m = 10;
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
    
    public void debug(){
        System.out.println("Masa: "+m+"Kg\tVelocidad Inicial: "+vi+"m/s\tAngulo: "+angulo+"rad");
    }
    
    public boolean equals(Solucion s){
        boolean resultado = false;
        if(this.m == s.getMasa() && this.vi == s.getVelocidadInicial() && this.angulo == s.getAngulo()){
            resultado = true;
        }
        return resultado;
    }
    
    public Solucion cruzar(Solucion s){
        String a = Double.toString(this.angulo);
        String b = Double.toString(s.getAngulo());
        int pos = a.indexOf(".");
        String a1 = a.substring(0, pos);
        String a2 = a.substring(pos+1, a.length());
        pos = b.indexOf(".");
        String b1 = a.substring(0, pos);
        String b2 = a.substring(pos+1, a.length());
        
        //double doubleVal = Double.longBitsToDouble(new BigInteger(text, 2).longValue());
        return new Solucion();
    }
}
