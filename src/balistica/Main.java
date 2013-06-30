/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package balistica;

import java.math.BigInteger;
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
        /*Solucion prueba = new Solucion();
        Ambiente ambiente = new Ambiente(9.8, 1000, 1000);
        Ambiente ambiente2 = new Ambiente();
        prueba.debug();
        ambiente.debug();
        System.out.println(ambiente.evaluar(prueba));
        ambiente2.debug();
        System.out.println(ambiente2.evaluar(prueba));*/
        int tamano = 30;
        Ambiente ambiente = new Ambiente();
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
        
        Iterator<Par> i = poblacion.iterator();
        Par p;
        /*while(i.hasNext()){
            p = i.next();
            p.solucion.debug();
            System.out.println(p.puntaje);
        }
        VentanaParametros vp = new VentanaParametros();
        vp.setVisible(true);*/
        s = new Solucion(0.0000001+Math.random()*((Math.PI/2)-0.0000001),1+Math.random()*999,1+Math.random()*99);
        Solucion t = new Solucion(0.0000001+Math.random()*((Math.PI/2)-0.0000001),1+Math.random()*999,1+Math.random()*99);
        s.debug();
        t.debug();
        //System.out.println("S: "+Long.toBinaryString(Double.doubleToRawLongBits(s.getAngulo())));
        //System.out.println("T: "+Long.toBinaryString(Double.doubleToRawLongBits(t.getAngulo())));
        (s.cruzar(t)).debug();
        (t.cruzar(s)).debug();
    }
}
