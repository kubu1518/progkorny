/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import ApplicationStuff.DataBase;
import ApplicationStuff.Journey;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ApplicationStuff.Support;

/**
 * Naplózó felület. Itt adjuk meg a napokhoz tartozó bejegyzéseket.
 * 
 * @author Rosti
 */
public class DiaryWindow extends javax.swing.JFrame {
    /**
     * Logger objektum létrehozása naplózáshoz.
     */
    protected static Logger logger = LoggerFactory.getLogger(DataBase.class);
/**
 * Egy utazás objektumhoz tartozó referencia változó.
 */
    protected Journey nj;
            
   /**
    * Az naplózó felület konstruktora. Itt kapja meg az utazás általános adatait
    * az adatokat bekérő ablakotól.
    * 
    * @param name Az utazás neve.
    * @param date1 Az utazás kezdő dátuma.
    * @param date2 Az utazás végének dátuma.
    * @param type Az utazás típusa.
    */
    public DiaryWindow(String name, DateTime date1, DateTime date2, String type) {
        nj = new Journey(name, date1, date2, type);
        initComponents();
        
    }
    
   

    /**
     * Az ablak inicializálása.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        daysScrollPanel = new javax.swing.JScrollPane();
        daysList = new javax.swing.JList();
        finishJButton = new javax.swing.JButton();
        dairyTextScrollPanel = new javax.swing.JScrollPane();
        dairyText = new javax.swing.JTextArea();
        SaveJButton = new javax.swing.JButton();
        journeyNameLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(nj.getJourneyName());

        daysList.setModel(new javax.swing.DefaultComboBoxModel(Support.daysOfJourney(nj)));
        daysList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        daysList.setSelectedIndex(0);
        daysList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                daysListMouseClicked(evt);
            }
        });
        daysScrollPanel.setViewportView(daysList);

        finishJButton.setText("Finish");
        finishJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finishJButtonActionPerformed(evt);
            }
        });

        dairyText.setColumns(20);
        dairyText.setLineWrap(true);
        dairyText.setRows(5);
        dairyText.setWrapStyleWord(true);
        dairyTextScrollPanel.setViewportView(dairyText);

        SaveJButton.setText("Save " + daysList.getSelectedValue().toString());
        SaveJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveJButtonActionPerformed(evt);
            }
        });

        journeyNameLabel.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        journeyNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        journeyNameLabel.setText(nj.getJourneyName() +" - "+ nj.getTypeOfTravel());
        journeyNameLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel1.setText("Please, describe Your journey in a few lines!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(daysScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(journeyNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(SaveJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                                .addComponent(finishJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(dairyTextScrollPanel))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(journeyNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(dairyTextScrollPanel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SaveJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(finishJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(daysScrollPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
/**
 * A napok listáján egy napra kattintva szerkeszthetjük a naphoz tartozó bejegyzést. 
 * 
 * @param evt A kiváltó esemény.
 */
    private void daysListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_daysListMouseClicked
        if (evt.getClickCount() == 1) {
          int index = daysList.locationToIndex(evt.getPoint());
          if (index >= 0) {
              dairyText.setText(nj.getaPageOfActualJourney()[index]);
              daysList.setSelectedIndex(index);
              SaveJButton.setText("Save " + daysList.getSelectedValue());
            
          }
        }
    }//GEN-LAST:event_daysListMouseClicked
/**
 * Az aktuális naphoz tartozó bejegyzés mentése.
 * 
 * @param evt A kiváltó esemény.
 */
    private void SaveJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveJButtonActionPerformed
        
        if(!dairyText.getText().equals("")){
             nj.getaPageOfActualJourney()[daysList.getSelectedIndex()] = dairyText.getText();
             logger.info("Save is succes: " + (daysList.getSelectedIndex()+1));
        }
        
    }//GEN-LAST:event_SaveJButtonActionPerformed
/**
 * Egy utazáshoz tartozó napló elfogadása, adatbázisba való feltöltés.
 * 
 * @param evt A kiváltó esemény.
 */
    private void finishJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finishJButtonActionPerformed
        
        nj.sendToDatabase();
        logger.info("Actual diary is sent to Database");
        this.dispose();
        
    }//GEN-LAST:event_finishJButtonActionPerformed
    
   
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
	/**
	*Mentés gomb.
	*/
    private javax.swing.JButton SaveJButton;
	/**
	*Egy naphoz tartozó bejegyzés.
	*/
    private javax.swing.JTextArea dairyText;
	/**
	* Bejegyzés szövegének gördítő panele.
	*/
    private javax.swing.JScrollPane dairyTextScrollPanel;
	/**
	*Napok listája.
	*/
    private javax.swing.JList daysList;
	/**
	*Napok listájának gördítő panele.
	*/
    private javax.swing.JScrollPane daysScrollPanel;
	/**
	* Befejezés gomb.
	*/
    private javax.swing.JButton finishJButton;
	/**
	* Utazás típusa címke.
	*/
    private javax.swing.JLabel jLabel1;
	/**
	* Utazás neve címke.
	*/
    private javax.swing.JLabel journeyNameLabel;
	
    // End of variables declaration//GEN-END:variables
}
