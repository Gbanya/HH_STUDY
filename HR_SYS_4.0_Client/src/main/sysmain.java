package main;

import control.Operator;
import model.ReturnResult;

import javax.swing.*;
import java.util.Scanner;
import model.Resume;
public class sysmain {
    public sysmain() {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("************��ӭ����xxx��������ϵͳ************");
            System.out.println("������Ϣ¼���밴----1");
            System.out.println("������Ϣɾ���밴----2");
            System.out.println("������Ϣ�޸��밴----3");
            System.out.println("������Ϣ��ѯ�밴----4");
            System.out.println("�������ݿ��ѯ�밴--5");
            System.out.println("�˳��밴-----------6");
            int choice = input.nextInt();
            if (choice == 1) {
                addResume();
            } else if (choice == 2) {
                deleteResume();
            } else if (choice == 3) {
                updateResume();
            } else if (choice == 4) {
                searchResume();
            } else if (choice == 5) {
                searchResumeAll();
            } else if (choice == 6) {
                break;

            } else {
                System.out.println("�����������������");
            }
        }
        //�ر�������
        System.out.println("���Ѿ��˳�xxx��������ϵͳ");
    }
    private void addResume() {
        System.out.println("************��ӭ�����������ϵͳ��¼�����*************");
        Scanner input = new Scanner(System.in);
        System.out.println("������������Ҫ¼��ѧ����Ϣ�����������֤�š���ҵԺУ");
        String Name = input.nextLine();
        String Id = input.nextLine();
        String School = input.nextLine();
        Resume resume = new Resume(Name, Id, School);
        Operator o =new Operator();
        //��Book����Operator����
        ReturnResult rr=o.addResume(resume);
        if(rr.isSuccess){
            JOptionPane.showMessageDialog(null, "��ӳɹ�");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "���ʧ��");
        }


    }
    private void deleteResume() {
    }

    private void updateResume() {

    }

    private void searchResume() {

    }

    private void searchResumeAll() {

    }




    public static void main(String[] args) {
        new sysmain();
    }
}
