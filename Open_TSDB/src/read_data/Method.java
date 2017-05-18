package read_data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;

import Http.HttpRequest;

public class Method {
	
	
	public void Post(File file, String st, String url, int x) throws InterruptedException, IOException{	// 缓冲文本读取，文件名，post url地址， 存储模式
		String tempString = null;
		int rate;
		int t=0;
		String sr ="[ ";
		String result="success";
		String temp = "";
		BufferedReader reader = new BufferedReader(new FileReader(file));
		if (x==1){
			try {
				while((tempString = reader.readLine()) != null){
					String []str= tempString.split(" ");
					if (Double.parseDouble(str[1]) > 500000)
						continue;
					if (str[0].length()==12){
						rate = 1;
						Timestamp ts = new Timestamp(System.currentTimeMillis());
						String strr = str[0].substring(0, 4)+"-"+str[0].substring(4, 6)+"-"+str[0].substring(6, 8)+" "+str[0].substring(8, 10)+":"+str[0].substring(10, 12)+":"+"00";
						ts = Timestamp.valueOf(strr);
						sr +="{\"metric\":\""+st+"\", \"timestamp\":"+Long.toString(ts.getTime())+", \"value\":"+str[1]+", \"tags\":{\"rate\":\""+rate+"\"}},";
						t++;
						if (t>49){
							Thread.sleep(10);
							String total =sr.substring(0, sr.length()-1)+" ]";
							temp = HttpRequest.sendPost(url, total);
							if (temp.equals("error"))
								result = temp;
							sr ="[ ";
							t=0;
						}
					}else if (str[0].length()==10){
						rate = 2;
						Timestamp ts = new Timestamp(System.currentTimeMillis());
						String strr = str[0].substring(0, 4)+"-"+str[0].substring(4, 6)+"-"+str[0].substring(6, 8)+" "+str[0].substring(8, 10)+":00:00";
						ts = Timestamp.valueOf(strr);
						sr +="{\"metric\":\""+st+"\", \"timestamp\":"+Long.toString(ts.getTime())+", \"value\":"+str[1]+", \"tags\":{\"rate\":\""+rate+"\"}},";
						t++;
						if (t>49){
							Thread.sleep(10);
							String total =sr.substring(0, sr.length()-1)+" ]";
							temp = HttpRequest.sendPost(url, total);
							if (temp.equals("error"))
								result = temp;
							sr ="[ ";
							t=0;
						}
					}else if (str[0].length()==8){
						rate = 3;
						Timestamp ts = new Timestamp(System.currentTimeMillis());
						String strr = str[0].substring(0, 4)+"-"+str[0].substring(4, 6)+"-"+str[0].substring(6, 8)+" 00:00:00";
						ts = Timestamp.valueOf(strr);
						sr +="{\"metric\":\""+st+"\", \"timestamp\":"+Long.toString(ts.getTime())+", \"value\":"+str[1]+", \"tags\":{\"rate\":\""+rate+"\"}},";
						t++;
						if (t>49){
							Thread.sleep(10);
							String total =sr.substring(0, sr.length()-1)+" ]";
							temp = HttpRequest.sendPost(url, total);
							if (temp.equals("error"))
								result = temp;
							sr ="[ ";
							t=0;
						}
					}else if (str[0].length()==14){
						rate = 0;
						Timestamp ts = new Timestamp(System.currentTimeMillis());
						String strr = str[0].substring(0, 4)+"-"+str[0].substring(4, 6)+"-"+str[0].substring(6, 8)+" "+str[0].substring(8, 10)+":"+str[0].substring(10, 12)+":"+str[0].substring(12, 14);
						ts = Timestamp.valueOf(strr);
						sr +="{\"metric\":\""+st+"\", \"timestamp\":"+Long.toString(ts.getTime())+", \"value\":"+str[1]+", \"tags\":{\"rate\":\""+rate+"\"}},";
						t++;
						if (t>49){
							Thread.sleep(10);
							String total =sr.substring(0, sr.length()-1)+" ]";
							temp = HttpRequest.sendPost(url, total);
							if (temp.equals("error"))
								result = temp;
							sr ="[ ";
							t=0;
						}
					}
				}
				if (sr.length()>5){
					String total =sr.substring(0, sr.length()-1)+" ]";
					temp = HttpRequest.sendPost(url, total);
					if (temp.equals("error"))
						result = temp;
				}
				sr ="[ ";
				t=0;
				//Write_log.bw.write(Write_log.date()+" success "+file.getAbsolutePath()+" \n");
				//Write_log.bw.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//Write_log.bw.write(Write_log.date()+" fail "+file.getAbsolutePath()+" \n");
				//Write_log.bw_error.write(Write_log.date()+" fail "+file.getAbsolutePath()+" \n");
				//Write_log.bw.flush();
				//Write_log.bw_error.flush();
				e.printStackTrace();
			}
		}else if (x == 2){
			try {
				while((tempString = reader.readLine()) != null){
					String []str= tempString.split(" ");
					if (Double.parseDouble(str[1]) > 500000)
						continue;
					String[] s=st.split("_");
					if (str[0].length()==12){
						rate=1;
						Timestamp ts = new Timestamp(System.currentTimeMillis());
						String strr = str[0].substring(0, 4)+"-"+str[0].substring(4, 6)+"-"+str[0].substring(6, 8)+" "+str[0].substring(8, 10)+":"+str[0].substring(10, 12)+":"+"00";
						ts = Timestamp.valueOf(strr);
						sr +="{\"metric\":\""+s[2]+"\", \"timestamp\":"+Long.toString(ts.getTime())+", \"value\":"+str[1]+", \"tags\":{\"stationpoint\":\""+s[1]+"\",\"rate\":\""+rate+"\", \"station\":\""+s[0]+"\"}},";
						t++;
						if (t>49){
							Thread.sleep(10);
							String total =sr.substring(0, sr.length()-1)+" ]";
							temp = HttpRequest.sendPost(url, total);
							if (temp.equals("error"))
								result = temp;
							sr ="[ ";
							t=0;
						}
					}else if (str[0].length()==10){
						rate=2;
						Timestamp ts = new Timestamp(System.currentTimeMillis());
						String strr = str[0].substring(0, 4)+"-"+str[0].substring(4, 6)+"-"+str[0].substring(6, 8)+" "+str[0].substring(8, 10)+":00:00";
						ts = Timestamp.valueOf(strr);
						sr +="{\"metric\":\""+s[2]+"\", \"timestamp\":"+Long.toString(ts.getTime())+", \"value\":"+str[1]+", \"tags\":{\"stationpoint\":\""+s[1]+"\",\"rate\":\""+rate+"\", \"station\":\""+s[0]+"\"}},";
						t++;
						if (t>49){
							Thread.sleep(10);
							String total =sr.substring(0, sr.length()-1)+" ]";
							temp = HttpRequest.sendPost(url, total);
							if (temp.equals("error"))
								result = temp;
							sr ="[ ";
							t=0;
						}					
					}else if (str[0].length()==8){
						rate = 3;
						Timestamp ts = new Timestamp(System.currentTimeMillis());
						String strr = str[0].substring(0, 4)+"-"+str[0].substring(4, 6)+"-"+str[0].substring(6, 8)+" 00:00:00";
						ts = Timestamp.valueOf(strr);
						sr +="{\"metric\":\""+s[2]+"\", \"timestamp\":"+Long.toString(ts.getTime())+", \"value\":"+str[1]+", \"tags\":{\"stationpoint\":\""+s[1]+"\",\"rate\":\""+rate+"\", \"station\":\""+s[0]+"\"}},";
						t++;
						if (t>49){
							Thread.sleep(10);
							String total =sr.substring(0, sr.length()-1)+" ]";
							temp = HttpRequest.sendPost(url, total);
							if (temp.equals("error"))
								result = temp;
							sr ="[ ";
							t=0;
						}	
					}else if (str[0].length()==14){
						rate = 0;
						Timestamp ts = new Timestamp(System.currentTimeMillis());
						String strr = str[0].substring(0, 4)+"-"+str[0].substring(4, 6)+"-"+str[0].substring(6, 8)+" "+str[0].substring(8, 10)+":"+str[0].substring(10, 12)+":"+str[0].substring(12, 14);
						ts = Timestamp.valueOf(strr);
						sr +="{\"metric\":\""+s[2]+"\", \"timestamp\":"+Long.toString(ts.getTime())+", \"value\":"+str[1]+", \"tags\":{\"stationpoint\":\""+s[1]+"\",\"rate\":\""+rate+"\", \"station\":\""+s[0]+"\"}},";
						t++;
						if (t>49){
							Thread.sleep(10);
							String total =sr.substring(0, sr.length()-1)+" ]";
							temp = HttpRequest.sendPost(url, total);
							if (temp.equals("error"))
								result = temp;
							sr ="[ ";
							t=0;
						}	
					}
				}
			if (sr.length()>5){
				String total =sr.substring(0, sr.length()-1)+" ]";
				temp = HttpRequest.sendPost(url, total);
				if (temp.equals("error"))
					result = temp;
			}
			sr ="[ ";
			t=0;
			//Write_log.bw.write(Write_log.date()+" success "+file.getAbsolutePath()+" \n");
			//Write_log.bw.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//Write_log.bw.write(Write_log.date()+" fail "+file.getAbsolutePath()+" \n");
				//Write_log.bw_error.write(Write_log.date()+" fail "+file.getAbsolutePath()+" \n");
				//Write_log.bw.flush();
				//Write_log.bw_error.flush();
				e.printStackTrace();
			}
		}
		Write_log.bw.write(Write_log.date()+" "+result+" "+file.getAbsolutePath()+" \n");
		Write_log.bw.flush();
		if (result.equals("error")){
			Write_log.bw_error.write(Write_log.date()+" error "+file.getAbsolutePath()+" \n");
			Write_log.bw_error.flush();
		}
		reader.close();
	}
}
