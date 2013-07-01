/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package balistica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 *
 * @author b01111
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //VentanaParametros vp = new VentanaParametros(); Aun no esta conectada a la aplicacion
        //vp.setVisible(true);
        int tamano = 30;
        int iteraciones = 30;
        double gravedad = 9.8;
        double alturaInicial = 0.0;
        double distanciaObjetivo  = 1000.0;
        
        //Generamos el ambiente y la poblacion inicial
        Ambiente ambiente = new Ambiente(gravedad,alturaInicial,distanciaObjetivo);
        ArrayList<Par> poblacion = generarPoblacion(tamano,ambiente);
        
        //Imprimimos los puntajes de la poblacion inicial (Por ahora en consola)
        System.out.println("Primera poblacion:");
        Iterator<Par> i = poblacion.iterator();
        Par p;
        while(i.hasNext()){
            p = i.next();
            System.out.println(p.puntaje);
        }
        
        //Iteramos sobre las poblaciones
        for(int j =0; j < iteraciones; ++j){
            poblacion = siguienteGeneracion(tamano,ambiente,poblacion);
        }
        
        //Los puntajes de la ultima poblacion
        System.out.println("Ultima poblacion:");
        i = poblacion.iterator();
        while(i.hasNext()){
            p = i.next();
            p.solucion.debug();
            System.out.println(p.puntaje);
        }
    }
    
    static private ArrayList<Par> generarPoblacion(int tamano,Ambiente ambiente){
        ArrayList<Par> poblacion = new ArrayList<>(tamano);
        Solucion s;
        for(int i = 0; i < tamano;++i){
            s = new Solucion(0.0000001+Math.random()*((Math.PI/2)-0.0000001),1+Math.random()*999,1+Math.random()*99);
            if(!poblacion.add(new Par(s,ambiente.evaluar(s)))){
                --i;
            }
        }
        Collections.sort(poblacion);
        Collections.reverse(poblacion);
        return poblacion;
    }
    
    /*
     * Se aplica elitismo, cruce por ruleta y mutacion que se encuentra dentro del cruce
     */
    static private ArrayList<Par> siguienteGeneracion(int tamano,Ambiente ambiente,ArrayList<Par> poblacionAnterior){
        ArrayList<Par> poblacion = new ArrayList<>(tamano);
        int n = 0;
        double aptitudTotal = 0.0;
        double acumulado = 0.0;
        double treshold;
        Par p = new Par();
        Par q = new Par();
        Hijos h;
        
        //Elitismo 10 individuos
        Iterator<Par> i = poblacionAnterior.iterator();
        while(i.hasNext() && n < 10){
            p = i.next();
            poblacion.add(p);
            ++n;
        }
        
        //Ruleta para cruce
        i = poblacionAnterior.iterator();
        while(i.hasNext()){
            p = i.next();
            aptitudTotal += p.puntaje; 
        }
        
        n = 0;
        while(n < 10){
            treshold = Math.random()*aptitudTotal;
            i = poblacionAnterior.iterator();
            while(i.hasNext() && acumulado < treshold){ //p es el primer padre
                p = i.next();
                acumulado += p.puntaje;
            }
            
            acumulado = 0.0;
            treshold = Math.random()*aptitudTotal;
            i = poblacionAnterior.iterator();
            while(i.hasNext() && acumulado < treshold){ //q es el segundo padre
                q = i.next();
                acumulado += q.puntaje;
            }
            h = p.solucion.cruzar(q.solucion);
            
            p = new Par(h.hijo1,ambiente.evaluar(h.hijo1));
            q = new Par(h.hijo2,ambiente.evaluar(h.hijo2));
            if(!poblacion.contains(p) && !poblacion.contains(q)){
                poblacion.add(p);
                poblacion.add(q);
                ++n;
            }
        }
        
        //Se ordena la poblacion por aptitud de mayor a menor
        Collections.sort(poblacion);
        Collections.reverse(poblacion);
        return poblacion;
    }
}
