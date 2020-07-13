package hrsys;


import bean.Resume;
import bean.ResumeList;
import work.Action;

import java.sql.SQLOutput;
import java.util.Scanner;

public class HRMS {
    public static void main(String[] args) {
        //���������
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
            } else if(choice==5){
                searchResumeAll();
            }
            else if (choice == 6) {
                break;

            } else {
                System.out.println("�����������������");
            }
        }
        //�ر�������
        System.out.println("���Ѿ��˳�xxx��������ϵͳ");

    }

    private static void searchResumeAll() {
        Action s = new Action();
        ResumeList resumelist=s.searchResumeAll();
        int resumeCount = resumelist.size();
        if(resumeCount>0)
        {
            for(int i=0;i<resumeCount;i++) {
                System.out.println("������"+resumelist.get(i).getName()+"  "
                        +"���֤��"+"��"+resumelist.get(i).getId()+"  "
                        +"��ҵԺУ"+"��"+resumelist.get(i).getSchool()+"  "
                        +"�������̣�"+resumelist.get(i).getProcess()+"  "
                        +"������ʾ״̬��"+resumelist.get(i).getDeleteStatus());
            }
        }
        else {
            System.out.println("�Բ��𣬼������ݿ�Ϊ��");
        }

    }

    public static void addResume() {
        System.out.println("************��ӭ�����������ϵͳ��¼�����*************");
        Scanner input = new Scanner(System.in);
        System.out.println("������������Ҫ¼��ѧ����Ϣ�����������֤�š���ҵԺУ");
        String Name = input.nextLine();
        String Id = input.nextLine();
        String School = input.nextLine();
        Resume resume = new Resume(Name, Id, School);
        Action a = new Action();
        int line = a.addresume(resume);
        if (line > 0) {
            System.out.println("���ͼ��ɹ�");
        } else {
            System.out.println("���ͼ��ʧ��");
        }
    }

    public static void deleteResume() {
        System.out.println("************��ӭ����ɾ��ѧ����Ϣ����************");
        Scanner input = new Scanner(System.in);
        System.out.println("��������Ҫɾ��ѧ����Ϣ�����֤��");
        String id = input.nextLine();
        Action d = new Action();
        int line = d.deleteResumeByid(id);
        System.out.println("ɾ��ͼ��ɹ�");
    }

    public static void updateResume() {


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
        Action d = new Action();
        int line = d.changeResume(resume,oldId);
        System.out.println("���³ɹ�");
    }

    public static void searchResume() {

        while(true)
        {
            System.out.println("************��ӭ����������ѯ************");
            System.out.println("��ѧ��������ѯ������----------1");
            System.out.println("��ѧ�����֤��ѯ������----------2");
            System.out.println("��ѧ����ҵԺУ��ѯ������------------3");
            System.out.println("��ѧ���������̲�ѯ������----------4");
            System.out.println("ģ����ѯ������------------5");
            System.out.println("�˳��밴----------------6");
            Scanner input = new Scanner(System.in);
            int choice =input.nextInt();
            if(choice==1)
            {
                searchResumeByName();

            }
            else if(choice==2)
            {
                searchResumeById();
            }
            else if(choice==3)
            {
                searchResumeBySchool();
            }
            else if(choice==4)
            {
                searchResumeByProcess();
            }
            else if(choice==5)
            {
                searchResumeByPointword();
            }
            else if(choice==6){
                break;
            }
            else{
                System.out.println("��ȷ�Ϻ���������");
            }
        }


    }

    private static void searchResumeByPointword() {
        Scanner input = new Scanner(System.in);
        System.out.println("��������Ҫ��ѯ������ѧ��������");
        String burname =input.nextLine();
        Action s = new Action();
        ResumeList resumelist=s.searchResumeByPointword(burname);
        int resumeCount = resumelist.size();
        if(resumeCount>0)
        {
            for(int i=0;i<resumeCount;i++) {
                System.out.println("������"+resumelist.get(i).getName()+"  "
                        +"���֤��"+"��"+resumelist.get(i).getId()+"  "
                        +"��ҵԺУ"+"��"+resumelist.get(i).getSchool()+"  "
                        +"�������̣�"+resumelist.get(i).getProcess()+"  "
                        +"������ʾ״̬��"+resumelist.get(i).getDeleteStatus());
            }
        }
        else {
            System.out.println("�Բ���û���ҵ�");
        }

    }

    private static void searchResumeByName() {
        Scanner input = new Scanner(System.in);
        System.out.println("��������Ҫ��ѯ������ѧ��������");
        String name =input.nextLine();
        Action s = new Action();
        ResumeList resumelist=s.searchResumeByName(name);
        int resumeCount = resumelist.size();
        if(resumeCount>0)
        {
            for(int i=0;i<resumeCount;i++) {
                System.out.println("������"+resumelist.get(i).getName()+"  "
                        +"���֤��"+"��"+resumelist.get(i).getId()+"  "
                        +"��ҵԺУ"+"��"+resumelist.get(i).getSchool()+"  "
                        +"�������̣�"+resumelist.get(i).getProcess()+"  "
                        +"������ʾ״̬��"+resumelist.get(i).getDeleteStatus());
            }
        }
        else {
            System.out.println("û���ҵ�����Ϊ"+name+"��ְ������");
        }

    }

    private static void searchResumeById() {
        Scanner input = new Scanner(System.in);
        System.out.println("��������Ҫ��ѯ������ְ�����֤�ţ�");
        String id =input.nextLine();
        Action s = new Action();
        ResumeList resumelist=s.searchResumeByid(id);
        int resumeCount = resumelist.size();
        if(resumeCount>0)
        {
            for(int i=0;i<resumeCount;i++) {
                System.out.println("������"+resumelist.get(i).getName()+"  "
                        +"���֤��"+"��"+resumelist.get(i).getId()+"  "
                        +"��ҵԺУ"+"��"+resumelist.get(i).getSchool()+"  "
                        +"�������̣�"+resumelist.get(i).getProcess()+"  "
                        +"������ʾ״̬��"+resumelist.get(i).getDeleteStatus());
            }
        }
        else {
            System.out.println("û���ҵ����֤��Ϊ"+id+"��ѧ������");
        }
    }

    private static void searchResumeBySchool() {
        Scanner input = new Scanner(System.in);
        System.out.println("��������Ҫ��ѯְ�������ı�ҵԺУ��");
        String school =input.nextLine();
        Action s = new Action();
        ResumeList resumelist=s.searchResumeByschool(school);
        int resumeCount = resumelist.size();
        if(resumeCount>0)
        {
            for(int i=0;i<resumeCount;i++) {
                System.out.println("������"+resumelist.get(i).getName()+"  "
                        +"���֤��"+"��"+resumelist.get(i).getId()+"  "
                        +"��ҵԺУ"+"��"+resumelist.get(i).getSchool()+"  "
                        +"�������̣�"+resumelist.get(i).getProcess()+"  "
                        +"������ʾ״̬��"+resumelist.get(i).getDeleteStatus());
            }
        }
        else {
            System.out.println("û���ҵ���ҵԺУΪ"+school+"��ְ������");
        }

    }

    private static void searchResumeByProcess() {
        Scanner input = new Scanner(System.in);
        System.out.println("��������Ҫ��ѯְ�������Ľ��̣�");
        String  process =input.nextLine();
        Action s = new Action();
        ResumeList resumelist=s.searchResumeByprocess(process);
        int resumeCount = resumelist.size();
        if(resumeCount>0)
        {
            for(int i=0;i<resumeCount;i++) {
                System.out.println("������"+resumelist.get(i).getName()+"  "
                        +"���֤��"+"��"+resumelist.get(i).getId()+"  "
                        +"��ҵԺУ"+"��"+resumelist.get(i).getSchool()+"  "
                        +"�������̣�"+resumelist.get(i).getProcess()+"  "
                        +"������ʾ״̬��"+resumelist.get(i).getDeleteStatus());
            }
        }
        else {
            System.out.println("Ŀǰ�����л�û�н�����"+process+"�ļ���");
        }
    }


}
