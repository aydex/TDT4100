package oving7;

import java.util.Scanner;

public class Sokoban implements ConsoleGame{
	
	private Board board;
	private String level;
	private Scanner sc;
	private int currentLevel;
	private MoveStack<Move> undoStack;
	private MoveStack<Move> redoStack;
	
	public Sokoban() {
		init("#####\n#@$.#\n#####");
	}
	
	@Override
	public void init(String level) {
		ConsoleOutput out = null;
		run(out);
	}
	
	public void run(ConsoleOutput output) {
		this.menu();
	}
	
	public void undo(Move move) {
		if (undoStack.empty()) {
			System.out.println("No more moves to undo");
		} else {
			move = undoStack.pop();
			if (move.movedBlock()) {
				board.move(move.getOpposite(), true);				
			} else {
				board.move(move.getOpposite(), false);				
			}
			redoStack.push(move);			
		}
	}
	
	public void redo(Move move) {
		if (redoStack.empty()) {
			System.out.println("No moves to redo");
		} else {
			move = redoStack.pop();
			board.move(move.getValue(), false);
			undoStack.push(move);
		}
	}
	public int move(char input) {
		int retVal = 0;
		Move move = new Move(input);
		if (move.isMove()) {
			int moveVal = board.move(move.getValue(), false);
			if (moveVal == 1) {
				move.setBlock(true);
			}
			undoStack.push(move);
			redoStack.clear();
		} else if (move.getValue() == 'u') {
			undo(move);
		} else if (move.getValue() == 'r') {
			redo(move);
		} else if (move.getValue() == 'x') {
			menu();
		}
		
		System.out.println(board);
		
		if (board.goal()) {
			System.out.println("Congratulations, you did it!");
			currentLevel++;
			nextLevel();
		}
		return retVal;
	}
	
	public void play() {
		undoStack = new MoveStack<Move>();
		redoStack = new MoveStack<Move>();
		board = new Board(this.level);
		System.out.println(board);
		System.out.println("Where do you want to go?");
		do {
			if (sc.hasNextInt()) {
				SaveLoadSokoban saver = new SaveLoadSokoban();
				int input = sc.nextInt();
				if (input == 1) {
					System.out.println("Saving save 1");
					saver.saveGame(board.getBoard());
				} else if (input == 2) {
					System.out.println("Saving save 2");
					saver.saveGame(board.getBoard(), "save2.txt");
				} else if (input == 3) {
					System.out.println("Saving save 3");
					saver.saveGame(board.getBoard(), "save3.txt");
				}
			} else {
				move(sc.next().charAt(0));				
			}
		} while(sc.hasNext());
	}
	
	public void nextLevel() {
		switch (currentLevel) {
		case 1:
			this.level = SampleLevels.SAMPLE_LEVEL2;
			play();
			break;
		case 2:
			this.level = SampleLevels.SAMPLE_LEVEL3;
			play();
			break;
		case 3:
			this.level = SampleLevels.SAMPLE_LEVEL4;
			play();
			break;
		default:
			menu();
			break;
		}
	}
	
	public void saveGame(String filename) {
		SaveLoadSokoban save = new SaveLoadSokoban();
		save.saveGame(board.getBoard(), filename);
	}
	
	public void loadGame(String filename) {
		SaveLoadSokoban load = new SaveLoadSokoban();
		if (load.loadGame(filename) != null) {
			this.level = load.loadGame(filename);			
		} else {
			System.out.println("No such savefile");
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
				+ "#\t\t2) Load game\t\t\t#\n"
				+ "#\t\t3) Choose level\t\t\t#\n"
				+ "#\t\t4) Help\t\t\t\t#\n"
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
				SaveLoadSokoban saveLoad = new SaveLoadSokoban();
				System.out.println(" ############################################### \n"
						+ "#\t  --------Choose save:-------\t\t#\n"
						+ "#\t\t\t\t\t\t#\n"
						+ "#\t\t  1) Save 1\t\t\t#\n"
						+ "#\t\t  2) Save 2\t\t\t#\n"
						+ "#\t\t  3) Save 3\t\t\t#\n"
						+ "#\t\t  0) Back   \t\t\t#\n"
						+ "#\t\t\t\t\t\t#\n"
						+ " ############################################### ");
				
				switch(sc.nextInt()) {
				case 1:
					if (saveLoad.loadGame() != null) {
						this.level = saveLoad.loadGame();						
					} else {
						menu();
					}
					break;
				case 2:
					if (saveLoad.loadGame("save2.txt") != null) {
						this.level = saveLoad.loadGame("save2.txt");						
					} else {
						menu();
					}
					break;
				case 3:
					if (saveLoad.loadGame("save3.txt") != null) {
						this.level = saveLoad.loadGame("save3.txt");						
					} else {
						menu();
					}
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
			case 4:
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
	
	@Override
	public Integer doLine(String input) {
		switch (input) {
		case "play":
			currentLevel = 1;
			board = new Board(SampleLevels.SAMPLE_LEVEL1);
			break;
		case "w":
			move('w');
			break;
		case "a":
			move('a');
			break;
		case "s":
			move('s');
			break;
		case "d":
			move('d');
			break;
		case "u":
			move('u');
			break;
		case "r":
			move('r');
			break;
		case "x":
			return 0;
		default:
			break;
		}
		
		if (input.charAt(0) == '>') {
			saveGame(input.substring(1));
		}
		
		if (input.charAt(0) == '<') {
			loadGame(input.substring(1));
		}
		
		if (currentLevel == 4) {
			return 1;
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		Sokoban sokoban = new Sokoban();
	}
}
