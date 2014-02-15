package Oving1;

public class CounterProgram {
	
	Oving1.Counter counter;
	
	void init() {
		this.counter = new Oving1.Counter(3);
	}
	
	void run() {
		Oving1.Counter counter = new Oving1.Counter(3);
		System.out.println(counter);
		System.out.println("counter = " + counter.getCounter());
		System.out.println(counter);
		System.out.println(counter.count());
		System.out.println(counter);
		System.out.println("counter = " + counter.getCounter());
		System.out.println(counter);
		System.out.println(counter.count());
		System.out.println(counter);
		System.out.println("counter = " + counter.getCounter());
		System.out.println(counter);
		System.out.println(counter.count());
		System.out.println(counter);
	}
	
	public static void main(String[] args) {
		CounterProgram program = new CounterProgram();
		program.init();
		program.run();
	}

}
