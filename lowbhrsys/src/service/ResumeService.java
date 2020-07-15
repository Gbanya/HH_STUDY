package service;

import java.util.LinkedList;
import java.util.Scanner;
import model.Resume;
public class ResumeService
{
	public static void addResume(LinkedList<Resume> resumeList)
	{
		System.out.println("��ӭ������Ӽ�������");
		Scanner input = new Scanner(System.in);
		System.out.println("������������Ҫ���ѧ������ѧ��ID��ѧУ�� ����״̬(�Կո�ָ�)");
		String studentName =input.next();
		int studentID =input.nextInt();
		String studentSchool =input.next();
		int process = input.nextInt();
		Resume resume = new Resume(studentName,studentID,studentSchool,process);
		resumeList.add(resume);
		System.out.println("���ѳɹ���Ӽ���");
		showBook(resumeList);
	}

	public static void deleteResume(LinkedList<Resume> resumeList)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("��ӭ����ɾ����������");
		System.out.println("��������Ҫɾ����ѧ����");
		String resumeName =input.nextLine();
		int resumeCount = resumeList.size();
		for(int i=0;i<resumeCount;i++)
		{
			if(resumeList.get(i).studentName.equals(resumeName))
			{
				resumeList.remove(i);
				System.out.println("���ѳɹ�ɾ������");
				break;
			}
			else if(i==resumeCount-1) {
				System.out.println("û�в��ҵ��ü���");
			}
		}
		 showBook(resumeList);
	}


	public static void updateBook(LinkedList<Resume> resumeList)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("��ӭ�����޸ļ�������");
		System.out.println("��������Ҫ�޸ĵļ�����");
		String resumeName=input.nextLine();
		int resumeCount = resumeList.size();
		for(int i=0;i<resumeCount;i++)
		{
			if(resumeList.get(i).studentName.equals(resumeName))
			{
				System.out.println("�����������µ�ѧ������ID��ѧУ�� ����״̬��(�Կո�ָ�)");
				String newresumeName=input.next();
				int newresumeID=input.nextInt();
				String newresumeSchool=input.next();
				int newProcess = input.nextInt();
				Resume resume =new Resume(newresumeName,newresumeID,newresumeSchool,newProcess);
				resumeList.set(i, resume);
				System.out.println("���ѳɹ��޸�");
				showBook(resumeList);
			}
			else if(i==resumeCount-1||resumeCount==0) {
				System.out.println("û�в��ҵ��ü���");
			}
		}
		System.out.println("û�в��ҵ��ü���");
	}

	public static void showBook(LinkedList<Resume> resumeList)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("�Ƿ���Ҫ��ӡ���м�������������Y�����ô�ӡ����������");
		String XUANZE=input.nextLine();
		String Y ="Y";
		if(XUANZE.equals(Y))
		{
			System.out.println("����������ϵͳ����"+ resumeList.size()+"�ݼ���");
			int bookCount = resumeList.size();
			for(int i=0;i<bookCount;i++) {
				System.out.println("��"+(i+1)+"��"+"---------"+"<<"+ resumeList.get(i).studentName+resumeList.get(i).studnetID+resumeList.get(i).studentSchool+resumeList.get(i).process+">>");
			}

		}
	}
}
