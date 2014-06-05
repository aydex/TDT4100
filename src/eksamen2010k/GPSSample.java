package eksamen2010k;

public class GPSSample {
	
	private final GPSPoint point;
	private final long time;
	
	public GPSSample(GPSPoint point, int time) {
		this.point = point;
		this.time = time;
	}

	public GPSPoint getPoint() {
		return point;
	}

	public long getTime() {
		return time;
	}
	
	public double distance(GPSPoint point) {
		return GPSUtil.distance(this.point, point);
	}
	
	public double distance(GPSSample sample) {
		return GPSUtil.distance(this.point, sample.point);
	}

}
