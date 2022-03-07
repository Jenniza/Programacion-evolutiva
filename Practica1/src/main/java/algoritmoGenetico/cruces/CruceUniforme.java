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
public class CruceUniforme extends Cruce{

    public CruceUniforme(AlgoritmoGenetico algG) {
        super(algG);
    }

    

    @Override
    public void cruce() {
        double p=0.4;
        for (int i = 0; i < sel_cruce.length; i+=2) {
            Individuo padre=algG.getPoblacion()[i];
            Individuo madre=algG.getPoblacion()[i+1];
            Boolean [] a=new Boolean[padre.getCromosoma().length];
            Boolean [] b=new Boolean[madre.getCromosoma().length];
            double rand=Math.random();
              for (int j = 0; j < padre.getCromosoma().length; j++) {
                if(rand<p){
                    a[j]=(Boolean)padre.getCromosoma()[j];
                    b[j]=(Boolean)madre.getCromosoma()[j];
                }else{
                    a[j]=(Boolean)madre.getCromosoma()[j];
                    b[j]=(Boolean)padre.getCromosoma()[j];
                
                }
            }
            hijo1=padre.clon((Boolean[])a);
            hijo2=madre.clon((Boolean[])b);
            algG.getPoblacion()[i]=hijo1;
            algG.getPoblacion()[i+1]=hijo2;
        }
    }
    
}
