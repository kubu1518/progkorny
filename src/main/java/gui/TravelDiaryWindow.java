package gui;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ApplicationStuff.DataBase;
import ApplicationStuff.Support;


/**
 * Az utazási napló alapvető adatait kéri be.
 *
 * @author István
 */
public class TravelDiaryWindow extends javax.swing.JFrame {
	/**
	 * Logger objektum létrehozása a loggoláshoz.
	 */
    protected static Logger logger = LoggerFactory.getLogger(DataBase.class);

/**
 * Az adatokat bekérő ablak konstruktora.
 */
  
    public TravelDiaryWindow() {
        initComponents();
    }

  
 
/**
 * Veszi az utazás nevét a szövegmezőből.
 * 
 * @return A mezőben lévő szöveg.
 */
    public String getJorneyTextField() {
        return jorneyTextField.getText();
    }
/**
 * Veszi a az utazás kezdő dátumának hónapját.
 * 
 * @return Az utazás kezdő dátumának hónapja.
 */
    public int getMonthComboBox() {
        return monthComboBox.getSelectedIndex() + 1;
    }
/**
 * Veszi az utazás végének a hónapját.
 * 
 * @return A hónap.
 */
    public int getMonthComboBox1() {
        return monthComboBox1.getSelectedIndex() + 1;
    }
    /**
 * Veszi a az utazás kezdő dátumának napját.
 * 
 * @return A nap.
 */

    public int getDayComboBox() {
        return dayComboBox.getSelectedIndex() + 1;
    }
   
 /**
 * Veszi a az utazás végének a napját.
 * 
 * @return A nap.
 */

    public int getDayComboBox1() {
        return dayComboBox1.getSelectedIndex() + 1;
    }
    
    /**
 * Veszi az utazás kezdő dátumának évét.
 * 
 * @return Az év.
 */

    public int getYearComboBox() {
        return Integer.parseInt(yearComboBox.getSelectedItem().toString());
    }

      /**
 * Veszi az utazás végének az évét.
 * 
 * @return Az év.
 */
    public int getYearComboBox1() {
        return Integer.parseInt(yearComboBox1.getSelectedItem().toString());
    }

    /**
     * Veszi az utazás típusát, feltéve, ha be van jelölve az egyik radiogomb,
     * egyébként nullal tér vissza.
     * 
     * @return Az utazás típusa.
     */
    public String getTravelTypeRadioButtom() {
        if (travelTypeRadioButtomBus.isSelected()) {
            return travelTypeRadioButtomBus.getText();
        } else if (travelTypeRadioButtomHol.isSelected()) {
            return travelTypeRadioButtomHol.getText();
        } else {
            return null;
        }
    }
    
    /**
     * Az ablak inicializálása.
     */

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        typeButGroup = new javax.swing.ButtonGroup();
        jorneyLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        typeLabel = new javax.swing.JLabel();
        jorneyTextField = new javax.swing.JTextField();
        fromLabel = new javax.swing.JLabel();
        monthComboBox = new javax.swing.JComboBox();
        dayComboBox = new javax.swing.JComboBox();
        yearComboBox = new javax.swing.JComboBox();
        toLabel = new javax.swing.JLabel();
        monthComboBox1 = new javax.swing.JComboBox();
        dayComboBox1 = new javax.swing.JComboBox();
        yearComboBox1 = new javax.swing.JComboBox();
        travelTypeRadioButtomHol = new javax.swing.JRadioButton();
        travelTypeRadioButtomBus = new javax.swing.JRadioButton();
        JourneyDairyNextButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Travel Dairy");
        setBounds(new java.awt.Rectangle(200, 200, 200, 200));
        setResizable(false);

        jorneyLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jorneyLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jorneyLabel.setText("Journey's name");

        dateLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        dateLabel.setText("Date of the Travel");

        typeLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        typeLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        typeLabel.setText("Type");
        typeLabel.setToolTipText("");

        fromLabel.setText("from");

        monthComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));

        dayComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        yearComboBox.setModel(new javax.swing.DefaultComboBoxModel(Support.dateSpinner()));

        toLabel.setText("to");

        monthComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));

        dayComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        yearComboBox1.setModel(new javax.swing.DefaultComboBoxModel(Support.dateSpinner()));

        typeButGroup.add(travelTypeRadioButtomHol);
        travelTypeRadioButtomHol.setText("Holiday");

        typeButGroup.add(travelTypeRadioButtomBus);
        travelTypeRadioButtomBus.setText("Business");

        JourneyDairyNextButton.setText("Next");
        JourneyDairyNextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JourneyDairyNextButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(dateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jorneyLabel)
                    .addComponent(typeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jorneyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(travelTypeRadioButtomBus)
                        .addGap(18, 18, 18)
                        .addComponent(travelTypeRadioButtomHol))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(fromLabel)
                            .addComponent(toLabel))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(monthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(dayComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(yearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(monthComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(dayComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(yearComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JourneyDairyNextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jorneyLabel)
                    .addComponent(jorneyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dateLabel)
                            .addComponent(fromLabel))
                        .addGap(18, 18, 18)
                        .addComponent(toLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dayComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(yearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(monthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(monthComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dayComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(yearComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(travelTypeRadioButtomBus)
                    .addComponent(travelTypeRadioButtomHol))
                .addGap(18, 18, 18)
                .addComponent(JourneyDairyNextButton)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
/**
 * Menti egy Journey objektumba a megadott adatokat, majd továbblép a naplóbejegyzés szerkesztőre.
 * 
 * @param evt A kiváltó esemény.
 */
    private void JourneyDairyNextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JourneyDairyNextButtonActionPerformed

         DateTime from = new DateTime(getYearComboBox(), getMonthComboBox(), getDayComboBox(), 0, 0);
         DateTime to =  new DateTime(getYearComboBox1(), getMonthComboBox1(), getDayComboBox1(), 0, 0);
         
         if((from.compareTo(to) < 0 || from.compareTo(to) == 0) && !(getTravelTypeRadioButtom() == null)){
        new DiaryWindow(
                this.getJorneyTextField(),
                new DateTime(getYearComboBox(), getMonthComboBox(), getDayComboBox(), 0, 0),
                new DateTime(getYearComboBox1(), getMonthComboBox1(), getDayComboBox1(), 0, 0),
                this.getTravelTypeRadioButtom()).setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        logger.info("Filling form is succes, Diary Window is created");
        this.dispose();
         }else{
        	 logger.error("Filling form is failed");
           JOptionPane.showMessageDialog(this, "Some fields were filled out incorrectly!", "Warning", JOptionPane.ERROR_MESSAGE);
           
         }
         
    }//GEN-LAST:event_JourneyDairyNextButtonActionPerformed
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
	/**
	* Továbblépő gomb.
	*/
    private javax.swing.JButton JourneyDairyNextButton;
	/**
	* Az utazás dátuma cimke.
	*/
    private javax.swing.JLabel dateLabel;
	/**
	* Az utazás kezdő napja.
	*/
    private javax.swing.JComboBox dayComboBox;
	/**
	* Az utazás végnapja.
	*/
    private javax.swing.JComboBox dayComboBox1;
	/**
	*Kezdő dátum cimke.
	*/
    private javax.swing.JLabel fromLabel;
	/**
	*Utazás neve címke.
	*/
    private javax.swing.JLabel jorneyLabel;
	/**
	*Utazás nevét bekérő szövegmező.
	*/
	
    private javax.swing.JTextField jorneyTextField;
	/**
	* Utazás kezdő hónapja.
	*/
    private javax.swing.JComboBox monthComboBox;
	/**
	* Utazás végének hónapja.
	*/
    private javax.swing.JComboBox monthComboBox1;
	/**
	* Vége dátum cimke.
	*/
    private javax.swing.JLabel toLabel;
	/**
	* Üzleti utazás típushoz tartozó gomb.
	*/
    private javax.swing.JRadioButton travelTypeRadioButtomBus;
	/**
	*Nyaralás, mint utazás típushoz tartozó gomb.
	*/
    private javax.swing.JRadioButton travelTypeRadioButtomHol;
	/**
	* Az utazás típusát megadó rádió gombok csoportja.
	*/
    private javax.swing.ButtonGroup typeButGroup;
	/**
	* Utazás típusa cimke.
	*/
    private javax.swing.JLabel typeLabel;
	/**
	*Az utazás kezdő dátumához tartozó évszám.
	*/
    private javax.swing.JComboBox yearComboBox;
	/**
	* Az utazás végéhez tartozó évszám.
	*/
    private javax.swing.JComboBox yearComboBox1;
	
    // End of variables declaration//GEN-END:variables
}
