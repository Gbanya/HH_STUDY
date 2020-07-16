package util;

import medol.ActionResult;
import medol.BookList;

public class Protocol {
	public Protocol()
	{
		
	}
	/*
	 * ��ActionResult���������԰�ActionResult.isSuccess+"/n"+failReason����ActionResult.isSuccess+"/n"+��ActionResult.resultData
	 * �õ����ַ�������ʽ��д
	 * ��forѭ����õ�ActionResult.resultData���ַ���
	 * */
	public String AddBookMessage(ActionResult ar)
	{	
		String str;
		String isSuccess=ar.isSuccess;
		if(isSuccess.equals("Success"))
		{
			str=isSuccess+"/n";
		}
		else
		{
			str=isSuccess+"/n"+ar.failReason;
		}
		return str;
	}
	public String deleteBookByNameMessage(ActionResult ar)
	{
		String str;
		String isSuccess=ar.isSuccess;
		if(isSuccess.equals("Success"))
		{
			str=isSuccess+"/n";
		}
		else
		{
			str=isSuccess+"/n"+ar.failReason;
		}
		return str;
	}
	public String deleteBookByAuthorMessage(ActionResult ar)
	{
		String str;
		String isSuccess=ar.isSuccess;
		if(isSuccess.equals("Success"))
		{
			str=isSuccess+"/n";
		}
		else
		{
			str=isSuccess+"/n"+ar.failReason;
		}
		return str;
	}
	public String changeBookMessage(ActionResult ar)
	{
		String str;
		String isSuccess=ar.isSuccess;
		if(isSuccess.equals("Success"))
		{
			str=isSuccess+"/n";
		}
		else
		{
			str=isSuccess+"/n"+ar.failReason;
		}
		return str;
	}
	public String searchBookByNameMessage(ActionResult ar)
	{
		String str;
		String isSuccess=ar.isSuccess;
		if(isSuccess.equals("Success"))
		{
			BookList bookList=(BookList)ar.resultData;
			str=isSuccess+"/n";
			//forѭ���õ�ActionResult.resultData�ַ���Ӧ���ַ���
			int booksize=bookList.size();
			for(int i=0;i<booksize;i++)
			{
				String bookstring=bookList.get(i).bookName+","+bookList.get(i).bookAuthor+","+bookList.get(i).bookPrice+";";
				str=str+bookstring;
			}
		}
		else
		{
			str=isSuccess+"/n"+ar.failReason;
		}
		return str;
	}
	public String searchBookByAuthorMessage(ActionResult ar)
	{
		String str;
		String isSuccess=ar.isSuccess;
		if(isSuccess.equals("Success"))
		{
			BookList bookList=(BookList)ar.resultData;
			str=isSuccess+"/n";
			//forѭ���õ�ActionResult.resultData�ַ���Ӧ���ַ���
			int booksize=bookList.size();
			for(int i=0;i<booksize;i++)
			{
				String bookstring=bookList.get(i).bookName+","+bookList.get(i).bookAuthor+","+bookList.get(i).bookPrice+";";
				str=str+bookstring;
			}
		}
		else
		{
			str=isSuccess+"/n"+ar.failReason;
		}
		return str;
	}
	public String searchBookByPriceMessage(ActionResult ar)
	{	
		String str;
		
		String isSuccess=ar.isSuccess;
		if(isSuccess.equals("Success"))
		{
			BookList bookList=(BookList)ar.resultData;
			str=isSuccess+"/n";
			//forѭ���õ�ActionResult.resultData�ַ���Ӧ���ַ���
			int booksize=bookList.size();
			for(int i=0;i<booksize;i++)
			{
				String bookstring=bookList.get(i).bookName+","+bookList.get(i).bookAuthor+","+bookList.get(i).bookPrice+";";
				str=str+bookstring;
			}
		}
		else
		{
			str=isSuccess+"/n"+ar.failReason;
		}
		return str;

	}
	public String searchBookByKeyWordMessage(ActionResult ar)
	{
		String str;
		String isSuccess=ar.isSuccess;
		if(isSuccess.equals("Success"))
		{
			BookList bookList=(BookList)ar.resultData;
			str=isSuccess+"/n";
			//forѭ���õ�ActionResult.resultData�ַ���Ӧ���ַ���
			int booksize=bookList.size();
			for(int i=0;i<booksize;i++)
			{
				String bookstring=bookList.get(i).bookName+","+bookList.get(i).bookAuthor+","+bookList.get(i).bookPrice+";";
				str=str+bookstring;
			}
		}
		else
		{
			str=isSuccess+"/n"+ar.failReason;
		}
		return str;
	}
}
