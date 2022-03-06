/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmoGenetico.mutaciones;

import algoritmoGenetico.AlgoritmoGenetico;

/**
 *
 * @author usuario_local
 */
public abstract class Mutacion {
  
    AlgoritmoGenetico algG;
    double probMuta;

    public Mutacion( AlgoritmoGenetico algG) {
        
        this.algG = algG;
        this.probMuta=algG.getProbMutacion()/100;
    }
    
    public abstract void mutacion();
}
