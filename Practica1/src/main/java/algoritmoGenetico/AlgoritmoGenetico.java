/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmoGenetico;

import GUI.Graficas;
import algoritmoGenetico.cruces.Cruce;
import algoritmoGenetico.cruces.CruceAritmetico;
import algoritmoGenetico.cruces.CruceBLX;
import algoritmoGenetico.cruces.CruceMonopunto;
import algoritmoGenetico.cruces.CruceSBX;
import algoritmoGenetico.cruces.CruceUniforme;
import algoritmoGenetico.individuos.Individuo;
import algoritmoGenetico.individuos.IndividuoFuncion1;
import algoritmoGenetico.individuos.IndividuoFuncion2;
import algoritmoGenetico.individuos.IndividuoFuncion3;
import algoritmoGenetico.individuos.IndividuoFuncion4;
import algoritmoGenetico.mutaciones.Mutacion;
import algoritmoGenetico.mutaciones.MutacionBasica;
import algoritmoGenetico.mutaciones.MutacionUniforme;
import algoritmoGenetico.seleccion.Seleccion;
import algoritmoGenetico.seleccion.SeleccionRestos;
import algoritmoGenetico.seleccion.SeleccionRuleta;
import algoritmoGenetico.seleccion.SeleccionTorneoDeterministico;
import algoritmoGenetico.seleccion.SeleccionTruncamiento;
import algoritmoGenetico.seleccion.SelecconEstocasticaUniversal;
import algoritmoGenetico.seleccion.SelecionTorneoProbabilistico;
import javax.swing.JPanel;


/**
 *
 * @GRUPO 13
 */
public class AlgoritmoGenetico {
    private int tamPoblacion;
    private Individuo[] poblacion;
    private double[] fitness;
    private int maxGeneraciones;
    private double probCruce;
    private double probMutacion;
    private int tamTorneo;
    private Individuo elMejor;
    private int pos_mejor;
    private int generacionActual;
    double precision;
    private Seleccion sel;
    private Cruce cruce;
    private Mutacion mut;
    private int funcion;
    private int tMut;
    private int tCru;
    private int tSel;
    private JPanel j;
    private double [] mejor;
    private double [] mejorAbsoluto;
    private double [] media;
    private double [] presion;
    private boolean elitismoCheck;
    private double elitismo;
    
    private double aptitud_mAbs = 0; // mejor aptitud
    Graficas g;
    /*public AlgoritmoGenetico(int tamPoblacion, Individuo[] poblacion, double[] fitness, int maxGeneraciones, double probCruce, double probMutacion, int tamTorneo, double precision) {
        this.tamPoblacion = tamPoblacion;
        this.poblacion = poblacion;
        this.fitness = fitness;
        this.maxGeneraciones = maxGeneraciones;
        this.probCruce = probCruce;
        this.probMutacion = probMutacion;
        this.tamTorneo = tamTorneo;
        this.precision = precision;
    }*/


