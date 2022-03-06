/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import algoritmoGenetico.AlgoritmoGenetico;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import org.math.plot.Plot2DPanel;

/**
 *
 * @author wulso
 */
public class PanelPrincipal extends javax.swing.JFrame {
    private Plot2DPanel panelMathPlot;
    private boolean elitism=false;
    /**
     * Creates new form PanelPrincipal
     */
    public PanelPrincipal() {
        initComponents();
        panelMathPlot = new Plot2DPanel();
        panelMathPlot.setBounds(350, 100, 600, 450);
        this.add(panelMathPlot);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        funcion = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tamPob = new javax.swing.JTextField();
        nGen = new javax.swing.JTextField();
        pCruce = new javax.swing.JTextField();
        pMutas = new javax.swing.JTextField();
        precision = new javax.swing.JTextField();
        seleccion = new javax.swing.JComboBox<>();
        cruce = new javax.swing.JComboBox<>();
        mutacion = new javax.swing.JComboBox<>();
        elitismo = new javax.swing.JTextField();
        ejecutar = new javax.swing.JButton();
        elitismoCheck = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Practica 1");

        funcion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Función 1", "Función 2", "Función 3", "Función 4" }));
        funcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                funcionActionPerformed(evt);
            }
        });

        jLabel2.setText("Tamaño de la población");

        jLabel3.setText("Número de generaciones");

        jLabel4.setText("Porcentaje de cruces");

        jLabel5.setText("Porcentaje de mutaciones");

        jLabel6.setText("Precisión");

        jLabel7.setText("Selección");

        jLabel8.setText("Cruce");

        jLabel9.setText("Mutación");

        tamPob.setText("100");

        nGen.setText("100");

        pCruce.setText("60");

        pMutas.setText("5");

        precision.setText("0.001");

        seleccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Estocastica", "Restos", "Ruleta", "T. Deterministico", "T. Probabilistico", "Truncamiento" }));

        cruce.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aritmetico", "BLX", "Monopunto", "SBX", "Uniforme" }));

        mutacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Basica", "Uniforme" }));

        elitismo.setText("2");
        elitismo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elitismoActionPerformed(evt);
            }
        });

        ejecutar.setText("Empezar");
        ejecutar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ejecutarMouseClicked(evt);
            }
        });

        elitismoCheck.setText("Elitismo");
        elitismoCheck.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                elitismoCheckStateChanged(evt);
            }
        });
        elitismoCheck.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                elitismoCheckMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(403, 403, 403)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel1))
                            .addComponent(funcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(ejecutar))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(elitismoCheck))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mutacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cruce, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(seleccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(precision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pMutas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pCruce, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nGen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tamPob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(elitismo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(557, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(funcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tamPob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nGen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(pCruce, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(pMutas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(precision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(seleccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cruce, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(mutacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(elitismo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(elitismoCheck))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 338, Short.MAX_VALUE)
                .addComponent(ejecutar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ejecutarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ejecutarMouseClicked
       
       AlgoritmoGenetico alG= new AlgoritmoGenetico(getFuncion(),getTamPob(),getnGen(),
               getpCruce(),getpMutas(),getPrecision(),getSeleccion(),getCruce(),getMutacion(),getElitismo(),elitism ,new Graficas(panelMathPlot));
       
        alG.run();
        
    }//GEN-LAST:event_ejecutarMouseClicked

    private void funcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_funcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_funcionActionPerformed

    private void elitismoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elitismoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_elitismoActionPerformed

    private void elitismoCheckMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_elitismoCheckMouseClicked
        //elitism=!elitism;
    }//GEN-LAST:event_elitismoCheckMouseClicked

    private void elitismoCheckStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_elitismoCheckStateChanged
        elitism=!elitism;
    }//GEN-LAST:event_elitismoCheckStateChanged

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cruce;
    private javax.swing.JButton ejecutar;
    private javax.swing.JTextField elitismo;
    private javax.swing.JCheckBox elitismoCheck;
    private javax.swing.JComboBox<String> funcion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JComboBox<String> mutacion;
    private javax.swing.JTextField nGen;
    private javax.swing.JTextField pCruce;
    private javax.swing.JTextField pMutas;
    private javax.swing.JTextField precision;
    private javax.swing.JComboBox<String> seleccion;
    private javax.swing.JTextField tamPob;
    // End of variables declaration//GEN-END:variables

    public int getCruce() {
        return cruce.getSelectedIndex();
    }

    public int getElitismo() {
        return  Integer.parseInt(elitismo.getText());
    }

    public int getFuncion() {
        return funcion.getSelectedIndex();
    }

    public int getMutacion() {
        return mutacion.getSelectedIndex();
    }

    public int getnGen() {
        return Integer.parseInt(nGen.getText());
    }

    public double getpCruce() {
        return Double.parseDouble(pCruce.getText());
    }

    public double getpMutas() {
        return Double.parseDouble(pMutas.getText());
    }

    public double getPrecision() {
        return Double.parseDouble(precision.getText());
    }

    public int getSeleccion() {
        return seleccion.getSelectedIndex();
    }

    public int getTamPob() {
        return Integer.parseInt(tamPob.getText());
    }
}