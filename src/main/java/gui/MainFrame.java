/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ApplicationStuff.DataBase;

/**
 * A főmenű ablakáért felelős osztály.
 * 
 * @author István
 */
public class MainFrame extends javax.swing.JFrame {
	/**
     * Logger objektum létrehozása a loggoláshoz.
     */
	 protected static Logger logger = LoggerFactory.getLogger(DataBase.class);

/**
 * A fő ablak konstruktora.    
 */
    public MainFrame() {
        initComponents();
    }
/**
 * Inicializálja az ablakot.
 */
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JButtons = new javax.swing.JPanel();
        newTravelDiary = new javax.swing.JButton();
        dataBaseViewer = new javax.swing.JButton();
        exit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Travel Diary");
        setBounds(new java.awt.Rectangle(200, 200, 400, 300));
        setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 10)); // NOI18N
        setResizable(false);

        newTravelDiary.setText("New Travel Diary");
        newTravelDiary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newTravelDiaryActionPerformed(evt);
            }
        });

        dataBaseViewer.setText("Travel Dairy Database");
        dataBaseViewer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataBaseViewerActionPerformed(evt);
            }
        });

        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JButtonsLayout = new javax.swing.GroupLayout(JButtons);
        JButtons.setLayout(JButtonsLayout);
        JButtonsLayout.setHorizontalGroup(
            JButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JButtonsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dataBaseViewer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                    .addComponent(newTravelDiary, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(exit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        JButtonsLayout.setVerticalGroup(
            JButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JButtonsLayout.createSequentialGroup()
                .addComponent(newTravelDiary, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dataBaseViewer, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(exit)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(JButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(80, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addComponent(JButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
/**
 * A gomb megjeleníti az adatbázis áttekintő programot.
 * 
 * @param evt A kiváltó esemény.
 */
    private void dataBaseViewerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataBaseViewerActionPerformed
        new DataBaseViewer().setVisible(true);
        logger.info("Database viewer is created");
    }//GEN-LAST:event_dataBaseViewerActionPerformed

    /**
     * A gomb megjeleníti az új utazási napló ablakot.
     * 
     * @param evt A kiváltó esemény.
     */
    private void newTravelDiaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newTravelDiaryActionPerformed
         new TravelDiaryWindow().setVisible(true); 
         logger.info("Travel diary window is created");
    }//GEN-LAST:event_newTravelDiaryActionPerformed
/**
 * A kilépés és adatbázis lezárás.
 * 
 * @param evt A kiváltó esemény.
 */
    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
         DataBase.close();
         logger.info("Main frame is closed");
        System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

   /**
    * A programot indító main metódus.
    * 
    * @param args A main argumetumai.
    */
    public static void main(String args[]) {
      
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        DataBase.connection();
        DataBase.createTable();
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
        logger.info("Main Frame is created");
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
	/**
	* A gombokat tároló panel.
	*/
    private javax.swing.JPanel JButtons;
	/**
	* Adatbázis áttekintő gombja.
	*/
    private javax.swing.JButton dataBaseViewer;
	/**
	* A kilépés gomb.
	*/
    private javax.swing.JButton exit;
	/**
	* Az új napló bejegyzés gombja.
	*/
    private javax.swing.JButton newTravelDiary;
    // End of variables declaration//GEN-END:variables
}
