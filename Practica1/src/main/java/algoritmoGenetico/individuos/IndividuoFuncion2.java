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
    public IndividuoFuncion2(double v,int n) {
        super(v,n);
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
        for(int i = 0; i < tamTotal; i++) this.cromosoma[i] = this.rand.nextBoolean();
        this.fenotipo[0]=getFenotipo(0);
        this.fenotipo[1]=getFenotipo(1);
        System.out.println("x: "+getFenotipo(0));
        System.out.println("y: "+getFenotipo(1));
        
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
        valor=sum1*sum2;
        return valor;
    }

    public double evalua() {
        //falta por hacer
        fitness=200-(getValor());
        return fitness;
    }

    @Override
    public Individuo clon(Boolean [] b) {
        IndividuoFuncion2 clon= new IndividuoFuncion2(this.getValorError(),0);
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
