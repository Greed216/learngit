package cidp.edu.cn.model;

public class Earthquakedata {
	private int interval;
	private long initial;
	private double [] data;
	
	public int getInterval() {
		return interval;
	}
	public void setInterval(int interval) {
		this.interval = interval;
	}
	public long getInitial() {
		return initial;
	}
	public void setInitial(long initial) {
		this.initial = initial;
	}
	public double[] getData() {
		return data;
	}
	public void setData(double[] data) {
		this.data = data;
	}

	
}
