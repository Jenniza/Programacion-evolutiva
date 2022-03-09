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
public class MutacionBasica extends Mutacion{

    public MutacionBasica( AlgoritmoGenetico ag) {
        super( ag);
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
                    prob=ran.nextDouble();
                    if(probMuta>prob){
                        mutado=true;
                        if(algG.getPoblacion()[i].getCromosoma()[j].equals(true)){
                            algG.getPoblacion()[i].setCromosoma(j, false);
                        
                        }else{
                            algG.getPoblacion()[i].setCromosoma(j, true);
                        
                        }
                        
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
