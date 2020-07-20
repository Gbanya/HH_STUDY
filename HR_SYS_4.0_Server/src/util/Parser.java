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
			ResumeList resumeList=parserAdd(message);
			ss.resultData=resumeList;
		}else if(head.equals("deletebyid"))
		{
			ResumeList resumeList=parserAdd(message);
			ss.resultData=resumeList;
		}else if(head.equals("change"))
		{
			ResumeList resumeList=parserChangeResume(message);
			ss.resultData=resumeList;
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
		String resumeName=str[0];
		String resumeId=str[1];
		String resumeSchool=str[2];
		/*double bookPrice=Double.parseDouble(str[2]);*/
		Resume book=new Resume(resumeName,resumeId,resumeSchool);
		ResumeList resumeList=new ResumeList();
		resumeList.add(book);
		return resumeList;
		
	}
	public ResumeList parserDeletById(String message) {

		String[] str=message.split(",");
		String resumeName=str[0];
		String resumeId=str[1];
		String resumeSchool=str[2];
		int resumeProcess=Integer.parseInt(str[3]);
		int resumeDeleteStatus=Integer.parseInt(str[4]);
		/*double bookPrice=Double.parseDouble(str[2]);*/
		Resume resume=new Resume(resumeName,resumeId,resumeSchool);
		resume.setProcess(resumeProcess);
		resume.setDeleteStatus(resumeDeleteStatus);
		ResumeList resumeList=new ResumeList();
		resumeList.add(resume);
		return resumeList;

	}
	public ResumeList parserChangeResume(String message) {
		String[] str=message.split(";");
		String[] resumemessage=str[0].split(",");
		String resumeName=resumemessage[0];
		String resumeId=resumemessage[1];
		String resumeSchool=resumemessage[2];
		int resumeProcess=Integer.parseInt(resumemessage[3]);
		int resumeDeleteStatus=Integer.parseInt(resumemessage[4]);
		String[] oldresuemmessage=str[1].split(",");
		String oldresumeId=oldresuemmessage[0];
		Resume oldresume=new Resume(null,oldresumeId,null);
		ResumeList resumeList=new ResumeList();
		resumeList.add(oldresume);
		Resume resume=new Resume(resumeName,resumeId,resumeSchool);
		resume.setProcess(resumeProcess);
		resume.setDeleteStatus(resumeDeleteStatus);
		resumeList.add(resume);
		return resumeList;

	}



}
