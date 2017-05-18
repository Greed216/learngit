package read_data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Write_log {
	public static File f;
	public static BufferedWriter bw;
	public static File f_error;
	public static BufferedWriter bw_error;
	private static String start;
	private static String end;
	
	public static void init(String path, String error) throws IOException{
		start = date();
		f = new File(path+start+".txt");
		if (!f.exists()){
			f.createNewFile();
		}
		bw = new BufferedWriter(new FileWriter(f.getAbsoluteFile()));
		f_error = new File(path+start+".txt");
		if (!f_error.exists()){
			f_error.createNewFile();
		}
		bw_error = new BufferedWriter(new FileWriter(f_error.getAbsoluteFile()));
	}
	
	public static String date(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		return df.format(new Date());
	}
	
	public static void notify_name() throws IOException{
		end=date();     
		bw.close();
		bw_error.close();
		String filename=f.getAbsolutePath();     
		if(filename.indexOf(".")>=0)     {     
			filename = filename.substring(0,filename.lastIndexOf("/")+1);     
		}     
		f.renameTo(new File(filename+start+"_to_"+end+".txt"));
		filename=f_error.getAbsolutePath();     
		if(filename.indexOf(".")>=0)     {     
			filename = filename.substring(0,filename.lastIndexOf("/")+1);     
		}     
		f_error.renameTo(new File(filename+start+"_to_"+end+".txt"));
	}
}
