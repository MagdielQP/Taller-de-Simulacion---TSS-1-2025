package proyecto3.tss.GUI;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.apache.commons.math3.distribution.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
//import proyecto1.tss.GUI.VentanaSimulacion.PanelSimulacion;
//import proyecto1.tss.GUI.VentanaSimulacion.PiezaVisual;


public class VentanaPrincipal extends javax.swing.JFrame {
    
   
    public VentanaPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ventanaPrincipal = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        horasSimulacion = new javax.swing.JTextField();
        txtProbSalaEspera = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtSalaEsperaCapacidad = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtServidorLimiteRetiro = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        nroReplicas = new javax.swing.JTextField();
        btnSimular = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtServdoresUnidades = new javax.swing.JTextField();
        jPanelSimulacion = new javax.swing.JPanel();
        nroMaquinas = new javax.swing.JLabel();
        txtTiempoLlegada = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtFormasTiempoUnifMedia = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtServidorRetiroMediaExp = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        txtServidorAtencionMediaExp = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtProbFormas = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtFormasTiempoUnifDiferencia = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ventanaPrincipal.setPreferredSize(new java.awt.Dimension(1074, 2584));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setText("Proyecto 3 - Taller de Simulacion");

        jLabel3.setText("TIEMPO LLEGADA DE CLIENTES");

        jLabel5.setText("SALA DE ESPERA");

        jLabel6.setText("TIMEPO LLENADO DE FORMAS");

        jLabel9.setText("horas de simulacion:");

