/**
 * A program for JAVA��һ�ڿ���ҵ---ͼ�����ϵͳ
 *
 * @version 1.2 2016-03-11
 * @author ���ʽ� 2014214225
 */
package library05;

import loadandsaveData.DataOperate;
import model.Book;
import service.BookService;
import utils.InputException;

import java.util.LinkedList;
import java.util.Scanner;

public class LMS {
    public static void main(String[] args) {

        LinkedList<Book> bookList = new LinkedList<Book>();
        Scanner input = new Scanner(System.in);
        // ��������ͼ��
        DataOperate.loadData(bookList);
        while (true) {
            System.out.println("***************ͼ�����ϵͳ************");
            System.out.println("               1 ����ͼ��");
            System.out.println("               2 ɾ��ͼ��");
            System.out.println("               3 �޸�ͼ��");
            System.out.println("               4 ��ѯͼ��");
            System.out.println("               5 �˳�\n");
            // if���ָ���ж�
            // �������ô���choiceֻ������int���͵�ѡ�����룬���������ַ�ʱ�ᱨ��δ�Ը��쳣���д���
            // �Ż�����choice����ΪString������choice����������쳣����
//			int choice = input.nextInt();
            String choice = input.nextLine();
            try {
                if (choice.equals("1")) {
                    BookService.addBook(bookList);
                } else if (choice.equals("2")) {
                    BookService.deleteBook(bookList);
                } else if (choice.equals("3")) {
                    BookService.updateBook(bookList);
                } else if (choice.equals("4")) {
                    BookService.showBook(bookList);
                } else if (choice.equals("5")) {
                    DataOperate.saveData(bookList);
                    break;
                }
                // �������쳣����󣬸ô��׳�һ��InputException
                else {
//					System.out.println("���������ȷ�Ϻ��������");
                    throw new InputException("������1-5");
                }
            } catch (InputException e) {
                System.out.println(e.getMessage());
            }
            ;


        }

    }
}