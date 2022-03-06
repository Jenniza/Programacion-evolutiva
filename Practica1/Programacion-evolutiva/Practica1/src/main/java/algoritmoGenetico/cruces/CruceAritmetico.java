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
public class CruceAritmetico extends Cruce{

    public CruceAritmetico(AlgoritmoGenetico algG) {
        super(algG);
    }

    

    @Override
    public void cruce() {
        for (int i = 0; i < sel_cruce.length; i+=2) {
            Individuo padre=algG.getPoblacion()[i];
            Individuo madre=algG.getPoblacion()[i+1];

            Object [] a=new Object[padre.getCromosoma().length];
            Object [] b=new Object[madre.getCromosoma().length];
            int pos=0;
            for (int m = 0; m < padre.getMin().length; m++) {
                
                Boolean x=(Boolean) padre.getCromosoma()[pos];
                Boolean y=(Boolean) madre.getCromosoma()[pos];
                Boolean llevada=false;
                if (x&&y){
                    llevada=true;
                }

                for (int j = 1; j < padre.getTamGenes()[m]; j++) {
                    pos++;
                    x=(Boolean) padre.getCromosoma()[j];
                    y=(Boolean) madre.getCromosoma()[j];
                    a[j-1]=x^y;
                    a[j-1]=llevada^(Boolean)a[j-1];
                    if(x&&y){
                        llevada=true;

                    }else {
                        llevada=false;
                    }
                }
                a[padre.getTamGenes()[m]-1]=llevada;
                pos++;
            }
            
            hijo1=padre.clon((Boolean[])a);
            hijo2=madre.clon((Boolean[])a);
            algG.getPoblacion()[i]=hijo1;
            algG.getPoblacion()[i+1]=hijo2;
    }
    
    }
}