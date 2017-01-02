import java.util.*;
import java.util.concurrent.SynchronousQueue;

public class Wheel {

	Pocket[] pocketArr = new Pocket[38]; {
	pocketArr[0] = new Pocket("00","Green");
	pocketArr[1] = new Pocket("0","Green");
	pocketArr[2] = new Pocket("1","Red");
	pocketArr[3] = new Pocket("2","Black");
	pocketArr[4] = new Pocket("3","Red");
	pocketArr[5] = new Pocket("4","Black");
	pocketArr[6] = new Pocket("5","Red");
	pocketArr[7] = new Pocket("6","Black");
	pocketArr[8] = new Pocket("7","Red");
	pocketArr[9] = new Pocket("8","Black");
	pocketArr[10] = new Pocket("9","Red");
	pocketArr[11] = new Pocket("10","Black");
	pocketArr[12] = new Pocket("11","Black");
	pocketArr[13] = new Pocket("12","Red");
	pocketArr[14] = new Pocket("13","Black");
	pocketArr[15] = new Pocket("14","Red");
	pocketArr[16] = new Pocket("15","Black");
	pocketArr[17] = new Pocket("16","Red");
	pocketArr[18] = new Pocket("17","Black");
	pocketArr[19] = new Pocket("18","Red");
	pocketArr[20] = new Pocket("19","Red");
	pocketArr[21] = new Pocket("20","Black");
	pocketArr[22] = new Pocket("21","Red");
	pocketArr[23] = new Pocket("22","Black");
	pocketArr[24] = new Pocket("23","Red");
	pocketArr[25] = new Pocket("24","Black");
	pocketArr[26] = new Pocket("25","Red");
	pocketArr[27] = new Pocket("26","Black");
	pocketArr[28] = new Pocket("27","Red");
	pocketArr[29] = new Pocket("28","Black");
	pocketArr[30] = new Pocket("29","Black");
	pocketArr[31] = new Pocket("30","Red");
	pocketArr[32] = new Pocket("31","Black");
	pocketArr[33] = new Pocket("32","Red");
	pocketArr[34] = new Pocket("33","Black");
	pocketArr[35] = new Pocket("34","Red");
	pocketArr[36] = new Pocket("35","Black");	
	pocketArr[37] = new Pocket("36","Red");	
	}
	
	private int bet;	//wager amount
	int payout;			//money won/loss per round
	int balance;		//remaining funds
	String color;		//color selected by user
	String choice;		//what do you want to bet on?
	Boolean win = false;	//is the game done?
	Scanner input = new Scanner(System.in);
	private Random random = new Random();
	
	
	public void wheel() {
		System.out.print("Welcome to Roulette Simulator 2000! \nWhat's your bankroll? ");
		balance = input.nextInt();
		System.out.println("\nGreat! You will be paying with $" + balance);
	}
	
	public void getBet() {
		System.out.print("How much would you like to bet? ");
		bet = input.nextInt();
		
		while(bet > balance) {
		System.out.println("I'm sorry you don't have enough money to place that bet");
		System.out.print("Please enter of " + balance + " or less: ");
		bet = input.nextInt();
		}
		System.out.println();
		input.nextLine();
		
	}
	
	public void chooseBet() {
		System.out.println("Would you like to bet on a color, even/odd, or a number?");
		System.out.print("type 'c' for color, 'e' for even/odd, or 'n' for a number: ");
		choice = input.nextLine();
		System.out.println();
		
		while (!choice.equals("c") && !choice.equals("e") && !choice.equals("n")) {
		System.out.print("Please select a valid choice, \n'c' for color, 'e' for even/odd, or 'n' for a number: ");
		choice = input.nextLine();
		}
		System.out.println();
	}
	
	public void placeBet() {
		
		if (choice.equals("c")) {
		System.out.print("What color would you like to bet on? ");
		color = input.nextLine();		
	}
		System.out.println();
			
	}
	
	public void roll() {		//get pocket color
		
		System.out.println("How many rounds would you like to play? ");
		int rounds = input.nextInt();
		
		System.out.println();
		System.out.printf("%-10s %-10s%-10s %-10s %-10s %-10s\n", 
							"Bet $", "Bet Location", "Result #", "Result color", "profit/loss", "Balance");
		
		
		for (int i = 0; i<rounds; i++) {
		int tempInt = random.nextInt(38);
		String tempColor =  pocketArr[tempInt].getColor().toLowerCase();
		String tempNumber = pocketArr[tempInt].getNumber();
			
		if(color.equals(tempColor)) {
			payout = bet;
		} else {
			payout = -bet;
		}
		
		balance = balance+payout;
		
		System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s\n", bet, color, tempColor, tempNumber, payout, balance);
		}
		
	}
	
	
	
	
	
}
