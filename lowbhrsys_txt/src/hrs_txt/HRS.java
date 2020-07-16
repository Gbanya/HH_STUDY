/**
 * A program for JAVA��һ�ڿ���ҵ---ͼ�����ϵͳ
 * @version 1.2 2016-03-11
 * @author ���ʽ� 2014214225
 */
package hrs_txt;
import java.util.LinkedList;
import java.util.Scanner;
import loadandsaveData.DataOperate;
import model.Resume;
import service.HRService;

public class HRS
{
	public static void main(String[] args) {

		LinkedList<Resume> resumeList = new LinkedList<Resume>();
		Scanner input = new Scanner(System.in);
		DataOperate.loadData(resumeList);//��������ͼ��
		while(true)
		{
			System.out.println("************��ӭ����HR����ϵͳ************");
			System.out.println("¼��Ա����Ϣ�밴----------1");
			System.out.println("ɾ��Ա����Ϣ�밴----------2");
			System.out.println("�޸�Ա����Ϣ�밴----------3");
			System.out.println("��ѯԱ����Ϣ�밴----------4");
			System.out.println("�˳��밴--------------5");
		//if���ָ���ж�
			int choice =input.nextInt();
			if(choice==1)
			{
				HRService.addResume(resumeList);
				DataOperate.saveData(resumeList);
			}
			else if(choice==2)
			{
				HRService.deleteResume(resumeList);
				DataOperate.saveData(resumeList);
			}
			else if(choice==3)
			{
				HRService.updateResume(resumeList);
				DataOperate.saveData(resumeList);
			}
			else if(choice==4)
			{
				HRService.showResume(resumeList);
				DataOperate.saveData(resumeList);
			}
			else if(choice==5)
			{
				break;
			}
			else {
				System.out.println("���������ȷ�Ϻ���������");
			}
		}
		System.out.println("�����˳�HR����ϵͳ");
	}
}