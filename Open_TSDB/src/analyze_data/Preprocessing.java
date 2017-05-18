package analyze_data;

import cidp.edu.cn.model.Earthquakedata;

public class Preprocessing {
    private int interval;					//间隔(按秒计算)
    private long initial;					//初值
    private double [] data;						//数据数组
    
	public Preprocessing(Earthquakedata eqd){
		data = eqd.getData();
		initial = eqd.getInitial();
		interval = eqd.getInterval();
	}
	public void divide(int n){
		for (int i =0; i < data.length; i++){
			
		}
	}
}
