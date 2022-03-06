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
public class CruceSBX extends Cruce{

    public CruceSBX(AlgoritmoGenetico algG) {
        super(algG);
    }

   

    @Override
    public void cruce() {
        for (int i = 0; i < sel_cruce.length; i+=2) {
            Individuo padre=algG.getPoblacion()[i];
            Individuo madre=algG.getPoblacion()[i+1];
            double beta=0;
            double r= Math.random();
            double n=1;
            Boolean [] a=new Boolean[padre.getCromosoma().length];
            Boolean [] b=new Boolean[madre.getCromosoma().length];
            if(r<=0.5){
                beta=2*Math.pow(r, 1/(n+1));}
            else{
                beta=Math.pow(1/(2*(1-r)), 1/(n+1));}
            for (int j = 0; j < padre.getCromosoma().length; j++) {
                double p=0;
                double k=0;
                if(((1+beta)*p+(1-beta)*k)/2<0.5){
                    a[j]=false;
                }else{
                    a[j]=true;
                }
                if(((1-beta)*p+(1+beta)*k)/2<0.5){
                    b[j]=false;
                }else{
                    b[j]=true;
                }
                
                
            }
            hijo1=padre.clon((Boolean[])a);
            hijo2=madre.clon((Boolean[])b);
            algG.getPoblacion()[i]=hijo1;
            algG.getPoblacion()[i+1]=hijo2;
        }
    }
}
