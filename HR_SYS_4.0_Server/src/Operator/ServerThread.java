package Operator;

import model.ActionResult;
import model.Resume;
import model.ResumeList;
import model.ReturnResult;
import util.Parser;
import util.Protocol;
import work.Action;

import java.io.*;
import java.net.Socket;

public class ServerThread extends Thread {
    Socket connection;
    static BufferedReader in;
    static PrintWriter out;
    static String str;

    public ServerThread(Socket connection) {
        this.connection = connection;
    }

    @Override
    public void run() {
        while (true) {
            /*
             * ��Server�е�getMessageByClient�����õ�Э�飨�ַ�����
             * ��Э�飨�ַ������ŵ�parser����� ���صõ�ReturnResult������head�������������ԣ����ͽ��
             * if����ж�head��Ϣ�õ��û��������ʲô����
             * ��ReturnResult��dataת��ΪbookList�Ӷ��õ�Book
             * �ѵõ���Book����Action�����������ݿ������ɾ�Ĳ�Ĳ���������ActionResult�������Ƿ�ɹ� ��ʧ��Ը�� ���ɹ�����������ԣ����ͽ��
             * ��ActionResult����Protocol�б�дЭ�飨�ַ�����������
             * ��Server�е�sendMessageToClient������Э�飨�ַ��������͵��ͻ���
             * �������������ϢΪ"bye"�رշ���������while
             * */
            try {
                in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(connection.getOutputStream())), true);
                str = in.readLine();

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            if (str.equals("bye")) {
                try {
                    out.println("bye");
                    in.close();
                    out.close();
                    connection.close();
                    break;
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } else {
                Parser parser = new Parser();
                ReturnResult ss = parser.parser(str);
                ActionResult ar = new ActionResult();
                if (ss.head.equals("add")) {
                    Action a = new Action();
                    ResumeList resumeList = (ResumeList) ss.resultData;
                    Resume resume = resumeList.get(0);
                    ar = a.addResume(resume);
                    Protocol protocol = new Protocol();
                    String message = protocol.AddResumeMessage(ar);
                    System.out.println("��ͻ��˷��أ�   " + message);
                    out.println(message);
                }

            }

        }
    }

}
