package service;

import java.util.LinkedList;
import java.util.Scanner;

import model.Staff;

public class StaffService {
	//Ա����Ϣ���
	public static void addStaff(LinkedList<Staff> staffList) {
		System.out.println("���ڿ�ʼ�����Ա��");
		Scanner input = new Scanner(System.in);
		System.out.println("������������Ա�����䡢���š��������Ա�");
		int age = input.nextInt();
		String staffId = input.nextLine();
		String name = input.nextLine();
		String sex = input.nextLine();
		
		Staff staff = new Staff(age, staffId, name, sex);
		staffList.add(staff); //�����Ա����Ϣ��������
		System.out.println("���ţ�"+staffId);
		System.out.println("����Ա����ӳɹ���");
	}
	
	//Ա����Ϣɾ��
	public static void delStaff(LinkedList<Staff> staffList) {
		System.out.println("ɾ��Ա����Ϣ");
		Scanner input = new Scanner(System.in);
		System.out.println("������Ҫɾ��Ա���Ĺ��ţ�");
		String staffId = input.nextLine();
		
		for(int i = 0; i < staffList.size();i++) {
			if(staffList.get(i).getStaffId().equals(staffId)) { //��������Ա�������뼯���е�Ա��������ȣ���Ӽ�����ɾ������Ա����Ϣ
				staffList.remove(i);
				System.out.println("����Ϊ��" + staffId + "��Ա����Ϣɾ���ɹ���");
				break;
			}else if (i == staffList.size() - 1) {
				System.out.println("δ�ҵ���Ա����Ϣ!");
			}
		}
	}
	
	//�޸�Ա����Ϣ
	public static void updateStaff(LinkedList<Staff> staffList) {
		System.out.println("�޸�Ա����Ϣ");
		Scanner input = new Scanner(System.in);
		System.out.println("������Ҫ�޸�Ա���Ĺ��ţ�");
		String staffId = input.nextLine();
		
		for(int i = 0; i < staffList.size();i++) {
			if(staffList.get(i).getStaffId().equals(staffId)) { //��������Ա�������뼯���е�Ա��������ȣ���Ӽ�����ɾ������Ա����Ϣ
				System.out.println("������������Ҫ�޸ĵ�Ա����Ϣ�����䡢���š��������Ա�");
				int newAge = input.nextInt();
				String newStaffId = input.nextLine();
				String newName = input.nextLine();
				String newSex = input.nextLine();
				Staff newStaff = new Staff(newAge, newStaffId, newName, newSex);
				staffList.set(i, newStaff);//�޸Ķ�Ӧ���ϱ���е�Ա����Ϣ
				System.out.println("ԭ����Ϊ��" + staffId + "��Ա����Ϣ�޸ĳɹ���");
				break;
			}else if (i == staffList.size() - 1 || staffList.size() == 0) {
				System.out.println("δ�ҵ���Ա����Ϣ!");
			}
		}
	}
	
	//��ʾԱ����Ϣ
	public static void showStaff(LinkedList<Staff> staffList) {
		System.out.println("����Ա����Ϣ���£�");
		for(int i = 0; i < staffList.size(); i++) {
			int age = staffList.get(i).getAge();
			String staffId = staffList.get(i).getStaffId();
			String name = staffList.get(i).getName();
			String sex = staffList.get(i).getSex();
			System.out.println("���䣺" + age + " " + "���ţ�" + staffId + " " + "������" + name + " " +"�Ա�" + sex );
		}
	}
	
}
