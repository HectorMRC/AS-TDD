package junit.com;

public class ReceiptImpl implements Receipt {
	private int time;
	
	public ReceiptImpl(int timePaid) {
		this.time = timePaid;
	}
	
	@Override
	public int value() {
		// TODO Auto-generated method stub
		return time;
	}

}
