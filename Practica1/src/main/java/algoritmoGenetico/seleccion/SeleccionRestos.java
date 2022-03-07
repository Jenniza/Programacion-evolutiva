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
public class SeleccionRestos extends Seleccion{

    public SeleccionRestos(AlgoritmoGenetico aThis) {
        super(aThis);
    }

  

    @Override
    public void seleccion() {
       
        ArrayList<Individuo> restos=new ArrayList<>();
        Individuo[] sel=new Individuo[algG.getTamPoblacion()];
        int pos=0;
        for (int i = 0; i < algG.getTamPoblacion(); i++) {
            double copias=algG.getPoblacion()[i].getPuntuacion()*algG.getTamPoblacion();
            for (int j = 1; j <= copias; j++) {
                sel[pos]=algG.getPoblacion()[i].clon(algG.getPoblacion()[i].getCromosoma());
                pos++;
            }
        }
        for (int i = pos; i < algG.getPoblacion().length; i++) {
            double rand=Math.random();
            int lug=0;
            while((rand>algG.getPoblacion()[lug].getPuntuacionAc())&&lug<algG.getTamPoblacion()) 
                        lug++;
                 
                Individuo n = algG.getPoblacion()[lug].clon (algG.getPoblacion()[lug].getCromosoma());
                sel[i]=n;    
                    
                
            }
        copiar(algG.getPoblacion(), sel);
    }
    
}
