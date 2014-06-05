package eksamen2010k;

import java.util.ArrayList;
import java.util.Iterator;

public class GPSData implements Iterable<GPSSample>{

	private ArrayList<GPSSample> samples= new ArrayList<GPSSample>();
	
	public void addGPSData(GPSSample sample) {
		this.samples.add(sample);
	}
	
	public Iterator<GPSSample> iterator() {
		return samples.iterator();
	}
	
	public int reduce() {
		int removed = 0;
		for (int i = 1; i < samples.size(); i++) {
			if ((samples.get(i).getTime() - samples.get(i-1).getTime() < 30) || GPSUtil.distance(samples.get(i).getPoint(), samples.get(i-1).getPoint()) < 15) {
				samples.remove(i);
				removed++;
			}
		}
		return removed;
	}
	
	public boolean contains(GPSPoint point, double distance) {
		for (GPSSample sample : samples) {
			if (sample.distance(point) < distance) {
				return true;
			}
		}
		return false;
	}
	
	public GPSSample closest(GPSPoint point) {
		GPSSample closest = null;
		for (GPSSample sample : samples) {
			if (sample.distance(point) < closest.distance(point) || closest == null) {
				closest = sample;
			}
		}
		return closest;
	}

}
