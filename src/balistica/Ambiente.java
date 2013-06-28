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
        tDisparo = 0.001;
        d = 1000;
        yi = 0;
    }
    
    public Ambiente(double gravedad, double alturaInicial, double distancia){
        this.g = gravedad;
        this.tDisparo = 0.001;
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
    
    public void debug(){
        System.out.println("Gravedad: "+g+"m/s^2\tTiempo de Disparo: "+tDisparo+"s\tDistancia Objetivo: "+d+"m\tAltura Inicial: "+yi+"m");
    }
    
    public double evaluar(Solucion s){
        double m =s.getMasa();
        double vi = s.getVelocidadInicial();
        double angulo = s.getAngulo();
        double fuerza = (m*vi/tDisparo);
        double ts;
        if(yi > 0.0){
            ts = (vi*Math.sin(angulo)+ Math.sqrt(Math.pow(vi,2)*Math.pow(Math.sin(angulo),2)+2*g*yi))/g;   //tiempo en impactar el suelo
        }else{
            ts = 2*vi*Math.sin(angulo)/g;
        }
        double ds = vi*ts*Math.cos(angulo);    //ds = distancia entre el punto de disparo y el de colision
        //System.out.println("Fuerza: "+fuerza+"N\tTiempo de impacto: "+ts+"s\tDistancia Recorrida: "+ds+"m");
        double puntaje = Math.max(0,1000+Math.max(0,(50-Math.abs(d-ds)))*100-3*ts-Math.pow(fuerza,1/3));
        return puntaje; //Falta sacar el puntaje
    }
}
