package ApplicationStuff;


import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ApplicationStuff.DataBase;





/**
 * Az aktuális, feldogozás alatt lévő utazási napló adatait tárolja.
 * 
 * @author Rosti
 */
public class Journey {
    /**
     * Az utazás neve.
     */
	
    private String journeyName;
    /**
     * Az utazás kezdő dátuma.
     */
    
    private DateTime  dateOfJourneyFrom;
    /**
     * Az utazás végének a dátuma.
     */
    
    private DateTime  dateOfJourneyTo;
    /**
     * Az utazás típusa.
     */
    
    private String typeOfTravel;
    /**
     * Az utazás napjainak száma.
     */
    
    private int numberOfDaysOfJourney;
    /**
     * Az utazás naplóbejegyzései.
     */
    
    String[] aPageOfActualJourney;
    /**
     * Logger objektum létrehozása logoláshoz.
     */
    
    protected static Logger logger = LoggerFactory.getLogger(DataBase.class);
    /**
     * Az utazás osztály konstruktora.
     * 
     * @param name Az utazás neve.
     * @param dateFrom Az utazás kezdő dátuma.
     * @param dateTo Az utazás végének dátuma.
     * @param type Az utazás típusa.
     */
    
    public Journey(String name, DateTime dateFrom, DateTime dateTo, String type){
        this.journeyName = name;
        this.dateOfJourneyFrom = dateFrom;
        this.dateOfJourneyTo = dateTo;
        this.typeOfTravel = type;
        numberOfDaysOfJourney = Days.daysBetween(new LocalDate(dateOfJourneyFrom), new LocalDate(dateOfJourneyTo)).getDays(); 
        aPageOfActualJourney = new String[numberOfDaysOfJourney + 1];
        for(int i = 0; i < aPageOfActualJourney.length; i++){
            aPageOfActualJourney[i] = "";
        }
    
    }
    
    /**
     * Alapértelmezett konstruktor.
     */
    
    public Journey(){
    	this.journeyName = "";
        this.dateOfJourneyFrom = null;
        this.dateOfJourneyTo = null;
        this.typeOfTravel = "";
        numberOfDaysOfJourney = 0;  
        
    }
    	
    
    /**
     * Beállítja az utazás napjainak számát.
     * 
     * @param numberOfDaysOfJourney Az utazás napjainak száma.
     */

    public void setNumberOfDaysOfJourney(int numberOfDaysOfJourney) {
		this.numberOfDaysOfJourney = numberOfDaysOfJourney;
	}

/**
 * Veszi az utazás napjainak számát.
 * 
 * @return Az utazás napjainak száma.
 */

	public int getNumberOfDaysOfJourney() {
        return numberOfDaysOfJourney;
    }
        /**
         * Veszi az utazás nevét.
         * 
         * @return Az utazás neve.
         */

    public String getJourneyName() {
        return journeyName;
    }
    /**
     * Veszi az aktuális utazáshoz tartozó napok bejegyzéseit.
     * 
     * @return Az aktuális utazás bejegyzései egy tömben.
     */

    public String[] getaPageOfActualJourney() {
        return aPageOfActualJourney;
    }
    /**
     * Veszi az utazás típusát.
     * 
     * @return Az utazás típusa.
     */

    public String getTypeOfTravel() {
        return typeOfTravel;
    }

 /**
  * Előkészíti és elküldi az aktuális utazási napló összes adatát az adatbázisnak.
  */
    
 public void sendToDatabase(){
     String datef = dateOfJourneyFrom.getYear() + "." 
                    + dateOfJourneyFrom.getMonthOfYear() + "." 
                    + dateOfJourneyFrom.getDayOfMonth();
     
     String datet = dateOfJourneyTo.getYear() + "." 
                    + dateOfJourneyTo.getMonthOfYear() + "." 
                    + dateOfJourneyTo.getDayOfMonth();
     
     DataBase.insertInto1(this.getJourneyName(), datef, datet, getTypeOfTravel());
     
     for(int i = 0; i < aPageOfActualJourney.length; i++){
         if(!getaPageOfActualJourney()[i].equals("")){
     DataBase.insertInto2(i+1,getaPageOfActualJourney()[i]);
         }else{
         DataBase.insertInto2(i+1,"Unknown - Maybe, you didn't save the page of dairy");
         }
             
     }
     logger.info("Data sending to Datbase is succes");
}
   
    
    
}
