package Operator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import model.ActionResult;
import model.Resume;
import model.ResumeList;
import model.ReturnResult;
import util.Parser;
import util.Protocol;
import work.Action;


/**
 * @author : liudeqing4191
 * @program : Operator\ServerThread.java
 * @description : ������Ҫ����
 * @date : 2020/7/16 13:52
 */

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
                ActionResult ar;
                if (ss.head.equals("add")) {
                    //���ݿ����
                    Action a = new Action();
                    ResumeList resumes = (ResumeList) ss.resultData;
                    Resume resume = resumes.get(0);
                    ar = a.addResume(resume);
                    //��дЭ�鱨��
                    Protocol protocol = new Protocol();
                    String message = protocol.addResumeMessage(ar);
                    System.out.println("��ͻ��˷��أ�   " + message);
                    out.println(message);
                } else if (ss.head.equals("delete")) {
                    //���ݿ����
                    Action a = new Action();
                    ResumeList resumes = (ResumeList) ss.resultData;
                    Resume resume = resumes.get(0);
                    ar = a.deleteResume(resume);
                    //��дЭ�鱨��
                    Protocol protocol = new Protocol();
                    String message = protocol.deleteResumeMessage(ar);
                    System.out.println("��ͻ��˷��أ�   " + message);
                    out.println(message);
                } else if (ss.head.equals("update")) {
                    //
                    Action a = new Action();
                    ResumeList resumes = (ResumeList) ss.resultData;
                    Resume resume = resumes.get(0);
                    ar = a.updataResume(resume);
                    //
                    Protocol protocol = new Protocol();
                    String message = protocol.updataResumeMessage(ar);
                    System.out.println("��ͻ��˷��أ�   " + message);
                    out.println(message);
                    break;
                } else if (ss.head.equals("searchbyid")) {
                    //���ݿ����
                    Action a = new Action();
                    ResumeList resumes = (ResumeList) ss.resultData;
                    Resume resume = resumes.get(0);
                    ar = a.searchResumeById(resume);
                    //��дЭ�鱨��
                    Protocol protocol = new Protocol();
                    String message = protocol.searchResumeMessage(ar);
                    System.out.println("��ͻ��˷��أ�   " + message);
                    out.println(message);
                } else if (ss.head.equals("searchbyname")) {
                    Action a = new Action();
                    ResumeList resumes = (ResumeList) ss.resultData;
                    Resume resume = resumes.get(0);
                    ar = a.searchResumeByName(resume);
                    //��дЭ�鱨��
                    Protocol protocol = new Protocol();
                    String message = protocol.searchResumeMessage(ar);
                    System.out.println("��ͻ��˷��أ�   " + message);
                    out.println(message);
                } else if (ss.head.equals("searchbyschool")) {
                    Action a = new Action();
                    ResumeList resumes = (ResumeList) ss.resultData;
                    Resume resume = resumes.get(0);
                    ar = a.searchResumeBySchool(resume);
                    //��дЭ�鱨��
                    Protocol protocol = new Protocol();
                    String message = protocol.searchResumeMessage(ar);
                    System.out.println("��ͻ��˷��أ�   " + message);
                    out.println(message);
                } else if (ss.head.equals("searchbyprocess")) {
                    Action a = new Action();
                    ResumeList resumes = (ResumeList) ss.resultData;
                    Resume resume = resumes.get(0);
                    ar = a.searchResumeByProcess(resume);
                    //��дЭ�鱨��
                    Protocol protocol = new Protocol();
                    String message = protocol.searchResumeMessage(ar);
                    System.out.println("��ͻ��˷��أ�   " + message);
                    out.println(message);
                } else if (ss.head.equals("searchbykeyword")) {
                    Action a = new Action();
                    ResumeList resumes = (ResumeList) ss.resultData;
                    Resume resume = resumes.get(0);
                    ar = a.searchResumeByKey(resume);
                    //��дЭ�鱨��
                    Protocol protocol = new Protocol();
                    String message = protocol.searchResumeMessage(ar);
                    System.out.println("��ͻ��˷��أ�   " + message);
                    out.println(message);
                }
            }

        }
    }

}
