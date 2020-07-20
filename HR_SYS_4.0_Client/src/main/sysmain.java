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
    //����idֵɾ������
    private void deleteResume() {

        System.out.println("************��ӭ����ɾ��ѧ����Ϣ����************");
        Scanner input = new Scanner(System.in);
        System.out.println("��������Ҫɾ��ѧ����Ϣ�����֤��");
        String id = input.nextLine();
        Resume resume=new Resume(null,id,null);
        Operator o =new Operator();
        ReturnResult rr=o.deleteResumeById(resume);
        if(rr.isSuccess)
        {
            JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "ɾ��ʧ��");
        }

    }
    //����id��������
    private void updateResume() {
        Scanner input = new Scanner(System.in);
        System.out.println("************��ӭ����ѧ����Ϣ�޸Ľ���************");
        System.out.println("��������Ҫ�޸�ѧ����Ϣ�����֤��");
        String oldId = input.nextLine();
        System.out.println("�����������ѧ���޸ĺ��ѧ�����������֤�š���ҵԺУ����������״̬����ʾ״̬��");
        System.out.println(
                "���м��������У�" +
                        " 0�������� " +
                        " 1������ͨ�� " +
                        " 2������ͨ�� " +
                        " 3�����ͨ�� " +
                        " 4������ͨ�� " +
                        " 5����ǩԼ " +
                        " 6������ְ");
        System.out.println(
                "��ʾ״̬�У�" +
                        "0 :��չʾ " +
                        "1 :չʾ");
        String newname = input.nextLine();
        String newid = input.nextLine();
        String newschool = input.nextLine();
        int newprocess = input.nextInt();
        int newdeleteStatus = input.nextInt();
        Resume resume=new Resume(newname,newid,newschool);
        resume.setProcess(newprocess);
        resume.setDeleteStatus(newdeleteStatus);
        //�ѽ����еõ������ݷ�������Resume��
        Resume oldResume=new Resume(null,oldId,null);
        Operator o =new Operator();
        //��Resume����Operator����
        ReturnResult rr=o.changeResume(resume,oldResume);
        if(rr.isSuccess)
        {
            JOptionPane.showMessageDialog(null, "���³ɹ�");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "����ʧ��");
        }

    }

    private void searchResume() {

    }

    private void searchResumeAll() {

    }




    public static void main(String[] args) {
        new sysmain();
    }
}
