package testconnection;

import database.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/*�������ݿ������Ƿ�ɹ�����Ϥʹ�����ݿ�ķ���*/
public class dbconnection {
    public static void main(String[] args) {
        try
        {
            //url = "jdbc:mysql://127.0.0.1:3306/mydb1";
            Connection conn =  DBConnection.getConnection();
            Statement statement =conn.createStatement();
            String stringSql ="select *from employee";
            ResultSet rs = statement.executeQuery(stringSql);
            System.out.println("���ݿ����ӳɹ���");
            System.out.println("============================");
            while(rs.next()){
                String uid=rs.getString(1);
                String uname=rs.getString(2);
                String sex=rs.getString(3);
                String birthday=rs.getString(4);
                System.out.println(uid+"\t"+uname+"\t"+sex+"\t"+birthday);
            }

            DBConnection.closeConnection(rs,statement,conn);

        }
        catch(SQLException e)
        {
            System.out.println("SQL Exception:"+e.toString());
        }

    }
}
