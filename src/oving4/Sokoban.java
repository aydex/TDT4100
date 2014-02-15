package oving4;

import java.util.Scanner;

public class Sokoban {
	
	private Board board;
	private String level;
	private Scanner sc;
	
	public Sokoban() {

	}
	
	public void run() {
		this.menu();
		
	}
	
	public int move(char move) {
		int retVal = 0;
		switch (move) {
			case 'w':
				board.up();
				System.out.println(board);
				break;
			case 'a': 
				board.left();
				System.out.println(board);	
				break;
			case 's':
				board.down();
				System.out.println(board);
				break;
			case 'd':
				board.right();
				System.out.println(board);
				break;
			case 'x':
				retVal = 2;
				break;
			case 'r':
				play();
				break;
			default: System.out.println("Invalid key, try again");
				break;
		}
		if (board.goal()) {
			System.out.println("Congratulations, you did it!");
			retVal = 1;
		}
		return retVal;
	}
	
	public void play() {
		board = new Board(this.level);
		System.out.println(board);
		System.out.println("Where do you want to go?");
		int val;
		do {
			val = this.move(sc.next().charAt(0));
		} while(val == 0);
		if (val == 1) {
			nextLevel();
		} else if (val == 2) {
			menu();
		}
	}
	
	public void nextLevel() {
		System.out.println("Bla");
		switch (this.level) {
		case SampleLevels.SAMPLE_LEVEL1:
			this.level = SampleLevels.SAMPLE_LEVEL2;
			play();
			break;
		case SampleLevels.SAMPLE_LEVEL2:
			this.level = SampleLevels.SAMPLE_LEVEL3;
			play();
			break;
		case SampleLevels.SAMPLE_LEVEL3:
			this.level = SampleLevels.SAMPLE_LEVEL4;
			play();
			break;
		default:
			menu();
			break;
		}
	}

	public String toString(){
		return board.toString();
	}
	
	public void menu() {
		System.out.println(" ############################################### \n"
				+ "#\t--------Welcome to Sokoban!-------\t#\n"
				+ "#\t\t\t\t\t\t#\n"
				+ "#\t\t1) Play game\t\t\t#\n"
				+ "#\t\t2) Choose level\t\t\t#\n"
				+ "#\t\t3) Help\t\t\t\t#\n"
				+ "#\t\t\t\t\t\t#\n"
				+ " ############################################### ");
		sc = new Scanner(System.in);
		while (sc.hasNextInt()) {
			switch(sc.nextInt()) {
			case 1:
				this.level = SampleLevels.SAMPLE_LEVEL1;
				play();
				break;
			case 2:
				System.out.println(" ############################################### \n"
						+ "#\t  --------Choose level:-------\t\t#\n"
						+ "#\t\t\t\t\t\t#\n"
						+ "#\t\t  1) Level 1\t\t\t#\n"
						+ "#\t\t  2) Level 2\t\t\t#\n"
						+ "#\t\t  3) Level 3\t\t\t#\n"
						+ "#\t\t  4) Level 4\t\t\t#\n"
						+ "#\t\t  0) Back   \t\t\t#\n"
						+ "#\t\t\t\t\t\t#\n"
						+ " ############################################### ");
				
				switch(sc.nextInt()) {
				case 1:
					this.level = SampleLevels.SAMPLE_LEVEL1;
					break;
				case 2:
					this.level = SampleLevels.SAMPLE_LEVEL2;
					break;
				case 3:
					this.level = SampleLevels.SAMPLE_LEVEL3;
					break;
				case 4:
					this.level = SampleLevels.SAMPLE_LEVEL4;
					break;
				case 0:
					menu();
					break;
				default:
					this.level = SampleLevels.SAMPLE_LEVEL1;
					break;
				}
				break;
			case 3:
				menu();
				break;
			default:
				menu();
				break;
			}
			play();
			break;
		}
	}
	
	public static void main(String[] args) {
		Sokoban sokoban = new Sokoban();
		sokoban.run();
	}
}
