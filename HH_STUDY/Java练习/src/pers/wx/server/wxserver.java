package pers.wx.server;
import java.net.*;
import java.io.*;

public class wxserver {
	public wxserver(){
		try{
			ServerSocket wxs=new ServerSocket(9999);//���÷������Ķ˿�
			System.out.println("���������ڼ���");
			Socket s=wxs.accept();//ֻ�з��������ͻ�����֮�󣬲Ż�ִ�к�������
			//System.out.println("22");//��֤�Ƿ����ӳɹ�
			InputStreamReader isr=new InputStreamReader(s.getInputStream());//���տͻ��˵�����
			BufferedReader br=new BufferedReader(isr);//���뻺��
			String xinxi=br.readLine();//����
			System.out.println(xinxi);//��ӡ����
			PrintWriter pw=new PrintWriter(s.getOutputStream(),true);//��ͻ��˴�����
			pw.println("���Ƿ�����");//������ɶ
			//ss.close();
		}catch(Exception e){
 
 
		}
	}

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		wxserver a=new wxserver();

	}

}
