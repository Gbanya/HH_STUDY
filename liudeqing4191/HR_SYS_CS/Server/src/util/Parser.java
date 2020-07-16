package util;

import model.Resume;
import model.ResumeList;
import model.ReturnResult;


/**
*@program : util\Parser.java
*@description : message(str)->ReturnResult
* @author : liudeqing4191
* @date : 2020/7/16 13:31
 * @returm :
*/

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
		 * �Ѳ�����������Ӧ��parser���������浽ResumeList��
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
			ResumeList resumes=parserAdd(message);
			ss.resultData=resumes;
		}
		else if(head.equals("delete"))
		{
			ResumeList resumes=parserDelete(message);
			ss.resultData=resumes;
		}
		else if(head.equals("update"))
		{
			ResumeList resumes=parserUpdate(message);
			ss.resultData=resumes;
		}
		else if(head.equals("searchbyid"))
		{
			ResumeList resumes=parserSearchById(message);
			ss.resultData=resumes;
		}
		else if(head.equals("searchbyname"))
		{
			ResumeList resumes=parserSearchByName(message);
			ss.resultData=resumes;
		}
		else if(head.equals("searchbyschool"))
		{
			ResumeList resumes=parserSearchBySchool(message);
			ss.resultData=resumes;
		}
		else if(head.equals("searchbyprocess"))
		{
			ResumeList resumes=parserSearchByProcess(message);
			ss.resultData=resumes;
		}
		else if(head.equals("searchbykey"))
		{
			ResumeList resumes=parserSearchByName(message);
			ss.resultData=resumes;
		}
		return ss;
		
	}
	/*
	 * 	","����resume���������Դ���Resume��
	 * ��󶼴���ResumeList�з���
	 * * */
	public ResumeList parserAdd(String message) {
		//id,name,school,process,d
		String[] str=message.split(",");
		String resumeId=str[0];
		String resumeName=str[1];
		String resumeSchool=str[2];
		int resumeProcess=Integer.parseInt(str[3]);
		int resumeDeleteStatus=Integer.parseInt(str[4]);

		Resume resume=new Resume(resumeName,resumeId);
		resume.setSchool(resumeSchool);
		resume.setProcess(resumeProcess);
		resume.setDeleteStatus(resumeDeleteStatus);

		ResumeList resumes=new ResumeList();
		resumes.add(resume);
		return resumes;
	}

	public ResumeList parserDelete(String message) {
		//id
		String resumeName=message;
		String resumeId=null;

		Resume resume=new Resume(resumeId,resumeName);

		ResumeList resumes=new ResumeList();
		resumes.add(resume);
		return resumes;
		
	}

	public ResumeList parserUpdate(String message) {
		//o_id,n_name,school,process,d
		String[] str=message.split(",");
		String resumeId=str[0];
		String resumeName=str[1];
		String resumeSchool=str[2];
		int resumeProcess=Integer.parseInt(str[3]);
		int resumeDeleteStatus=Integer.parseInt(str[4]);

		Resume resume=new Resume(resumeName,resumeId);
		resume.setSchool(resumeSchool);
		resume.setProcess(resumeProcess);
		resume.setDeleteStatus(resumeDeleteStatus);

		ResumeList resumes=new ResumeList();
		resumes.add(resume);
		return resumes;
	}



	public ResumeList parserSearchById(String message) {
		Resume resume=new Resume(null,message);

		ResumeList resumes=new ResumeList();
		resumes.add(resume);
		return resumes;
	}
	public ResumeList parserSearchByName(String message) {
		Resume resume=new Resume(message,null);

		ResumeList resumes=new ResumeList();
		resumes.add(resume);
		return resumes;
	}
	public ResumeList parserSearchBySchool(String message) {
		Resume resume=new Resume(null,null);
		resume.setSchool(message);
		ResumeList resumes=new ResumeList();
		resumes.add(resume);
		return resumes;
	}
	public ResumeList parserSearchByProcess(String message) {
		Resume resume=new Resume(null,null);
		resume.setProcess(Integer.parseInt(message));
		ResumeList resumes=new ResumeList();
		resumes.add(resume);
		return resumes;
	}
//	public ResumeList parserSearchByKey(String message) {
//		Resume resume=new Resume(null,null);
//		resume.setProcess(Integer.parseInt(message));
//		ResumeList resumes=new ResumeList();
//		resumes.add(resume);
//		return resumes;
//	}



}
