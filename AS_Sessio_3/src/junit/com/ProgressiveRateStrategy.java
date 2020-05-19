package junit.com;

public class ProgressiveRateStrategy implements RateStrategy {
	
	public int calculator(int insertedSoFar, int minuts) {
		if (insertedSoFar <= 0) {
			return minuts;
		}
		
		int temps = 0;
		int residu = 0;
		
		if (temps <= 60) {
			if (insertedSoFar > 150) {
				residu = insertedSoFar-150;
				temps += 60;
			}
			
			temps += insertedSoFar/5 *2;
			
		} else if (temps > 60 && temps <= 120) {
			if (insertedSoFar > 200) {
				residu = insertedSoFar-200;
				temps += 60;
			}
			
			temps += insertedSoFar/5 * 1.5;
			
		} else {
			temps += insertedSoFar/5 * 1;
		}
		
		return calculator(residu, temps);
	}

	@Override
	public int calculaTime(int insertedSoFar) {
		return calculator(insertedSoFar, 0);
	}

}
