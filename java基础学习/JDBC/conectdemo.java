package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class conectdemo {
    /**
     * ʹ��JDBC����MySQL���ݿ�
     *
     * @author lloyd
     */
    public static void main(String[] args) {
        try {
            // 1.�������ݿ�������
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("���ݿ��������سɹ�");

            // 2.��������
            //��ʽΪjdbc:mysql:
            // 127.0.0.1:3306/���ݿ�����?useSSL=true&characterEncoding=utf-8&user=�˺���&password=����
            Connection connection = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/HRDB?useSSL=true&characterEncoding=utf-8&serverTimezone=GMT&user=root&password=qwe3208620");
            System.out.println("�������ӳɹ�");


        }
        catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
}
