package junit.interval;

public class TempsInterval {
	private int hi;
	private int hf;
	
	
	public TempsInterval(int hi, int hf) throws IntervalIncorrecte {
		if(hi>hf)throw new IntervalIncorrecte();
		if(hi<0)throw new IntervalIncorrecte();
		if(hf<0)throw new IntervalIncorrecte();
		if(hi>23)throw new IntervalIncorrecte();
		if(hf>23)throw new IntervalIncorrecte();
		this.hi=hi;
		this.hf=hf;
		
	}
	
	
	
	
	
	public int gethi() {
		return hi;
	}
	

	public int gethf() {
		return hf;
	}

}
