/**
 * A program for JAVA��һ�ڿ���ҵ---ͼ�����ϵͳ
 * @version 1.2 2016-03-11
 * @author ���ʽ� 2014214225
 */
package library05;
import java.util.LinkedList;
import java.util.Scanner;
import loadandsaveData.DataOperate;
import model.Book;
import service.BookService;

public class LMS
{
	public static void main(String[] args) {

		LinkedList<Book> bookList = new LinkedList<Book>();
		Scanner input = new Scanner(System.in);
		DataOperate.loadData(bookList);//��������ͼ��
		while(true)
		{
			System.out.println("************��ӭ�������ϰ�ͼ�����ϵͳ************");
			System.out.println("����ͼ���밴----------1");
			System.out.println("ɾ��ͼ���밴----------2");
			System.out.println("�޸�ͼ���밴----------3");
			System.out.println("��ѯͼ���밴----------4");
			System.out.println("�˳��밴--------------5");
		//if���ָ���ж�
			int choice =input.nextInt();
			if(choice==1)
			{
				BookService.addBook(bookList);
			}
			else if(choice==2)
			{
				BookService.deleteBook(bookList);
			}
			else if(choice==3)
			{
				BookService.updateBook(bookList);
			}
			else if(choice==4)
			{
				BookService.showBook(bookList);
			}
			else if(choice==5)
			{
				DataOperate.saveData(bookList);
				break;
			}
			else {
				System.out.println("���������ȷ�Ϻ��������");
			}
		}
		System.out.println("�����˳�ͼ�����ϵͳ");
	}
}