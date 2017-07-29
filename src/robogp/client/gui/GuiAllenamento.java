package robogp.client.gui;

import java.awt.Component;
import java.util.ArrayList;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListCellRenderer;
import robogp.cards.Card;
import robogp.client.AllenamentoController;
import robogp.robodrome.view.RobodromeAnimationObserver;

/**
 *
 * @author Andrea
 */
public class GuiAllenamento extends javax.swing.JFrame  {

    private String robotName;
    private String rbdName;

    DefaultListModel displayList = new DefaultListModel();
    AllenamentoController ctr;

    public GuiAllenamento() {
        initComponents();
        ctr = AllenamentoController.getInstance();

        //Pulsanti
        this.riProgrammaButton.setEnabled(false);
        this.piazzaRobot.setEnabled(false);
        this.avviaProgrammaButton.setEnabled(false);
        this.move1Button.setEnabled(false);
        this.move2Button.setEnabled(false);
        this.move3Button.setEnabled(false);
        this.backUpButton.setEnabled(false);
        this.turnLeftButton.setEnabled(false);
        this.turnRightButton.setEnabled(false);
        this.uTurnButton.setEnabled(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        configRobodromo = new javax.swing.JDialog();
        robodromeCombo = new javax.swing.JComboBox<>();
        okConfigAllenamento = new javax.swing.JButton();
        nomeRobotCombo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        configRobot = new javax.swing.JDialog();
        posX = new javax.swing.JTextField();
        posY = new javax.swing.JTextField();
        exitConfigRobot = new javax.swing.JButton();
        direzioneCombo = new javax.swing.JComboBox<>();
        okConfigRobot = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        splitPanel = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        scegliRobodromo = new javax.swing.JButton();
        piazzaRobot = new javax.swing.JButton();
        avviaProgrammaButton = new javax.swing.JButton();
        riProgrammaButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        move1Button = new javax.swing.JButton();
        move2Button = new javax.swing.JButton();
        move3Button = new javax.swing.JButton();
        backUpButton = new javax.swing.JButton();
        turnLeftButton = new javax.swing.JButton();
        turnRightButton = new javax.swing.JButton();
        uTurnButton = new javax.swing.JButton();
        EastPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel8 = new javax.swing.JLabel();

        configRobodromo.setTitle("SCEGLI ROBODROMO");
        configRobodromo.setMinimumSize(new java.awt.Dimension(400, 300));
        configRobodromo.setName("configRobodromo"); // NOI18N
        configRobodromo.setUndecorated(true);

        robodromeCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "riskyexchange", "checkmate" }));

        okConfigAllenamento.setText("Conferma");
        okConfigAllenamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okConfigAllenamentoActionPerformed(evt);
            }
        });

        nomeRobotCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "blue", "red", "yellow", "emerald", "violet", "orange", "turquoise", "green" }));

        jLabel5.setText("Seleziona Robodromo:");

        jLabel6.setText("Seleziona Robot");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("SETUP ALLENAMENTO");

        javax.swing.GroupLayout configRobodromoLayout = new javax.swing.GroupLayout(configRobodromo.getContentPane());
        configRobodromo.getContentPane().setLayout(configRobodromoLayout);
        configRobodromoLayout.setHorizontalGroup(
            configRobodromoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, configRobodromoLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(configRobodromoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(configRobodromoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(robodromeCombo, 0, 161, Short.MAX_VALUE)
                    .addComponent(nomeRobotCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(59, 59, 59))
            .addGroup(configRobodromoLayout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addComponent(okConfigAllenamento, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(151, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, configRobodromoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        configRobodromoLayout.setVerticalGroup(
            configRobodromoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(configRobodromoLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(configRobodromoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(robodromeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(43, 43, 43)
                .addGroup(configRobodromoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeRobotCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(47, 47, 47)
                .addComponent(okConfigAllenamento)
                .addGap(29, 29, 29))
        );

        configRobodromo.getAccessibleContext().setAccessibleName("scegliRobodromo");

        configRobot.setMinimumSize(new java.awt.Dimension(400, 250));

        posX.setText("0");

        posY.setText("0");

        exitConfigRobot.setText("Exit");
        exitConfigRobot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitConfigRobotActionPerformed(evt);
            }
        });

        direzioneCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "E", "N", "S", "W" }));

        okConfigRobot.setText("Conferma");
        okConfigRobot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okConfigRobotActionPerformed(evt);
            }
        });

        jLabel1.setText("COORDINATA  X:");

        jLabel2.setText("COORDINATA Y:");

        jLabel3.setText("DIREZIONE ROBOT:");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("POSIZIONA ROBOT");

        javax.swing.GroupLayout configRobotLayout = new javax.swing.GroupLayout(configRobot.getContentPane());
        configRobot.getContentPane().setLayout(configRobotLayout);
        configRobotLayout.setHorizontalGroup(
            configRobotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(configRobotLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(configRobotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(configRobotLayout.createSequentialGroup()
                        .addGroup(configRobotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(configRobotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(posY)
                            .addComponent(posX)
                            .addComponent(direzioneCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(configRobotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(configRobotLayout.createSequentialGroup()
                            .addComponent(okConfigRobot, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(exitConfigRobot, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        configRobotLayout.setVerticalGroup(
            configRobotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(configRobotLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(configRobotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(configRobotLayout.createSequentialGroup()
                        .addComponent(posX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(configRobotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(posY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(configRobotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(direzioneCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addGap(25, 25, 25)
                .addGroup(configRobotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okConfigRobot)
                    .addComponent(exitConfigRobot))
                .addGap(25, 25, 25))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Allenamento");
        setBackground(new java.awt.Color(0, 0, 0));

        jPanel1.setLayout(new java.awt.GridLayout(4, 10));

        scegliRobodromo.setText("Scegli Robodromo");
        scegliRobodromo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scegliRobodromoActionPerformed(evt);
            }
        });
        jPanel1.add(scegliRobodromo);

        piazzaRobot.setText("Piazza Robot");
        piazzaRobot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                piazzaRobotActionPerformed(evt);
            }
        });
        jPanel1.add(piazzaRobot);

        avviaProgrammaButton.setText("Avvia Programma");
        avviaProgrammaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                avviaProgrammaButtonActionPerformed(evt);
            }
        });
        jPanel1.add(avviaProgrammaButton);

        riProgrammaButton.setText("riProgramma");
        riProgrammaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                riProgrammaButtonActionPerformed(evt);
            }
        });
        jPanel1.add(riProgrammaButton);

        splitPanel.setLeftComponent(jPanel1);

        jPanel2.setLayout(new java.awt.GridLayout(1, 7));

        move1Button.setText("Move 1");
        move1Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                move1ButtonActionPerformed(evt);
            }
        });
        jPanel2.add(move1Button);

        move2Button.setText("Move 2");
        move2Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                move2ButtonActionPerformed(evt);
            }
        });
        jPanel2.add(move2Button);

        move3Button.setText("Move 3");
        move3Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                move3ButtonActionPerformed(evt);
            }
        });
        jPanel2.add(move3Button);

        backUpButton.setText("Back up");
        backUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backUpButtonActionPerformed(evt);
            }
        });
        jPanel2.add(backUpButton);

        turnLeftButton.setText("Turn Left");
        turnLeftButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                turnLeftButtonActionPerformed(evt);
            }
        });
        jPanel2.add(turnLeftButton);

        turnRightButton.setText("Turn Right");
        turnRightButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                turnRightButtonActionPerformed(evt);
            }
        });
        jPanel2.add(turnRightButton);

        uTurnButton.setText("U Turn");
        uTurnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uTurnButtonActionPerformed(evt);
            }
        });
        jPanel2.add(uTurnButton);

        javax.swing.GroupLayout EastPanelLayout = new javax.swing.GroupLayout(EastPanel);
        EastPanel.setLayout(EastPanelLayout);
        EastPanelLayout.setHorizontalGroup(
            EastPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        EastPanelLayout.setVerticalGroup(
            EastPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 633, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(jList1);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("ROBOGP ALLENAMENTO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(splitPanel)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EastPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(EastPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(splitPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void scegliRobodromoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scegliRobodromoActionPerformed
        configRobodromo.setVisible(true);
        configRobodromo.setLocation(200, 200);


    }//GEN-LAST:event_scegliRobodromoActionPerformed

    private void okConfigAllenamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okConfigAllenamentoActionPerformed
        rbdName = this.robodromeCombo.getSelectedItem().toString();
        robotName = this.nomeRobotCombo.getSelectedItem().toString();

        ctr.creaRobodromo(rbdName);
      

        splitPanel.setRightComponent(ctr.getRv());

        this.configRobodromo.setVisible(false);

        this.scegliRobodromo.setEnabled(false);
        this.piazzaRobot.setEnabled(true);

    }//GEN-LAST:event_okConfigAllenamentoActionPerformed

    private void piazzaRobotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_piazzaRobotActionPerformed
        configRobot.setVisible(true);

        this.riProgrammaButton.setEnabled(true);
        this.avviaProgrammaButton.setEnabled(true);
        this.move1Button.setEnabled(true);
        this.move2Button.setEnabled(true);
        this.move3Button.setEnabled(true);
        this.backUpButton.setEnabled(true);
        this.turnLeftButton.setEnabled(true);
        this.turnRightButton.setEnabled(true);
        this.uTurnButton.setEnabled(true);

    }//GEN-LAST:event_piazzaRobotActionPerformed

    private void exitConfigRobotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitConfigRobotActionPerformed
        configRobot.dispose();
    }//GEN-LAST:event_exitConfigRobotActionPerformed

    private void okConfigRobotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okConfigRobotActionPerformed
        int x = Integer.parseInt(this.posX.getText().trim());
        int y = Integer.parseInt(this.posY.getText().trim());
        String direzione = this.direzioneCombo.getSelectedItem().toString();

        ctr.piazzaRobot(robotName, direzione, x, y);

        if (ctr.personalPoolEmpty()) {
            displayList.clear();
            ctr.riProgramma();
        }

        configRobot.setVisible(false);
    }//GEN-LAST:event_okConfigRobotActionPerformed

    private void move1ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_move1ButtonActionPerformed

        ctr.addMove1Card();
        
        //Aggiungo immagine alla lista di carte scelte(programma)
        displayList.addElement(ctr.getMove1());
        jList1.setCellRenderer(new RegistrilRenderer());
        jList1.setModel(displayList);


    }//GEN-LAST:event_move1ButtonActionPerformed

    private void avviaProgrammaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_avviaProgrammaButtonActionPerformed
        ctr.runProgramma();


    }//GEN-LAST:event_avviaProgrammaButtonActionPerformed

    private void turnLeftButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_turnLeftButtonActionPerformed
           ctr.addTurnLCard();
        
        //Aggiungo immagine alla lista di carte scelte(programma)
        displayList.addElement(ctr.getTurnL());
        jList1.setCellRenderer(new RegistrilRenderer());
        jList1.setModel(displayList);
    }//GEN-LAST:event_turnLeftButtonActionPerformed

    private void riProgrammaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_riProgrammaButtonActionPerformed
        displayList.clear();
        ctr.riProgramma();


    }//GEN-LAST:event_riProgrammaButtonActionPerformed

    private void move2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_move2ButtonActionPerformed
            ctr.addMove2Card();
        
        //Aggiungo immagine alla lista di carte scelte(programma)
        displayList.addElement(ctr.getMove2());
        jList1.setCellRenderer(new RegistrilRenderer());
        jList1.setModel(displayList);

    }//GEN-LAST:event_move2ButtonActionPerformed

    private void move3ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_move3ButtonActionPerformed
       ctr.addMove3Card();
        
        //Aggiungo immagine alla lista di carte scelte(programma)
        displayList.addElement(ctr.getMove3());
        jList1.setCellRenderer(new RegistrilRenderer());
        jList1.setModel(displayList);

    }//GEN-LAST:event_move3ButtonActionPerformed

    private void backUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backUpButtonActionPerformed
        ctr.addBackUpCard();
        
        //Aggiungo immagine alla lista di carte scelte(programma)
        displayList.addElement(ctr.getBackup());
        jList1.setCellRenderer(new RegistrilRenderer());
        jList1.setModel(displayList);

    }//GEN-LAST:event_backUpButtonActionPerformed

    private void turnRightButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_turnRightButtonActionPerformed
       ctr.addTurnRCard();
        
        //Aggiungo immagine alla lista di carte scelte(programma)
        displayList.addElement(ctr.getTurnR());
        jList1.setCellRenderer(new RegistrilRenderer());
        jList1.setModel(displayList);
    }//GEN-LAST:event_turnRightButtonActionPerformed

    private void uTurnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uTurnButtonActionPerformed
            ctr.addUTurnCard();
        
        //Aggiungo immagine alla lista di carte scelte(programma)
        displayList.addElement(ctr.getuTurn());
        jList1.setCellRenderer(new RegistrilRenderer());
        jList1.setModel(displayList);
    }//GEN-LAST:event_uTurnButtonActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel EastPanel;
    private javax.swing.JButton avviaProgrammaButton;
    private javax.swing.JButton backUpButton;
    private javax.swing.JDialog configRobodromo;
    private javax.swing.JDialog configRobot;
    private javax.swing.JComboBox<String> direzioneCombo;
    private javax.swing.JButton exitConfigRobot;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JList<ArrayList<Card>> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton move1Button;
    private javax.swing.JButton move2Button;
    private javax.swing.JButton move3Button;
    private javax.swing.JComboBox<String> nomeRobotCombo;
    private javax.swing.JButton okConfigAllenamento;
    private javax.swing.JButton okConfigRobot;
    private javax.swing.JButton piazzaRobot;
    private javax.swing.JTextField posX;
    private javax.swing.JTextField posY;
    private javax.swing.JButton riProgrammaButton;
    private javax.swing.JComboBox<String> robodromeCombo;
    private javax.swing.JButton scegliRobodromo;
    private javax.swing.JSplitPane splitPanel;
    private javax.swing.JButton turnLeftButton;
    private javax.swing.JButton turnRightButton;
    private javax.swing.JButton uTurnButton;
    // End of variables declaration//GEN-END:variables



    class RegistrilRenderer extends DefaultListCellRenderer implements ListCellRenderer<Object> {

        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            Card regImg = (Card) value;
            setIcon(new javax.swing.ImageIcon(regImg.getImage()));
            setEnabled(true);
            return this;
        }
    }
}
