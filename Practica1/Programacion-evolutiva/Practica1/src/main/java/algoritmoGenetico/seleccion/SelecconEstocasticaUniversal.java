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
       
        Individuo[] sel=new Individuo[algG.getTamPoblacion()];
        Double random=Math.random();
        double distancia=random/algG.getTamPoblacion();
        double mark=distancia;
        int pos=0;
        for (int i = 0; i < algG.getPoblacion().length; i++) {
            
            
            while((mark>algG.getPoblacion()[pos].getPuntuacionAc())&&mark<algG.getTamPoblacion()) 
                        pos++;
                 
                Individuo n = algG.getPoblacion()[pos].clon (algG.getPoblacion()[pos].getCromosoma());
                sel[i]=n;    
                mark+=1/(double)algG.getTamPoblacion();
                    
                
            }
            
        
        copiar(algG.getPoblacion(), sel);
    }

    
    
}
