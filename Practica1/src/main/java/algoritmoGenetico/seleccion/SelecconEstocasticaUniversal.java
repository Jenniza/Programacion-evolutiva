/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmoGenetico.seleccion;

import algoritmoGenetico.AlgoritmoGenetico;
import algoritmoGenetico.individuos.Individuo;
import java.util.Random;

/**
 *
 * @author usuario_local
 */
public class SelecconEstocasticaUniversal extends Seleccion{

    public SelecconEstocasticaUniversal(AlgoritmoGenetico aThis) {
       super(aThis);
    }

    @Override
    public void seleccion() {
        Individuo[] aux=new Individuo[algG.getTamPoblacion()];
        for (int i = 0; i < algG.getTamPoblacion(); i++) {
            aux[i]=algG.getPoblacion()[i].clon(algG.getPoblacion()[i].getCromosoma());
        }
        algG.quicksort(aux, 0, algG.getTamPoblacion()-1);
        Individuo[] sel=new Individuo[algG.getTamPoblacion()];
        double distancia=1/(double)algG.getTamPoblacion();
        Random rand=new Random();
        double mark=rand.nextDouble(distancia);
        
        for (int i = 0; i < algG.getPoblacion().length; i++) {
            double inf=i/algG.getTamPoblacion();
            double max=(i+1)/algG.getTamPoblacion();
            for (int j = 0; j < algG.getTamPoblacion(); j++) {
                if(aux[i].getPuntuacionAc()>=inf && aux[i].getPuntuacionAc()<=max ){
                    sel[i]=aux[j];
                    j=algG.getTamPoblacion();
                }
            }
            
                
            }
            
        
        copiar(algG.getPoblacion(), sel);
    }

    
    
}
