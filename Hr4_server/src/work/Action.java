package work;

import database.DBConnection;

import model.ActionResult;
import model.Resume;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Action
{
	/*
	 * ������Ӧ�Ĳ��������ݿ⴫��SQL���
	 * ͨ�����ݿⷵ�ص���Ӱ��������line���ͣ�boolean���жϲ����Ƿ�ɹ�
	 * line>0����boolean=trueΪ�ɹ� ��ar.isSuccess="Success
	 * ��ѯͼ��Ļ���ActionResult.resultData=resumeList;
	 *  ��֮false ������ActionResult.failReason
	 *
	 * */
	//���ͼ�鷽����
	public ActionResult addresume(Resume resume)
	{
		int line = 0;
		ActionResult ar=new ActionResult();
		try
		{
			Connection conn =  DBConnection.getConnection();
			Statement statement =conn.createStatement();
			String stringSql = "insert into resume1 values('"+resume.getName()+"','"+resume.getId()+"','"+resume.getSchool()+"')";
			line=statement.executeUpdate(stringSql);
			DBConnection.closeConnection(null,statement,conn);
		}
		catch(SQLException e)
		{
			System.out.println("SQL Exception:"+e.toString());
		}
		if(line>0)
		{
			ar.setIsSuccess("Success");
		}
		else
		{
			ar.setIsSuccess("false");
			ar.setFailReason("unknow error");
		}
		return ar;
	}
	//ɾ��ͼ�鷽����
	public ActionResult deleteresumeByName(Resume resume)
	{
		int line=0;
		ActionResult ar=new ActionResult();
		try
		{
			Connection conn = DBConnection.getConnection();
			Statement statement =conn.createStatement();
			String stringSql ="delete from resume1 where name = '"+resume.getName()+"'";
			line=statement.executeUpdate(stringSql);
			DBConnection.closeConnection(null,statement,conn);
		}
		catch(SQLException e)
		{
			System.out.println("SQL Exception:"+e.toString());
		}

		if(line>0)
		{
			ar.setIsSuccess("Success");
		}
		else
		{
			ar.setIsSuccess("false");
			ar.setFailReason("û���ҵ���ѧ��");
		}


		return ar;
	}
	public ActionResult deleteresumeByid(Resume resume)
	{
		int line=0;
		ActionResult ar=new ActionResult();
		try
		{
			Connection conn = DBConnection.getConnection();
			Statement statement =conn.createStatement();
			String stringSql ="delete from resume1 where id = '"+resume.getId()+"'";
			line=statement.executeUpdate(stringSql);
			DBConnection.closeConnection(null,statement,conn);
		}
		catch(SQLException e)
		{
			System.out.println("SQL Exception:"+e.toString());
		}
		if(line>0)
		{
			ar.setIsSuccess("Success");
		}
		else
		{
			ar.setIsSuccess("false");
			ar.setFailReason("û���ҵ���ѧ��");
		}


		return ar;
	}
	//�޸�ͼ�鷽����
	public ActionResult changeresume(Resume resume,Resume oldresume)
	{
			int line=0;
			ActionResult ar=new ActionResult();
		try
			{
				Connection conn = DBConnection.getConnection();
				Statement statement =conn.createStatement();
				String stringSql ="UPDATE resume1 SET name = '"+resume.getName()+"', id='"+resume.getId()+"',school='"+resume.getSchool()+"' WHERE  name= '"+oldresume.getName()+"'";
				line=statement.executeUpdate(stringSql);
				DBConnection.closeConnection(null,statement,conn);
			}
		catch(SQLException e)
			{
				System.out.println("SQL Exception:"+e.toString());
			}
		if(line>0)
		{
			ar.setIsSuccess("Success");
		}
		else
		{
			ar.setIsSuccess("false");
			ar.setFailReason("û���ҵ���ѧ��");
		}

		return ar;
	}
	//��ѯͼ�鷽����
	public  ActionResult searchresumeByName(Resume resume)
	{
		ArrayList<Resume> resumeList =new ArrayList<>();
		ActionResult ar=new ActionResult();
		try
		{
			Connection conn =  DBConnection.getConnection();
			Statement statement =conn.createStatement();
			String sql = "select * from resume1 where name='"+resume.getName()+"'";
			ResultSet rs = statement.executeQuery(sql);
			//�Ѳ�ѯ����ŵ�resumeList�Ĳ���
			while(rs.next())
			{
				Resume aresume=new Resume(rs.getString(1),rs.getString(2),rs.getString(3));
				resumeList.add(aresume);
			}
			DBConnection.closeConnection(rs,statement,conn);
		}
		catch(SQLException e)
		{
			System.out.println("SQL Exception:"+e.toString());
		}
		int resumesize=resumeList.size();

		if(resumesize>0)
		{
			ar.setIsSuccess("Success");
			ar.setResultData(resumeList);
		}
		else
		{
			ar.setIsSuccess("false");
			ar.setFailReason("û���ҵ���ѧ��");
		}


		return ar;

	}
	public  ActionResult searchresumeByid(Resume resume)
	{
		ArrayList<Resume> resumeList =new ArrayList<>();
		ActionResult ar=new ActionResult();
		try
		{

			Connection conn =  DBConnection.getConnection();
			Statement statement =conn.createStatement();
			String sql = "select * from resume1 where id='"+resume.getId()+"'";
			ResultSet rs = statement.executeQuery(sql);
			//�Ѳ�ѯ����ŵ�resumeList�Ĳ���
			while(rs.next())
			{
				Resume aresume=new Resume(rs.getString(1),rs.getString(2),rs.getString(3));
				resumeList.add(aresume);
			}
			DBConnection.closeConnection(rs,statement,conn);
		}
		catch(SQLException e)
		{
			System.out.println("SQL Exception:"+e.toString());
		}
		int resumesize=resumeList.size();
		if(resumesize>0)
		{
			ar.setIsSuccess("Success");
			ar.setResultData(resumeList);
		}
		else
		{
			ar.setIsSuccess("false");
			ar.setFailReason("û���ҵ���ѧ��");
		}
		return ar;
	}
	public  ActionResult searchresumeByschool(Resume resume)
	{
		ArrayList<Resume> resumeList =new ArrayList<>();
			ActionResult ar=new ActionResult();
		try
		{
			Connection conn =  DBConnection.getConnection();
			Statement statement =conn.createStatement();
			String sql = "select * from resume1 where school='"+resume.getSchool()+"'";
			ResultSet rs = statement.executeQuery(sql);
			//�Ѳ�ѯ����ŵ�resumeList�Ĳ���
			while(rs.next())
			{
				Resume aresume=new Resume(rs.getString(1),rs.getString(2),rs.getString(3));
				resumeList.add(aresume);
			}
			DBConnection.closeConnection(rs,statement,conn);
			int resumesize=resumeList.size();
			if(resumesize>0)
			{
				ar.setIsSuccess("Success");
				ar.setResultData(resumeList);
			}
			else
			{
				ar.setIsSuccess("false");
				ar.setFailReason("û���ҵ���ѧ��");
			}
		}
		catch(SQLException e)
		{
			System.out.println("SQL Exception:"+e.toString());
		}
		return ar;
	}
	public  ActionResult searchresumeByPointword(Resume resume)
	{
		ArrayList<Resume> resumeList =new ArrayList<>();
		ActionResult ar=new ActionResult();
		try
		{
			Connection conn =  DBConnection.getConnection();
			Statement statement =conn.createStatement();
			String sql = "select * from resume1 where name like '%"+resume.getName()+"%'";
			ResultSet rs = statement.executeQuery(sql);
			//�Ѳ�ѯ����ŵ�resumeList�Ĳ���
			while(rs.next())
			{
				Resume aresume=new Resume(rs.getString(1),rs.getString(2),rs.getString(3));
				resumeList.add(aresume);
			}
			DBConnection.closeConnection(rs,statement,conn);
			int resumesize=resumeList.size();
			if(resumesize>0)
			{
				ar.setIsSuccess("Success");
				ar.setResultData(resumeList);
			}
			else
			{
				ar.setIsSuccess("false");
				ar.setFailReason("û���ҵ���ѧ��");
			}
		}
		catch(SQLException e)
		{
			System.out.println("SQL Exception:"+e.toString());
		}
		return ar;
	}
}
