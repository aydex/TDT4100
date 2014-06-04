package eksamen2009k;

import java.util.Scanner;

public class FourInARow {
	
	public Board board;
	
	public FourInARow() {
		board = new Board();
	}
	
	public static void main(String[] args) {
		FourInARow game = new FourInARow();
		Piece current = Piece.LIGHT;
		game.board.printBoard(current);
		Scanner sc = new Scanner(System.in);
		int x;
		while (sc.hasNext()) {
			x = sc.nextInt();
			int outcome = game.board.place(x, current);
			if (outcome == -1) {
				System.out.println(current + " player has won!");
				break;
			} else if (outcome == -2) {
				System.out.println("Illegal move, please try again");
			} else if (outcome == 0) {
				System.out.println(current + " dropped column " + x + " down to row " + outcome);
				current = current.other();
				game.board.printBoard(current);
			}
		}
	}
	
}
