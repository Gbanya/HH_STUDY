package operator;

/**
 * @program: HH_STUDY
 * @description:
 * @author: qiu haoran
 * @create: 2020-07-20 16:08
 */
import work.SocketThread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String []args)
    {
        //����һ���������������ö˿ں�Ϊ9090
        Server s=new Server();
        s.setServer(9090);
    }
    /**
     * ʵ�ַ������ĳ�ʼ��
     * @param port �˿ں�
     */
    public void setServer(int port)
    {
        try {
            ServerSocket s=new ServerSocket(port);
            System.out.println("�����������ɹ�,�˿ں�Ϊ"+port);
            //�ȴ��ͻ��˵�����
            Socket client=s.accept();
            processchat(client);


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    /**
     * ʵ�ַ������Ķ���д
     * @param client
     */
    public void processchat(Socket client)
    {

        try {
            InputStream in=client.getInputStream();
            OutputStream out=client.getOutputStream();
            BufferedReader bd=new BufferedReader(new InputStreamReader(in));
            //�����������ӳɹ���ָ������ͻ��ˡ�
            String s1="���������ӳɹ�"+"\r\n";
            out.write(s1.getBytes());
            out.flush();
            //�������������߳̽��з�������д����
            SocketThread so=new SocketThread(client);
            so.start();
            while(true)
            {   //��������ȡ�ͻ��˷�����ָ��������Ķ�����
                BufferedReader brd=new BufferedReader(new InputStreamReader(in));
                String s = brd.readLine();
                System.out.println("�ͻ���˵"+s);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}