package read_data;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;



public class MyThread implements Runnable{	//∂‡œﬂ≥Ã
	
	private String url;
	private int x;
	
	public MyThread(String url, int x){
		this.url = url;	
		this.x = x;
	}
	
	public MyThread(){}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		File file;
		Method m = new Method();
		while(true){
			file=Initialization.getTask();
			if (file == null) break;
			String st = file.getName().substring(0, 12);
			try {
				m.Post(file, st, url, x);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
		System.out.println("Congratulation~"+url);
		Start.endtime = System.currentTimeMillis();
		System.out.println(Start.endtime-Start.starttime);
	}
}
