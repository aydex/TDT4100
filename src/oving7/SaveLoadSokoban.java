package oving7;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class SaveLoadSokoban implements SaveLoad {

	@Override
	public void saveGame(String save) {
		try {
			PrintWriter saver = new PrintWriter("save1.txt");
			saver.println(save);
			saver.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String loadGame() {
		try {
			Scanner loader = new Scanner(new FileReader("save1.txt"));
			String board = "";
			while (loader.hasNextLine()) {
				board += loader.nextLine();
				board += "\n";
			}
			loader.close();
			return board;				
		} catch (FileNotFoundException e) {
			System.out.println("No such file: " + e);
		}
		return null;
	}

	@Override
	public void saveGame(String save, String filename) {
		try {
			PrintWriter saver = new PrintWriter(filename);
			saver.println(save);
			saver.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String loadGame(String filename) {
		try {
			Scanner loader = new Scanner(new FileReader(filename));
			String board = "";
			while (loader.hasNextLine()) {
				board += loader.nextLine();
				board += "\n";
			}
			loader.close();
			return board;				
		} catch (FileNotFoundException e) {
			System.out.println("No such file: " + e);
		}
		return null;
	}

}
