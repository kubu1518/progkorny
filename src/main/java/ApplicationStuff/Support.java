/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ApplicationStuff;

import org.joda.time.DateTime;

/**
 * Az alkalmazást támogató kisebb metódusok. 
 * 
 * @author Rosti
 */
public class Support {
    
    /**
     * Létrehoz egy tömböt évszámokkal 1970-től az aktuális dátumig és még 4 évet rászámol.
     * 
     * @return Az évszámokat tartalmazó tömb. 
     */
       public static String[] dateSpinner() {
           DateTime now = new DateTime();
           
        String[] tmp = new String[now.getYear() + 4 - 1970 + 1];
        for (int i = 1970; i <= (now.getYear() + 4); i++) {
            tmp[i - 1970] = Integer.toString(i);
        }
        return tmp;
    }
       /**
        * Előállít egy x.day stringeket tartalmazó tömböt a paraméterben
        * átadott utazás napjainak száma alapján.
        * 
        * @param j Az utazás.
        * @return Napok a tömbben.
        */
         public static String[] daysOfJourney(Journey j){
          
        	 
        String[] tmp = new String[j.getNumberOfDaysOfJourney() + 1];
         for(int i=1; i <= j.getNumberOfDaysOfJourney() + 1; i++){
             tmp[i-1] = i +". day";
         }
         return tmp;
    }
}
