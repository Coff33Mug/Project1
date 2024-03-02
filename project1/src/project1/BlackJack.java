package project1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BlackJack {
	//Game state checker and values
	private List<Cards> PH = new ArrayList<>();
	private List<Cards> DH = new ArrayList<>();
	private int PT = 0;
	private int DT = 0;
	private boolean gameover = false;
	
	public void dealInitial() { 
		for (int i = 0; i < 2; i++) {
			PH.add(new Cards());
			DH.add(new Cards());
		}
	}
	
	public void hitP(int PT) {
		PH.add(new Cards());
		this.PT = 0;
		/*if (PT > 21) {
			gameover = true;
			System.out.println("Player loses... went over 21.");
		} else if (PT < 21) {
			PH.add(new Cards());
		} else {
			gameover = true;
			System.out.println("Player Wins! You got 21.");
		}*/
		
	}
	
	public void hitD(int DT) {
		DH.add(new Cards());
		this.DT = 0;
		/*if (DT > 21) {
			gameover = true;
			System.out.println("Player Wins! Dealer went over 21.");
		} else if (DT < 21) {
			PH.add(new Cards());
		} else {
			gameover = true;
			System.out.println("Player loses... Dealer got 21.");
		}*/
		
	}
	
	
	
	public void printPH(List<Cards> List, int PT) {
		System.out.print("Player's Hand: ");
		for (Cards card : List) {
			System.out.print(card.getCard(PT) + " ");
			this.PT += card.getCard(PT);
		}
	}
	
	public void printDHI(List<Cards> List, int DT) {
		System.out.print("\nDealer's Hand: " + List.get(0).getCard(DT) + " ?");
		// Update DT, might not be necessary
		//this.DT += List.get(0).getCard(DT);
		System.out.println("\nH or S?\n");
	}
	
	public void printDHA(List<Cards> List, int DT) {
		System.out.print("\nDealer's Hand: ");
		for (Cards card : List) {
			System.out.print(card.getCard(DT) + " ");
			this.DT += card.getCard(DT);
		}
	}
	
	
	public boolean checkP(int PT) {
		if (PT > 21) {
			gameover = true;
			System.out.println("Player loses... went over 21.");
			return true;
		} else if (PT == 21) {
			gameover = true;
			System.out.println("Player Wins! You got 21.");
			return true;
		}
		return false;
	}
	
	public boolean checkD(int DT) {
		if (DT > 21) {
			gameover = true;
			System.out.println("Player Wins! Dealer went over 21.");
			return true;
		} else if (DT == 21) {
			gameover = true;
			System.out.println("Player loses... Dealer got 21.");
			return true;
		}
		return false;
	}
	
	public List<Cards> getListPH() {
		return PH;
	}
	
	public List<Cards> getListDH() {
		return DH;
	}
	
	public int getPT(List<Cards> List) {
		this.PT = 0;
		for (Cards card : List) {
			this.PT += card.getCard(PT);
		}
		return PT;
	}
	
	// The This.DT might have an issue.
	public int getDT(List<Cards> List) {
		this.DT = 0;
		for (Cards card : List) {
			this.DT += card.getCard(DT);
		}
		return DT;
	}
	
	public boolean getGame() {
		return gameover;
	}
}
