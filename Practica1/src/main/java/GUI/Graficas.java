/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import javax.swing.JPanel;
import org.math.plot.*;
/**
 *
 * @author usuario_local
 */
public class Graficas {
    Plot2DPanel panelMathPlot;
    Graficas(Plot2DPanel panelMathPlot) {
        this.panelMathPlot=panelMathPlot;
    }
     
     public  void mostrarGrafica(double[] mejorAbs, double[] mejor, double[] media, double[] presion, JPanel panel){
         double [] x = new double[mejorAbs.length];
            for(int i = 0; i < x.length; i++) {
                    x[i] = i+1;
            }


            panelMathPlot.addLegend("SOUTH");
            panelMathPlot.addLinePlot("Mejor Absoluto", Color.BLUE, x, mejorAbs);
            panelMathPlot.addLinePlot("Mejor de la Generacion", Color.RED, x, mejor);
            panelMathPlot.addLinePlot("Media Generacion", Color.GREEN, x, media);
            //panelMathPlot.addLinePlot("Presion selectiva", Color.gray, x, presion);
           
     }
    
    
    
    
    
}
