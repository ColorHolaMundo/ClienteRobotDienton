package com.colorholamundo.clienterobotdienton;

import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.colorholamundo.comun.datosred.Coordenada;
import com.colorholamundo.comun.datosred.Instruccion;


/**
 *
 * @author COLOR HOLAMUNDO
 */
public class Marco extends javax.swing.JFrame {

	private static final long serialVersionUID = -3601689376026749860L;
	
	private ClienteRobot cliente = null;
    private String ipServidor = "192.168.0.100";
    private String puerto = "10000";
    private boolean conectado = false;

    public Marco() {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(Marco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(Marco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(Marco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(Marco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }

        initComponents();

    }

    private void initComponents() {

        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        botonConexion = new org.edisoncor.gui.button.ButtonCircle();
        entradaAdelante = new org.edisoncor.gui.textField.TextFieldRectBackground();
        labelAdelante = new org.edisoncor.gui.label.LabelTask();
        labelAtras = new org.edisoncor.gui.label.LabelTask();
        entradaAtras = new org.edisoncor.gui.textField.TextFieldRectBackground();
        labelGiroDerecha = new org.edisoncor.gui.label.LabelTask();
        entradaDerecha = new org.edisoncor.gui.textField.TextFieldRectBackground();
        labelGiroDerecha1 = new org.edisoncor.gui.label.LabelTask();
        entradaIzquierda = new org.edisoncor.gui.textField.TextFieldRectBackground();
        panelRectTranslucido1 = new org.edisoncor.gui.panel.PanelRectTranslucido();
        mapa2D = new com.colorholamundo.clienterobotdienton.Mapa2D();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelCoordenada = new javax.swing.JEditorPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu = new javax.swing.JMenu();
        datosDeConexion = new javax.swing.JMenuItem();
        editarConexion = new javax.swing.JMenuItem();
        menuOpciones = new javax.swing.JMenu();
        menuReinicio = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.jpg"))); // NOI18N

        botonConexion.setColor(new java.awt.Color(255, 0, 0));
        botonConexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConexionActionPerformed(evt);
            }
        });

        entradaAdelante.setEditable(false);
        entradaAdelante.setDescripcion("Centimetros");

        labelAdelante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/flecha.png"))); // NOI18N
        labelAdelante.setText("Adelante");
        labelAdelante.setDescription("Movimiento");
        labelAdelante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelAdelanteMouseClicked(evt);
            }
        });

        labelAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/flechaAtras.png"))); // NOI18N
        labelAtras.setText("Atras");
        labelAtras.setDescription("Movimiento");
        labelAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelAtrasMouseClicked(evt);
            }
        });

        entradaAtras.setEditable(false);
        entradaAtras.setDescripcion("Centimetros");

        labelGiroDerecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/giroDerecha.png"))); // NOI18N
        labelGiroDerecha.setText("Derecha");
        labelGiroDerecha.setDescription("Giro");
        labelGiroDerecha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelGiroDerechaMouseClicked(evt);
            }
        });

        entradaDerecha.setEditable(false);
        entradaDerecha.setDescripcion("Grados");

        labelGiroDerecha1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/giroIzquierda.png"))); // NOI18N
        labelGiroDerecha1.setText("Izquierda");
        labelGiroDerecha1.setDescription("Giro");
        labelGiroDerecha1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelGiroDerecha1MouseClicked(evt);
            }
        });

        entradaIzquierda.setEditable(false);
        entradaIzquierda.setDescripcion("Grados");

        mapa2D.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                eventoMovimiento(evt);
            }
        });
        mapa2D.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eventoClicMapa(evt);
            }
        });

        javax.swing.GroupLayout mapa2DLayout = new javax.swing.GroupLayout(mapa2D);
        mapa2D.setLayout(mapa2DLayout);
        mapa2DLayout.setHorizontalGroup(
            mapa2DLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        mapa2DLayout.setVerticalGroup(
            mapa2DLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelRectTranslucido1Layout = new javax.swing.GroupLayout(panelRectTranslucido1);
        panelRectTranslucido1.setLayout(panelRectTranslucido1Layout);
        panelRectTranslucido1Layout.setHorizontalGroup(
            panelRectTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRectTranslucido1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mapa2D, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelRectTranslucido1Layout.setVerticalGroup(
            panelRectTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRectTranslucido1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mapa2D, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelCoordenada.setEditable(false);
        panelCoordenada.setBackground(new java.awt.Color(255, 255, 204));
        panelCoordenada.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jScrollPane1.setViewportView(panelCoordenada);

        javax.swing.GroupLayout panelImage1Layout = new javax.swing.GroupLayout(panelImage1);
        panelImage1.setLayout(panelImage1Layout);
        panelImage1Layout.setHorizontalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImage1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(botonConexion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelImage1Layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelAdelante, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelImage1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                                .addComponent(labelAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(entradaAdelante, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(entradaAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelImage1Layout.createSequentialGroup()
                                .addComponent(labelGiroDerecha, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(entradaDerecha, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelImage1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(labelGiroDerecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(entradaIzquierda, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(panelRectTranslucido1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(65, 65, 65))
        );
        panelImage1Layout.setVerticalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImage1Layout.createSequentialGroup()
                .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelImage1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(botonConexion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelImage1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(entradaAdelante, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(labelGiroDerecha, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(labelAdelante, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(entradaDerecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelImage1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(entradaAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelGiroDerecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(entradaIzquierda, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelImage1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(17, 17, 17)
                .addComponent(panelRectTranslucido1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(24, 24, 24))
        );

        menu.setBackground(new java.awt.Color(255, 255, 255));
        menu.setText("Conexion");
        menu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        datosDeConexion.setText("Datos de Conexion");
        datosDeConexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datosDeConexionActionPerformed(evt);
            }
        });
        menu.add(datosDeConexion);

        editarConexion.setText("Editar Conexion");
        editarConexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarConexionActionPerformed(evt);
            }
        });
        menu.add(editarConexion);

        jMenuBar1.add(menu);

        menuOpciones.setText("Opciones");

        menuReinicio.setText("Reinicio");
        menuReinicio.setEnabled(false);
        menuReinicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eventoMenuReinicio(evt);
            }
        });
        menuOpciones.add(menuReinicio);

        jMenuBar1.add(menuOpciones);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void datosDeConexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datosDeConexionActionPerformed
        JOptionPane.showMessageDialog(this, "IP SERVIDOR: " + ipServidor + "\n"
                + "PUERTO: " + puerto);
    }//GEN-LAST:event_datosDeConexionActionPerformed

    private void editarConexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarConexionActionPerformed
        ipServidor = JOptionPane.showInputDialog(null, "IP SERVIDOR");
        puerto = JOptionPane.showInputDialog(null, "PUERTO");
    }//GEN-LAST:event_editarConexionActionPerformed

    private void botonConexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConexionActionPerformed
        if (!conectado) {
            botonConexion.setColor(new Color(0, 255, 255));
            botonConexion.setEnabled(false);
            //  Mapa2D.limpiar();
            try {

                int puertoServidor = Integer.parseInt(puerto);

                cliente = new ClienteRobot(this, ipServidor, puertoServidor);

                cliente.execute();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "DATOS NO VALIDOS");
                System.exit(-1);
            }

        } else {
            cliente.cerrarConexion();
        }
    }//GEN-LAST:event_botonConexionActionPerformed

    private void labelAdelanteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelAdelanteMouseClicked
        try {
            if (conectado) {
                double distancia = Double.parseDouble(entradaAdelante.getText());

                Instruccion instruccion = new Instruccion(Instruccion.ADELANTE, distancia);
                entradaAdelante.setText("");

                cliente.enviarDatos(instruccion);
            }
        } catch (Exception ex) {
            entradaAdelante.setText("");
            JOptionPane.showMessageDialog(this, "MEDIDA NO VALIDA");
        }

    }//GEN-LAST:event_labelAdelanteMouseClicked

    private void labelAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelAtrasMouseClicked
        try {
            if (conectado) {
                double distancia = Double.parseDouble(entradaAtras.getText());

                Instruccion instruccion = new Instruccion(Instruccion.ATRAS, distancia);
                entradaAtras.setText("");

                cliente.enviarDatos(instruccion);
            }
        } catch (Exception ex) {
            entradaAtras.setText("");
            JOptionPane.showMessageDialog(this, "MEDIDA NO VALIDA");
        }

    }//GEN-LAST:event_labelAtrasMouseClicked

    private void labelGiroDerechaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelGiroDerechaMouseClicked
        try {
            if (conectado) {
                double giro = Double.parseDouble(entradaDerecha.getText());

                Instruccion instruccion = new Instruccion(Instruccion.GIRODERECHA, giro);
                entradaDerecha.setText("");

                cliente.enviarDatos(instruccion);
            }
        } catch (Exception ex) {
            entradaDerecha.setText("");
            JOptionPane.showMessageDialog(this, "MEDIDA NO VALIDA");
        }

    }//GEN-LAST:event_labelGiroDerechaMouseClicked

    private void labelGiroDerecha1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelGiroDerecha1MouseClicked
        try {
            if (conectado) {
                double giro = Double.parseDouble(entradaIzquierda.getText());

                Instruccion instruccion = new Instruccion(Instruccion.GIROIZQUIERDA, giro);
                entradaIzquierda.setText("");

                cliente.enviarDatos(instruccion);
            }
        } catch (Exception ex) {
            entradaIzquierda.setText("");
            JOptionPane.showMessageDialog(this, "MEDIDA NO VALIDA");
        }

    }//GEN-LAST:event_labelGiroDerecha1MouseClicked

    private void eventoMenuReinicio(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eventoMenuReinicio

        if (conectado) {
            mapa2D.reinicioMapa();
            cliente.enviarDatos(new Instruccion(5, 0));
        }
    }//GEN-LAST:event_eventoMenuReinicio

    private void eventoMovimiento(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eventoMovimiento
     
        int x = (int) mapa2D.posicionXenCM(evt.getX());
        int y = (int) mapa2D.posicionYenCM(evt.getY());

        panelCoordenada.setText("X: " + x + " cm\n"
                + "Y: " + y + " cm");
    }//GEN-LAST:event_eventoMovimiento

    private void eventoClicMapa(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eventoClicMapa
        if (conectado) {

            int x = (int) mapa2D.posicionXenCM(evt.getX());
            int y = (int) mapa2D.posicionYenCM(evt.getY());

            int opcion = JOptionPane.showConfirmDialog(this, "DESEA REALIZAR LA TAREA: \n "
                    + "X= " + x + "\n "
                    + "Y= " + y);

            if (opcion == 0) {
                ingresarTarea(x, y);

                Instruccion instruccion = new Instruccion(Instruccion.AUTONOMO, x, y);
                cliente.enviarDatos(instruccion);
            }
        }
    }//GEN-LAST:event_eventoClicMapa

    public void ingresarObstaculo(Coordenada coordenada) {

        mapa2D.ingresarObstaculo(coordenada);
        mapa2D.repaint();
    }

    public void ingresarTarea(int x, int y) {
        mapa2D.ingresarTarea(x, y);
    }

    public void conexionRealizada() {
        botonConexion.setEnabled(true);
        botonConexion.setColor(new Color(0, 255, 0));
        conectado = true;
        menuReinicio.setEnabled(true);

        entradaAdelante.setEditable(true);
        entradaAtras.setEditable(true);
        entradaDerecha.setEditable(true);
        entradaIzquierda.setEditable(true);

        entradaAdelante.setText("");
        entradaAtras.setText("");
        entradaDerecha.setText("");
        entradaIzquierda.setText("");

    }

    public void conexionFinalizada() {
        botonConexion.setEnabled(true);
        botonConexion.setColor(new Color(255, 0, 0));
        conectado = false;
        menuReinicio.setEnabled(false);

        entradaAdelante.setEditable(false);
        entradaAtras.setEditable(false);
        entradaDerecha.setEditable(false);
        entradaIzquierda.setEditable(false);

        entradaAdelante.setText("");
        entradaAtras.setText("");
        entradaDerecha.setText("");
        entradaIzquierda.setText("");

    }

    public static void main(String args[]) {

        new Marco().setVisible(true);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonCircle botonConexion;
    private javax.swing.JMenuItem datosDeConexion;
    private javax.swing.JMenuItem editarConexion;
    private org.edisoncor.gui.textField.TextFieldRectBackground entradaAdelante;
    private org.edisoncor.gui.textField.TextFieldRectBackground entradaAtras;
    private org.edisoncor.gui.textField.TextFieldRectBackground entradaDerecha;
    private org.edisoncor.gui.textField.TextFieldRectBackground entradaIzquierda;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private org.edisoncor.gui.label.LabelTask labelAdelante;
    private org.edisoncor.gui.label.LabelTask labelAtras;
    private org.edisoncor.gui.label.LabelTask labelGiroDerecha;
    private org.edisoncor.gui.label.LabelTask labelGiroDerecha1;
    private com.colorholamundo.clienterobotdienton.Mapa2D mapa2D;
    private javax.swing.JMenu menu;
    private javax.swing.JMenu menuOpciones;
    private javax.swing.JMenuItem menuReinicio;
    private javax.swing.JEditorPane panelCoordenada;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    private org.edisoncor.gui.panel.PanelRectTranslucido panelRectTranslucido1;
    // End of variables declaration//GEN-END:variables
}
