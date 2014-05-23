import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.net.URL;
import java.util.Scanner;

import ApplicationStuff.Journey;
import ApplicationStuff.Support;


public class SupportTest {
	
	Support s;
	Journey j;
	String[] tmp;
	String[] tmp2 =  {"1. day","2. day","3. day"};
	

	

	
	
	
	@Before
	public void setUp() throws Exception {
		 s = new Support();
		URL url = getClass().getClassLoader().getResource("date.txt"); 
		String utvonal = url.toString(); 
		String utvonal2 = utvonal.replace("file:", "");
		Scanner b = new Scanner(new FileReader(utvonal2));
		 
		 
		 
		 String line;
		 int lenght=0;
		 tmp = new String[49];
		 int i = 0;
		 while(b.hasNextLine()){
			 tmp[i++] = b.nextLine();
		 }
		
		 
		
		
		 
		 
	}

	@Test
	public void testdateSpinner() {
		assertEquals(tmp,s.dateSpinner() );
		
	}
	
	@Test
	public void testgetNumberOfDaysOfJourney() {
		j = new Journey();
		j.setNumberOfDaysOfJourney(2);   
		assertArrayEquals(tmp2, Support.daysOfJourney(j));
		
	}
	

}
