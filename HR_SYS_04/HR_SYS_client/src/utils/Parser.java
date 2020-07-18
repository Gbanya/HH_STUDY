package utils;


import bean.Resume;
import bean.ResumeList;
import bean.ReturnResult;


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
			String[] resumeinfo=amessage[1].split(";");
			ResumeList resumeList=new ResumeList ();
			int resumesize=resumeinfo.length;
			for(int i=0;i<resumesize;i++)
			{
				String[] resume=resumeinfo[i].split(",");
				String name=resume[0];
				String id=resume[1];
				String school=resume[2];

				Resume newResume = new Resume(name,id,school);
				resumeList.add(newResume);
			}
			returnResult.resultData=resumeList;
		}
		else
		{
			returnResult.isSuccess = false;
			ResumeList resumeList=new ResumeList ();
			returnResult.failReason =amessage[1];
			returnResult.resultData=resumeList;
		}
		return returnResult;
	}

}