    public AlgoritmoGenetico(int funcion,int tamPoblacion, int maxGeneraciones, double probCruce, double probMutacion, double precision, int seleccion, 
            int cruce, int mutacion, double elitismo, boolean elitismoCheck, Graficas g) {
        
        this.funcion=funcion;
        this.tamPoblacion = tamPoblacion;
        this.maxGeneraciones = maxGeneraciones;
        this.probCruce = probCruce;
        this.probMutacion = probMutacion;
        this.tSel = seleccion;
        this.precision = precision;
        this.tCru=cruce;
        this.tMut=mutacion;
        this.j=j;
        this.mejor=new double[maxGeneraciones];
        this.mejorAbsoluto=new double[maxGeneraciones];
        this.media=new double[maxGeneraciones];
        this.presion=new double[maxGeneraciones];
        this.elitismoCheck=elitismoCheck;
        this.elitismo=elitismo;
        this.g=g;
        switch(mutacion){
            case 0:
                this.mut=new MutacionBasica(this);
                break;
            case 1:
                this.mut=new MutacionUniforme(this);
                 break;

        }
        
        switch(cruce){
            case 0:
                this.cruce=new CruceAritmetico(this);
                break;
            case 1:
                this.cruce=new CruceBLX(this);
                 break;
            case 2:
                this.cruce=new CruceMonopunto(this);
                break;
            case 3:
                this.cruce=new CruceSBX(this);
                 break;
                 
            case 4:
                this.cruce=new CruceUniforme(this);
                 break;
        
        }
         switch(seleccion){
            case 0:
                this.sel=new SelecconEstocasticaUniversal(this);
               
                break;
            case 1:
                this.sel=new SeleccionRestos(this);
                
                 break;
            case 2:
                
                this.sel=new SeleccionRuleta(this);
                break;
            case 3:
                this.sel=new SeleccionTorneoDeterministico(this);
                 break;
            case 4:
                this.sel=new SelecionTorneoProbabilistico(this); 
                 break;     
            case 5:
                
                this.sel=new SeleccionTruncamiento(this);
                 break;
        
        }
        
    }
    
    
    
    
    public void run() {
        iniciarPoblacion();
        evaluar();
        generacionActual++;
        while(this.generacionActual < this.maxGeneraciones) {
            Individuo[] pobElite;
            pobElite=new Individuo[(int)(tamPoblacion*elitismo)/100];
            if (elitismoCheck) {
                pobElite=getElite(elitismo);
            }
            sel.seleccion();
            this.cruce.cruce();
            mut.mutacion();
            if (elitismoCheck) {
                introElite(pobElite);
            }
            evaluar();
            generacionActual++;
            
            
        }
        g.mostrarGrafica(mejorAbsoluto,mejor,media,presion,j);
    }

    private void iniciarPoblacion() {
        this.poblacion = new Individuo[tamPoblacion];
        for (int i = 0; i < tamPoblacion; i++) {
            switch(funcion){
                case 0:
                    this.poblacion[i]=new IndividuoFuncion1(this.precision);
                    break;
                case 1:
                    this.poblacion[i]=new IndividuoFuncion2(this.precision);
                     break;
                case 2:
                    this.poblacion[i]=new IndividuoFuncion3(this.precision);
                     break;
                case 3:
                    this.poblacion[i]=new IndividuoFuncion4(this.precision);
                     break;
            }
            
        }
    }

    private void evaluar() {
        double punt_acu = 0; // puntuación acumulada
        double aptitud_mejor = 0; // mejor aptitud
        double mAbs=0;
        double sumaptitud = 0; // suma de la aptitud
        double sumavalor=0;
        
        if(generacionActual!=0){
            mAbs=mejorAbsoluto[generacionActual-1];
            
        }
        
        for (int i = 0; i < tamPoblacion; i++) {
            double aptitud=poblacion[i].evalua();
            sumaptitud+=aptitud;
            sumavalor+=poblacion[i].getValor();
            if (poblacion[i].getFitness()>aptitud_mejor){
                aptitud_mejor=poblacion[i].getFitness();
                pos_mejor=i;
                mejor[generacionActual]=poblacion[i].getValor();
                if (aptitud_mAbs<poblacion[i].getFitness()){
                    mAbs=poblacion[i].getValor();
                    aptitud_mAbs=poblacion[i].getFitness();
                }
            
            }
            
        }
        media[generacionActual]=sumavalor/tamPoblacion;
        mejor[generacionActual]=poblacion[pos_mejor].getValor();
        mejorAbsoluto[generacionActual]=mAbs;
        presion[generacionActual]=aptitud_mejor / media[generacionActual];
        poblacion[0].setPuntuacion(poblacion[0].getFitness()/sumaptitud);
        poblacion[0].setPuntuacionAc(poblacion[0].getPuntuacion());
        for (int i = 1; i < tamPoblacion; i++) {
            poblacion[i].setPuntuacion(poblacion[i].getFitness()/sumaptitud);
            poblacion[i].setPuntuacionAc(poblacion[i-1].getPuntuacionAc()+poblacion[i].getPuntuacion());
        }
        
    }
  
