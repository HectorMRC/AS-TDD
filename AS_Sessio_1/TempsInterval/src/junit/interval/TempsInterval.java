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
	
	public int temps() {
		return (this.hf - this.hi) + 1;
	}

	public String periodedeDia() {
		String franja ="Més d’un període";
		if(hi>=8 && hf<=12)franja="Mati";
		else if(hi>=13 && hf<=20)franja="Tarda";
		else if(hi>=21 && hf<=7)franja="Nit";
		return franja;
	}

}
