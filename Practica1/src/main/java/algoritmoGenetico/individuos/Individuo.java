/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmoGenetico.individuos;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author usuario_local
 */
public abstract class Individuo<T> {
    T[] cromosoma; //cadena de genes
    double[] fenotipo;
    int[] tamGenes; //longitod
    double[] min;
    double[] max;
    double valorError;
    Random rand = new Random();
    double fitness;
    double puntuacion;
    double puntuacionAc;
   public Individuo(double v){
       valorError=v;
   
   }
    
 
   public int tamGen(double vErrot, double min, double max){
       return (int) (Math.log10(((max - min) / vErrot) + 1) / Math.log10(2));
   }
   

    public T[] getCromosoma() {
        return cromosoma;
    }


    public int[] getTamGenes() {
        return tamGenes;
    }

    public double[] getMin() {
        return min;
    }

    public double[] getMax() {
        return max;
    }

    public double getValorError() {
        return valorError;
    }

    public Random getRand() {
        return rand;
    }

    public double getFitness() {
        return fitness;
    }

    public double getPuntuacion() {
        return puntuacion;
    }

    public double getPuntuacionAc() {
        return puntuacionAc;
    }

    public void setCromosoma(int pos, T mut) {
        this.cromosoma[pos] = mut;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    public void setCromosoma(T[] cromosoma) {
        this.cromosoma = cromosoma;
    }

    public void setValorError(double valorError) {
        this.valorError = valorError;
    }

    public void setPuntuacion(double puntuacion) {
        this.puntuacion = puntuacion;
    }

    public void setPuntuacionAc(double puntuacionAc) {
        this.puntuacionAc = puntuacionAc;
    }
    
    public abstract double evalua();
    public abstract Individuo clon( T[] crom);
    public abstract double getFenotipo(int num);
    
}
