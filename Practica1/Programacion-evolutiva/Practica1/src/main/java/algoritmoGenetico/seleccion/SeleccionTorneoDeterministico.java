/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmoGenetico.seleccion;

import algoritmoGenetico.AlgoritmoGenetico;
import algoritmoGenetico.individuos.Individuo;

/**
 *
 * @author usuario_local
 */
public class SeleccionTorneoDeterministico extends Seleccion{

    public SeleccionTorneoDeterministico(AlgoritmoGenetico aThis) {
       super(aThis);
    }

  

    @Override
    public void seleccion( ) {
        Individuo[] sel=new Individuo[algG.getTamPoblacion()];
        int muestreo=3;
        for (int i = 0; i < algG.getPoblacion().length; i++) {
            int j=0;
            int[] torneo=new int[muestreo];
            while (j<muestreo) {                
                int rand=(int) (Math.random()*100);
                torneo[j]=rand;
                j++;
            }
            
            j=1;
           
            int mejor=torneo[0];
            while(j<muestreo) {
                int aux=torneo[j];
                if(algG.getPoblacion()[mejor].getPuntuacion()<algG.getPoblacion()[aux].getPuntuacion()){
                    mejor=aux;
                }
                j++;
            }
                        
                 
                Individuo n = algG.getPoblacion()[mejor].clon (algG.getPoblacion()[mejor].getCromosoma());
                sel[i]=n;    
                    
                
            }
        copiar(algG.getPoblacion(), sel);
    }
    
}
