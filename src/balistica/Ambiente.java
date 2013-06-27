/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package balistica;

/**
 *
 * @author b01111
 */
public class Ambiente {
    private double g;
    private double tDisparo;
    private double d;
    private double yi;
    
    public Ambiente(){
        g = 9.8;
        tDisparo = 0.0001;
        d = 1000;
        yi = 0;
    }
    
    public Ambiente(double gravedad,double alturaInicial, double distancia){
        this.g = gravedad;
        this.tDisparo = 0.0001;
        this.d = distancia;
        this.yi = alturaInicial;
    }
    
    public double getGravedad(){
        return g;
    }
    
    public double getTdisparo(){
        return tDisparo;
    }
    
    public double getAlturaInicial(){
        return yi;
    }
    
    public double getDistanciaObjetivo(){
        return d;
    }
    
    public double evaluar(Solucion s){
        double m =s.getMasa();
        double vi = s.getVelocidadInicial();
        double angulo = s.getAngulo();
        double puntaje = 0.0;
        double fuerza = m*vi/tDisparo;
        double ts = (vi*Math.sin(angulo)- Math.sqrt(Math.pow(vi,2)*Math.pow(Math.sin(angulo),2)+2*g*yi))/g;   //tiempo en impactar el suelo
        double ds = vi*ts*Math.cos(angulo);    //ds = distancia entre el punto de disparo y el de colision
        return puntaje; //Falta sacar el puntaje
    }
}
