package junit.interval;

import static org.junit.Assert.*;

import org.junit.Test;

public class IntervalTest {

	
	@Test
	public void intervalvalid() throws IntervalIncorrecte {
		int hi=11;
		int hf=23;
		TempsInterval i= new TempsInterval(hi,hf);
		assertEquals(i.gethi(),11);
		assertEquals(i.gethf(),23);
	}
	
	

	@Test (expected=IntervalIncorrecte.class)
	public void HimesgranHf() throws IntervalIncorrecte{
		int hi= 20;
		int hf=10;
		TempsInterval i= new TempsInterval(hi,hf);
		
	}
	
	@Test (expected=IntervalIncorrecte.class)
	public void Hinegativa() throws IntervalIncorrecte{
		int hi= -20;
		int hf=10;
		TempsInterval i= new TempsInterval(hi,hf);
		
	}
	
	@Test (expected=IntervalIncorrecte.class)
	public void Hfnegativa() throws IntervalIncorrecte{
		int hi= 20;
		int hf=-10;
		TempsInterval i= new TempsInterval(hi,hf);
		
	}
	
	@Test (expected=IntervalIncorrecte.class)
	public void Himesque23() throws IntervalIncorrecte{
		int hi= 450;
		int hf= 10;
		TempsInterval i= new TempsInterval(hi,hf);
		
	}
	
	@Test (expected=IntervalIncorrecte.class)
	public void Hfmesque23() throws IntervalIncorrecte{
		int hi= 20;
		int hf= 39;
		TempsInterval i= new TempsInterval(hi,hf);
		
	}
	
	
	
    
}
