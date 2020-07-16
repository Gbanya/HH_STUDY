package util;

import model.Book;
import model.BookList;
import model.ReturnResult;

public class Parser 
{
	/**���ԡ�/n�������õ��Ƿ�ɹ��ͳɹ��������ʧ��ԭ��
	 * ���ʧ�� returnResult.isSuccess=false returnResult.failReasonΪ�����ĵڶ�����
	 * �ɹ���returnResult.isSuccess=true
	 * ���ԡ�;������������
	 * ���ԡ���������ÿ������������Էֱ𸳸�Book�浽BookList
	 * �ٰ�BookList�ŵ�returnResult.resultData��
	 * ����returnResult
	 * */
	public ReturnResult parserAdd(String message)
	{
		ReturnResult returnResult = new ReturnResult();
		String[] amessage=message.split("/n");
		if(amessage[0].equals("Success"))
		{
			returnResult.isSuccess = true;
		}
		else
		{
			returnResult.failReason=amessage[1];
		}
		return returnResult;
	}
	public ReturnResult parserDelete(String message)
	{
		ReturnResult returnResult = new ReturnResult();
		String[] amessage=message.split("/n");
		if(amessage[0].equals("Success"))
		{
			returnResult.isSuccess = true;
		}
		else
		{
			returnResult.failReason=amessage[1];
		}
		return returnResult;
	}
	public ReturnResult parserChange(String message)
	{
		ReturnResult returnResult = new ReturnResult();
		String[] amessage=message.split("/n");
		if(amessage[0].equals("Success"))
		{
			returnResult.isSuccess = true;
		}
		else
		{
			returnResult.failReason=amessage[1];
		}
		return returnResult;
	}
	public ReturnResult parserSearch(String message)
	{  
		ReturnResult returnResult = new ReturnResult();
		String[] amessage=message.split("/n");
		if(amessage[0].equals("Success"))
		{
			returnResult.isSuccess = true;
			String[] bookinfo=amessage[1].split(";");
			BookList bookList=new BookList();
			int bookSize=bookinfo.length;
			for(int i=0;i<bookSize;i++)
			{
				String[] book=bookinfo[i].split(",");
				String bookName=book[0];
				String bookAuthor=book[1];
				double bookPrice=Double.parseDouble(book[2]);
				Book Book=new Book(bookName,bookAuthor,bookPrice);
				bookList.add(Book);
			}
			returnResult.resultData=bookList;
		}
		else
		{
			returnResult.isSuccess = false;
			BookList bookList=new BookList();
			returnResult.failReason =amessage[1];
			returnResult.resultData=bookList;
		}
		return returnResult;
	}

}