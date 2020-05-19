package junit.com;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestProgressiveRate {

	  PayStation ps;
	  
	  /** Fixture for pay station testing. */
	  @Before
	  public void setUp() {
		RateStrategy rateImplementation = new ProgressiveRateStrategy();
	    ps = new PayStationImpl(rateImplementation);
	  }

	  @Test
	  public void primeraHoraDeParking() throws IllegalCoinException {
	    ps.addPayment( 5 );
	    int gotTime = ps.readDisplay();
	    
	    assertEquals( "Should display 2 min for 5 cents", 
	                  5 / 5 * 2,  gotTime); 
	  }
	  
	  @Test
	  public void segonaHoraDeParking() throws IllegalCoinException {
		for (int i = 0; i < 160/10; i++) {
			ps.addPayment( 10 );
		}
	    
	    int gotTime = ps.readDisplay();
	    assertEquals( "Should display 2 min for 5 cents", 
	                  63,  gotTime); 
	  }
}
