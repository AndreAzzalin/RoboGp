package robogp.client.gui;

import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import main.mainFrame;
import robogp.client.GiocarePartitaController;
import robogp.logic.Logic;
import robogp.matchmanager.RobotMatch;
import robogp.robodrome.view.RobodromeView;

/**
 *
 * @author Andrea
 */
public class GuiGiocare extends javax.swing.JFrame {

    private String robotName;
    private String rbdName;
    boolean programma;

    private mainFrame mf;
    private RobodromeView rv;
    private Logic logic;
    private ArrayList<RobotMatch> robotMatchList;
    private GiocarePartitaController ctr;

    public GuiGiocare(GiocarePartitaController ctr) {
        this.ctr = ctr;
        initComponents();
        
        programma = false;
        //disailito tutte le tab per i robot personali

        for (int i = 0; i < 4; i++) {
            personalRbTab.setEnabledAt(i, false);
        }
        
        

    }

    public JLabel getRbAvvName1() {
        return rbAvvName1;
    }

    public JLabel getRbAvvName2() {
        return rbAvvName2;
    }

    public JLabel getRbAvvName3() {
        return rbAvvName3;
    }

    public JLabel getRbAvvName4() {
        return rbAvvName4;
    }

    public JLabel getRbAvvName5() {
        return rbAvvName5;
    }

    public JLabel getRbAvvName6() {
        return rbAvvName6;
    }

    public JLabel getRbAvvName7() {
        return rbAvvName7;
    }
    
    
    
    
    public JLabel getRbAvvLabel1() {
        return rbAvvLabel1;
    }

    public JLabel getRbAvvLabel2() {
        return rbAvvLabel2;
    }

    public JLabel getRbAvvLabel3() {
        return rbAvvLabel3;
    }

    public JLabel getRbAvvLabel4() {
        return rbAvvLabel4;
    }

    public JLabel getRbAvvLabel5() {
        return rbAvvLabel5;
    }

    public JLabel getRbAvvLabel6() {
        return rbAvvLabel6;
    }

    public JLabel getRbAvvLabel7() {
        return rbAvvLabel7;
    }

    public JLabel getRbAvvHp1() {
        return rbAvvHp1;
    }

    public JLabel getRbAvvHp2() {
        return rbAvvHp2;
    }

    public JLabel getRbAvvHp3() {
        return rbAvvHp3;
    }

    public JLabel getRbAvvHp4() {
        return rbAvvHp4;
    }

    public JLabel getRbAvvHp5() {
        return rbAvvHp5;
    }

    public JLabel getRbAvvHp6() {
        return rbAvvHp6;
    }

    public JLabel getRbAvvHp7() {
        return rbAvvHp7;
    }

    public JLabel getRbAvvNumVite1() {
        return rbAvvNumVite1;
    }

    public JLabel getRbAvvNumVite2() {
        return rbAvvNumVite2;
    }

    public JLabel getRbAvvNumVite3() {
        return rbAvvNumVite3;
    }

    public JLabel getRbAvvNumVite4() {
        return rbAvvNumVite4;
    }

    public JLabel getRbAvvNumVite5() {
        return rbAvvNumVite5;
    }

    public JLabel getRbAvvNumVite6() {
        return rbAvvNumVite6;
    }

    public JLabel getRbAvvNumVite7() {
        return rbAvvNumVite7;
    }

    

    

    public boolean isProgramma() {
        return programma;
    }

    public JLabel getHpLabelTab2() {
        return hpLabelTab2;
    }

    public JLabel getHpLabelTab3() {
        return hpLabelTab3;
    }

    public JLabel getHpLabelTab4() {
        return hpLabelTab4;
    }

    public JLabel getNumViteLabelTab2() {
        return numViteLabelTab2;
    }

    public JLabel getNumViteLabelTab3() {
        return numViteLabelTab3;
    }

    public JLabel getNumViteLabelTab4() {
        return numViteLabelTab4;
    }
    
    
    
    

    public JLabel getTitleLabel() {
        return titleLabel;
    }

    public JLabel getRbIconTab1() {
        return rbIconTab1;
    }


    public JLabel getRbIconTab2() {
        return rbIconTab2;
    }


    public JPanel getPerosnalRbTab1() {
        return perosnalRbTab1;
    }

    public JPanel getPerosnalRbTab3() {
        return perosnalRbTab3;
    }

    public JPanel getPerosnalRbTab4() {
        return perosnalRbTab4;
    }

