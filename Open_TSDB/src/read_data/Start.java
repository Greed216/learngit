package read_data;

import java.io.IOException;

import read_data.MyThread;

public class Start {
	
	public static long starttime;
	public static long endtime;
	public static void main(String[] args) throws IOException, InterruptedException {	//args[0]是文件输入路径，args[1]是存储模式(1为台站_测点_测项结合metric，2为测项为metric)
		// TODO Auto-generated method stub
		Initialization init = new Initialization();
		if (args.length >0)
		{
			System.out.println("path="+args[0]);
			//init.getFiles("/home/hadoop/Videos/data");
			init.getFiles(args[0]);
		}
		String file = "/home/hadoop/earthquakelog/";
		String file_error = "/home/hadoop/earthquakelog/error/" ;
		Write_log.init(file,file_error);//("/home/hadoop/earthquakelog/1.txt","/home/hadoop/earthquakelog/error/1.txt");
		starttime= System.currentTimeMillis();	//开始计时
		MyThread mt1 = new MyThread("http://172.17.81.235:4242/api/put", Integer.parseInt(args[1]));int t1 = 2;		//bigdata-2 thread*4
		MyThread mt2 = new MyThread("http://172.17.81.238:4242/api/put", Integer.parseInt(args[1]));int t2 = 2;		//bigdata-1 thread*2
		MyThread mt3 = new MyThread("http://172.17.81.236:4242/api/put", Integer.parseInt(args[1]));int t3 = 1;		//bigdata-5 thread*2
		MyThread mt4 = new MyThread("http://172.17.81.240:4242/api/put", Integer.parseInt(args[1]));int t4 = 1;		//bigdata-3 thread*2
		MyThread mt5 = new MyThread("http://172.17.81.237:4242/api/put", Integer.parseInt(args[1]));int t5 = 0;		//bigdata-4 thread*1
		Thread [] th1 = new Thread[10];
		Thread [] th2 = new Thread[10];
		Thread [] th3 = new Thread[10];
		Thread [] th4 = new Thread[10];
		Thread [] th5 = new Thread[10];
		for (int i = 0; i< t1; i++){
			 th1[i] = new Thread(mt1);
			 th1[i].start();
		}
		for (int i = 0; i< t2; i++){
			 th2[i] = new Thread(mt2);
			 th2[i].start();
		}
		for (int i = 0; i< t3; i++){
			 th3[i] = new Thread(mt3);
			 th3[i].start();
		}
		for (int i = 0; i< t4; i++){
			 th4[i] = new Thread(mt4);
			 th4[i].start();
		}
		for (int i = 0; i< t5; i++){
			 th5[i] = new Thread(mt5);
			 th5[i].start();
		}
		boolean f = false;
		while (true){
			
			for (int i = 0; i< t1; i++){
				 if (th1[i].isAlive())
					 f = true;
			}
			for (int i = 0; i< t2; i++){
				if (th2[i].isAlive())
					 f = true;
			}
			for (int i = 0; i< t3; i++){
				if (th3[i].isAlive())
					 f = true;
			}
			for (int i = 0; i< t4; i++){
				if (th4[i].isAlive())
					 f = true;
			}
			for (int i = 0; i< t5; i++){
				if (th5[i].isAlive())
					 f = true;
			}
			if (!f){
				Write_log.notify_name();
				break;
			}
			Thread.currentThread();
			Thread.sleep(10000);
			f = false;
		}
	}

}
