
package ApplicationStuff;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.slf4j.Logger; 
import org.slf4j.LoggerFactory;

/**
 * Az adatbázis művelekért felelős absztrakt osztály, mint a kapcsolat létesítés, lezárás,
 * adatbázisba való beszúrás, adatbázisból való lekérdezés.
 * 
 * @author Rosti
 */


public abstract class DataBase {
    /**
     * Adatbázis kapcsolat objektuma.
     */
    private static Connection connection = null;
    /**
     * Az adatbázis állapot objektum.
     */
    private static Statement statement = null;
    /**
     * Az adatbázis egy nézete.
     */
    private static ResultSet rs = null;
    /**
     * A lekérdezéshez előkészített utasítás.
     */
    private static PreparedStatement preparedStatement = null;
    /**
     * Az adatbázisba való id beállításért felelős.
     */
    private static int n = 0;
    /**
     * Lekérdezéseknél használt átmeneti tömb.
     */
    private static String[] tmp = null;
    
    /**
     * Az adatbázishoz szükséges felhasználónév.
     */
    private static String nName = "";
    
    /**
     * Az adatbázis szükséges jelszó.
     */
    private static String password = "";
    
    /**
     * Naplózási objektum létrehozása loggoláshoz.
     */
    protected static Logger logger = LoggerFactory.getLogger(DataBase.class);
/**
 * Az adatbázishoz való kapcsolódást végzi.
 */
    public static void connection() {
        try {
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        } catch (SQLException e) {
            logger.error("Database driver is not available");
        }
        try {
        	
    		Scanner b = new Scanner(new FileReader("src/main/resources/dbconnection.txt"));
    		
    		nName = b.nextLine();
    		password = b.nextLine();
    		b.close();
        	
            connection = DriverManager.getConnection("jdbc:oracle:thin:@db.inf.unideb.hu:1521:ora11g", nName, password);
            statement = connection.createStatement();
        } catch (SQLException e) {
        	logger.error("Database is not available");
        } catch (FileNotFoundException e) {
			logger.error("File is not found.");
			e.printStackTrace();
		}

        logger.info("Connection is okay");
    }
    /**
     * Az adatbázis kapcsolat lezárását végzi.
     */

    public static void close() {
        try {
            statement.close();
            connection.close();
            logger.info("Connection is closed");
        } catch (SQLException e) {
        	logger.error("Connection closing error");
        }

    }
    /**
     * Az aktuális táblához rendel az adatbázisból egy táblanézetet.
     * 
     * @param table A lekérdezett tábla.
     */

    public static void getResultSet(String table) {
        try {
        	String sql = "Select * from " + table;
            preparedStatement = connection.prepareStatement(sql, rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_UPDATABLE);
            rs = preparedStatement.executeQuery();
        } catch (SQLException ex) {
        	logger.error("Resultset error");
        }

    }
    /**
     * Létrehozza a JOURNEY és DAYS táblát az adabázisba, feltéve, ha létezik.
     */

    public static void createTable() {
        try {
            DatabaseMetaData md = connection.getMetaData();
            rs = md.getTables(null, null, "JOURNEY", null);
            if (!rs.next()) {
                String sql = "CREATE TABLE JOURNEY"
                        + "(id INTEGER not NULL, "
                        + " name VARCHAR2(25), "
                        + " datef VARCHAR2(25), "
                        + " datet VARCHAR2(25), "
                        + " type VARCHAR2(10), "
                        + " PRIMARY KEY ( id ))";

                statement.executeUpdate(sql);
                logger.info("Table is created - JOURNEY");

            }

            rs = md.getTables(null, null, "DAYS", null);
            if (!rs.next()) {
                String sql = "CREATE TABLE DAYS"
                        + "(id INTEGER not NULL, "
                        + " day INTEGER, "
                        + " dtext VARCHAR2(1000))";

                statement.executeUpdate(sql);
                logger.info("Table is created - DAYS");

            }

          
        } catch (SQLException e) {
            logger.error("Tables creating error");
        }

    }
    /**
     * Egy utazási napló nevét, dátumát és típusát szúrja be a JOURNEY táblába.
     * 
     * @param name Az utazás neve.
     * @param from Az utazás kezdő dátuma.
     * @param to Az utazás végének dátuma.
     * @param type Az utazás tipusa.
     */
    
