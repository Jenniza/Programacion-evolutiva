/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmoGenetico.cruces;

import algoritmoGenetico.AlgoritmoGenetico;
import algoritmoGenetico.individuos.Individuo;
import java.util.ArrayList;

/**
 *
 * @author usuario_local
 */
public abstract class Cruce {
    //seleccionados para reproducir
    AlgoritmoGenetico algG;
    int [] sel_cruce;
    //contador seleccionados
    double prob;
    Individuo hijo1,hijo2;
    public Cruce (AlgoritmoGenetico algG){
        this.algG=algG;
        double prob=algG.getProbCruce()/100;
      
        
        
        
    }
    public void getSel(){
        ArrayList<Integer> sel=new ArrayList<Integer>();
        for (int i = 0; i < algG.getTamPoblacion(); i++) {
            double rand= Math.random();
            if (prob>=rand) {
                sel.add(i);
            }
        }
        sel_cruce=sel.stream().mapToInt(i->i).toArray();
    
    }
    public abstract void cruce();
}
