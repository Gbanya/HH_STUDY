package util;

import model.Resume;
import model.ReturnResult;

import java.util.ArrayList;

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
			returnResult.setIsSuccess(true);
		}
		else
		{
			returnResult.setFailReason(amessage[1]);
		}
		return returnResult;
	}
	public ReturnResult parserDelete(String message)
	{
		ReturnResult returnResult = new ReturnResult();
		String[] amessage=message.split("/n");
		if(amessage[0].equals("Success"))
		{
			returnResult.setIsSuccess(true);
		}
		else
		{
			returnResult.setFailReason(amessage[1]);
		}
		return returnResult;
	}
	public ReturnResult parserChange(String message)
	{
		ReturnResult returnResult = new ReturnResult();
		String[] amessage=message.split("/n");
		if(amessage[0].equals("Success"))
		{
			returnResult.setIsSuccess(true);
		}
		else
		{
			returnResult.setFailReason(amessage[1]);
		}
		return returnResult;
	}
	public ReturnResult parserSearch(String message)
	{
		ReturnResult returnResult = new ReturnResult();
		String[] amessage=message.split("/n");
		if(amessage[0].equals("Success"))
		{
			returnResult.setIsSuccess(true);
			String[] bookinfo=amessage[1].split(";");
			ArrayList<Resume> bookList=new ArrayList<>();
			int bookSize=bookinfo.length;
			for(int i=0;i<bookSize;i++)
			{
				String[] Resume=bookinfo[i].split(",");
				String name=Resume[0];
				String id=Resume[1];
				String school=Resume[2];
				Resume resume=new Resume(name,id,school);
				bookList.add(resume);
			}
			returnResult.setResultData(bookList);
		}
		else
		{
			returnResult.setIsSuccess(false);
			ArrayList<Resume> bookList=new ArrayList<>();
			returnResult.setFailReason(amessage[1]);
			returnResult.setResultData(bookList);
		}
		return returnResult;
	}

}
