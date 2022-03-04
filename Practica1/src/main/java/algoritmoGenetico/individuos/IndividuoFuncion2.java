/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmoGenetico.individuos;

/**
 *
 * @author usuario_local
 */
public class IndividuoFuncion2 extends Individuo<Boolean> {
    //Schubert
    public IndividuoFuncion2(double v) {
        super(v);
        this.tamGenes = new int[2];
        this.min = new double[2];
        this.max = new double[2];
        this.fenotipo = new double[2];
        this.min[0] = -10.0;
        this.min[1] = -10.0;
        this.max[0] = 10.0;
        this.max[1] = 10.0;
        this.tamGenes[0] = this.tamGen(this.valorError, min[0], max[0]);
        this.tamGenes[1] = this.tamGen(this.valorError, min[1], max[1]);
        int tamTotal = tamGenes[0] + tamGenes[1];
        this.cromosoma = new Boolean[tamTotal];
    }

    public double getValor() {
        double valor=0;
        double x1 = this.getFenotipo(0), x2 = this.getFenotipo(1);
        double sum1 =0, sum2=0;
        for(int i=1;i<6;i++ ){
            sum1+=i*Math.cos((i+1)*x1+i);
        }
        for(int i=1;i<6;i++ ){
            sum2+=i*Math.cos((i+1)*x2+i);
        }
        valor=sum1+sum2;
        return valor;
    }

    
}
