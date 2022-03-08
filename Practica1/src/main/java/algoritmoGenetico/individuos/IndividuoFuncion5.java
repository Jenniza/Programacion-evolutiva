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
    //Michalewicz
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
        double valor=0;
       for(int i = 0; i < fenotipo.length;i++) {
			valor += Math.sin(getFenotipo(i)) *Math.pow((Math.sin(((i+1)*Math.pow(getFenotipo(i),2))/Math.PI)),20);
       }
        
        return valor;
    }

    @Override
    public double evalua() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Individuo clon(Double[] b) {
        IndividuoFuncion5 clon= new IndividuoFuncion5(this.getValorError(),0);
        clon.setCromosoma(b);
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
            if(cromosoma[j+pos]>1){
                aux=1;
            }

            res+=aux*Math.pow(2, p);
            p++;

        }

        return min[num]+res*((max[num]-min[num]))/(Math.pow(2, tamGenes[num])-1);
    }
    
}
