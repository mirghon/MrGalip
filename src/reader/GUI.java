package reader;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

import java.util.Timer;
import java.util.TimerTask;

/*
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
*/

public class GUI extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private boolean activeStatus=false;
/*	Galip galip = new Galip();

    public boolean getStatus() {
		return activeStatus;
	}

	public void setStatus(boolean status) {
		this.activeStatus = status;
	}
*/
	public GUI() {
        initComponents();
    }

    private void initComponents() {
    	
		BufferedImage icon = null;
		try {
			icon = ImageIO.read((new File("Resources/icon.png")));
		} catch (IOException e) {e.printStackTrace();}

        Panel = new javax.swing.JPanel();
        Label1 = new javax.swing.JLabel();
        Label2 = new javax.swing.JLabel();
        Button2 = new javax.swing.JButton();
        Button3 = new javax.swing.JButton();
        ToggleButton = new javax.swing.JToggleButton();
        ScrollPane = new javax.swing.JScrollPane();
        LogPane = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mr. Galip");
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImage(icon);
        setPreferredSize(new java.awt.Dimension(500, 300));

        Panel.setPreferredSize(new java.awt.Dimension(500, 300));
        Panel.setRequestFocusEnabled(false);

        Label1.setText("Mr. Galip nimmt Dir die Codeeingabe des CC-Launchers ab.");

        Label2.setBackground(new java.awt.Color(255, 255, 255));
        Label2.setText("Automatische Abfrageerkennung ist AUS.");

        ToggleButton.setText("Start");
        ToggleButton.setToolTipText("Automatische Abfrageerkennung an- / ausschalten");
        ToggleButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ToggleButtonMouseClicked(evt);
            }
        });
        ToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ToggleButtonActionPerformed(evt);
            }
        });
        
        Button2.setText("Test");
        Button2.setToolTipText("Einmalige Abfrageerkennung");
        Button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button2ActionPerformed(evt);
            }
        });

        Button3.setText("Log Speichern");
        Button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button3ActionPerformed(evt);
            }
        });


        ScrollPane.setViewportView(LogPane);

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addComponent(Label1, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                .addGap(157, 157, 157))
            .addComponent(Label2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanelLayout.createSequentialGroup()
                .addComponent(ToggleButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Button2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Button3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(ScrollPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addComponent(Label1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ToggleButton)
                    .addComponent(Button2)
                    .addComponent(Button3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Label2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED/*, 37, Short.MAX_VALUE*/)
                .addComponent(ScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    	MessageConsole console = new MessageConsole(LogPane);
    	console.redirectOut();
    	console.redirectErr(Color.RED, null);


        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ToggleButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ToggleButtonMouseClicked
/*        if (activeStatus) {
            activeStatus=false;
            ToggleButton1.setText("Aus");
            Label2.setText("Mr. Galip ist AUS.");
        } else {
            activeStatus=true;
            ToggleButton1.setText("Ein");
            Label2.setText("Mr. Galip ist AKTIV.");
        }
*/
    }//GEN-LAST:event_ToggleButtonMouseClicked

    private void ToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ToggleButtonActionPerformed

		if (!activeStatus) {
            activeStatus=true;
//          galip.setStatus(true);
            ToggleButton.setText("Stop");
            Label2.setText("Automatische Abfrageerkennung ist AKTIV.");
			Start.log("Codeerkennung gestartet");
			try{timer.scheduleAtFixedRate(pingcheck,0,5000);} catch (Exception e) {Start.err("Ausnahmefehler UI:174 - Erkennungsmodus ist bereits aktiv");}
            
        } else {
            activeStatus=false;
            ToggleButton.setText("Start");
            Label2.setText("Automatische Abfrageerkennungist AUS.");
            try{timer.purge();} catch (Exception e) {Start.err("Ausnahmefehler UI:180 - Erkennungsmodus konnte nicht deaktiviert werden");}
            Start.log("Codeerkennung gestoppt");
        }
    }//GEN-LAST:event_ToggleButtonActionPerformed

    private void Button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button2ActionPerformed
        Screenbot.solveCode(false);
    }//GEN-LAST:event_Button2ActionPerformed

    private void Button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button3ActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save as...");
        int userSelection = fileChooser.showSaveDialog(LogPane);
        if (userSelection == fileChooser.APPROVE_OPTION) {
        	File fileToSave = fileChooser.getSelectedFile();
		try (
			FileWriter writer = new FileWriter(fileToSave);
			BufferedWriter bw = new BufferedWriter(writer)) {
				bw.write(LogPane.getText());
				bw.close();
		} catch (IOException e) {Start.err("Fehler beim Speichern der Datei");}
        }

    }//GEN-LAST:event_Button3ActionPerformed

    //GEN-BEGIN:variables
	private javax.swing.JToggleButton ToggleButton;
    private javax.swing.JButton Button2;
    private javax.swing.JButton Button3;
    private javax.swing.JLabel Label1;
    private javax.swing.JLabel Label2;
    private javax.swing.JPanel Panel;
    private javax.swing.JScrollPane ScrollPane;
    private javax.swing.JTextPane LogPane;
	Timer timer = new Timer(true);
	TimerTask pingcheck = new Daemon();
//	Daemon galip = new Daemon();
	
    //GEN-END:variables
}
