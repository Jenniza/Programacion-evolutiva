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
public class IndividuoFuncionExtra2 extends Individuo<Double>{
    //Michalewicz
    public IndividuoFuncionExtra2(double v,int n) {
        super(v,n);
        this.tamGenes = new int[n];
        this.min = new double[n];
        this.max = new double[n];
        this.fenotipo = new double[n];
        int tamTotal =0;
        for (int i = 0; i < n; i++) {
            this.min[i] = -5.12;
            this.max[i] = 5.12;
            this.tamGenes[i] = 1;
            tamTotal+=tamGenes[i];
        }
       
      
        this.cromosoma = new Double[tamTotal];
        for(int i = 0; i < tamTotal; i++) this.cromosoma[i] = this.rand.nextDouble(0, Math.PI);
        
    }

    @Override
    public double getValor() {
        double valor=0;
        for(int i = 0; i < fenotipo.length;i++) {
            valor += (Math.pow(getFenotipo(i),2));
       }
        
        return valor;
    }

    @Override
    public double evalua() {
       fitness=getValor();
        return fitness;
    }

    @Override
    public Individuo clon(Double[] b) {
        IndividuoFuncionExtra2 clon= new IndividuoFuncionExtra2(this.getValorError(),fenotipo.length);
        for (int i = 0; i < cromosoma.length; i++) {
            clon.setCromosoma(i,new Double(b[i]));
        }
        clon.evalua();
        return clon;
    }

    @Override
    public double getFenotipo(int num) {
       

        return cromosoma[num];
    }

    @Override
    public String toString() {
        String res="Valor mínimo en: "+Math.round(getValor()/valorError)*valorError;
        for (int i = 0; i < min.length; i++) {
            res=res+" x"+(i+1)+": "+Math.round(getFenotipo(i)/valorError)*valorError;
        }
        return res;

    }
    
}
