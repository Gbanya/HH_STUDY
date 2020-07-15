package sys;


import Work.Action;
import bean.Resume;
import bean.ResumeList;

import java.util.Scanner;

public class Hrsys {
	public Hrsys() {

		Scanner input = new Scanner(System.in);
		int count = 1;

		do{
			System.out.println("########## ��ӭ�������¹���ϵͳ(����Mysql���ݿ�) ##########");
			System.out.println("##########[����ӦƸ���밴----------1]��");
			System.out.println("##########[ɾ��ӦƸ���밴----------2]��");
			System.out.println("##########[�޸�ӦƸ���밴----------3]��");
			System.out.println("##########[��ѯӦƸ���밴----------4]��");
			System.out.println("##########[�˳��밴--------------0]��");
			// switch������ѡ���ж�
			int choice = input.nextInt();
			switch(choice) {
				case 1:
					addResume();
					break;

				case 2:
					deleteResume();
					break;

				case 3:
					updateResume();
					break;

				case 4:
					searchBook();
					break;

				default:
					System.out.println("�����ʽ������ȷ�Ϻ�������룡");
					break;

				case 0:
					System.out.println("(�����˳���������ϵͳ");
					count = 0;

			}

		}while (count == 1);
	}
	static void addResume()
	{
		System.out.println("��ӭ�������ӦƸ�߽���");
		Scanner input = new Scanner(System.in);
		System.out.println("����������ӦƸ�ߵ��������Ա����䣬ѧ��");
		String RName=input.nextLine();
		String RGender =input.nextLine();
		String RAge =input.nextLine();
		String REdu = input.nextLine();
		Resume r=new Resume(RName,RGender,RAge,REdu);
		Action a =new Action();
		int line=a.addResume(r);
		if(line>0){
			System.out.println("���ӦƸ�߳ɹ�");
		}
		else
		{
			System.out.println("���ʧ��,����������");
		}
	}

	//*************************ɾ��ӦƸ��*******************************
	static void deleteResume()
	{

		Scanner input = new Scanner(System.in);
		System.out.println("************��ӭ����ɾ��ӦƸ�߽���************");
		System.out.println("��������Ҫɾ����ӦƸ��*����*");
		String RName =input.nextLine();
		Resume r=new Resume(RName,null,null,null);
		Action d =new Action();
		int line=d.deleteResumeByName(r);
		if(line>0)
		{
			System.out.println("ɾ��ӦƸ�߳ɹ�");
		}
		else
		{
			System.out.println("û���ҵ���ӦƸ�ߣ��޷�ɾ��");
		}

	}


	//*************************��ѯӦƸ��*******************************
	static void searchBook() {
		while (true) {
			System.out.println("************��ӭ������ѯӦƸ�߽���************");
			System.out.println("��������Ҫ��ѯ��ӦƸ������");
			Scanner input = new Scanner(System.in);

			String Name = input.nextLine();
			Resume r = new Resume(Name, null, null, null);
			Action s = new Action();
			ResumeList list = s.searchResumeByName(r);
			int Count = list.size();
			if (Count > 0) {
				for (int i = 0; i < Count; i++) {
					System.out.println("����:" + list.get(i).getName() + ">>" + "  "
							+ "�Ա�" + "��" + list.get(i).getGender() + "  "
							+ "����" + "��" + list.get(i).getAge() + "  "
							+ "ѧ��" + "��" + list.get(i).getEducation() + "  ");
				}
			} else {
				System.out.println("û���ҵ�����Ϊ" + Name + "��ӦƸ��");
			}

		}
	}

	//*************************�޸�ӦƸ����Ϣ*******************************
	static void updateResume(){
		System.out.println("************��ӭ�����޸�ӦƸ����Ϣ����************");
		System.out.println("��������Ҫ�޸ĵ�ӦƸ������");
		Scanner input = new Scanner(System.in);
		String oldName = input.nextLine();
		System.out.println("�����������޸Ĺ����ӦƸ�ߵ��������Ա����䣬ѧ��");
		String RName=input.nextLine();
		String RGender =input.nextLine();
		String RAge =input.nextLine();
		String REdu = input.nextLine();
		//ԭ������Ϣ���µ�ӦƸ����Ϣ
		Resume oldR = new Resume(oldName, null, null, null);
		Resume newR = new Resume(RName,RGender,RAge,REdu);

		Action a = new Action();
		int line=a.changeResume(newR, oldR);
		if(line>0)
		{
			System.out.println("�޸ĳɹ�");
		}
		else
		{
			System.out.println("�޸�ʧ�ܣ����������������");
		}

	}


	public static void main(String[] args)
	{
		new Hrsys();
	}
}