package pers.wx.client_new;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.io.*;
import java.util.*;
import java.net.*;
 
public class client_new
{
 
	private static String line=null;
	public static void main(String[] args) throws UnknownHostException, IOException
	{
		runSocket();
		
	}
	private static void runSocket() throws IOException
	{
		final String HOST="192.168.1.2";
		//final String HOST="127.0.0.1";
		Socket socket = new Socket(HOST, 3574);//����һ���ͻ�������
		OutputStream out = socket.getOutputStream();//��ȡ����˵��������Ϊ���������������
		InputStream in=socket.getInputStream();//��ȡ����˵���������Ϊ�˻�ȡ��������������
 
		PrintWriter bufw=new PrintWriter(out,true);
		BufferedReader bufr=new BufferedReader(new InputStreamReader(in));
		while (true) 
		{
			line=bufr.readLine();//��ȡ����˴���������
			if(line==null)
				break;
			System.out.println("�����˵:"+line);//��ӡ����˴���������
			bufw.println((new Date()) + ",Hello,I am Client!");//�������ݸ������
 
		}
	}
	
}