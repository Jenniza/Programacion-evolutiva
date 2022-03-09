/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmoGenetico.cruces;

import algoritmoGenetico.AlgoritmoGenetico;
import algoritmoGenetico.individuos.Individuo;
import java.util.Random;

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
        if(algG.getFuncion()==4){
            Random rand=new Random();
            for (int i = 0; i < sel_cruce.length; i+=2) {
            Individuo padre=algG.getPoblacion()[i];
            Individuo madre=algG.getPoblacion()[i+1];
            
            
            double n=1;
            Double [] a=new Double[padre.getCromosoma().length];
            
            
            for (int j = 0; j < padre.getCromosoma().length; j++) {
                double alfa= 0.5;
                double max;
                double min;
                double l;
                if ((Double)padre.getCromosoma()[j]>(Double)madre.getCromosoma()[j]) {
                    max=(Double)padre.getCromosoma()[j];
                    min=(Double)madre.getCromosoma()[j];
                }else{
                    min=(Double)padre.getCromosoma()[j];
                    max=(Double)madre.getCromosoma()[j];
                }
                l=max-min;
                double cromosomaHijo=rand.nextDouble(min-l*alfa, max + l*alfa);
                a[i]=cromosomaHijo;
                
            }
            hijo1=padre.clon((Double[])a);
            hijo2=madre.clon((Double[])a);
            algG.getPoblacion()[i]=hijo1;
            algG.getPoblacion()[i+1]=hijo2;
        }
    
        }else{
            for (int i = 0; i < sel_cruce.length; i+=2) {
            Individuo padre=algG.getPoblacion()[i];
            Individuo madre=algG.getPoblacion()[i+1];


            double n=1;
            Boolean [] a=new Boolean[padre.getCromosoma().length];
            Boolean [] b=new Boolean[madre.getCromosoma().length];

            for (int j = 0; j < padre.getCromosoma().length; j++) {
                double r= Math.random();
                if (r>0.5){
                    a[i]=(Boolean)padre.getCromosoma()[j];
                    b[i]=(Boolean)madre.getCromosoma()[j];

                }else{
                    b[i]=(Boolean)padre.getCromosoma()[j];
                    a[i]=(Boolean)madre.getCromosoma()[j];
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