        horasSimulacion.setText("8");
        horasSimulacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                horasSimulacionActionPerformed(evt);
            }
        });

        txtProbSalaEspera.setText("90");

        jLabel17.setText("Capacidad");

        txtSalaEsperaCapacidad.setText("40");
        txtSalaEsperaCapacidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSalaEsperaCapacidadActionPerformed(evt);
            }
        });

        jLabel20.setText("Limite para retiro");

        txtServidorLimiteRetiro.setText("10");
        txtServidorLimiteRetiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtServidorLimiteRetiroActionPerformed(evt);
            }
        });

        jLabel26.setText("Nro de Replicas:");

        nroReplicas.setText("1");
        nroReplicas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nroReplicasActionPerformed(evt);
            }
        });

        btnSimular.setText("SIMULAR");
        btnSimular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimularActionPerformed(evt);
            }
        });

        jLabel27.setText("Prob. Sala Espera");

        jLabel12.setText("SERVIDORES");

        jLabel15.setText("Unidades");

        txtServdoresUnidades.setText("2");
        txtServdoresUnidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtServdoresUnidadesActionPerformed(evt);
            }
        });

        jPanelSimulacion.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout jPanelSimulacionLayout = new javax.swing.GroupLayout(jPanelSimulacion);
        jPanelSimulacion.setLayout(jPanelSimulacionLayout);
        jPanelSimulacionLayout.setHorizontalGroup(
            jPanelSimulacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1039, Short.MAX_VALUE)
        );
        jPanelSimulacionLayout.setVerticalGroup(
            jPanelSimulacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 662, Short.MAX_VALUE)
        );

        nroMaquinas.setText("Media de Poisson");

        txtTiempoLlegada.setText("18");
        txtTiempoLlegada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTiempoLlegadaActionPerformed(evt);
            }
        });

        jLabel22.setText("T.Uniforme Media");

        txtFormasTiempoUnifMedia.setText("6");
        txtFormasTiempoUnifMedia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFormasTiempoUnifMediaActionPerformed(evt);
            }
        });

        jLabel24.setText("T. retiro - Media Exp");

        txtServidorRetiroMediaExp.setText("5");
        txtServidorRetiroMediaExp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtServidorRetiroMediaExpActionPerformed(evt);
            }
        });

        jLabel52.setText("T. atencion - Media Exp");

        txtServidorAtencionMediaExp.setText("6");

        jLabel30.setText("Prob. Llenar Formas");

        txtProbFormas.setText("10");
        txtProbFormas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProbFormasActionPerformed(evt);
            }
        });

        jLabel16.setText("Clientes/hora");

        jLabel18.setText("%");

        jLabel25.setText("%");

        jLabel23.setText("T.Uniforme Diferencia");

        txtFormasTiempoUnifDiferencia.setText("2");
        txtFormasTiempoUnifDiferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFormasTiempoUnifDiferenciaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ventanaPrincipalLayout = new javax.swing.GroupLayout(ventanaPrincipal);
        ventanaPrincipal.setLayout(ventanaPrincipalLayout);
        ventanaPrincipalLayout.setHorizontalGroup(
            ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                        .addGap(365, 365, 365)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel1))
                    .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jPanelSimulacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 21, Short.MAX_VALUE))
            .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSalaEsperaCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                                .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel27)
                                    .addComponent(nroMaquinas))
                                .addGap(25, 25, 25)
                                .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtProbSalaEspera, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTiempoLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel16)))
                            .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                                .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel30))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtProbFormas, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel25))))
                    .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel3)))
                .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventanaPrincipalLayout.createSequentialGroup()
                        .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel12)
                                .addGap(256, 256, 256)
                                .addComponent(btnSimular, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                                        .addComponent(jLabel23)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtFormasTiempoUnifDiferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                                        .addComponent(jLabel22)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtFormasTiempoUnifMedia, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventanaPrincipalLayout.createSequentialGroup()
                                        .addComponent(jLabel26)
                                        .addGap(27, 27, 27)
                                        .addComponent(nroReplicas, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventanaPrincipalLayout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(horasSimulacion, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(142, 142, 142))
                    .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                        .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jLabel20))
                            .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel52)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel24))
                                .addGap(18, 18, 18)
                                .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtServdoresUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtServidorAtencionMediaExp, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtServidorLimiteRetiro, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtServidorRetiroMediaExp, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        ventanaPrincipalLayout.setVerticalGroup(
            ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                        .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel1))
                            .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventanaPrincipalLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                                        .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(txtTiempoLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(nroMaquinas)))
                                        .addGap(18, 18, 18)
                                        .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel27)
                                            .addComponent(txtProbSalaEspera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel18))
                                        .addGap(18, 18, 18)
                                        .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel30)
                                            .addComponent(txtProbFormas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel25))
                                        .addGap(41, 41, 41)
                                        .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel17)
                                            .addComponent(txtSalaEsperaCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel15)
                                        .addComponent(txtServdoresUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel26)
                                    .addComponent(nroReplicas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(16, 16, 16)
                                .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(horasSimulacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(56, 56, 56)
                                .addComponent(btnSimular, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 43, Short.MAX_VALUE))))
                    .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(txtFormasTiempoUnifMedia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(txtFormasTiempoUnifDiferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel52)
                        .addGap(22, 22, 22)
                        .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(txtServidorLimiteRetiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtServidorAtencionMediaExp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtServidorRetiroMediaExp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 199, Short.MAX_VALUE)
                .addComponent(jPanelSimulacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1281, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(ventanaPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1086, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1300, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void horasSimulacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_horasSimulacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_horasSimulacionActionPerformed

    private void txtSalaEsperaCapacidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSalaEsperaCapacidadActionPerformed
        // TODO add your handling code here:
        //aqui
    }//GEN-LAST:event_txtSalaEsperaCapacidadActionPerformed

    private void txtServidorLimiteRetiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtServidorLimiteRetiroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtServidorLimiteRetiroActionPerformed

    private void nroReplicasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nroReplicasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nroReplicasActionPerformed

    private void btnSimularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimularActionPerformed
        ParametrosSimulacion params = new ParametrosSimulacion();
        
        params.llegadaTiempoMediaPoisson = Integer.parseInt(txtTiempoLlegada.getText());
        params.probSalaEspera = Integer.parseInt(txtProbSalaEspera.getText());
        params.probLlenadoForma = Integer.parseInt(txtTiempoLlegada.getText());
        
        params.formasTiempoUniformeMedia = Integer.parseInt(txtFormasTiempoUnifMedia.getText());
        params.formasTiempoUniformeDiferencia = Integer.parseInt(txtFormasTiempoUnifDiferencia.getText());
        
        params.salaEsperaCapacidad = Integer.parseInt(txtSalaEsperaCapacidad.getText());
        
        params.servidoresUnidades = Integer.parseInt(txtServdoresUnidades.getText());
        params.servidoresTiempoExpMedia = Integer.parseInt(txtServidorAtencionMediaExp.getText());
        params.servidoresLimiteRetiro = Integer.parseInt(txtServidorLimiteRetiro.getText());
        params.servidoresRetiroTiempoExpMedia = Integer.parseInt(txtServidorRetiroMediaExp.getText());

        params.nroReplicas = Integer.parseInt(nroReplicas.getText());
        params.horasSimulacion = Integer.parseInt(horasSimulacion.getText());
        

        VentanaSimulacion sim = new VentanaSimulacion(params);
        sim.setVisible(true);
        
    }//GEN-LAST:event_btnSimularActionPerformed

    private void txtServdoresUnidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtServdoresUnidadesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtServdoresUnidadesActionPerformed

    private void txtFormasTiempoUnifMediaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFormasTiempoUnifMediaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFormasTiempoUnifMediaActionPerformed

    private void txtServidorRetiroMediaExpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtServidorRetiroMediaExpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtServidorRetiroMediaExpActionPerformed

    private void txtTiempoLlegadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTiempoLlegadaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTiempoLlegadaActionPerformed

    private void txtFormasTiempoUnifDiferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFormasTiempoUnifDiferenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFormasTiempoUnifDiferenciaActionPerformed

    private void txtProbFormasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProbFormasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProbFormasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSimular;
    private javax.swing.JTextField horasSimulacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanelSimulacion;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nroMaquinas;
    private javax.swing.JTextField nroReplicas;
    private javax.swing.JTextField txtFormasTiempoUnifDiferencia;
    private javax.swing.JTextField txtFormasTiempoUnifMedia;
    private javax.swing.JTextField txtProbFormas;
    private javax.swing.JTextField txtProbSalaEspera;
    private javax.swing.JTextField txtSalaEsperaCapacidad;
    private javax.swing.JTextField txtServdoresUnidades;
    private javax.swing.JTextField txtServidorAtencionMediaExp;
    private javax.swing.JTextField txtServidorLimiteRetiro;
    private javax.swing.JTextField txtServidorRetiroMediaExp;
    private javax.swing.JTextField txtTiempoLlegada;
    private javax.swing.JPanel ventanaPrincipal;
    // End of variables declaration//GEN-END:variables
}

