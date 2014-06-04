package eksamen2008k;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;


public class PriceList implements Comparator<MobileThing> {
	
	Map<MobileThing, Integer> priceList = new HashMap<MobileThing, Integer>();
	
	private ArrayList<PriceListener> listeners = new ArrayList<PriceListener>();
	
	public void addListener(PriceListener listener) {
		listeners.add(listener);
	}
	
	public void add(MobileThing mb, int price) {
		priceList.put(mb, price);
	}
	
	public void add(MobileThing mb) {
		priceList.put(mb, -1);
	}
	
	public void remove(MobileThing mb) {
		priceList.remove(mb);
	}
	
	public void setPrice(MobileThing mb, int price) {
		if (priceList.containsKey(mb)) {
			priceList.put(mb, price);
			for (PriceListener pl : listeners) {
				pl.notifyPrice(mb, price);
			}
		} else {
			throw new IllegalArgumentException("MobileThing is not in this PriceList: " + mb);
		}
	}
	
	public ArrayList<MobileThing> sortOnMemory(Map<MobileThing, Integer> map) {
		ArrayList<MobileThing> sortedList = new ArrayList<MobileThing>();
		for (MobileThing mb : map.keySet()) {
			sortedList.add(mb);
		}
		Collections.sort(sortedList);
		return sortedList;
	}
	
	public ArrayList<MobileThing> sortOnPrice(Map<MobileThing, Integer> map) {
		ArrayList<MobileThing> sortedList = new ArrayList<MobileThing>();
		for (MobileThing mb : map.keySet()) {
			sortedList.add(mb);
		}
		Collections.sort(sortedList, this);
		return sortedList;
	}
	
	public int getPrice(MobileThing mb) {
		return priceList.get(mb) != null ? priceList.get(mb) : -1;
	}
	
	public Map<MobileThing, Integer> getMobilesFromBrand(String brand) {
		Map<MobileThing, Integer> newList = new HashMap<MobileThing, Integer>();
		for (MobileThing mb : priceList.keySet()) {
			if (mb.getBrand().equals(brand)) {
				newList.put(mb, priceList.get(mb));
			}
		}
		return newList;
	}

	@Override
	public int compare(MobileThing o1, MobileThing o2) {
		int p1 = getPrice(o1);
		int p2 = getPrice(o2);
		return p1-p2;
	}
	
}
