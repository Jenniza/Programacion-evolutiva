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
public abstract class Seleccion {
    AlgoritmoGenetico algG;
    
    
    public Seleccion(AlgoritmoGenetico algG){
        this.algG=algG;
    
    }
    public abstract void seleccion();
    public void copiar(Individuo[] previo, Individuo[] sel){
        for (int i = 0; i < previo.length; i++) {
            previo[i]=sel[i];
        }
    
    
    }
}
