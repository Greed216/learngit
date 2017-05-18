package query_data;

import java.sql.Timestamp;

import Http.HttpRequest;
import cidp.edu.cn.model.Dbbeen;
import cidp.edu.cn.model.Earthquakedata;



public class Method {
	Dbbeen dbb=new Dbbeen();
    String url="172.17.81.237:4242"; 
    int interval = 0;					//���(�������)
    long initial = 0;					//��ֵ
    double [] data;						//��������
    
    public void Seturl(String url)
        {
                this.url=url;
        }

	public void query(Dbbeen dbb){
		String url="172.17.81.238:4242";
        String start = dbb.getStarttime();
        String end = dbb.getEndtime();
        String item = dbb.getItem();
        String station = dbb.getStation();
        String stationpoint = dbb.getStationpoint();
        String rate = dbb.getZoom();
        String aggregator = dbb.getAggregator();    
        Timestamp tstart = new Timestamp(System.currentTimeMillis());
		Timestamp tend = new Timestamp(System.currentTimeMillis());
		/*String s_start = start.substring(0, 4)+"-"+start.substring(4, 6)+"-"+start.substring(6, 8)+" "+start.substring(8, 10)+":"+start.substring(10, 12)+":"+"00";
		String s_end = end.substring(0, 4)+"-"+end.substring(4, 6)+"-"+end.substring(6, 8)+" "+end.substring(8, 10)+":"+end.substring(10, 12)+":"+"00";	*/
		tstart = Timestamp.valueOf(start);
		tend = Timestamp.valueOf(end);
		String metric = station+"_"+stationpoint+"_"+item;
		String json2 = "start="+Long.toString(tstart.getTime())+"&end="+Long.toString(tend.getTime())+"&m="+aggregator+":"+metric+"{rate="+rate+"}";
		System.out.println(json2);
		String s=HttpRequest.sendGet("http://"+url+"/api/query", json2);
        String[] si = s.split(",");
        si[3] = si[3].substring(7, si[3].length());
        si[si.length-1]=si[si.length-1].substring(0, si[si.length-1].length()-3);
        String[]  sp =new String[2];
        int zoom = Integer.parseInt(rate);	//������
        if (zoom == 0){					//������
        	interval = 1;
        }else if (zoom == 1){			//������
        	interval = 60;
        }else if (zoom == 2){			//ʱ����
        	interval = 3600;
        }else if (zoom == 3){			//������
        	interval = 86400;
        }else if (zoom == 4){			//������
        	interval = 604800;
        }else if (zoom == 5){			//�����ݣ������ȷ��		86400*30
        	interval = 2592000;
        }else if (zoom == 6){			//�������ݣ������ȷ��	259200*3
        	interval = 7776000;
        }else if (zoom == 7){			//�����ݣ������ȷ��		86400*365
        	interval = 31536000;
        }
        data = new double[si.length];
        int t = 2;									
        for(int i = 3 ; i < si.length; i++){
        	sp = si[i].split(":");                   
            double d = Double.parseDouble(sp[1]);
            if (i == 3){
            	initial = new Long(sp[0].substring(1, sp[0].length()-1));		//��ֵ
            }
            data[t++] = d;
        }
       // for (int i = 0; i < t; i++){
       // 	System.out.println(data[i]);
       // }
        //System.out.println(initial+" "+interval);
	}
	
	public Earthquakedata transmit(){
		 Earthquakedata eqd = new Earthquakedata();
		 eqd.setData(data);
	     eqd.setInitial(initial);
	     eqd.setInterval(interval);
	     return eqd;
	}
	
	
	public static void main(String a[]){
		Dbbeen da = new Dbbeen();
        Method ou = new Method();
        da.setStation("11015");
        da.setEndtime("2016-01-01 00:10:00");
        da.setStarttime("2016-01-01 00:00:00");
        da.setItem("4112");
        da.setStationpoint("1");
        da.setZoom("1");     
        ou.query(da);
        //System.out.println(Arrays.toString(ou.query(da))); 
    }

}

