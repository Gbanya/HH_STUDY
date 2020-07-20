package work;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import medol.Resume;
import medol.ResumeList;
import database.DBConnection;
import medol.ActionResult;
public class Action
{
    //��Ӽ���������
//	  * * 0��������
//     * 1������ͨ��
//     * 2������ͨ��
//     * 3�����ͨ��
//     * 4������ͨ��
//     * 5����ǩԼ
//     * 6������ְ
    private String [] chprocess={"������","����ͨ��","����ͨ��","���ͨ��","����ͨ��","��ǩԼ","����ְ"};
    public ActionResult addResume(Resume resume)
    {
        int line = 0;
        ActionResult ar = new ActionResult();

        try {
            Connection conn = DBConnection.getConnection();
            Statement statement = conn.createStatement();
            String stringSql = "insert into resume values('"+resume.resumeName+"','"+resume.resumeId+"','"+resume.resumeSchool+"','"+resume.resumeprocess+"')";
            line = statement.executeUpdate(stringSql);
            DBConnection.closeConnection((ResultSet)null, statement, conn);
        } catch (SQLException var7) {
            System.out.println("SQL Exception:" + var7.toString());
        }

        if (line > 0) {
            ar.isSuccess = "Success";
        } else {
            ar.isSuccess = "false";
            ar.failReason = "unknow error";
        }
        return ar;
    }
    //ɾ����������,����ɾ��
    public ActionResult deleteResumeById(Resume resume)
    {
        int line=0;
        ActionResult ar = new ActionResult();
        try
        {
            Connection conn = DBConnection.getConnection();
            Statement statement =conn.createStatement();
            String stringSql ="delete from resume where id = '"+resume.resumeId+"'";
            line=statement.executeUpdate(stringSql);
            DBConnection.closeConnection(null,statement,conn);
        }
        catch(SQLException e)
        {
            System.out.println("SQL Exception:"+e.toString());
        }
        if (line > 0) {
            ar.isSuccess = "Success";
        } else {
            ar.isSuccess = "false";
            ar.failReason = "û���ҵ���ͼ��";
        }
        return ar;
    }
//    public ActionResult deleteResumeByName(Resume resume)
//    {
//        int line=0;
//        ActionResult ar = new ActionResult();
//        try
//        {
//            System.out.println("1");
//            Connection conn = DBConnection.getConnection();
//            System.out.println("2");
//            Statement statement =conn.createStatement();
//            System.out.println("3");
//            String stringSql ="delete from resume where resumename = '"+resume.getName()+"'";
//            System.out.println("4");
//            line=statement.executeUpdate(stringSql);
//            System.out.println("5");
//            DBConnection.closeConnection(null,statement,conn);
//        }
//        catch(SQLException e)
//        {
//            System.out.println("SQL Exception:"+e.toString());
//        }
//        System.out.println("6");
//        return ar;
//    }
//    //�޸ļ���������
//    public ActionResult changeResume(Resume resume,Resume oldresume)
//    {
//        int line=0;
//        ActionResult ar = new ActionResult();
//        try
//        {
//            Connection conn = DBConnection.getConnection();
//            Statement statement =conn.createStatement();
//            String stringSql ="UPDATE resumemis SET resumeId = '"+resume.getName()+"','"+resume.getSchool()+chprocess[resume.getProcess()]+"' WHERE  resumename= '"+oldresume.getName()+"'";
//            line=statement.executeUpdate(stringSql);
//            DBConnection.closeConnection(null,statement,conn);
//        }
//        catch(SQLException e)
//        {
//            System.out.println("SQL Exception:"+e.toString());
//        }
//        return line;
//    }
//    //��ѯ����������
//    public  ResumeList searchResumeById(Resume resume)
//    {
//        ResumeList resumeList=new ResumeList();
//        try
//        {
//            Connection conn =  DBConnection.getConnection();
//            Statement statement =conn.createStatement();
//            String sql = "select * from resumemis where id='"+resume.getId()+"'";
//            ResultSet rs = statement.executeQuery(sql);
//            while(rs.next())
//            {
//                Resume aresume=new Resume(rs.getString("resumename"),rs.getString(2),rs.getString(3),rs.getInt(4));
//                resumeList.add(aresume);
//            }
//            DBConnection.closeConnection(rs,statement,conn);
//        }
//        catch(SQLException e)
//        {
//            System.out.println("SQL Exception:"+e.toString());
//        }
//        return resumeList;
//
//    }
//    public  ResumeList searchResumeByresumename(Resume resume)
//    {
//        ResumeList resumeList=new ResumeList();
//        try
//        {
//
//            Connection conn =  DBConnection.getConnection();
//            Statement statement =conn.createStatement();
//            String sql = "select * from resumemis where resumename='"+resume.getName()+"'";
//            ResultSet rs = statement.executeQuery(sql);
//            while(rs.next())
//            {
//                Resume aresume=new Resume(rs.getString("resumename"),rs.getString(2),rs.getString(3),rs.getInt(4));
//                resumeList.add(aresume);
//            }
//            DBConnection.closeConnection(rs,statement,conn);
//        }
//        catch(SQLException e)
//        {
//            System.out.println("SQL Exception:"+e.toString());
//        }
//        return resumeList;
//    }
//    public  ResumeList searchResumeByProcess(Resume resume)
//    {
//        ResumeList resumeList=new ResumeList();
//        try
//        {
//            Connection conn =  DBConnection.getConnection();
//            Statement statement =conn.createStatement();
//            String sql = "select * from resumemis where process='"+resume.getProcess()+"'";
//            ResultSet rs = statement.executeQuery(sql);
//            while(rs.next())
//            {
//                Resume aresume=new Resume(rs.getString("resumename"),rs.getString(2),rs.getString(3),rs.getInt(4));
//                resumeList.add(aresume);
//            }
//            DBConnection.closeConnection(rs,statement,conn);
//            return resumeList;
//        }
//        catch(SQLException e)
//        {
//            System.out.println("SQL Exception:"+e.toString());
//        }
//        return null;
//    }
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
