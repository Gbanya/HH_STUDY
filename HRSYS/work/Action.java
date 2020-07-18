package work;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import bean.Resume;
import bean.ResumeList;
import database.DBConnection;

public class Action 
{
	//���ͼ�鷽����
//	  * * 0��������
//     * 1������ͨ��
//     * 2������ͨ��
//     * 3�����ͨ��
//     * 4������ͨ��
//     * 5����ǩԼ
//     * 6������ְ
	private String [] chprocess={"������","����ͨ��","����ͨ��","���ͨ��","����ͨ��","��ǩԼ","����ְ"};
	public int addbook(Resume resume)
	{ 
		int line = 0;
		
		try
		{
			Connection conn =  DBConnection.getConnection();
			Statement statement =conn.createStatement();
			String stringSql = "insert into resumemis values('"+resume.getName()+"','"+resume.getId()+"','"+resume.getSchool()+chprocess[resume.getProcess()]+"')";
			line=statement.executeUpdate(stringSql);
			DBConnection.closeConnection(null,statement,conn);	
		}
		catch(SQLException e)
		{
			System.out.println("SQL Exception:"+e.toString());
		}
		return line;
	}
	//ɾ��ͼ�鷽����
	public int deleteResumeById(Resume resume)
	{
		int line=0;
		try
		{
			Connection conn = DBConnection.getConnection();
			Statement statement =conn.createStatement();
			String stringSql ="delete from resumemis where id = '"+resume.getId()+"'";
			line=statement.executeUpdate(stringSql);
			DBConnection.closeConnection(null,statement,conn);
		}
		catch(SQLException e)
		{
			System.out.println("SQL Exception:"+e.toString());
		}
		return line;
	}
	public int deleteResumeByName(Resume resume)
	{
		int line=0;
		try
		{
			System.out.println("1");
			Connection conn = DBConnection.getConnection();
			System.out.println("2");
			Statement statement =conn.createStatement();
			System.out.println("3");
			String stringSql ="delete from resumemis where resumename = '"+resume.getName()+"'";
			System.out.println("4");
			line=statement.executeUpdate(stringSql);
			System.out.println("5");
			DBConnection.closeConnection(null,statement,conn);
		}
		catch(SQLException e)
		{
			System.out.println("SQL Exception:"+e.toString());
		}
		System.out.println("6");
		return line;
	}
	//�޸�ͼ�鷽����
	public int changeResume(Resume resume,Resume oldresume)
	{
			int line=0;
		try
			{
				Connection conn = DBConnection.getConnection();
				Statement statement =conn.createStatement();
				String stringSql ="UPDATE resumemis SET resumeId = '"+resume.getName()+"','"+resume.getSchool()+chprocess[resume.getProcess()]+"' WHERE  resumename= '"+oldresume.getName()+"'";
				line=statement.executeUpdate(stringSql);
				DBConnection.closeConnection(null,statement,conn);
			}
		catch(SQLException e)
			{
				System.out.println("SQL Exception:"+e.toString());
			}
		return line;
	}
	//��ѯͼ�鷽����
	public  ResumeList searchResumeById(Resume resume)
	{
		ResumeList resumeList=new ResumeList();
		try
		{
			Connection conn =  DBConnection.getConnection();
			Statement statement =conn.createStatement();
			String sql = "select * from resumemis where id='"+resume.getId()+"'";
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next())
			{
				Resume aresume=new Resume(rs.getString("resumename"),rs.getString(2),rs.getString(3),rs.getInt(4));
				resumeList.add(aresume);
			}
			DBConnection.closeConnection(rs,statement,conn);
		}
		catch(SQLException e)
		{
			System.out.println("SQL Exception:"+e.toString());
		}
		return resumeList;
		
	}
	public  ResumeList searchResumeByresumename(Resume resume)
	{
		ResumeList resumeList=new ResumeList();
		try
		{
			
			Connection conn =  DBConnection.getConnection();
			Statement statement =conn.createStatement();
			String sql = "select * from resumemis where resumename='"+resume.getName()+"'";
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next())
			{
				Resume aresume=new Resume(rs.getString("resumename"),rs.getString(2),rs.getString(3),rs.getInt(4));
				resumeList.add(aresume);
			}
			DBConnection.closeConnection(rs,statement,conn);
		}
		catch(SQLException e)
		{
			System.out.println("SQL Exception:"+e.toString());
		}
		return resumeList;
	}
	public  ResumeList searchResumeByProcess(Resume resume)
	{
			ResumeList resumeList=new ResumeList();
		try
		{
			Connection conn =  DBConnection.getConnection();
			Statement statement =conn.createStatement();
			String sql = "select * from resumemis where process='"+resume.getProcess()+"'";
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next())
			{
				Resume aresume=new Resume(rs.getString("resumename"),rs.getString(2),rs.getString(3),rs.getInt(4));
				resumeList.add(aresume);
			}
			DBConnection.closeConnection(rs,statement,conn);
			return resumeList;
		}
		catch(SQLException e)
		{
			System.out.println("SQL Exception:"+e.toString());
		}
		return null;
	}	
//	public  ResumeList searchResumeByPointword(Resume resume)
//	{
//		ResumeList resumeList=new ResumeList();
//		try
//		{
//			Connection conn =  DBConnection.getConnection();
//			Statement statement =conn.createStatement();
//			String sql = "select * from resumemis where resumeName like '%"+resume.resumeName+"%'";
//			ResultSet rs = statement.executeQuery(sql);
//			while(rs.next())
//			{
//				Resume aresume=new Resume(rs.getString(1),rs.getString(2),rs.getDouble(3));
//				resumeList.add(aresume);
//			}
//			DBConnection.closeConnection(rs,statement,conn);
//			return resumeList;
//		}
//		catch(SQLException e)
//		{
//			System.out.println("SQL Exception:"+e.toString());
//		}
//		return resumeList;
//	}
}
