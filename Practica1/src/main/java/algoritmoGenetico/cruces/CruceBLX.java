/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmoGenetico.cruces;

import algoritmoGenetico.AlgoritmoGenetico;
import algoritmoGenetico.individuos.Individuo;

/**
 *
 * @author usuario_local
 */
public class CruceBLX extends Cruce{

    public CruceBLX(AlgoritmoGenetico algG) {
        super(algG);
    }

   

    @Override
   public void cruce() {
        for (int i = 0; i < sel_cruce.length; i+=2) {
            Individuo padre=algG.getPoblacion()[i];
            Individuo madre=algG.getPoblacion()[i+1];
            
            
            double n=1;
            Object [] a=new Object[padre.getCromosoma().length];
            Object [] b=new Object[madre.getCromosoma().length];
            
            for (int j = 0; j < padre.getCromosoma().length; j++) {
                double r= Math.random();
                if (r>0.5){
                    a[i]=padre.getCromosoma()[j];
                    b[i]=madre.getCromosoma()[j];
                
                }else{
                    b[i]=padre.getCromosoma()[j];
                    a[i]=madre.getCromosoma()[j];
                }
                
                
            }
            hijo1=padre.clon((Boolean[])a);
            hijo2=madre.clon((Boolean[])b);
            algG.getPoblacion()[i]=hijo1;
            algG.getPoblacion()[i+1]=hijo2;
        }
    }
    
}
