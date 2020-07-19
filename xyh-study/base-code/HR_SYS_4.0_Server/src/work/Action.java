package work;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.DBConnection;
import medol.ActionResult;
import medol.Book;
import medol.BookList;

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
	public ActionResult addbook(Book book)
	{ 
		int line = 0;
		ActionResult ar=new ActionResult();
		try
		{
			Connection conn =  DBConnection.getConnection();
			Statement statement =conn.createStatement();
			String stringSql = "insert into bookmis values('"+book.bookName+"','"+book.bookAuthor+"','"+book.bookPrice+"')";
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
	//ɾ��ͼ�鷽����
	public ActionResult deleteBookByName(Book book)
	{
		int line=0;
		ActionResult ar=new ActionResult();
		try
		{
			Connection conn = DBConnection.getConnection();
			Statement statement =conn.createStatement();
			String stringSql ="delete from bookmis where bookName = '"+book.bookName+"'";
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
			ar.failReason="û���ҵ���ͼ��";
		}
		return ar;
	}
	public ActionResult deleteBookByAuthor(Book book)
	{
		int line=0;
		ActionResult ar=new ActionResult();
		try
		{
			Connection conn = DBConnection.getConnection();
			Statement statement =conn.createStatement();
			String stringSql ="delete from bookmis where bookAuthor = '"+book.bookAuthor+"'";
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
			ar.failReason="û���ҵ���ͼ��";
		}
		return ar;
	}
	//�޸�ͼ�鷽����
	public ActionResult changeBook(Book book,Book oldbook)
	{
			int line=0;
			ActionResult ar=new ActionResult();
		try
			{
				Connection conn = DBConnection.getConnection();
				Statement statement =conn.createStatement();
				String stringSql ="UPDATE bookmis SET bookName = '"+book.bookName+"', bookAuthor='"+book.bookAuthor+"',bookPrice='"+book.bookPrice+"' WHERE  bookName= '"+oldbook.bookName+"'";
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
			ar.failReason="û���ҵ���ͼ��";
		}
		return ar;
	}
	//��ѯͼ�鷽����
	public  ActionResult searchBookByName(Book book)
	{
		BookList bookList=new BookList();
		ActionResult ar=new ActionResult();
		try
		{
			Connection conn =  DBConnection.getConnection();
			Statement statement =conn.createStatement();
			String sql = "select * from bookmis where bookName='"+book.bookName+"'";
			ResultSet rs = statement.executeQuery(sql);
			//�Ѳ�ѯ����ŵ�BookList�Ĳ���
			while(rs.next())
			{
				Book abook=new Book(rs.getString(1),rs.getString(2),rs.getDouble(3));
				bookList.add(abook);
			}
			DBConnection.closeConnection(rs,statement,conn);
		}
		catch(SQLException e)
		{
			System.out.println("SQL Exception:"+e.toString());
		}
		int booksize=bookList.size();
		if(booksize>0)
		{
			ar.isSuccess="Success";
			ar.resultData=bookList;
		}
		else
		{
			ar.isSuccess="false";
			ar.failReason="û���ҵ����ͼ��";
		}
		return ar;
		
	}
	public  ActionResult searchBookByAuthor(Book book)
	{
		BookList bookList=new BookList();
		ActionResult ar=new ActionResult();
		try
		{
			
			Connection conn =  DBConnection.getConnection();
			Statement statement =conn.createStatement();
			String sql = "select * from bookmis where bookAuthor='"+book.bookAuthor+"'";
			ResultSet rs = statement.executeQuery(sql);
			//�Ѳ�ѯ����ŵ�BookList�Ĳ���
			while(rs.next())
			{
				Book abook=new Book(rs.getString(1),rs.getString(2),rs.getDouble(3));
				bookList.add(abook);
			}
			DBConnection.closeConnection(rs,statement,conn);
		}
		catch(SQLException e)
		{
			System.out.println("SQL Exception:"+e.toString());
		}
		int booksize=bookList.size();
		if(booksize>0)
		{
			ar.isSuccess="Success";
			ar.resultData=bookList;
		}
		else
		{
			ar.isSuccess="false";
			ar.failReason="û���ҵ����ͼ��";
		}
		return ar;
	}
	public  ActionResult searchBookByPrice(Book book)
	{
			BookList bookList=new BookList();
			ActionResult ar=new ActionResult();
		try
		{
			Connection conn =  DBConnection.getConnection();
			Statement statement =conn.createStatement();
			String sql = "select * from bookmis where bookPrice='"+book.bookPrice+"'";
			ResultSet rs = statement.executeQuery(sql);
			//�Ѳ�ѯ����ŵ�BookList�Ĳ���
			while(rs.next())
			{
				Book abook=new Book(rs.getString(1),rs.getString(2),rs.getDouble(3));
				bookList.add(abook);
			}
			DBConnection.closeConnection(rs,statement,conn);
			int booksize=bookList.size();
			if(booksize>0)
			{
				ar.isSuccess="Success";
				ar.resultData=bookList;
			}
			else
			{
				ar.isSuccess="false";
				ar.failReason="û���ҵ����ͼ��";
			}
		}
		catch(SQLException e)
		{
			System.out.println("SQL Exception:"+e.toString());
		}
		return ar;
	}	
	public  ActionResult searchBookByPointword(Book book)
	{
		BookList bookList=new BookList();
		ActionResult ar=new ActionResult();
		try
		{
			Connection conn =  DBConnection.getConnection();
			Statement statement =conn.createStatement();
			String sql = "select * from bookmis where bookName like '%"+book.bookName+"%'";
			ResultSet rs = statement.executeQuery(sql);
			//�Ѳ�ѯ����ŵ�BookList�Ĳ���
			while(rs.next())
			{
				Book abook=new Book(rs.getString(1),rs.getString(2),rs.getDouble(3));
				bookList.add(abook);
			}
			DBConnection.closeConnection(rs,statement,conn);
			int booksize=bookList.size();
			if(booksize>0)
			{
				ar.isSuccess="Success";
				ar.resultData=bookList;
			}
			else
			{
				ar.isSuccess="false";
				ar.failReason="û���ҵ����ͼ��";
			}
		}
		catch(SQLException e)
		{
			System.out.println("SQL Exception:"+e.toString());
		}
		return ar;
	}
}