    public static void insertInto1(String name, String from, String to, String type){
    
        getResultSet("JOURNEY");
        try {
            while(rs.next()){
                n = rs.getInt(1);
            }
            rs.last();
            statement.execute("Insert into JOURNEY(id,name,datef,datet,type) values(" + (n + 1) + ",'" + name + "','" + from + "','" + to + "','" + type +"')");
            logger.info("Insert is completed - JOURNEY");
            
        } catch (SQLException ex) {
            logger.error("Inserting error - JOURNEY");
        }
    } 
    /**
     * A DAYS táblába szúrja be a megadott naphoz a megadott bejegyzést.
     * 
     * @param day Egy utazási napló napja.
     * @param text Az aktuális utazási napló napjához tartozó bejegyzés.
     */
    public static void insertInto2(int day, String text){
         getResultSet("Days");
         
         try{
        	 rs.last(); 
         statement.execute("Insert into DAYS(id,day,dtext) values(" + (n + 1) + "," + day + ",'" + text + "')");
         logger.info("Insert is completed - DAYS");
         }catch(SQLException e){
        	 logger.error("Inserting error - DAYS");
         }
         
    }
    /**
     * Az adatbázisból kikeresi az utazási naplók neveit.
     * 
     * @return Az utazási naplók neveinek tömbje.
     */
    public static String[] nameCollector(){
           
        try {
            ResultSet nrs = connection.prepareStatement("select count(name) from journey").executeQuery();
            nrs.next();
            int lenght= nrs.getInt(1);
            
            tmp = new String[lenght]; 
            
            nrs = connection.prepareStatement("select name from journey order by id").executeQuery();
            
            for(int i = 0; nrs.next(); i++){
                tmp[i] = nrs.getString(1);
            }
            logger.info("Collecting names is succes");
            
        } catch (SQLException ex) {
        	logger.error("Collecting names is failed");
        }
         return tmp;  
    }
    /**
     * Egy utazási naplóhoz tartozó napok leírását gyűjti össze.
     * 
     * @param id Az aktuális utazási napló id-je.
     * @return Az aktuális utazási napló szövege.
     */
    public static String viewerContentFiller(int id){
        String fullText = "";
        
        try {
            rs = connection.prepareStatement("select dtext from days where id = " + id +  "order by day ").executeQuery();
            int i = 1;
            while(rs.next()){
             fullText += (i++) + ".day" + "\n" + "\n" + rs.getString(1) + "\n" + "\n";
             
        }
         
        } catch (SQLException ex) {
            logger.error("Getting diary pages is failed");
        }
        logger.info("Getting diary pages is succes");
        return fullText;
        
    }
    /**
     * Az adatbázisból való törlést végzi id szerint, majd 
     * a {@link ApplicationStuff.DataBase#nameCollector} metódussal újraalkotja az utazási naplók tömbjét.
     * 
     * @param id az aktuális id.
     * @return nameColllector visszatérési értéke.
     */
    public static String[] deleteFromDatabase(int id){
        try {
            statement.executeUpdate("delete from days where id = " + id);
            statement.executeUpdate("delete from journey where id = " + id);
            statement.executeUpdate("update days set id= id-1 where id >"+id);
            statement.executeUpdate("update journey set id= id-1 where id >"+id);
            getLastId();
        } catch (SQLException ex) {
            logger.error("Deleting from Database is failed");
        }
        logger.info("Deleting from Database is succes");
        return nameCollector();
        
    }
    /**
     *Az aktuális táblanézet utolsó sorának id-ját teszi az n változóba. 
     */
    public static void getLastId(){
        getResultSet("JOURNEY");
        try {
            int id = 0;
            while(rs.next()){
             //n = rs.getInt(1);
              id++;  
            }
            n = id;
            
        } catch (SQLException ex) {
            logger.error("Getting last id is failed");
        }
        
        
    }
    
}
