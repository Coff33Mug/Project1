package project1;

public class Cards {
	private int value;
	
	public Cards() {
		value = (int)(Math.random() * 10) + 1;
	}
	
	public int getCard(int Total) {
		if (value == 1 && (Total + 11) < 21) {
			this.value = 11;
			return 11;
		}
		return this.value;
	}
}
