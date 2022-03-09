
package algoritmoGenetico.individuos;

/**
 *
 * @author wulso
 */
public class IndividuoFuncionExtra1 extends Individuo<Boolean>{

    public IndividuoFuncionExtra1(double v, int n) {
        super(v, n);
        this.tamGenes = new int[2];
        this.min = new double[2];
        this.max = new double[2];
        this.fenotipo = new double[2];
        this.min[0] = -5;
        this.min[1] = 0;
        this.max[0] = 10;
        this.max[1] = 15;
        this.tamGenes[0] = this.tamGen(this.valorError, min[0], max[0]);
        this.tamGenes[1] = this.tamGen(this.valorError, min[1], max[1]);
        int tamTotal = tamGenes[0] + tamGenes[1];
        this.cromosoma = new Boolean[tamTotal];
        for(int i = 0; i < tamTotal; i++) this.cromosoma[i] = this.rand.nextBoolean();
        this.fenotipo[0]=getFenotipo(0);
        this.fenotipo[1]=getFenotipo(1);
        
        
    }

    @Override
    public double getValor() {
        double pi=Math.PI;
        double a=1;
        double b=5.1/(4*Math.pow(pi, 2));
        double c=5/pi;
        double r=6;
        double s= 10;
        double t=1/(8*pi);
        double x1 = getFenotipo(0), x2 =getFenotipo(1);
        this.fenotipo[0]=x1;
        this.fenotipo[1]=x2;
        
        double term1=a * Math.pow((x2 - (b*Math.pow(x1, 2)) + (c*x1) - r), 2);
        double term2=s*(1-t)*Math.cos(x1);
        return term1+term2+s;
    }

    @Override
    public double evalua() {
        fitness=200-getValor();
        return fitness;
    }

    public Individuo clon(Boolean [] b) {
        IndividuoFuncionExtra1 clon= new IndividuoFuncionExtra1(this.getValorError(),fenotipo.length);
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
        return ("Valor mínimo en: "+Math.round(getValor()/valorError)*valorError+" x1: "+Math.round(getFenotipo(0)/valorError)*valorError+" x2: "+Math.round(getFenotipo(1)/valorError)*valorError);
    }
    
    
}
