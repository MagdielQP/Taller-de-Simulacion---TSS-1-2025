package proyecto2.tss.GUI;

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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        horasSimulacion = new javax.swing.JTextField();
        txtFabricaDistSiguiente = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtMantenimientoCapacidad = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtNroMecanicos = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtReservasCapacidad = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtMontacargasVelVacio = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        nroReplicas = new javax.swing.JTextField();
        btnSimular = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtMantenDistSiguiente = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        txtReparacionDistSiguiente = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtMontacargasUnidades = new javax.swing.JTextField();
        jPanelSimulacion = new javax.swing.JPanel();
        nroMaquinas = new javax.swing.JLabel();
        txtNroMaquinas = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        txtTiempoOperacion = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtTiempoReparacion = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtReservasInventarioIni = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txtReservasDistSiguiente = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtMontacargasVelLleno = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        txtMontacargasTiempos = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ventanaPrincipal.setPreferredSize(new java.awt.Dimension(1074, 2584));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setText("Proyecto 2 - Taller de Simulacion");

        jLabel3.setText("FABRICA DE HILOPOLIESTER");

        jLabel4.setText("MANTENIMIENTO");

        jLabel5.setText("ALMACEN RESERVAS");

        jLabel6.setText("REPARACIONES");

        jLabel9.setText("horas de simulacion:");

        jLabel10.setText("DISTANCIA DE TRASLADO");

        horasSimulacion.setText("100");
        horasSimulacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                horasSimulacionActionPerformed(evt);
            }
        });

        txtFabricaDistSiguiente.setText("55");

        jLabel11.setText("Capacidad");

        txtMantenimientoCapacidad.setText("100");
        txtMantenimientoCapacidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMantenimientoCapacidadActionPerformed(evt);
            }
        });

        jLabel14.setText("Mecanicos");

        txtNroMecanicos.setText("5");
        txtNroMecanicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNroMecanicosActionPerformed(evt);
            }
        });

        jLabel17.setText("Capacidad");

        txtReservasCapacidad.setText("3");
        txtReservasCapacidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtReservasCapacidadActionPerformed(evt);
            }
        });

        jLabel20.setText("Vel. Vacio en Mt/min");

        txtMontacargasVelVacio.setText("150");
        txtMontacargasVelVacio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMontacargasVelVacioActionPerformed(evt);
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

        jLabel27.setText("En metros");

        jLabel28.setText("En metros");

        txtMantenDistSiguiente.setText("5");
        txtMantenDistSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMantenDistSiguienteActionPerformed(evt);
            }
        });

        jLabel33.setText("En metros");

        txtReparacionDistSiguiente.setText("40");

        jLabel12.setText("MONTACARGAS");

        jLabel15.setText("Unidades");

        txtMontacargasUnidades.setText("2");
        txtMontacargasUnidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMontacargasUnidadesActionPerformed(evt);
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

        nroMaquinas.setText("Nro. Maquinas");

        txtNroMaquinas.setText("50");

        jLabel19.setText("DISTANCIA DE TRASLADO");

        jLabel51.setText("T. Operacion");

        txtTiempoOperacion.setText("189");

        jLabel21.setText("DISTANCIA DE TRASLADO");

        jLabel22.setText("T. Reparacion");

        txtTiempoReparacion.setText("45");
        txtTiempoReparacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTiempoReparacionActionPerformed(evt);
            }
        });

        jLabel23.setText("Inv. Inicial");

        txtReservasInventarioIni.setText("3");
        txtReservasInventarioIni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtReservasInventarioIniActionPerformed(evt);
            }
        });

        jLabel13.setText("DISTANCIA DE TRASLADO");

        jLabel29.setText("En metros");

        txtReservasDistSiguiente.setText("20");

        jLabel24.setText("Vel. Lleno en Mt/min");

        txtMontacargasVelLleno.setText("100");
        txtMontacargasVelLleno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMontacargasVelLlenoActionPerformed(evt);
            }
        });

        jLabel52.setText("T. Subida y bajada en seg");

        txtMontacargasTiempos.setText("50");

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
                .addGap(33, 33, 33)
                .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(17, 17, 17))
                    .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                            .addComponent(jLabel23)
                            .addGap(18, 18, 18)
                            .addComponent(txtReservasInventarioIni, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                            .addComponent(jLabel17)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtReservasCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                            .addComponent(jLabel29)
                            .addGap(18, 18, 18)
                            .addComponent(txtReservasDistSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel13)
                        .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                                        .addComponent(jLabel51)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtTiempoOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                                        .addComponent(nroMaquinas)
                                        .addGap(22, 22, 22)
                                        .addComponent(txtNroMaquinas, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(jLabel5)
                                .addComponent(jLabel10)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventanaPrincipalLayout.createSequentialGroup()
                            .addGap(29, 29, 29)
                            .addComponent(jLabel27)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtFabricaDistSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                        .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                                    .addGap(51, 51, 51)
                                    .addComponent(jLabel11)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtMantenimientoCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventanaPrincipalLayout.createSequentialGroup()
                                    .addGap(48, 48, 48)
                                    .addComponent(jLabel28)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtMantenDistSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(jLabel19))
                            .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addComponent(jLabel4)))
                        .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                                .addGap(108, 108, 108)
                                .addComponent(jLabel6)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel21)
                                    .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                                        .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel14)
                                            .addComponent(jLabel22))
                                        .addGap(18, 18, 18)
                                        .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtNroMecanicos, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtTiempoReparacion, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                                        .addComponent(jLabel33)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtReparacionDistSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventanaPrincipalLayout.createSequentialGroup()
                                        .addComponent(jLabel26)
                                        .addGap(27, 27, 27)
                                        .addComponent(nroReplicas, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventanaPrincipalLayout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(horasSimulacion, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(142, 142, 142))))
                    .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                                .addComponent(jLabel52)
                                .addGap(18, 18, 18)
                                .addComponent(txtMontacargasTiempos, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                                        .addGap(49, 49, 49)
                                        .addComponent(jLabel15)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtMontacargasUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                                        .addGap(71, 71, 71)
                                        .addComponent(jLabel12))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventanaPrincipalLayout.createSequentialGroup()
                                        .addComponent(jLabel20)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtMontacargasVelVacio, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                                    .addComponent(jLabel24)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtMontacargasVelLleno, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventanaPrincipalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSimular, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121))
        );
        ventanaPrincipalLayout.setVerticalGroup(
            ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel1))
                    .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                        .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtMantenimientoCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMantenDistSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28)))
                    .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                        .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txtNroMecanicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26)
                            .addComponent(nroReplicas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventanaPrincipalLayout.createSequentialGroup()
                                .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtTiempoOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel51)))
                                    .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel22)
                                            .addComponent(txtTiempoReparacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                        .addComponent(btnSimular, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addComponent(jLabel21)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtReparacionDistSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel33)))
                                    .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtFabricaDistSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel27)))))
                            .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(horasSimulacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nroMaquinas)
                            .addComponent(txtNroMaquinas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(35, 35, 35)
                .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(txtReservasCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(txtReservasInventarioIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13))
                    .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(txtMontacargasUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(txtMontacargasVelVacio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(txtMontacargasVelLleno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtReservasDistSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel29))
                    .addComponent(txtMontacargasTiempos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel52))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 171, Short.MAX_VALUE)
                .addComponent(jPanelSimulacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1276, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(ventanaPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1074, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void horasSimulacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_horasSimulacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_horasSimulacionActionPerformed

    private void txtMantenimientoCapacidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMantenimientoCapacidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMantenimientoCapacidadActionPerformed

    private void txtNroMecanicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNroMecanicosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNroMecanicosActionPerformed

    private void txtReservasCapacidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtReservasCapacidadActionPerformed
        // TODO add your handling code here:
        //aqui
    }//GEN-LAST:event_txtReservasCapacidadActionPerformed

    private void txtMontacargasVelVacioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMontacargasVelVacioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMontacargasVelVacioActionPerformed

    private void nroReplicasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nroReplicasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nroReplicasActionPerformed

    private void btnSimularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimularActionPerformed
        ParametrosSimulacion params = new ParametrosSimulacion();
        
        params.nroMaquinas = Integer.parseInt(txtNroMaquinas.getText());
        params.distFabricaSiguiente = Integer.parseInt(txtFabricaDistSiguiente.getText());
        params.tiempoOperacion = Integer.parseInt(txtTiempoOperacion.getText());
        
        params.mantenimientoCapacidad = Integer.parseInt(txtMantenimientoCapacidad.getText());
        params.distMantenimietoSiguiente = Integer.parseInt(txtMantenDistSiguiente.getText());
        
        params.nroMecanicos = Integer.parseInt(txtNroMecanicos.getText());
        params.tiempoReparacion = Integer.parseInt(txtTiempoReparacion.getText());
        params.distReparacionSiguiente = Integer.parseInt(txtReparacionDistSiguiente.getText());
        
        params.reservasCapacidad = Integer.parseInt(txtReservasCapacidad.getText());
        params.reservasInventarioInicial = Integer.parseInt(txtReservasInventarioIni.getText());
        params.distReservasSiguiente = Integer.parseInt(txtReservasDistSiguiente.getText());

        params.montacargasUnidades = Integer.parseInt(txtMontacargasUnidades.getText());
        params.montacargasVelVacio = Integer.parseInt(txtMontacargasVelVacio.getText());
        params.montacargasVelLleno = Integer.parseInt(txtMontacargasVelLleno.getText());
        params.monstacargasTiempos = Integer.parseInt(txtMontacargasTiempos.getText());

        params.nroReplicas = Integer.parseInt(nroReplicas.getText());
        params.horasSimulacion = Integer.parseInt(horasSimulacion.getText());
        

        VentanaSimulacion sim = new VentanaSimulacion(params);
        sim.setVisible(true);
        
    }//GEN-LAST:event_btnSimularActionPerformed

    private void txtMontacargasUnidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMontacargasUnidadesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMontacargasUnidadesActionPerformed

    private void txtMantenDistSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMantenDistSiguienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMantenDistSiguienteActionPerformed

    private void txtTiempoReparacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTiempoReparacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTiempoReparacionActionPerformed

    private void txtReservasInventarioIniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtReservasInventarioIniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtReservasInventarioIniActionPerformed

    private void txtMontacargasVelLlenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMontacargasVelLlenoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMontacargasVelLlenoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSimular;
    private javax.swing.JTextField horasSimulacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanelSimulacion;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nroMaquinas;
    private javax.swing.JTextField nroReplicas;
    private javax.swing.JTextField txtFabricaDistSiguiente;
    private javax.swing.JTextField txtMantenDistSiguiente;
    private javax.swing.JTextField txtMantenimientoCapacidad;
    private javax.swing.JTextField txtMontacargasTiempos;
    private javax.swing.JTextField txtMontacargasUnidades;
    private javax.swing.JTextField txtMontacargasVelLleno;
    private javax.swing.JTextField txtMontacargasVelVacio;
    private javax.swing.JTextField txtNroMaquinas;
    private javax.swing.JTextField txtNroMecanicos;
    private javax.swing.JTextField txtReparacionDistSiguiente;
    private javax.swing.JTextField txtReservasCapacidad;
    private javax.swing.JTextField txtReservasDistSiguiente;
    private javax.swing.JTextField txtReservasInventarioIni;
    private javax.swing.JTextField txtTiempoOperacion;
    private javax.swing.JTextField txtTiempoReparacion;
    private javax.swing.JPanel ventanaPrincipal;
    // End of variables declaration//GEN-END:variables
}

