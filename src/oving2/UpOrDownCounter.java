package oving2;

public class UpOrDownCounter {
	
	public int start;
	public int end;
	
	public UpOrDownCounter(int start, int end) throws IllegalArgumentException{
		this.start = start;
		this.end = end;
		if (start == end) {
			throw new IllegalArgumentException("Start og slutt er lik");
		}
	}
	
	public int getCounter() {
		return 0;
	}
	
	public boolean count() {
		if (this.start < this.end) {
			
		} else if (this.start > this.end) {
			
		}
		return false;
	}

}
