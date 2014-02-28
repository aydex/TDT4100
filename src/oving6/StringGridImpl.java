package oving6;

import java.util.ArrayList;
import java.util.Iterator;

public class StringGridImpl implements StringGrid {
	
	private ArrayList<ArrayList<String>> stringGrid = new ArrayList<ArrayList<String>>();

	StringGridImpl(int row, int column) {
		for (int i = 0; i < row; i++) {
			this.stringGrid.add(new ArrayList<String>());
			for (int j = 0; j < column; j++) {
				this.stringGrid.get(i).add(null);
			}
		}
	}
	
	@Override
	public int getRowCount() {
		return stringGrid.size();
	}

	@Override
	public int getColumnCount() {
		return stringGrid.get(0).size();
	}

	@Override
	public String getElement(int row, int column) {
		if (row > this.getRowCount()-1 || column > this.getColumnCount()-1 || row < 0 || column < 0) {
			throw new IllegalArgumentException("Index out of range");
		}
		return stringGrid.get(row).get(column);
	}

	@Override
	public void setElement(int row, int column, String element) {
		if (row > this.getRowCount() || column > this.getColumnCount() || row < 0 || column < 0) {
			throw new IllegalArgumentException("Index out of range");
		}
		stringGrid.get(row).remove(column);
		stringGrid.get(row).add(column, element);
	}
	
	@Override
	public Iterator<String> iterator() {
		return new StringGridIterator(this, true);
	}
	
	public static void main(String[] args) {
		StringGridImpl stringGridTest = new StringGridImpl(2, 3);
		System.out.println(stringGridTest.getRowCount() + "," + stringGridTest.getColumnCount());
		stringGridTest.setElement(0, 0, "0,0");
		stringGridTest.setElement(0, 1, "0,1");
		stringGridTest.setElement(0, 2, "0,2");
		stringGridTest.setElement(1, 0, "1,0");
		stringGridTest.setElement(1, 1, "1,1");
		stringGridTest.setElement(1, 2, "1,2");
		for (String s: stringGridTest) {
			System.out.println(s);
		}
	}

	
}
