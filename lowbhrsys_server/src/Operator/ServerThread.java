package Operator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import medol.ActionResult;
import medol.Book;
import medol.BookList;
import medol.ReturnResult;
import util.Parser;
import util.Protocol;
import work.Action;

public class ServerThread extends Thread
{
	Socket connection;
	static BufferedReader in;
	static PrintWriter out;
	static String str;
	public ServerThread(Socket connection)
	{
		this.connection=connection;
	}
	@Override
	public void run()
	{
		while(true)
		{
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
				 in =new BufferedReader(new InputStreamReader(connection.getInputStream()));
				 out =new PrintWriter(new BufferedWriter(new OutputStreamWriter(connection.getOutputStream())),true);
				 str = in.readLine();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if(str.equals("bye"))
			{
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
			}
			else
			{
			Parser parser=new Parser();
			ReturnResult ss=parser.parser(str);
			ActionResult ar=new ActionResult();
			if(ss.head.equals("add"))
			{
				Action a=new Action();
				BookList bookList=(BookList)ss.resultData;
				Book book=bookList.get(0);
				ar=a.addbook(book);
				Protocol protocol=new Protocol();
				String message=protocol.AddBookMessage(ar);
				System.out.println("��ͻ��˷��أ�   "+message);
				out.println(message);

			}		
			else if(ss.head.equals("deletebyname"))
			{
				Action a=new Action();
				BookList bookList=(BookList)ss.resultData;
				Book book=bookList.get(0);
				ar=a.deleteBookByName(book);
				Protocol protocol=new Protocol();
				String message=protocol.deleteBookByNameMessage(ar);
				System.out.println("��ͻ��˷��أ�   "+message);
				out.println(message);
			}
			else if(ss.head.equals("deletebyauthor"))
			{
				Action a=new Action();
				BookList bookList=(BookList)ss.resultData;
				Book book=bookList.get(0);
				ar=a.deleteBookByAuthor(book);
				Protocol protocol=new Protocol();
				String message=protocol.deleteBookByAuthorMessage(ar);
				System.out.println("��ͻ��˷��أ�   "+message);
				out.println(message);				
			}
			else if(ss.head.equals("change"))
			{
				Action a=new Action();
				BookList bookList=(BookList)ss.resultData;
				Book book=bookList.get(0);
				Book oldbook=bookList.get(1);
				ar=a.changeBook(book, oldbook);
				Protocol protocol=new Protocol();
				String message=protocol.changeBookMessage(ar);
				System.out.println("��ͻ��˷��أ�   "+message);
				out.println(message);
				break;
			}
			else if(ss.head.equals("searchbyname"))
			{
				Action a=new Action();
				BookList bookList=(BookList)ss.resultData;
				Book book=bookList.get(0);
				ar=a.searchBookByName(book);
				Protocol protocol=new Protocol();
				String message=protocol.searchBookByNameMessage(ar);
				System.out.println("��ͻ��˷��أ�   "+message);
				out.println(message);
			}
			else if(ss.head.equals("searchbyauthor"))
			{
				Action a=new Action();
				BookList bookList=(BookList)ss.resultData;
				Book book=bookList.get(0);
				ar=a.searchBookByAuthor(book);
				Protocol protocol=new Protocol();
				String message=protocol.searchBookByAuthorMessage(ar);
				System.out.println("��ͻ��˷��أ�   "+message);
				out.println(message);
//				break;
			}
			else if(ss.head.equals("searchbyprice"))
			{
				Action a=new Action();
				BookList bookList=(BookList)ss.resultData;
				Book book=bookList.get(0);
				ar=a.searchBookByPrice(book);
				Protocol protocol=new Protocol();
				String message=protocol.searchBookByPriceMessage(ar);
				System.out.println("��ͻ��˷��أ�   "+message);
				out.println(message);
//				break;
			}
			else if(ss.head.equals("searchbykeyword"))
			{
				Action a=new Action();
				BookList bookList=(BookList)ss.resultData;
				Book book=bookList.get(0);
				ar=a.searchBookByPointword(book);
				Protocol protocol=new Protocol();
				String message=protocol.searchBookByKeyWordMessage(ar);
				System.out.println("��ͻ��˷��أ�   "+message);
				out.println(message);
//				break;
			}
			}
			
		}
	}

}
