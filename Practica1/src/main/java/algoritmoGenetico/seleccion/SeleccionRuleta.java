/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmoGenetico.seleccion;

import algoritmoGenetico.AlgoritmoGenetico;
import algoritmoGenetico.individuos.Individuo;
import java.util.ArrayList;

/**
 *
 * @author usuario_local
 */
public class SeleccionRuleta extends Seleccion{

    public SeleccionRuleta(AlgoritmoGenetico algG) {
       super(algG);
    }


    @Override
    public void seleccion() {
        Individuo[] sel=new Individuo[algG.getTamPoblacion()];
        
        for (int i = 0; i < algG.getPoblacion().length; i++) {
            double rand=Math.random();
            int pos=0;
            while((rand>algG.getPoblacion()[pos].getPuntuacionAc())&&pos<algG.getTamPoblacion()) 
                        pos++;
                 
                Individuo n = algG.getPoblacion()[pos].clon (algG.getPoblacion()[pos].getCromosoma());
                sel[i]=n;    
                    
                
            }
            
        
        copiar(algG.getPoblacion(), sel);
    }
    
}