    public JTextArea getPlPersonalTab3() {
        return plPersonalTab3;
    }



    public JTextArea getPlPersonalTab4() {
        return plPersonalTab4;
    }

    public JLabel getRbIconTab3() {
        return rbIconTab3;
    }

    public JLabel getRbIconTab4() {
        return rbIconTab4;
    }

    public JPanel getPerosnalRbTab2() {
        return perosnalRbTab2;
    }

    public JTextArea getPlPersonalTab2() {
        return plPersonalTab2;
    }

    public JLabel getHpLabelTab1() {
        return hpLabelTab1;
    }

    public JLabel getNumViteLabelTab1() {
        return numViteLabelTab1;
    }

  

    public JTextArea getLogRbAvversari() {
        return logRbAvversari;
    }

    public JTextArea getLogGiocare() {
        return logGiocare;
    }

    public JTextArea getPlPersonalTab1() {
        return plPersonalTab1;
    }

    public JTabbedPane getPersonalRbTab() {
        return personalRbTab;
    }

    public JSplitPane getSplitPanel() {
        return splitPanel;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        listIstruzioni = new javax.swing.JDialog();
        chiudiLogReg = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        logRbAvversari = new javax.swing.JTextArea();
        splitPanel = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        personalRbTab = new javax.swing.JTabbedPane();
        perosnalRbTab1 = new javax.swing.JPanel();
        rbIconTab1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        hpLabelTab1 = new javax.swing.JLabel();
        numViteLabelTab1 = new javax.swing.JLabel();
        programmaRb1 = new javax.swing.JButton();
        plPersonalTab1 = new javax.swing.JTextArea();
        perosnalRbTab2 = new javax.swing.JPanel();
        rbIconTab2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        hpLabelTab2 = new javax.swing.JLabel();
        numViteLabelTab2 = new javax.swing.JLabel();
        programmaRb2 = new javax.swing.JButton();
        plPersonalTab2 = new javax.swing.JTextArea();
        perosnalRbTab3 = new javax.swing.JPanel();
        rbIconTab3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        hpLabelTab3 = new javax.swing.JLabel();
        numViteLabelTab3 = new javax.swing.JLabel();
        programmaRb3 = new javax.swing.JButton();
        plPersonalTab3 = new javax.swing.JTextArea();
        perosnalRbTab4 = new javax.swing.JPanel();
        rbIconTab4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        hpLabelTab4 = new javax.swing.JLabel();
        numViteLabelTab4 = new javax.swing.JLabel();
        programmaRb4 = new javax.swing.JButton();
        plPersonalTab4 = new javax.swing.JTextArea();
        titleLabel = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        logGiocare = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        rbAvvPanel1 = new javax.swing.JPanel();
        rbAvvLabel1 = new javax.swing.JLabel();
        rbAvvHp1 = new javax.swing.JLabel();
        rbAvvNumVite1 = new javax.swing.JLabel();
        rbAvvName1 = new javax.swing.JLabel();
        rbAvvPanel2 = new javax.swing.JPanel();
        rbAvvLabel2 = new javax.swing.JLabel();
        rbAvvHp2 = new javax.swing.JLabel();
        rbAvvNumVite2 = new javax.swing.JLabel();
        rbAvvName2 = new javax.swing.JLabel();
        rbAvvPanel3 = new javax.swing.JPanel();
        rbAvvLabel3 = new javax.swing.JLabel();
        rbAvvHp3 = new javax.swing.JLabel();
        rbAvvNumVite3 = new javax.swing.JLabel();
        rbAvvName3 = new javax.swing.JLabel();
        rbAvvPanel4 = new javax.swing.JPanel();
        rbAvvLabel4 = new javax.swing.JLabel();
        rbAvvHp4 = new javax.swing.JLabel();
        rbAvvNumVite4 = new javax.swing.JLabel();
        rbAvvName4 = new javax.swing.JLabel();
        rbAvvPanel5 = new javax.swing.JPanel();
        rbAvvLabel5 = new javax.swing.JLabel();
        rbAvvHp5 = new javax.swing.JLabel();
        rbAvvNumVite5 = new javax.swing.JLabel();
        rbAvvName5 = new javax.swing.JLabel();
        rbAvvPanel6 = new javax.swing.JPanel();
        rbAvvLabel6 = new javax.swing.JLabel();
        rbAvvHp6 = new javax.swing.JLabel();
        rbAvvNumVite6 = new javax.swing.JLabel();
        rbAvvName6 = new javax.swing.JLabel();
        rbAvvPanel7 = new javax.swing.JPanel();
        rbAvvLabel7 = new javax.swing.JLabel();
        rbAvvHp7 = new javax.swing.JLabel();
        rbAvvNumVite7 = new javax.swing.JLabel();
        rbAvvName7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        listIstruzioni.setMinimumSize(new java.awt.Dimension(400, 400));
        listIstruzioni.setName("listIstruzioni"); // NOI18N

        chiudiLogReg.setText("Chiudi");
        chiudiLogReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chiudiLogRegActionPerformed(evt);
            }
        });

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("REGISTRI IN ESECUZIONE");

        logRbAvversari.setColumns(20);
        logRbAvversari.setRows(5);
        jScrollPane5.setViewportView(logRbAvversari);

        javax.swing.GroupLayout listIstruzioniLayout = new javax.swing.GroupLayout(listIstruzioni.getContentPane());
        listIstruzioni.getContentPane().setLayout(listIstruzioniLayout);
        listIstruzioniLayout.setHorizontalGroup(
            listIstruzioniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(listIstruzioniLayout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(chiudiLogReg, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(148, Short.MAX_VALUE))
            .addGroup(listIstruzioniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(listIstruzioniLayout.createSequentialGroup()
                    .addGap(81, 81, 81)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(84, Short.MAX_VALUE)))
        );
        listIstruzioniLayout.setVerticalGroup(
            listIstruzioniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listIstruzioniLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 268, Short.MAX_VALUE)
                .addComponent(chiudiLogReg)
                .addGap(23, 23, 23))
            .addGroup(listIstruzioniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(listIstruzioniLayout.createSequentialGroup()
                    .addGap(58, 58, 58)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(81, Short.MAX_VALUE)))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Giocare");
        setBackground(new java.awt.Color(0, 0, 0));

        jPanel1.setLayout(new java.awt.GridLayout(4, 10));
        splitPanel.setLeftComponent(jPanel1);

        jPanel2.setLayout(new java.awt.GridLayout(1, 7));

        perosnalRbTab1.setLayout(new java.awt.GridLayout(1, 4, 50, 20));
        perosnalRbTab1.add(rbIconTab1);

        hpLabelTab1.setText("hp");

        numViteLabelTab1.setText("NumVite");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(hpLabelTab1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(numViteLabelTab1, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(hpLabelTab1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(numViteLabelTab1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        perosnalRbTab1.add(jPanel4);

        programmaRb1.setText("Programma Robot");
        programmaRb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                programmaRb1ActionPerformed(evt);
            }
        });
        perosnalRbTab1.add(programmaRb1);

        plPersonalTab1.setColumns(20);
        plPersonalTab1.setRows(5);
        plPersonalTab1.setMaximumSize(new java.awt.Dimension(160, 75));
        perosnalRbTab1.add(plPersonalTab1);

        personalRbTab.addTab("", perosnalRbTab1);

        perosnalRbTab2.setLayout(new java.awt.GridLayout(1, 4, 50, 0));
        perosnalRbTab2.add(rbIconTab2);

        hpLabelTab2.setText("hp");

        numViteLabelTab2.setText("NumVite");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hpLabelTab2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(numViteLabelTab2, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(hpLabelTab2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(numViteLabelTab2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        perosnalRbTab2.add(jPanel3);

        programmaRb2.setText("Programma Robot");
        programmaRb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                programmaRb2ActionPerformed(evt);
            }
        });
        perosnalRbTab2.add(programmaRb2);

        plPersonalTab2.setColumns(20);
        plPersonalTab2.setRows(5);
        perosnalRbTab2.add(plPersonalTab2);

        personalRbTab.addTab("", perosnalRbTab2);

        perosnalRbTab3.setLayout(new java.awt.GridLayout(1, 3, 50, 0));
        perosnalRbTab3.add(rbIconTab3);

        hpLabelTab3.setText("hp");

        numViteLabelTab3.setText("NumVite");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hpLabelTab3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(numViteLabelTab3, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(hpLabelTab3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(numViteLabelTab3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        perosnalRbTab3.add(jPanel5);

        programmaRb3.setText("Programma Robot");
        programmaRb3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                programmaRb3ActionPerformed(evt);
            }
        });
        perosnalRbTab3.add(programmaRb3);

        plPersonalTab3.setColumns(20);
        plPersonalTab3.setRows(5);
        perosnalRbTab3.add(plPersonalTab3);

        personalRbTab.addTab("", perosnalRbTab3);

        perosnalRbTab4.setLayout(new java.awt.GridLayout(1, 4, 50, 0));
        perosnalRbTab4.add(rbIconTab4);

        hpLabelTab4.setText("hp");

        numViteLabelTab4.setText("NumVite");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(numViteLabelTab4, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(hpLabelTab4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(hpLabelTab4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(numViteLabelTab4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        perosnalRbTab4.add(jPanel6);

        programmaRb4.setText("Programma Robot");
        programmaRb4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                programmaRb4ActionPerformed(evt);
            }
        });
        perosnalRbTab4.add(programmaRb4);

        plPersonalTab4.setColumns(20);
        plPersonalTab4.setRows(5);
        perosnalRbTab4.add(plPersonalTab4);

        personalRbTab.addTab("", perosnalRbTab4);

        jPanel2.add(personalRbTab);

        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        logGiocare.setColumns(20);
        logGiocare.setRows(5);
        jScrollPane4.setViewportView(logGiocare);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("LOG PARTITA");

        jPanel7.setMaximumSize(new java.awt.Dimension(200, 800));
        jPanel7.setMinimumSize(new java.awt.Dimension(200, 800));
        jPanel7.setPreferredSize(new java.awt.Dimension(200, 800));
        jPanel7.setLayout(new java.awt.GridLayout(7, 0));

        rbAvvPanel1.setMaximumSize(new java.awt.Dimension(150, 150));
        rbAvvPanel1.setMinimumSize(new java.awt.Dimension(150, 150));
        rbAvvPanel1.setPreferredSize(new java.awt.Dimension(150, 150));

        rbAvvName1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout rbAvvPanel1Layout = new javax.swing.GroupLayout(rbAvvPanel1);
        rbAvvPanel1.setLayout(rbAvvPanel1Layout);
        rbAvvPanel1Layout.setHorizontalGroup(
            rbAvvPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rbAvvPanel1Layout.createSequentialGroup()
                .addGroup(rbAvvPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rbAvvPanel1Layout.createSequentialGroup()
                        .addComponent(rbAvvLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(rbAvvPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbAvvNumVite1, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(rbAvvHp1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(rbAvvPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(rbAvvName1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        rbAvvPanel1Layout.setVerticalGroup(
            rbAvvPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rbAvvPanel1Layout.createSequentialGroup()
                .addComponent(rbAvvName1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(rbAvvPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbAvvLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(rbAvvPanel1Layout.createSequentialGroup()
                        .addComponent(rbAvvHp1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(rbAvvNumVite1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        jPanel7.add(rbAvvPanel1);

        rbAvvName2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout rbAvvPanel2Layout = new javax.swing.GroupLayout(rbAvvPanel2);
        rbAvvPanel2.setLayout(rbAvvPanel2Layout);
        rbAvvPanel2Layout.setHorizontalGroup(
            rbAvvPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rbAvvPanel2Layout.createSequentialGroup()
                .addGroup(rbAvvPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rbAvvPanel2Layout.createSequentialGroup()
                        .addComponent(rbAvvLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(rbAvvPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbAvvHp2, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(rbAvvNumVite2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(rbAvvPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(rbAvvName2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        rbAvvPanel2Layout.setVerticalGroup(
            rbAvvPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rbAvvPanel2Layout.createSequentialGroup()
                .addComponent(rbAvvName2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(rbAvvPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rbAvvPanel2Layout.createSequentialGroup()
                        .addComponent(rbAvvHp2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbAvvNumVite2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(rbAvvLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.add(rbAvvPanel2);

        rbAvvName3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout rbAvvPanel3Layout = new javax.swing.GroupLayout(rbAvvPanel3);
        rbAvvPanel3.setLayout(rbAvvPanel3Layout);
        rbAvvPanel3Layout.setHorizontalGroup(
            rbAvvPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rbAvvPanel3Layout.createSequentialGroup()
                .addGroup(rbAvvPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rbAvvPanel3Layout.createSequentialGroup()
                        .addComponent(rbAvvLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(rbAvvPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbAvvNumVite3, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(rbAvvHp3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(rbAvvPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(rbAvvName3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        rbAvvPanel3Layout.setVerticalGroup(
            rbAvvPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rbAvvPanel3Layout.createSequentialGroup()
                .addComponent(rbAvvName3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(rbAvvPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rbAvvPanel3Layout.createSequentialGroup()
                        .addComponent(rbAvvHp3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbAvvNumVite3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(rbAvvLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.add(rbAvvPanel3);

        rbAvvName4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout rbAvvPanel4Layout = new javax.swing.GroupLayout(rbAvvPanel4);
        rbAvvPanel4.setLayout(rbAvvPanel4Layout);
        rbAvvPanel4Layout.setHorizontalGroup(
            rbAvvPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rbAvvPanel4Layout.createSequentialGroup()
                .addGroup(rbAvvPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rbAvvPanel4Layout.createSequentialGroup()
                        .addComponent(rbAvvLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(rbAvvPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbAvvNumVite4, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(rbAvvHp4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(rbAvvPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(rbAvvName4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        rbAvvPanel4Layout.setVerticalGroup(
            rbAvvPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rbAvvPanel4Layout.createSequentialGroup()
                .addComponent(rbAvvName4, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(rbAvvPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rbAvvPanel4Layout.createSequentialGroup()
                        .addComponent(rbAvvHp4, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbAvvNumVite4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(rbAvvLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.add(rbAvvPanel4);

        rbAvvName5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout rbAvvPanel5Layout = new javax.swing.GroupLayout(rbAvvPanel5);
        rbAvvPanel5.setLayout(rbAvvPanel5Layout);
        rbAvvPanel5Layout.setHorizontalGroup(
            rbAvvPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rbAvvPanel5Layout.createSequentialGroup()
                .addGroup(rbAvvPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rbAvvPanel5Layout.createSequentialGroup()
                        .addComponent(rbAvvLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(rbAvvPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbAvvHp5, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(rbAvvNumVite5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(rbAvvPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(rbAvvName5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        rbAvvPanel5Layout.setVerticalGroup(
            rbAvvPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rbAvvPanel5Layout.createSequentialGroup()
                .addComponent(rbAvvName5, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(rbAvvPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rbAvvPanel5Layout.createSequentialGroup()
                        .addComponent(rbAvvHp5, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbAvvNumVite5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(rbAvvLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.add(rbAvvPanel5);

        rbAvvName6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout rbAvvPanel6Layout = new javax.swing.GroupLayout(rbAvvPanel6);
        rbAvvPanel6.setLayout(rbAvvPanel6Layout);
        rbAvvPanel6Layout.setHorizontalGroup(
            rbAvvPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rbAvvPanel6Layout.createSequentialGroup()
                .addGroup(rbAvvPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rbAvvPanel6Layout.createSequentialGroup()
                        .addComponent(rbAvvLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(rbAvvPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbAvvHp6, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(rbAvvNumVite6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(rbAvvPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(rbAvvName6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        rbAvvPanel6Layout.setVerticalGroup(
            rbAvvPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rbAvvPanel6Layout.createSequentialGroup()
                .addComponent(rbAvvName6, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(rbAvvPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rbAvvPanel6Layout.createSequentialGroup()
                        .addComponent(rbAvvHp6, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbAvvNumVite6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(rbAvvLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.add(rbAvvPanel6);

        rbAvvName7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout rbAvvPanel7Layout = new javax.swing.GroupLayout(rbAvvPanel7);
        rbAvvPanel7.setLayout(rbAvvPanel7Layout);
        rbAvvPanel7Layout.setHorizontalGroup(
            rbAvvPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rbAvvPanel7Layout.createSequentialGroup()
                .addGroup(rbAvvPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rbAvvPanel7Layout.createSequentialGroup()
                        .addComponent(rbAvvLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(rbAvvPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(rbAvvPanel7Layout.createSequentialGroup()
                                .addComponent(rbAvvHp7, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 59, Short.MAX_VALUE))
                            .addComponent(rbAvvNumVite7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(rbAvvPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(rbAvvName7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        rbAvvPanel7Layout.setVerticalGroup(
            rbAvvPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rbAvvPanel7Layout.createSequentialGroup()
                .addComponent(rbAvvName7, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(rbAvvPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rbAvvPanel7Layout.createSequentialGroup()
                        .addComponent(rbAvvHp7, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbAvvNumVite7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(rbAvvLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.add(rbAvvPanel7);

        jButton1.setText("Mostra registri in esecuzione");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(splitPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 732, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 732, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(750, 750, 750)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(splitPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(46, 46, 46)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(175, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void programmaRb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_programmaRb1ActionPerformed
       ctr.getCardChooserRb1().setVisible(true);
      programmaRb1.setEnabled(false);
    }//GEN-LAST:event_programmaRb1ActionPerformed

    private void programmaRb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_programmaRb2ActionPerformed
       ctr.getCardChooserRb2().setVisible(true);
       programmaRb2.setEnabled(false);
    }//GEN-LAST:event_programmaRb2ActionPerformed

    private void programmaRb3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_programmaRb3ActionPerformed
        ctr.getCardChooserRb3().setVisible(true);
        programmaRb3.setEnabled(false);
    }//GEN-LAST:event_programmaRb3ActionPerformed

    private void programmaRb4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_programmaRb4ActionPerformed
        ctr.getCardChooserRb4().setVisible(true);
         programmaRb4.setEnabled(false);
    }//GEN-LAST:event_programmaRb4ActionPerformed

    private void chiudiLogRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chiudiLogRegActionPerformed
      listIstruzioni.setVisible(false);
    }//GEN-LAST:event_chiudiLogRegActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       listIstruzioni.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton chiudiLogReg;
    private javax.swing.JLabel hpLabelTab1;
    private javax.swing.JLabel hpLabelTab2;
    private javax.swing.JLabel hpLabelTab3;
    private javax.swing.JLabel hpLabelTab4;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JDialog listIstruzioni;
    private javax.swing.JTextArea logGiocare;
    private javax.swing.JTextArea logRbAvversari;
    private javax.swing.JLabel numViteLabelTab1;
    private javax.swing.JLabel numViteLabelTab2;
    private javax.swing.JLabel numViteLabelTab3;
    private javax.swing.JLabel numViteLabelTab4;
    private javax.swing.JPanel perosnalRbTab1;
    private javax.swing.JPanel perosnalRbTab2;
    private javax.swing.JPanel perosnalRbTab3;
    private javax.swing.JPanel perosnalRbTab4;
    private javax.swing.JTabbedPane personalRbTab;
    private javax.swing.JTextArea plPersonalTab1;
    private javax.swing.JTextArea plPersonalTab2;
    private javax.swing.JTextArea plPersonalTab3;
    private javax.swing.JTextArea plPersonalTab4;
    private javax.swing.JButton programmaRb1;
    private javax.swing.JButton programmaRb2;
    private javax.swing.JButton programmaRb3;
    private javax.swing.JButton programmaRb4;
    private javax.swing.JLabel rbAvvHp1;
    private javax.swing.JLabel rbAvvHp2;
    private javax.swing.JLabel rbAvvHp3;
    private javax.swing.JLabel rbAvvHp4;
    private javax.swing.JLabel rbAvvHp5;
    private javax.swing.JLabel rbAvvHp6;
    private javax.swing.JLabel rbAvvHp7;
    private javax.swing.JLabel rbAvvLabel1;
    private javax.swing.JLabel rbAvvLabel2;
    private javax.swing.JLabel rbAvvLabel3;
    private javax.swing.JLabel rbAvvLabel4;
    private javax.swing.JLabel rbAvvLabel5;
    private javax.swing.JLabel rbAvvLabel6;
    private javax.swing.JLabel rbAvvLabel7;
    private javax.swing.JLabel rbAvvName1;
    private javax.swing.JLabel rbAvvName2;
    private javax.swing.JLabel rbAvvName3;
    private javax.swing.JLabel rbAvvName4;
    private javax.swing.JLabel rbAvvName5;
    private javax.swing.JLabel rbAvvName6;
    private javax.swing.JLabel rbAvvName7;
    private javax.swing.JLabel rbAvvNumVite1;
    private javax.swing.JLabel rbAvvNumVite2;
    private javax.swing.JLabel rbAvvNumVite3;
    private javax.swing.JLabel rbAvvNumVite4;
    private javax.swing.JLabel rbAvvNumVite5;
    private javax.swing.JLabel rbAvvNumVite6;
    private javax.swing.JLabel rbAvvNumVite7;
    private javax.swing.JPanel rbAvvPanel1;
    private javax.swing.JPanel rbAvvPanel2;
    private javax.swing.JPanel rbAvvPanel3;
    private javax.swing.JPanel rbAvvPanel4;
    private javax.swing.JPanel rbAvvPanel5;
    private javax.swing.JPanel rbAvvPanel6;
    private javax.swing.JPanel rbAvvPanel7;
    private javax.swing.JLabel rbIconTab1;
    private javax.swing.JLabel rbIconTab2;
    private javax.swing.JLabel rbIconTab3;
    private javax.swing.JLabel rbIconTab4;
    private javax.swing.JSplitPane splitPanel;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables

  
    

}
