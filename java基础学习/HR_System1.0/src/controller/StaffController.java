package controller;

import java.util.LinkedList;
import java.util.Scanner;

import model.Staff;
import service.StaffService;

public class StaffController {

	public static void main(String[] args) {
		LinkedList<Staff> staffList = new LinkedList<Staff>();
		Scanner input = new Scanner(System.in);
		while(true)
		{
			System.out.println("************��ӭ�������¹���ϵͳ************");
			System.out.println("����Ա����Ϣ�밴----------1");
			System.out.println("ɾ��Ա����Ϣ�밴----------2");
			System.out.println("�޸�Ա����Ϣ�밴----------3");
			System.out.println("��ѯ����Ա����Ϣ�밴----------4");
			
			//switch���ָ���ж�
			int num =input.nextInt();
			switch(num) {
				case 1:
					StaffService.addStaff(staffList);
					break;
				case 2:
					StaffService.delStaff(staffList);
					break;
				case 3:
					StaffService.updateStaff(staffList);
					break;
				case 4:
					StaffService.showStaff(staffList);
					break;
				default:
					System.out.println("�������������ԣ�");
					break;
			}
			
		}
	}

}
