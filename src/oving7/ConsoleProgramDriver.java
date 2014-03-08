package oving7;

import java.util.Scanner;

public class ConsoleProgramDriver implements ConsoleOutput {

	private ConsoleGame program;
	private String level = null;

	private void init(ConsoleGame program, String level) {
		this.program = program;
		this.level = level;
	}
	
	public void run() {
		Scanner scanner = new Scanner(System.in);
		do {
			if (level == null) {
				if (scanner.hasNextLine()) {
					level = scanner.nextLine();
				}
				message("Enter level: ");
				level = scanner.nextLine();
			}
			program.init(level);
			program.run(this);
			Integer result = null;
			while (result == null) {
				if (scanner.hasNextLine()) {
					String line = scanner.nextLine();
					result = program.doLine(line);
				} else {
					result = 0;
				}
			}
			message("Game over" + (result != 0 ? "" : ", no result") + "!");
			if (result > 0) {
				level = null;
			}
			message("Another go (true/false)?");
		} while (scanner.nextBoolean());
		scanner.close();
	}

	public static void main(String[] args) throws Exception {
		ConsoleProgramDriver driver = new ConsoleProgramDriver();
		//onsoleProgramDriver.main(Sokoban.class.getName(), null);
		ConsoleGame program = (ConsoleGame) Class.forName(args[0]).newInstance();
		driver.init(program, args.length > 1 ? args[1] : null);
		driver.run();
	}

	@Override
	public void message(String message) {
		System.out.println(message);
	}

	@Override
	public void error(String message) {
		System.err.println(message);
	}
}