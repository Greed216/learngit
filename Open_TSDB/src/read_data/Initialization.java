package read_data;

import java.io.File;


public class Initialization {		//��ʼ���� ���ڼ�¼д���ļ�·����ͬ����ͬ�߳�
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
