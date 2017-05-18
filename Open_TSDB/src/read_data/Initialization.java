package read_data;

import java.io.File;


public class Initialization {		//初始化， 用于记录写入文件路径和同步不同线程
	public static File [] fd;
	//public static String [] str;
	
	public void getFiles(String path)
	{
		File file = new File(path);
		fd=file.listFiles();
		//str = new String [fd.length+1];
		//for (int i=0;i<fd.length;i++){
		//	str[i] = fd[i].getName().substring(0,12);
		//}
	}
	
	private static int num =0;
	
	public static synchronized File getTask()
	{
		if (num == fd.length)
			return null;
		else
		{
			System.out.println(fd[num].getName());
			return fd[num++];
		}
	}
}
