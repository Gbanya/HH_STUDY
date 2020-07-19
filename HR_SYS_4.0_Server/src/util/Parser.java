package util;

import model.Resume;
import model.ResumeList;
import model.ReturnResult;

public class Parser
{
	public Parser()
	{
		
	}
	static String[] amessage;
	static String head;
	static ReturnResult ss;
	static String message;
	public ReturnResult parser(String str)
	{
		/*
		 * �Ȱ���/n�������õ���Ҫ�Ĳ����Ͳ�������
		 * if����жϲ���
		 * �Ѳ�����������Ӧ��parser���������浽BookList��
		 * ��ReturnResult��head=�����õ���head
		 * ��ReturnResult��resultData����BookList
		 * */
		amessage=str.split("/n");
		head=amessage[0];
		message=amessage[1];
		ss=new ReturnResult();
		ss.head=head;
		if(head.equals("add"))
		{
			ResumeList bookList=parserAdd(message);
			ss.resultData=bookList;
		}
		return ss;
		
	}
	/*
	 * ��;�������õ�Book����������
	 * 	","����book���������Դ���Book��
	 * ��󶼴���BookList�з���
	 * * */
	public ResumeList parserAdd(String message) {
		String[] str=message.split(",");
		String bookName=str[0];
		String bookAuthor=str[1];
		String bookPrice=str[2];
		/*double bookPrice=Double.parseDouble(str[2]);*/
		Resume book=new Resume(bookName,bookAuthor,bookPrice);
		ResumeList bookList=new ResumeList();
		bookList.add(book);
		return bookList;
		
	}

}