     public Individuo[] getElite(double elitismo) {
        //quicksort(poblacion, 0, tamPoblacion-1);
        Individuo[] res= new Individuo[(int)(tamPoblacion*elitismo)/100];
        double mAb=0;
        double ultAb=100000;
        int pos=-1;
        
        for (int i = 0; i < res.length; i++) {
            for (int k = 0; k < tamPoblacion; k++) {
                if(poblacion[k].getFitness()>=mAb && pos!=k && poblacion[k].getFitness()<=ultAb){
                    mAb=poblacion[k].getFitness();
                    pos=k;
                }
            }
             res[i]=this.poblacion[pos];
             ultAb=mAb;
        }
 
        return res;
        
    }
    private void introElite(Individuo[] pobElite) {
        //quicksort(poblacion, 0, tamPoblacion-1);
        double mAb=pobElite[0].getFitness();
        
        int pos=-1;
        
        for (int i = 0; i < pobElite.length; i++) {
            for (int k = 0; k < tamPoblacion; k++) {
                if(poblacion[k].getFitness()<=mAb && pos!=k ){
                    mAb=poblacion[k].getFitness();
                    pos=k;
                }
            }
             this.poblacion[pos]=pobElite[i];
             
        }
    }
    //SACADO DE INTERNET
   public static void quicksort(Individuo A[], int izq, int der) {

        Individuo pivote=A[izq].clon(A[izq].getCromosoma()); // tomamos primer elemento como pivote
        int i=izq;         // i realiza la búsqueda de izquierda a derecha
        int j=der;         // j realiza la búsqueda de derecha a izquierda
        Individuo aux;

        while(i < j){                          // mientras no se crucen las búsquedas                                   
           while(A[i].getFitness() <= pivote.getFitness() && i < j) i++; // busca elemento mayor que pivote
           while(A[j].getFitness() > pivote.getFitness()) j--;           // busca elemento menor que pivote
           if (i < j) {                        // si no se han cruzado                      
               aux= A[i].clon(A[i].getCromosoma());                      // los intercambia
               A[i]=A[j].clon(A[j].getCromosoma());
               A[j]=aux;
           }
         }

         A[izq]=A[j];      // se coloca el pivote en su lugar de forma que tendremos                                    
         A[j]=pivote;      // los menores a su izquierda y los mayores a su derecha

         if(izq < j-1)
            quicksort(A,izq,j-1);          // ordenamos subarray izquierdo
         if(j+1 < der)
            quicksort(A,j+1,der);          // ordenamos subarray derecho

  }

    public int getTamPoblacion() {
        return tamPoblacion;
    }

    public Individuo[] getPoblacion() {
        return poblacion;
    }

    public double[] getFitness() {
        return fitness;
    }

    public int getMaxGeneraciones() {
        return maxGeneraciones;
    }

    public double getProbCruce() {
        return probCruce;
    }

    public double getProbMutacion() {
        return probMutacion;
    }

    public int getTamTorneo() {
        return tamTorneo;
    }

    public Individuo getElMejor() {
        return elMejor;
    }

    public int getPos_mejor() {
        return pos_mejor;
    }

    public int getGeneracionActual() {
        return generacionActual;
    }

    public double getPrecision() {
        return precision;
    }

    public Seleccion getSel() {
        return sel;
    }

    public Cruce getCruce() {
        return cruce;
    }

    public Mutacion getMut() {
        return mut;
    }

    public int getFuncion() {
        return funcion;
    }

    public int gettMut() {
        return tMut;
    }

    public void setFitness(double[] fitness) {
        this.fitness = fitness;
    }

    

   

   


    
    

}
