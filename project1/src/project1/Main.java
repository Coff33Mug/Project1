package project1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		// Initial Variables
		List<Cards> PH = new ArrayList<>();
		List<Cards> DH = new ArrayList<>();
		int PT = 0;
		int DT = 0;
		boolean gameover = false;
		
		
		BlackJack game = new BlackJack();
		Scanner scanner = new Scanner(System.in);
		// Print initial cards
		game.dealInitial();
		PH = game.getListPH();
		DH = game.getListDH();
		PT = game.getPT(PH);
		DT = game.getDT(DH);
		gameover = game.getGame();
		game.printPH(PH, PT);
		PT = game.getPT(PH);
		game.printDHI(DH,DT);
		
		while (!gameover) {
			// Update game state
			PH = game.getListPH();
			DH = game.getListDH();
			PT = game.getPT(PH);
			DT = game.getDT(DH);
			gameover = game.getGame();
			
			// Response and actions
			String response = scanner.nextLine().toUpperCase();
			
			if (response.equals("H")) {
				// Hits and updates list
				game.hitP(PT);
				PH = game.getListPH();
				// Prints lists and updates PT
				PT = game.getPT(PH);
				game.printPH(PH, PT);
				game.printDHI(DH, DT);
				PT = game.getPT(PH);
				// Checks player total
				game.checkP(PT);
				System.out.println("PT: " + PT);
				System.out.println("DT: " + DT);
			} else { // Stand
				// Dealer logic and checks
				// Updating totals
				PT = game.getPT(PH);
				DT = game.getDT(DH);
				System.out.println("PT: " + PT);
				System.out.println("DT: " + DT);
				
				if (PT < DT) {
					System.out.println("Dealer Wins... didn't draw a single card.");
				}
				
				while (PT >= DT) {
					// Hitting, updating list and totals
					game.hitD(DT);
					DH = game.getListDH();
					DT = game.getDT(DH);
					game.checkD(DT);
					System.out.println("Updated DT: " + DT);
				}
				game.printPH(PH, PT);
				game.printDHA(DH, DT);
				gameover = true;
			}
			
			

		}
	}
}
