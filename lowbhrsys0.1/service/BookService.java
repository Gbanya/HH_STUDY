package service;

import model.Book;

import java.util.LinkedList;
import java.util.Scanner;

public class BookService {
    public static void addBook(LinkedList<Book> bookList) {
        System.out.println("��ӭ�������ͼ�����");
        Scanner input = new Scanner(System.in);
        System.out.println("������������Ҫ���ͼ���������ߣ��۸�");
        String bookName = input.nextLine();
        String bookAuthor = input.nextLine();
        float bookPrice = input.nextFloat();
        Book book = new Book(bookName, bookAuthor, bookPrice);
        bookList.add(book);
        System.out.println("���ѳɹ����ͼ��");
        showBook(bookList);
    }

    public static void deleteBook(LinkedList<Book> bookList) {
        Scanner input = new Scanner(System.in);
        System.out.println("��ӭ����ɾ��ͼ�����");
        System.out.println("��������Ҫɾ����ͼ����");
        String bookName = input.nextLine();
        int bookCount = bookList.size();
        for (int i = 0; i < bookCount; i++) {
            if (bookList.get(i).bookName.equals(bookName)) {
                bookList.remove(i);
                System.out.println("���ѳɹ�ɾ��ͼ��");
                break;
            } else if (i == bookCount - 1) {
                System.out.println("û�в��ҵ����鼮");
            }
        }
        showBook(bookList);
    }


    public static void updateBook(LinkedList<Book> bookList) {
        Scanner input = new Scanner(System.in);
        System.out.println("��ӭ�����޸�ͼ�����");
        System.out.println("��������Ҫ�޸ĵ�ͼ����");
        String bookName = input.nextLine();
        int bookCount = bookList.size();
        for (int i = 0; i < bookCount; i++) {
            if (bookList.get(i).bookName.equals(bookName)) {
                System.out.println("�����������µ����������ߣ��۸�");
                String newbookName = input.nextLine();
                String newbookAuthor = input.nextLine();
                float newbookPrice = input.nextFloat();
                Book book = new Book(newbookName, newbookAuthor, newbookPrice);
                bookList.set(i, book);
                System.out.println("���ѳɹ��޸ĳɹ�");
                showBook(bookList);
            } else if (i == bookCount - 1 || bookCount == 0) {
                System.out.println("û�в��ҵ����鼮");
            }
        }
        System.out.println("û�в��ҵ����鼮");
    }

    public static void showBook(LinkedList<Book> bookList) {
        Scanner input = new Scanner(System.in);
        System.out.println("�Ƿ���Ҫ��ӡ����ͼ�飬��������Y�����ô�ӡ����������");
        String XUANZE = input.nextLine();
        String Y = "Y";
        if (XUANZE.equals(Y)) {
            System.out.println("��ͼ�����ϵͳ����" + bookList.size() + "����");
            int bookCount = bookList.size();
            for (int i = 0; i < bookCount; i++) {
                System.out.println("��" + (i + 1) + "��" + "---------" + "<<" + bookList.get(i).bookName + ">>");
            }
        }
    }
}
