/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cidp.edu.cn.model;

public class Dbbeen {
    private String station ="*";      //̨վ
    private String item = "*";         //����
    private String stationpoint = "*";  //���
    private String starttime = "*";   //��ʼʱ��
    private String endtime = "*";     //����ʱ��
    private String zoom = "*";        //������
    private String aggregator = "sum";   //�ۺ���

    public String getAggregator() {
        return aggregator;
    }
   // ���þۺ��� Ĭ�� ��sum��
    public void setAggregator(String aggregator) {
        this.aggregator = aggregator;
    }
    
     //��ȡ̨վ
    public String getStation() {
        return station;
    }
    //����̨վ
    public void setStation(String station) {
        this.station = station;
    }
     //��ȡ����
    public String getItem() {
        return item;
    }
     //���ò���
    public void setItem(String item) {
        this.item = item;
    }
   //��ȡ���
    public String getStationpoint() {
        return stationpoint;
    }
//���ò��
    public void setStationpoint(String stationpoint) {
        this.stationpoint = stationpoint;
    }
//��ȡ��ʼʱ��
    public String getStarttime() {
        return starttime;
    }
//���ÿ�ʼʱ��
    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }
//��ȡ����ʱ��
    public String getEndtime() {
        return endtime;
    }
  //���ý���ʱ��
    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }
   //��ȡ������
    public String getZoom() {
        return zoom;
    }
 //���ò�����
    public void setZoom(String zoom) {
        this.zoom = zoom;
    }
    
}
