package work;

import database.DBConnection;
import model.ActionResult;
import model.Resume;
import model.ResumeList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Action 
{
	/*
	 * ������Ӧ�Ĳ��������ݿ⴫��SQL���
	 * ͨ�����ݿⷵ�ص���Ӱ��������line���ͣ�boolean���жϲ����Ƿ�ɹ�
	 * line>0����boolean=trueΪ�ɹ� ��ar.isSuccess="Success
	 * ��ѯͼ��Ļ���ActionResult.resultData=bookList;
	 *  ��֮false ������ActionResult.failReason
	 * 
	 * */
	//���ͼ�鷽����
	public ActionResult addResume(Resume resume)
	{ 
		int line = 0;
		ActionResult ar=new ActionResult();
		try
		{
			Connection conn =  DBConnection.getConnection();
			Statement statement =conn.createStatement();
			String stringSql = "insert into employee values(" +
					"'"+resume.getName()+"','"+resume.getId()+"','"+resume.getSchool()+"'," +
					"'"+resume.getProcess()+"','"+resume.getDeleteStatus()+"')";
			line=statement.executeUpdate(stringSql);
			DBConnection.closeConnection(null,statement,conn);	
		}
		catch(SQLException e)
		{
			System.out.println("SQL Exception:"+e.toString());
		}
		if(line>0)
		{
			ar.isSuccess="Success";
		}
		else
		{
			ar.isSuccess="false";
			ar.failReason="unknow error";
		}
		return ar;
	}

}
