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
public class SeleccionTruncamiento extends Seleccion{

    public SeleccionTruncamiento(AlgoritmoGenetico aThis) {
        super(aThis);
    }

    @Override
    public void seleccion() {
        double trunc=50;
        double elec=algG.getTamPoblacion()*trunc/100;
        Individuo[] sel=new Individuo[algG.getTamPoblacion()];
        Individuo[] aux=algG.getElite(elec);
        int vuelta=(int) (algG.getTamPoblacion()/elec);
        int i=0;
        while (i < algG.getPoblacion().length) {
            for (int j = 0; j < aux.length && i < algG.getPoblacion().length; j++) {
                sel[i]=aux[j].clon(aux[j].getCromosoma());
                i++;
            }
            
          
                    
                
            }
            
        
        copiar(algG.getPoblacion(), sel);
    }

    
}
