package project1;

public class Cards {
	private int value;
	
	public Cards() {
		value = (int)(Math.random() * 11) + 1;
	}
	
	public int getCard(int Total) {
		if (value == 11 && Total > 21) {
			return 1;
		}
		return this.value;
	}
}
