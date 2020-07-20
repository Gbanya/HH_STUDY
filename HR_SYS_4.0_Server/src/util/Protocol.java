package util;

import model.ActionResult;
import model.ResumeList;

public class Protocol {
	public Protocol()
	{
		
	}
	/*
	 * ��ActionResult���������԰�ActionResult.isSuccess+"/n"+failReason����ActionResult.isSuccess+"/n"+��ActionResult.resultData
	 * �õ����ַ�������ʽ��д
	 * ��forѭ����õ�ActionResult.resultData���ַ���
	 * */
	public String AddResumeMessage(ActionResult ar)
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

	public String DeleteResumeMessage(ActionResult ar)
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
	public String changeResumeMessage(ActionResult ar)
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
}
