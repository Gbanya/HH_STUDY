package work;

import bean.Resume;
import bean.ResumeList;
import database.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Action {
    //���ѧ��������Ϣ
    public int addresume(Resume resume)
    {
        int line = 0;

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
        return line;
    }
    //ɾ��������
    public int deleteResumeByid(String id)
    {
        int line=0;
        try
        {
            Connection conn = DBConnection.getConnection();
            Statement statement =conn.createStatement();
            String stringSql ="delete from employee where id = '"+id+"'";
            line=statement.executeUpdate(stringSql);
            DBConnection.closeConnection(null,statement,conn);

        }
        catch(SQLException e)
        {
            System.out.println("SQL Exception:"+e.toString());
        }
        return line;
    }

    //ͨ�����֤�Ÿ���ѧ������
    public int changeResume(Resume resume,String id)
    {
        int line=0;
        try
        {
            Connection conn = DBConnection.getConnection();
            Statement statement =conn.createStatement();
            String stringSql ="UPDATE employee SET name = '"+resume.getName()+"',id='"+resume.getId()+"', school='"+resume.getSchool()+"',process='"+resume.getProcess()+"',deletestatus='"+resume.getDeleteStatus()+"' WHERE  id= '"+id+"'";
            line=statement.executeUpdate(stringSql);
            DBConnection.closeConnection(null,statement,conn);
        }
        catch(SQLException e)
        {
            System.out.println("SQL Exception:"+e.toString());
        }
        return line;
    }

    //��ѯ����������������
    public ResumeList searchResumeByName(String name)
    {
        ResumeList resumeList=new ResumeList();
        try
        {
            Connection conn =  DBConnection.getConnection();
            Statement statement =conn.createStatement();
            String sql = "select * from employee where name='"+name+"'";
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next())
            {
                Resume resume=new Resume(rs.getString("name"),rs.getString(2),rs.getString(3));
                resume.setProcess(rs.getInt(4));
                resume.setDeleteStatus(rs.getInt(5));
                resumeList.add(resume);
            }
            DBConnection.closeConnection(rs,statement,conn);
        }
        catch(SQLException e)
        {
            System.out.println("SQL Exception:"+e.toString());
        }
        return resumeList;
    }
    //��ѯ�����������ձ�ҵԺУ
    public ResumeList searchResumeByschool(String school)
    {
        ResumeList resumeList=new ResumeList();
        try
        {
            Connection conn =  DBConnection.getConnection();
            Statement statement =conn.createStatement();
            String sql = "select * from employee where school='"+school+"'";
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next())
            {
                Resume resume=new Resume(rs.getString("name"),rs.getString(2),rs.getString(3));
                resume.setProcess(rs.getInt(4));
                resume.setDeleteStatus(rs.getInt(5));
                resumeList.add(resume);
            }
            DBConnection.closeConnection(rs,statement,conn);
        }
        catch(SQLException e)
        {
            System.out.println("SQL Exception:"+e.toString());
        }
        return resumeList;
    }
    //��ѯ���������������֤��
    public ResumeList searchResumeByid(String id)
    {
        ResumeList resumeList=new ResumeList();
        try
        {
            Connection conn =  DBConnection.getConnection();
            Statement statement =conn.createStatement();
            String sql = "select * from employee where id='"+id+"'";
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next())
            {
                Resume resume=new Resume(rs.getString("name"),rs.getString(2),rs.getString(3));
                resume.setProcess(rs.getInt(4));
                resume.setDeleteStatus(rs.getInt(5));
                resumeList.add(resume);
            }
            DBConnection.closeConnection(rs,statement,conn);
        }
        catch(SQLException e)
        {
            System.out.println("SQL Exception:"+e.toString());
        }
        return resumeList;
    }

    //��ѯ�����������ռ�������
    public ResumeList searchResumeByprocess(String process)
    {
        ResumeList resumeList=new ResumeList();
        try
        {
            Connection conn =  DBConnection.getConnection();
            Statement statement =conn.createStatement();
            String sql = "select * from employee where process='"+process+"'";
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next())
            {
                Resume resume=new Resume(rs.getString("name"),rs.getString(2),rs.getString(3));
                resume.setProcess(rs.getInt(4));
                resume.setDeleteStatus(rs.getInt(5));
                resumeList.add(resume);
            }
            DBConnection.closeConnection(rs,statement,conn);
        }
        catch(SQLException e)
        {
            System.out.println("SQL Exception:"+e.toString());
        }
        return resumeList;
    }
    //����ӦƸ������ģ����ѯ
    public  ResumeList searchResumeByPointword(String burname)
    {
        ResumeList resumeList=new ResumeList();
        try
        {
            Connection conn =  DBConnection.getConnection();
            Statement statement =conn.createStatement();
            String sql = "select * from employee where name like '%"+burname+"%'";
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next())
            {
                Resume resume=new Resume(rs.getString("name"),rs.getString(2),rs.getString(3));
                resume.setProcess(rs.getInt(4));
                resume.setDeleteStatus(rs.getInt(5));
                resumeList.add(resume);
            }
            DBConnection.closeConnection(rs,statement,conn);
            return resumeList;
        }
        catch(SQLException e)
        {
            System.out.println("SQL Exception:"+e.toString());
        }
        return resumeList;
    }
    //ȫ����ѯ
    public  ResumeList searchResumeAll()
    {
        ResumeList resumeList=new ResumeList();
        try
        {
            Connection conn =  DBConnection.getConnection();
            Statement statement =conn.createStatement();
            String sql = "select * from employee ";
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next())
            {
                Resume resume=new Resume(rs.getString("name"),rs.getString(2),rs.getString(3));
                resume.setProcess(rs.getInt(4));
                resume.setDeleteStatus(rs.getInt(5));
                resumeList.add(resume);
            }
            DBConnection.closeConnection(rs,statement,conn);
            return resumeList;
        }
        catch(SQLException e)
        {
            System.out.println("SQL Exception:"+e.toString());
        }
        return resumeList;
    }

}
