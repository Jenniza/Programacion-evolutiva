/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmoGenetico.cruces;

import algoritmoGenetico.AlgoritmoGenetico;
import algoritmoGenetico.individuos.Individuo;
import algoritmoGenetico.individuos.IndividuoFuncion1;
import algoritmoGenetico.individuos.IndividuoFuncion2;
import algoritmoGenetico.individuos.IndividuoFuncion3;
import algoritmoGenetico.individuos.IndividuoFuncion4;
import java.util.Random;

/**
 *
 * @author usuario_local
 */
public class CruceMonopunto extends Cruce{

    public CruceMonopunto(AlgoritmoGenetico algG) {
        super(algG);
    }

    

    
    public void cruce() {
       Random rand=new Random();
       if(algG.getFuncion()==4){
         for (int i = 0; i < sel_cruce.length; i+=2) {
            Individuo padre=algG.getPoblacion()[i];
            Individuo madre=algG.getPoblacion()[i+1];
            int pCruce=rand.nextInt(padre.getCromosoma().length-2)+1;
            
            Double [] a=new Double[padre.getCromosoma().length];
            Double [] b=new Double[madre.getCromosoma().length];
            for (int j = 0; j < padre.getCromosoma().length; j++) {
                if(pCruce>j){
                    a[j]=(Double)padre.getCromosoma()[j];
                    b[j]=(Double)madre.getCromosoma()[j];
                }else{
                    a[j]=(Double)madre.getCromosoma()[j];
                    b[j]=(Double)padre.getCromosoma()[j];
                
                }
            }
            hijo1=padre.clon((Double[])a);
            hijo2=madre.clon((Double[])b);
            algG.getPoblacion()[i]=hijo1;
            algG.getPoblacion()[i+1]=hijo2;
            
        }
       }
       else{
        for (int i = 0; i < sel_cruce.length; i+=2) {
            Individuo padre=algG.getPoblacion()[i];
            Individuo madre=algG.getPoblacion()[i+1];
            int pCruce=rand.nextInt(padre.getCromosoma().length-2)+1;
            
            Boolean [] a=new Boolean[padre.getCromosoma().length];
            Boolean [] b=new Boolean[madre.getCromosoma().length];
            for (int j = 0; j < padre.getCromosoma().length; j++) {
                if(pCruce>j){
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
    
}
