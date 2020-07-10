package service;

import java.util.LinkedList;
import java.util.Scanner;
import model.Resume;
public class HRService
{
	//¼����Ϣ
	public static void addResume(LinkedList<Resume> resumeList)
	{
		System.out.println("��ӭ����Ա����Ϣ¼�����");
		Scanner input = new Scanner(System.in);
		System.out.println("������������Ҫ¼��Ա�������֣����֤�ţ�ѧУ���������");
		String workerName = input.nextLine();
		String workerId = input.nextLine();
		String workerSchool = input.nextLine();
		int preProcess = input.nextInt();
		while (preProcess > 6 || preProcess <0){
			System.out.println("�������ֻ��Ϊ0-6�����������룺");
			preProcess = input.nextInt();
		}
		int process = preProcess;
		Resume resume = new Resume(workerName, workerId, workerSchool, process);
		resumeList.add(resume);
		System.out.println("���ѳɹ�¼��Ա����Ϣ");
		showResume(resumeList);
	}

	//ɾ����Ϣ
	public static void deleteResume(LinkedList<Resume> resumeList)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("��ӭ����Ա����Ϣɾ������");
		System.out.println("��������Ҫɾ����Ա������");
		String workerName =input.nextLine();
		int workerCount = resumeList.size();
		for(int i=0; i<workerCount; i++)
		{
			if(resumeList.get(i).getName().equals(workerName))
			{
				resumeList.remove(i);
				System.out.println("���ѳɹ�ɾ��Ա��:" + workerName);
				break;
			}
			else if(i==workerCount-1) {
				System.out.println("û�в��ҵ�Ա��:" + workerName);
			}
		}
		 showResume(resumeList);
	}

	//�޸���Ϣ
	public static void updateResume(LinkedList<Resume> resumeList)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("��ӭ����Ա���޸Ľ���");
		showResume(resumeList);
		System.out.println("��������Ҫ�޸ĵ�Ա������");
		String workerName = input.nextLine();
		int workerCount = resumeList.size();
		for(int i=0; i<workerCount; i++)
		{
			if(resumeList.get(i).getName().equals(workerName))
			{
				System.out.println("������������Ա�������֣����֤�ţ�ѧУ");
				String newworkerName = input.nextLine();
				String newworkerId = input.nextLine();
				String newworkerSchool = input.nextLine();
				int process = input.nextInt();
				Resume resume = new Resume(newworkerName, newworkerId, newworkerSchool, process);
				resumeList.set(i, resume);
				System.out.println("���ѳɹ��޸ĳɹ�");
				showResume(resumeList);
			}
			else if(i==workerCount-1 || workerCount==0) {
				System.out.println("û�в��ҵ���Ա��");
			}
		}
		System.out.println("û�в��ҵ���Ա��");
	}

	//չʾ��Ϣ
	public static void showResume(LinkedList<Resume> resumeList)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("�Ƿ���Ҫ��ӡ����Ա����Ϣ����������Y�����ô�ӡ����������");
		String XUANZE=input.nextLine();
		String Y ="Y";
		if(XUANZE.equals(Y))
		{
			System.out.println("��HR����ϵͳ����" + resumeList.size() + "��Ա��");
			int workerCount = resumeList.size();
			for(int i=0; i<workerCount; i++) {
				System.out.println("��"+(i+1)+"��"+"---------"+"<<"+resumeList.get(i).getName()+">>");
			}
		}
	}
}
