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
        double prob=15;
        
        ArrayList<Individuo> restos=new ArrayList<>();
        Individuo[] sel=new Individuo[algG.getTamPoblacion()];
        
        for (int i = 0; i < 10; i++) {
            double rand = Math.random()*100;
            if(prob<=rand){}
        }
    }
    
}
