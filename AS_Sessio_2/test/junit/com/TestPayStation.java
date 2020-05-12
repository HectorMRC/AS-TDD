package junit.com;

import org.junit.*;
import static org.junit.Assert.*;

/** Test cases for the Pay Station system.
 
   This source code is from the book 
     "Flexible, Reliable Software:
       Using Patterns and Agile Development"
     published 2010 by CRC Press.
   Author: 
     Henrik B Christensen 
     Department of Computer Science
     Aarhus University
   
   Please visit http://www.baerbak.com/ for further information.

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at
 
       http://www.apache.org/licenses/LICENSE-2.0
 
   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

*/
public class TestPayStation {
  PayStation ps;
  /** Fixture for pay station testing. */
  @Before
  public void setUp() {
    ps = new PayStationImpl();
  }

  /**
   * Entering 5 cents should make the display report 2 minutes 
   * parking time.
  */
  @Test
  public void shouldDisplay2MinFor5Cents() throws IllegalCoinException {
    ps.addPayment( 5 );
    assertEquals( "Should display 2 min for 5 cents", 
                  2, ps.readDisplay() ); 
  }

  /**
   * Entering 25 cents should make the display report 10 minutes
   * parking time.
  */
  @Test
  public void shouldDisplay10MinFor25Cents() throws IllegalCoinException {
    ps.addPayment( 25 );
    assertEquals( "Should display 10 min for 25 cents", 
                  25 / 5 * 2, ps.readDisplay() );
    // 25 cent in 5 cent coins each giving 2 minutes parking
  }

  /** 
   * Verify that illegal coin values are rejected.
  */
  @Test(expected=IllegalCoinException.class)
  public void shouldRejectIllegalCoin() throws IllegalCoinException {
    ps.addPayment(17);
  }
  
  @Test
  public void shouldDisplay14MinFor35Cents() throws IllegalCoinException {
	  ps.addPayment(10);
	  ps.addPayment(25);
	  assertEquals( "Should display 14 min for 35 cents", 
              35 / 5 * 2, ps.readDisplay() );
  }
  
  @Test
  public void shouldDisplay16Minfor40CentsAndProduceValidReceipt() throws IllegalCoinException {
	  ps.addPayment(5);
	  ps.addPayment(10);
	  ps.addPayment(25);
	  
	  Receipt receipt = ps.buy();

	  assertEquals("Buy receipt should be the same", 16, receipt.value());
  }
  
  @Test
  public void buyFor100Cents() throws IllegalCoinException {
	  ps.addPayment(25);
	  ps.addPayment(25);
	  ps.addPayment(25);
	  ps.addPayment(25);
	  
	  Receipt receipt = ps.buy();

	  assertEquals( "Should display 40 min for 100 cents", 
              100 / 5 * 2, receipt.value());
  }
  
  @Test
  public void payStationResetsBetweenTwoDifferentPayments() throws IllegalCoinException {
	  ps.addPayment(25);
	  ps.addPayment(25);
	  Receipt receipt = ps.buy();
	  
	  assertEquals( "Should display 20 min for 100 cents", 
              50 / 5 * 2, receipt.value());
	  
	  ps.addPayment(25);
	  ps.addPayment(25);
	  
	  Receipt receipt1 = ps.buy();

	  assertEquals( "Should display 20 min for 100 cents", 
              50 / 5 * 2, receipt1.value());
  }
}
