package pers.wx.client;
import java.net.*;
import java.io.*;
public class wxclient {
public int data;
public int flag = 0;
 public static void main(String[] args){
	 wxclient c=new wxclient();
 }
 public wxclient(){
	 try{
		 Socket wxc=new Socket("192.168.1.2",9999);//����˿ڣ�ǰ���Ƿ�������Ip���Լ�����һ����127.0.0.1,������Ƕ˿ڣ����������Ӧ
	 PrintWriter pw=new PrintWriter(wxc.getOutputStream(),true);//IO������
	 while(flag!=1)
	 {
	 pw.println(data);//���͵�����
	 //pw.flush();
	 //s.shutdownInput();
	 }
	InputStream isr=wxc.getInputStream();//��ȡ����
	 BufferedReader br=new BufferedReader(new InputStreamReader(isr));//�浽������
	 String fanhui=br.readLine();//��ȡ����
	 System.out.println(fanhui);//�������
	 //s.close();
	 }catch(Exception e){
		 
	 }
 }
}