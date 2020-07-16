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
 * @description : 进程主要工作
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
             * 用Server中的getMessageByClient方法得到协议（字符串）
             * 把协议（字符串）放到parser里解析 返回得到ReturnResult（包含head和数据两个属性）类型结果
             * if语句判断head信息得到用户端想进行什么操作
             * 把ReturnResult的data转换为bookList从而得到Book
             * 把得到的Book传到Action进行连接数据库进行增删改查的操作并返回ActionResult（包含是否成功 ，失败愿意 ，成功结果三个属性）类型结果
             * 把ActionResult交给Protocol中编写协议（字符串）并返回
             * 用Server中的sendMessageToClient方法把协议（字符串）发送到客户端
             * 如果传过来的信息为"bye"关闭服务器跳出while
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
                    //数据库操作
                    Action a = new Action();
                    ResumeList resumes = (ResumeList) ss.resultData;
                    Resume resume = resumes.get(0);
                    ar = a.addResume(resume);
                    //编写协议报文
                    Protocol protocol = new Protocol();
                    String message = protocol.addResumeMessage(ar);
                    System.out.println("向客户端返回：   " + message);
                    out.println(message);
                } else if (ss.head.equals("delete")) {
                    //数据库操作
                    Action a = new Action();
                    ResumeList resumes = (ResumeList) ss.resultData;
                    Resume resume = resumes.get(0);
                    ar = a.deleteResume(resume);
                    //编写协议报文
                    Protocol protocol = new Protocol();
                    String message = protocol.deleteResumeMessage(ar);
                    System.out.println("向客户端返回：   " + message);
                    out.println(message);
                } else if (ss.head.equals("update")) {
                    //
                    Action a = new Action();
                    ResumeList resumes = (ResumeList) ss.resultData;
                    Resume resume = resumes.get(0);
                    ar = a.updateResume(resume);
                    //
                    Protocol protocol = new Protocol();
                    String message = protocol.updataResumeMessage(ar);
                    System.out.println("向客户端返回：   " + message);
                    out.println(message);
                } else if (ss.head.equals("searchbyid")) {
                    //数据库操作
                    Action a = new Action();
                    ResumeList resumes = (ResumeList) ss.resultData;
                    Resume resume = resumes.get(0);
                    ar = a.searchResumeById(resume);
                    //编写协议报文
                    Protocol protocol = new Protocol();
                    String message = protocol.searchResumeMessage(ar);
                    System.out.println("向客户端返回：   " + message);
                    out.println(message);
                } else if (ss.head.equals("searchbyname")) {
                    Action a = new Action();
                    ResumeList resumes = (ResumeList) ss.resultData;
                    Resume resume = resumes.get(0);
                    ar = a.searchResumeByName(resume);
                    //编写协议报文
                    Protocol protocol = new Protocol();
                    String message = protocol.searchResumeMessage(ar);
                    System.out.println("向客户端返回：   " + message);
                    out.println(message);
                } else if (ss.head.equals("searchbyschool")) {
                    Action a = new Action();
                    ResumeList resumes = (ResumeList) ss.resultData;
                    Resume resume = resumes.get(0);
                    ar = a.searchResumeBySchool(resume);
                    //编写协议报文
                    Protocol protocol = new Protocol();
                    String message = protocol.searchResumeMessage(ar);
                    System.out.println("向客户端返回：   " + message);
                    out.println(message);
                } else if (ss.head.equals("searchbyprocess")) {
                    Action a = new Action();
                    ResumeList resumes = (ResumeList) ss.resultData;
                    Resume resume = resumes.get(0);
                    ar = a.searchResumeByProcess(resume);
                    //编写协议报文
                    Protocol protocol = new Protocol();
                    String message = protocol.searchResumeMessage(ar);
                    System.out.println("向客户端返回：   " + message);
                    out.println(message);
                } else if (ss.head.equals("searchbykey")) {
                    Action a = new Action();
                    ResumeList resumes = (ResumeList) ss.resultData;
                    Resume resume = resumes.get(0);
                    ar = a.searchResumeByKey(resume);
                    //编写协议报文
                    Protocol protocol = new Protocol();
                    String message = protocol.searchResumeMessage(ar);
                    System.out.println("向客户端返回：   " + message);
                    out.println(message);
                }
            }

        }
    }

}
