package day04.demo;

import java.util.Scanner;
/*
��ϰ���ж�������������е����ֵ
*/
public class Demo2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("�������һ������");
        int a=sc.nextInt();
        System.out.println("������ڶ�������");
        int b=sc.nextInt();
        System.out.println("���������������");
        int c=sc.nextInt();
        int temp=a>b? a:b;
        int max=temp>c?temp:c;
        System.out.println("�����������������ǣ�"+max);

    }
}