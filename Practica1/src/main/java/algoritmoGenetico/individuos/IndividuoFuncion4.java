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
public class IndividuoFuncion4 extends Individuo<Boolean>{

    //Michalewicz
    public IndividuoFuncion4(double v,int n) {
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
       
      
        this.cromosoma = new Boolean[tamTotal];
        for(int i = 0; i < tamTotal; i++) this.cromosoma[i] = this.rand.nextBoolean();
        
        
    }

    @Override
    public double getValor() {
       double valor=0;
       for(int i = 0; i < fenotipo.length;i++) {
            valor += -(Math.sin(getFenotipo(i)) *Math.pow((Math.sin(((i+2)*Math.pow(getFenotipo(i),2))/Math.PI)),20));
       }
        
        return valor;
    }

    @Override
    public double evalua() {
        fitness=1+n-getValor();
        return fitness;
    }

    @Override
    public Individuo clon(Boolean [] b) {
        IndividuoFuncion4 clon= new IndividuoFuncion4(this.getValorError(),fenotipo.length);
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
        String res="Valor mínimo en: "+Math.round(getValor()/valorError)*valorError;
        for (int i = 0; i < min.length; i++) {
            res=res+" x"+(i+1)+": "+Math.round(getFenotipo(i)/valorError)*valorError;
        }
        return res;
       
    }
    
}
