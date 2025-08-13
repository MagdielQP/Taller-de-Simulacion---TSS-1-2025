package proyecto4.tss.GUI;

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
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        horasSimulacion = new javax.swing.JTextField();
        txtCamionMedia = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtRutaDescargaMedia = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        nroReplicas = new javax.swing.JTextField();
        btnSimular = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jPanelSimulacion = new javax.swing.JPanel();
        nroMaquinas = new javax.swing.JLabel();
        txtMercaderiaInicial = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        txtFurgonetaMedia = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtCamionDiferencia = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        txtFurgonetaDiferencia = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtRutaDescargaDiferencia = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtRutaCargaMedia = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txtRutaCargaDiferencia = new javax.swing.JTextField();
        nroMaquinas1 = new javax.swing.JLabel();
        txtDistancias = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtCentroDistrCamionMedia = new javax.swing.JTextField();
        txtCentroDistrCamionDiferencia = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        txtCentroDistrFurgonetaMedia = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        txtCentroDistrFurgonetaDiferencia = new javax.swing.JTextField();
        nroMaquinas2 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txtVelocidadFurgonetaVacio = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        txtVelocidadFurgonetaLleno = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        txtVelocidadCamionVacio = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        txtVelocidadCamionLleno = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ventanaPrincipal.setPreferredSize(new java.awt.Dimension(1074, 2584));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setText("Proyecto 4 - Taller de Simulacion");

        jLabel3.setText("BODEGA");

        jLabel4.setText("RUTA");

        jLabel6.setText("CENTRO DE DISTRIBUCIONES");

        jLabel9.setText("horas de simulacion:");

        jLabel10.setText("TIEMPOS CARGA+DESCARGA");

        horasSimulacion.setText("100");
        horasSimulacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                horasSimulacionActionPerformed(evt);
            }
        });

        txtCamionMedia.setText("95");
        txtCamionMedia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCamionMediaActionPerformed(evt);
            }
        });

        jLabel11.setText("media");

        txtRutaDescargaMedia.setText("5");
        txtRutaDescargaMedia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRutaDescargaMediaActionPerformed(evt);
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

        jLabel27.setText("camiones-vanes media");

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

        nroMaquinas.setText("mercaderia inicial");

        txtMercaderiaInicial.setText("50");

        jLabel19.setText("TIEMPOS CARGA FURGONETAS");

        jLabel51.setText("furgonetas media");

        txtFurgonetaMedia.setText("50");
        txtFurgonetaMedia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFurgonetaMediaActionPerformed(evt);
            }
        });

        jLabel30.setText("camiones-vanes diferencia");

        txtCamionDiferencia.setText("10");
        txtCamionDiferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCamionDiferenciaActionPerformed(evt);
            }
        });

        jLabel53.setText("furgonetas diferencia");

        txtFurgonetaDiferencia.setText("5");
        txtFurgonetaDiferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFurgonetaDiferenciaActionPerformed(evt);
            }
        });

        jLabel16.setText("TIEMPOS DESCARGA FURGONETAS");

        jLabel18.setText("diferencia");

        txtRutaDescargaDiferencia.setText("2");
        txtRutaDescargaDiferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRutaDescargaDiferenciaActionPerformed(evt);
            }
        });

        jLabel25.setText("media");

        txtRutaCargaMedia.setText("7");
        txtRutaCargaMedia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRutaCargaMediaActionPerformed(evt);
            }
        });

        jLabel31.setText("diferencia");

        txtRutaCargaDiferencia.setText("5");
        txtRutaCargaDiferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRutaCargaDiferenciaActionPerformed(evt);
            }
        });

        nroMaquinas1.setText("distancias D.Exp");

        txtDistancias.setText("7");

        jLabel12.setText("TIEMPOS CARGA+DESCARGA");

        jLabel28.setText("camiones-vanes media");

        txtCentroDistrCamionMedia.setText("95");
        txtCentroDistrCamionMedia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCentroDistrCamionMediaActionPerformed(evt);
            }
        });

        txtCentroDistrCamionDiferencia.setText("10");
        txtCentroDistrCamionDiferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCentroDistrCamionDiferenciaActionPerformed(evt);
            }
        });

        jLabel32.setText("camiones-vanes diferencia");

        jLabel52.setText("furgonetas media");

        txtCentroDistrFurgonetaMedia.setText("50");
        txtCentroDistrFurgonetaMedia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCentroDistrFurgonetaMediaActionPerformed(evt);
            }
        });

        jLabel54.setText("furgonetas diferencia");

        txtCentroDistrFurgonetaDiferencia.setText("5");
        txtCentroDistrFurgonetaDiferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCentroDistrFurgonetaDiferenciaActionPerformed(evt);
            }
        });

        nroMaquinas2.setText("Km");

        jLabel29.setText("Velocidad Furgoneta Vacio");

        txtVelocidadFurgonetaVacio.setText("150");
        txtVelocidadFurgonetaVacio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVelocidadFurgonetaVacioActionPerformed(evt);
            }
        });

        jLabel33.setText("Velocidad Furgoneta Lleno");

        txtVelocidadFurgonetaLleno.setText("120");
        txtVelocidadFurgonetaLleno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVelocidadFurgonetaLlenoActionPerformed(evt);
            }
        });

        jLabel55.setText("Velocidad Camion Vacio");

        txtVelocidadCamionVacio.setText("90");
        txtVelocidadCamionVacio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVelocidadCamionVacioActionPerformed(evt);
            }
        });

        jLabel56.setText("Velocidad Camion Lleno");

        txtVelocidadCamionLleno.setText("70");
        txtVelocidadCamionLleno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVelocidadCamionLlenoActionPerformed(evt);
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
                        .addComponent(jPanelSimulacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                        .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ventanaPrincipalLayout.createSequentialGroup()
                                    .addGap(65, 65, 65)
                                    .addComponent(jLabel10))
                                .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                                    .addGap(48, 48, 48)
                                    .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventanaPrincipalLayout.createSequentialGroup()
                                                .addComponent(jLabel53)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtFurgonetaDiferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventanaPrincipalLayout.createSequentialGroup()
                                                .addComponent(jLabel27)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtCamionMedia, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventanaPrincipalLayout.createSequentialGroup()
                                                .addComponent(jLabel51)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtFurgonetaMedia, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                                                .addComponent(jLabel30)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtCamionDiferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                                            .addComponent(nroMaquinas)
                                            .addGap(22, 22, 22)
                                            .addComponent(txtMercaderiaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                                .addGap(139, 139, 139)
                                .addComponent(jLabel3))
                            .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventanaPrincipalLayout.createSequentialGroup()
                                            .addComponent(jLabel54)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtCentroDistrFurgonetaDiferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventanaPrincipalLayout.createSequentialGroup()
                                            .addComponent(jLabel28)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txtCentroDistrCamionMedia, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventanaPrincipalLayout.createSequentialGroup()
                                            .addComponent(jLabel52)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtCentroDistrFurgonetaMedia, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                                            .addComponent(jLabel32)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtCentroDistrCamionDiferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ventanaPrincipalLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel12))))))
                        .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                                .addGap(99, 99, 99)
                                .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                                                .addComponent(jLabel31)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtRutaCargaDiferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                                                .addComponent(jLabel25)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtRutaCargaMedia, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                                        .addComponent(nroMaquinas1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDistancias, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nroMaquinas2))
                                    .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                                        .addGap(85, 85, 85)
                                        .addComponent(jLabel4))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventanaPrincipalLayout.createSequentialGroup()
                                        .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGap(18, 18, 18)
                                        .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtRutaDescargaDiferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtRutaDescargaMedia, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(44, 44, 44))
                                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventanaPrincipalLayout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addGap(25, 25, 25)))
                                .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                                        .addGap(168, 168, 168)
                                        .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventanaPrincipalLayout.createSequentialGroup()
                                                .addComponent(jLabel26)
                                                .addGap(27, 27, 27)
                                                .addComponent(nroReplicas, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventanaPrincipalLayout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(horasSimulacion, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(213, 213, 213))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventanaPrincipalLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnSimular, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(234, 234, 234))))
                            .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                                        .addComponent(jLabel33)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtVelocidadFurgonetaLleno, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                                        .addComponent(jLabel29)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtVelocidadFurgonetaVacio, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                                        .addComponent(jLabel55)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtVelocidadCamionVacio, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                                        .addComponent(jLabel56)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtVelocidadCamionLleno, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        ventanaPrincipalLayout.setVerticalGroup(
            ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nroMaquinas)
                            .addComponent(txtMercaderiaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCamionMedia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCamionDiferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFurgonetaMedia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel51))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel53)
                            .addComponent(txtFurgonetaDiferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCentroDistrCamionMedia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28)
                            .addComponent(txtVelocidadFurgonetaVacio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCentroDistrCamionDiferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32)
                            .addComponent(txtVelocidadFurgonetaLleno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCentroDistrFurgonetaMedia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel52)
                            .addComponent(txtVelocidadCamionVacio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel55)))
                    .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                        .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel1))
                            .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel26)
                                    .addComponent(nroReplicas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(16, 16, 16)
                                .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(horasSimulacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(nroMaquinas1)
                                    .addComponent(txtDistancias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nroMaquinas2))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(ventanaPrincipalLayout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(txtRutaDescargaMedia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel18)
                                    .addComponent(txtRutaDescargaDiferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel19))
                            .addComponent(btnSimular, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(txtRutaCargaMedia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31)
                            .addComponent(txtRutaCargaDiferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(165, 165, 165)))
                .addGroup(ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel54)
                    .addComponent(txtCentroDistrFurgonetaDiferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel56)
                    .addComponent(txtVelocidadCamionLleno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
                .addComponent(jPanelSimulacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1244, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(ventanaPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1086, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void horasSimulacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_horasSimulacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_horasSimulacionActionPerformed

    private void txtRutaDescargaMediaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRutaDescargaMediaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRutaDescargaMediaActionPerformed

    private void nroReplicasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nroReplicasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nroReplicasActionPerformed

    private void btnSimularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimularActionPerformed
        ParametrosSimulacion params = new ParametrosSimulacion();
        
        params.mercaderiaInicial = Integer.parseInt(txtMercaderiaInicial.getText());
        
        params.camionMedia = Integer.parseInt(txtCamionMedia.getText());
        params.camionDiferencia = Integer.parseInt(txtCamionDiferencia.getText());
        params.furgonetaMedia = Integer.parseInt(txtFurgonetaMedia.getText());
        params.furgonetaDiferencia = Integer.parseInt(txtFurgonetaDiferencia.getText());
        
        params.distancias = Integer.parseInt(txtDistancias.getText());
        
        params.rutaDescargaMedia = Integer.parseInt(txtRutaDescargaMedia.getText());
        params.rutaDescargaDiferencia = Integer.parseInt(txtRutaDescargaDiferencia.getText());
        
        params.rutaCargaMedia = Integer.parseInt(txtRutaCargaMedia.getText());
        params.rutaCargaDiferencia = Integer.parseInt(txtRutaCargaDiferencia.getText());

        params.centroDistrCamionMedia = Integer.parseInt(txtCentroDistrCamionMedia.getText());
        params.centroDistrCamionDiferencia = Integer.parseInt(txtCentroDistrCamionDiferencia.getText());
        params.centroDistrFurgonetaMedia = Integer.parseInt(txtCentroDistrFurgonetaMedia.getText());
        params.centroDistrFurgonetaDiferencia = Integer.parseInt(txtCentroDistrFurgonetaDiferencia.getText());
        
        params.velocidadFurgonetaVacio = Integer.parseInt(txtVelocidadFurgonetaVacio.getText());
        params.velocidadFurgonetaLleno = Integer.parseInt(txtVelocidadFurgonetaLleno.getText());
        params.velocidadCamionVacio = Integer.parseInt(txtVelocidadCamionVacio.getText());
        params.velocidadCamionLleno = Integer.parseInt(txtVelocidadCamionLleno.getText());

        params.nroReplicas = Integer.parseInt(nroReplicas.getText());
        params.horasSimulacion = Integer.parseInt(horasSimulacion.getText());
        

        VentanaSimulacion sim = new VentanaSimulacion(params);
        sim.setVisible(true);
        
    }//GEN-LAST:event_btnSimularActionPerformed

    private void txtCamionMediaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCamionMediaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCamionMediaActionPerformed

    private void txtFurgonetaMediaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFurgonetaMediaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFurgonetaMediaActionPerformed

    private void txtCamionDiferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCamionDiferenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCamionDiferenciaActionPerformed

    private void txtFurgonetaDiferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFurgonetaDiferenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFurgonetaDiferenciaActionPerformed

    private void txtRutaDescargaDiferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRutaDescargaDiferenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRutaDescargaDiferenciaActionPerformed

    private void txtRutaCargaMediaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRutaCargaMediaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRutaCargaMediaActionPerformed

    private void txtRutaCargaDiferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRutaCargaDiferenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRutaCargaDiferenciaActionPerformed

    private void txtCentroDistrCamionMediaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCentroDistrCamionMediaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCentroDistrCamionMediaActionPerformed

    private void txtCentroDistrCamionDiferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCentroDistrCamionDiferenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCentroDistrCamionDiferenciaActionPerformed

    private void txtCentroDistrFurgonetaMediaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCentroDistrFurgonetaMediaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCentroDistrFurgonetaMediaActionPerformed

    private void txtCentroDistrFurgonetaDiferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCentroDistrFurgonetaDiferenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCentroDistrFurgonetaDiferenciaActionPerformed

    private void txtVelocidadFurgonetaVacioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVelocidadFurgonetaVacioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVelocidadFurgonetaVacioActionPerformed

    private void txtVelocidadFurgonetaLlenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVelocidadFurgonetaLlenoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVelocidadFurgonetaLlenoActionPerformed

    private void txtVelocidadCamionVacioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVelocidadCamionVacioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVelocidadCamionVacioActionPerformed

    private void txtVelocidadCamionLlenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVelocidadCamionLlenoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVelocidadCamionLlenoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSimular;
    private javax.swing.JTextField horasSimulacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanelSimulacion;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nroMaquinas;
    private javax.swing.JLabel nroMaquinas1;
    private javax.swing.JLabel nroMaquinas2;
    private javax.swing.JTextField nroReplicas;
    private javax.swing.JTextField txtCamionDiferencia;
    private javax.swing.JTextField txtCamionMedia;
    private javax.swing.JTextField txtCentroDistrCamionDiferencia;
    private javax.swing.JTextField txtCentroDistrCamionMedia;
    private javax.swing.JTextField txtCentroDistrFurgonetaDiferencia;
    private javax.swing.JTextField txtCentroDistrFurgonetaMedia;
    private javax.swing.JTextField txtDistancias;
    private javax.swing.JTextField txtFurgonetaDiferencia;
    private javax.swing.JTextField txtFurgonetaMedia;
    private javax.swing.JTextField txtMercaderiaInicial;
    private javax.swing.JTextField txtRutaCargaDiferencia;
    private javax.swing.JTextField txtRutaCargaMedia;
    private javax.swing.JTextField txtRutaDescargaDiferencia;
    private javax.swing.JTextField txtRutaDescargaMedia;
    private javax.swing.JTextField txtVelocidadCamionLleno;
    private javax.swing.JTextField txtVelocidadCamionVacio;
    private javax.swing.JTextField txtVelocidadFurgonetaLleno;
    private javax.swing.JTextField txtVelocidadFurgonetaVacio;
    private javax.swing.JPanel ventanaPrincipal;
    // End of variables declaration//GEN-END:variables
}

