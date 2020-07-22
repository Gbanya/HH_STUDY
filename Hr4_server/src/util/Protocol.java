package util;

import model.ActionResult;
import model.Resume;

import java.util.ArrayList;

public class Protocol {
	public Protocol()
	{

	}
	/*
	 * ��ActionResult���������԰�ActionResult.isSuccess+"/n"+failReason����ActionResult.isSuccess+"/n"+��ActionResult.resultData
	 * �õ����ַ�������ʽ��д
	 * ��forѭ����õ�ActionResult.resultData���ַ���
	 * */
	public String AddresumeMessage(ActionResult ar)
	{
		String str;
		String isSuccess=ar.getIsSuccess();
		if(isSuccess.equals("Success"))
		{
			str=isSuccess+"/n";
		}
		else
		{
			str=isSuccess+"/n"+ar.getFailReason();
		}
		return str;
	}
	public String deleteresumeByNameMessage(ActionResult ar)
	{
		String str;
		String isSuccess=ar.getIsSuccess();
		if(isSuccess.equals("Success"))
		{
			str=isSuccess+"/n";
		}
		else
		{
			str=isSuccess+"/n"+ar.getFailReason();
		}
		return str;
	}
	public String deleteresumeByidMessage(ActionResult ar)
	{
		String str;
		String isSuccess=ar.getIsSuccess();
		if(isSuccess.equals("Success"))
		{
			str=isSuccess+"/n";
		}
		else
		{
			str=isSuccess+"/n"+ar.getFailReason();
		}
		return str;
	}
	public String changeresumeMessage(ActionResult ar)
	{
		String str;
		String isSuccess=ar.getIsSuccess();
		if(isSuccess.equals("Success"))
		{
			str=isSuccess+"/n";
		}
		else
		{
			str=isSuccess+"/n"+ar.getFailReason();
		}
		return str;
	}
	public String searchresumeByNameMessage(ActionResult ar)
	{
		String str;
		String isSuccess=ar.getIsSuccess();
		if(isSuccess.equals("Success"))
		{
			ArrayList<Resume>  resumeArrayList=(ArrayList<Resume> )ar.getResultData();
			str=isSuccess+"/n";
			//forѭ���õ�ActionResult.resultData�ַ���Ӧ���ַ���
			int resumesize=resumeArrayList.size();
			for(int i=0;i<resumesize;i++)
			{
				String resumestring=resumeArrayList.get(i).getName()+","+resumeArrayList.get(i).getSchool()+","+resumeArrayList.get(i).getId()+";";
				str=str+resumestring;
			}
		}
		else
		{
			str=isSuccess+"/n"+ar.getFailReason();
		}
		return str;
	}
	public String searchresumeByidMessage(ActionResult ar)
	{
		String str;
		String isSuccess=ar.getIsSuccess();
		if(isSuccess.equals("Success"))
		{
			ArrayList<Resume>  resumeArrayList=(ArrayList<Resume> )ar.getResultData();
			str=isSuccess+"/n";
			//forѭ���õ�ActionResult.resultData�ַ���Ӧ���ַ���
			int resumesize=resumeArrayList.size();
			for(int i=0;i<resumesize;i++)
			{
				String resumestring=resumeArrayList.get(i).getName()+","+resumeArrayList.get(i).getSchool()+","+resumeArrayList.get(i).getId()+";";
				str=str+resumestring;
			}
		}
		else
		{
			str=isSuccess+"/n"+ar.getFailReason();
		}
		return str;
	}
	public String searchresumeByschoolMessage(ActionResult ar)
	{
		String str;

		String isSuccess=ar.getIsSuccess();
		if(isSuccess.equals("Success"))
		{
			ArrayList<Resume>  resumeArrayList=(ArrayList<Resume> )ar.getResultData();
			str=isSuccess+"/n";
			//forѭ���õ�ActionResult.resultData�ַ���Ӧ���ַ���
			int resumesize=resumeArrayList.size();
			for(int i=0;i<resumesize;i++)
			{
				String resumestring=resumeArrayList.get(i).getName()+","+resumeArrayList.get(i).getSchool()+","+resumeArrayList.get(i).getId()+";";
				str=str+resumestring;
			}
		}
		else
		{
			str=isSuccess+"/n"+ar.getFailReason();
		}
		return str;

	}
	public String searchresumeByKeyWordMessage(ActionResult ar)
	{
		String str;
		String isSuccess=ar.getIsSuccess();
		if(isSuccess.equals("Success"))
		{
			ArrayList<Resume>  resumeArrayList=(ArrayList<Resume> )ar.getResultData();
			str=isSuccess+"/n";
			//forѭ���õ�ActionResult.resultData�ַ���Ӧ���ַ���
			int resumesize=resumeArrayList.size();
			for(int i=0;i<resumesize;i++)
			{
				String resumestring=resumeArrayList.get(i).getName()+","+resumeArrayList.get(i).getSchool()+","+resumeArrayList.get(i).getId()+";";
				str=str+resumestring;
			}
		}
		else
		{
			str=isSuccess+"/n"+ar.getFailReason();
		}
		return str;
	}
}
