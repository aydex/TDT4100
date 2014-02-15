package oving2;

public class StackProgram {
	private Stack stack;
	private RandomStringGenerator rsg;
	
	void init() {
		stack = new Stack();
		rsg = new RandomStringGenerator();
	}
	
	void run() {
		stack.push(rsg.getRandomString());
		System.out.println(stack);
	}
	
	public static void main(String[] args) {
		StackProgram stackProgram = new StackProgram();
		stackProgram.init();
		stackProgram.run();
	}
}
