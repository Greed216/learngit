package analyze_data;

import cidp.edu.cn.model.Earthquakedata;

public class Preprocessing {
    private int interval;					//���(�������)
    private long initial;					//��ֵ
    private double [] data;						//��������
    
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
