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
public class IndividuoFuncion3 extends Individuo<Boolean> {
    //EggHolder
    public IndividuoFuncion3(double v,int n) {
        super(v,n);
        this.tamGenes = new int[2];
        this.min = new double[2];
        this.max = new double[2];
        this.fenotipo = new double[2];
        this.min[0] = -512;
        this.min[1] = -512;
        this.max[0] = 512;
        this.max[1] = 512;
        this.tamGenes[0] = this.tamGen(this.valorError, min[0], max[0]);
        this.tamGenes[1] = this.tamGen(this.valorError, min[1], max[1]);
        int tamTotal = tamGenes[0] + tamGenes[1];
        this.cromosoma = new Boolean[tamTotal];
        for(int i = 0; i < tamTotal; i++) this.cromosoma[i] = this.rand.nextBoolean();
        this.fenotipo[0]=getFenotipo(0);
        this.fenotipo[1]=getFenotipo(1);
    }

   public double getValor() {
       double x1 = this.getFenotipo(0), x2 = this.getFenotipo(1);
       return (-(x2 + 47)* Math.sin(Math.sqrt(Math.abs(x2 + (x1 / 2) + 47))) 
               - x1 * Math.sin(Math.sqrt(Math.abs(x1 - (x2 + 47)))));
   
   }

   public double evalua() {
        //falta por hacer
        fitness=1000-getValor();
        return fitness;
    }

    @Override
    public Individuo clon(Boolean [] b) {
        IndividuoFuncion3 clon= new IndividuoFuncion3(this.getValorError(),0);
        for (int i = 0; i < cromosoma.length; i++) {
            clon.setCromosoma(i,new Boolean(b[i]));
        }
        clon.evalua();
        return clon;
    }

    @Override
    public double getFenotipo(int num) {
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

    @Override
    public String toString() {
        return ("Valor mínimo en: "+getValor()+" x1: "+getFenotipo(0)+" x2: "+getFenotipo(1));
    }
    
}
