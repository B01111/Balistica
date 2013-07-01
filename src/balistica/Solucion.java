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
    
    public Hijos cruzar(Solucion s){
        String angulos = cruzarValores(this.angulo,s.getAngulo());
        String velocidades = cruzarValores(this.vi,s.getVelocidadInicial());
        String masas = cruzarValores(this.m,s.getMasa());
        int pos = angulos.indexOf(" ");
        Double angulo1 = Double.parseDouble(angulos.substring(0, pos));
        Double angulo2 = Double.parseDouble(angulos.substring(pos+1, angulos.length()));
        
        pos = velocidades.indexOf(" ");
        Double velocidad1 = Double.parseDouble(velocidades.substring(0, pos));
        Double velocidad2 = Double.parseDouble(velocidades.substring(pos+1, velocidades.length()));
        
        pos = masas.indexOf(" ");
        Double masa1 = Double.parseDouble(masas.substring(0, pos));
        Double masa2 = Double.parseDouble(masas.substring(pos+1, masas.length()));
        
        return new Hijos(new Solucion(angulo1,velocidad1,masa1),new Solucion(angulo2,velocidad2,masa2));
    }
    
    /*
     * "Cruza" 2 valores y devuelve los "hijos" en un string
     * separados por un espacio.
     */
    private String cruzarValores(double x, double y){
        String a = Double.toString(x);
        String b = Double.toString(y);
        int pos = a.indexOf(".");   //Se separa las parte entera de la decimal
        String a1 = a.substring(0, pos);
        String a2 = a.substring(pos+1, a.length());
        pos = b.indexOf(".");
        String b1 = b.substring(0, pos);
        String b2 = b.substring(pos+1, b.length());
        
        a1 = Long.toBinaryString(Long.parseLong(a1));//Se pasan las 4 partes a binario
        a2 = Long.toBinaryString(Long.parseLong(a2));
        b1 = Long.toBinaryString(Long.parseLong(b1));
        b2 = Long.toBinaryString(Long.parseLong(b2));
        
        pos = (int)a1.length()/2;       //Se parten en 8
        String a1a = a1.substring(0, pos);
        String a1b = a1.substring(pos, a1.length());
        pos = (int)b1.length()/2;
        String b1a = b1.substring(0, pos);
        String b1b = b1.substring(pos, b1.length());
        pos = (int)a2.length()/2;
        String a2a = a2.substring(0, pos);
        String a2b = a2.substring(pos, a2.length());
        pos = (int)b2.length()/2;
        String b2a = b2.substring(0, pos);
        String b2b = b2.substring(pos, b2.length());
        
        a = Long.parseLong(a1a+b1b,2)+"."+Long.parseLong(a2a+b2b,2);    //Se combinan las partes
        b = Long.parseLong(b1a+a1b,2)+"."+Long.parseLong(b2a+a2b,2);
        return a+" "+b;
    }
}
