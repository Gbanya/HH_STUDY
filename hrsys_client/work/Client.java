package work;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @program: HH_STUDY
 * @description:
 * @author: qiu haoran
 * @create: 2020-07-20 15:45
 */
public class Client {
    BufferedReader in;
    PrintWriter out;
    private Socket tcpConnection;
    public Client() {
        try {
            tcpConnection = new Socket(InetAddress.getLocalHost(), 9090);
            System.out.println("�����Ϸ�������");
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static class clientContainer {
        private static Client client = new Client();
    }

    public static Client getClient() {
        return clientContainer.client;
    }

    public String sendMessageToSever(String message)//�����ַ���ȥ�ͷ���
    {
        String str = "";
        try {
//            out.println(message);
            System.out.println("����������ͣ�  "+message);
            tcpConnection.getOutputStream().write(message.getBytes("UTF-8"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return str;
    }

    public void closeClient()//�رտͻ��˲��ر�����
    {
        try {
            in.close();
            out.close();
            tcpConnection.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        new Client();

    }

//    public void clien( )
//    {
//        try {
//            OutputStream out=tcpConnection.getOutputStream();
//            //��ȡ�ͻ��˷����ġ����������ӳɹ���
//            String string=in.readLine();
//            System.out.println(string);
//            //�������̶߳�ȡ������������ָ��
//            ClientThread ct=new ClientThread(in);
//            ct.start();
//            while(true)
//
//            {
//                //�ͻ��˷�ָ���������
//                Scanner s=new Scanner(System.in);
//                String str=s.nextLine();
//                str+="\r\n";
//                out.write(str.getBytes());
//                out.flush();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    public String readstring(InputStream in) throws Exception
    {
        StringBuffer sb=new StringBuffer();
        char c=0;
        while(c!=13)
        {
            int i=in.read();
            c=(char)i;
            sb.append(c);
        }
        String s=sb.toString().trim();
        return s;
    }
}

