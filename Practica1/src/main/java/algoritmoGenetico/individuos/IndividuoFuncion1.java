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
import java.util.*;

public class IndividuoFuncion1 extends Individuo<Boolean> {
    
    
    
    
    public IndividuoFuncion1(double vError,int n) {
       super(vError,n);
        this.tamGenes = new int[2];
        this.min = new double[2];
        this.max = new double[2];
        this.fenotipo = new double[2];
        this.min[0] = -3.000;
        this.min[1] = 4.100;
        this.max[0] = 12.100;
        this.max[1] = 5.800;
        this.tamGenes[0] = this.tamGen(this.valorError, min[0], max[0]);
        this.tamGenes[1] = this.tamGen(this.valorError, min[1], max[1]);
        int tamTotal = tamGenes[0] + tamGenes[1];
        this.cromosoma = new Boolean[tamTotal];
        for(int i = 0; i < tamTotal; i++) this.cromosoma[i] = this.rand.nextBoolean();
        this.fenotipo[0]=getFenotipo(0);
        this.fenotipo[1]=getFenotipo(1);
        System.out.println("x: "+getFenotipo(0));
         System.out.println("y: "+getFenotipo(1));
    }
    
    
    
    
    
    public double getValor() {
        double x1 = this.getFenotipo(0), x2 = this.getFenotipo(1);
        return (21.5 + x1 * Math.sin(4 * Math.PI * x1) + x2 * Math.sin(20 * Math.PI * x2));
}

    public double evalua() {
       fitness=getValor();
        return fitness;
    }

    @Override
    public Individuo clon(Boolean [] b) {
        IndividuoFuncion1 clon= new IndividuoFuncion1(this.getValorError(),0);
        clon.setCromosoma(b);
        clon.evalua();
        return clon;
    }

    @Override
    public double getFenotipo(int num){
       double res=0;
       int pos=0;
       int p=0;
       //ArrayList<T> alelo= new ArrayList();
       for (int i = 0; i < num; i++) {
           pos+=tamGenes[i];
       }
       for (int j = 0; j < tamGenes[num]; j++) {
           //alelo.add(cromosoma[j]);
           double aux=0;
           if(cromosoma[j+pos]){
               aux=1;
           }
          
           res+=aux*Math.pow(2, p);
           p++;
                   
       }
       
       return min[num]+res*((max[num]-min[num]))/(Math.pow(2, tamGenes[num])-1);
   }

}
