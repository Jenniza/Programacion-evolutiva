/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmoGenetico.mutaciones;

import algoritmoGenetico.AlgoritmoGenetico;
import java.util.Random;

/**
 *
 * @author usuario_local
 */
public class MutacionUniforme extends Mutacion{

    public MutacionUniforme( AlgoritmoGenetico algG) {
        super(algG);
    }


    @Override
    public void mutacion() {
                boolean mutado=false;
        int i,j;
        double prob;
        Random ran= new Random();
        for (i = 0; i < algG.getTamPoblacion(); i++) {
            for (int k = 0; k < algG.getPoblacion()[i].getTamGenes().length; k++) {
                int genTam =algG.getPoblacion()[i].getTamGenes()[k];
                for (j = 0;  j< genTam; ++j) {
                    prob=ran.nextDouble(0,100);
                    if(probMuta>prob){
                        mutado=true;
                        algG.getPoblacion()[i].setCromosoma(k, ran.nextDouble(algG.getPoblacion()[i].getMin()[k], algG.getPoblacion()[i].getMax()[k]));
                        
                    }
                    
                }
                if (mutado){
                    algG.getPoblacion()[i].evalua();
                    mutado=false;
                }
            }
             
            
        }
    }
    
}
