package Oving1;

public class Counter {
	
	int end;
	int counter = 1;
	
	public Counter(int end) {
		this.end = end;
	}
	
	public String toString() {
		return "[Counter end=" + end + ", counter=" + counter + "]";
	}
	
	public int getCounter() {
		return counter;
	}
	
	public boolean count() {
		if (this.counter < this.end){
			this.counter++;
		}
		return this.counter == this.end;
	}
}
