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
public class IndividuoFuncion5 extends Individuo<Double>{

    public IndividuoFuncion5(double v,int n) {
        super(v,n);
        this.tamGenes = new int[n];
        this.min = new double[n];
        this.max = new double[n];
        this.fenotipo = new double[n];
        int tamTotal =0;
        for (int i = 0; i < n; i++) {
            this.min[i] = 0;
            this.max[i] = Math.PI;
            this.tamGenes[i] = this.tamGen(this.valorError, min[i], max[i]);
            tamTotal+=tamGenes[i];
        }
       
      
        this.cromosoma = new Double[tamTotal];
        for(int i = 0; i < tamTotal; i++) this.cromosoma[i] = this.rand.nextDouble(0, Math.PI);
        for (int i = 0; i < n; i++) {
            System.out.println("x"+n+getFenotipo(i));
        }
    }

    @Override
    public double getValor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double evalua() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Individuo clon(Double[] crom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getFenotipo(int num) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
