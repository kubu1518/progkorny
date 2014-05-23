/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import ApplicationStuff.DataBase;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * Az adatbázis áttekintő ablak osztálya.
 *
 * @author Rosti
 */
public class DataBaseViewer extends javax.swing.JFrame {
    /**
     * Logger objektum létrehozása naplózáshoz.
     */
    
	protected static Logger logger = LoggerFactory.getLogger(DataBase.class);

   /**
    * Az adatbázis áttekintő konstruktora.
    */
    public DataBaseViewer() {
        initComponents();
    }

    /**
     * Az ablak inicializálása.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ViewerScrollPane = new javax.swing.JScrollPane();
        ViewerTextArae = new javax.swing.JTextArea();
        DiaryComboBox = new javax.swing.JComboBox();
        deleteButton = new javax.swing.JButton();
        infLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        ViewerTextArae.setEditable(false);
        ViewerTextArae.setColumns(20);
        ViewerTextArae.setLineWrap(true);
        ViewerTextArae.setRows(5);
        ViewerTextArae.setText(DataBase.viewerContentFiller(1));
        ViewerTextArae.setWrapStyleWord(true);
        ViewerScrollPane.setViewportView(ViewerTextArae);

        DiaryComboBox.setModel(new javax.swing.DefaultComboBoxModel(DataBase.nameCollector()));
        DiaryComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DiaryComboBoxActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete");
        deleteButton.setToolTipText("Delete the actual selected journey.");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        infLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        infLabel.setText("Please, choose a diary!");
        infLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(DiaryComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                    .addComponent(infLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(ViewerScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(infLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ViewerScrollPane)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(DiaryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 313, Short.MAX_VALUE)
                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
/**
 * A utazásokhoz tartozó naplóbejegyzések ablakát frissíti.
 * 
 * @param evt A kiváltó esemény.
 */
    private void DiaryComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DiaryComboBoxActionPerformed
        ViewerTextArae.setText(DataBase.viewerContentFiller(DiaryComboBox.getSelectedIndex() + 1));
    }//GEN-LAST:event_DiaryComboBoxActionPerformed
/**
 * A törlés végzi. Egy megerősítő ablakot is felhoz törlés előtt.
 * 
 * @param evt A kiváltó esemény.
 */
    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int n = JOptionPane.showConfirmDialog(
                this,
                "Would you like to delete the actual journey definitively?",
                "Delete",
                JOptionPane.YES_NO_OPTION);
        
        if (n == 0) {
            DiaryComboBox.setModel(new DefaultComboBoxModel(DataBase.deleteFromDatabase(DiaryComboBox.getSelectedIndex() + 1)));
            ViewerTextArae.setText(DataBase.viewerContentFiller(DiaryComboBox.getSelectedIndex() + 1));
            logger.info("A diary was deleted");
        }
    }//GEN-LAST:event_deleteButtonActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
	/**
	* Az utazások nevei.
	*/
    private javax.swing.JComboBox DiaryComboBox;
	/**
	* A naplóbejegyezéseket megjelenítő gördítő panel.
	*/
    private javax.swing.JScrollPane ViewerScrollPane;
	/**
	* Naplóbejegyzéseket jelenít meg.
	*/
    private javax.swing.JTextArea ViewerTextArae;
	/**
	* Törlő gomb.
	*/
    private javax.swing.JButton deleteButton;
	/**
	* Információs sáv.
	*/
    private javax.swing.JLabel infLabel;
    // End of variables declaration//GEN-END:variables
}
