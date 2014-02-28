package oving6;

import java.util.Iterator;

public class StringGridIterator implements Iterator<String>{
	
	private StringGrid stringGrid;
	private boolean rowMajor;
	private int n;

	public StringGridIterator(StringGridImpl gridImpl, boolean b) {
		this.stringGrid = gridImpl;
		this.rowMajor = b;
		this.n = 0;
	}
	@Override
	public boolean hasNext() {
		if (n == stringGrid.getColumnCount()*stringGrid.getRowCount()) {
			return false;
		} else {
			return true;			
		}
	}
	
	@Override
	public String next() {
		String retString = "";
		if (rowMajor) {
			retString = stringGrid.getElement(n/stringGrid.getColumnCount(), n%stringGrid.getColumnCount());
			n++;
		} else {
			retString = stringGrid.getElement(n%stringGrid.getRowCount(), n/stringGrid.getRowCount());
			n++;
		}
		return retString;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
	
	public static void main(String[] args) {
		StringGridImpl sg = new StringGridImpl(2, 3);
		StringGridIterator sgi = new StringGridIterator(sg, true);
		sg.setElement(0, 0, "0.0");
		sg.setElement(0, 1, "0.1");
		sg.setElement(0, 2, "0.2");
		sg.setElement(1, 0, "1.0");
		sg.setElement(1, 1, "1.1");
		sg.setElement(1, 2, "1.2");
		while (sgi.hasNext()) {
			System.out.println(sgi.hasNext());
			System.out.println(sgi.next());			
		}
		System.out.println(sgi.hasNext());
		
	}

}
