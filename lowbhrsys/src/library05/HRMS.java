/**
 * A program for �ı���д---��������ϵͳ
 * @version 2.0 2020-07-15
 * @author ������
 */
package library05;
import java.util.LinkedList;
import java.util.Scanner;
import loadandsaveData.DataOperate;
import model.Resume;
import service.ResumeService;

public class HRMS
{
	public static void main(String[] args) {

		LinkedList<Resume> resumeList = new LinkedList<Resume>();
		Scanner input = new Scanner(System.in);
		DataOperate.loadData(resumeList);//��������ͼ��
		while(true)
		{
			System.out.println("************��ӭ�������ϰ��������ϵͳ************");
			System.out.println("���Ӽ����밴----------1");
			System.out.println("ɾ�������밴----------2");
			System.out.println("�޸ļ����밴----------3");
			System.out.println("��ѯ�����밴----------4");
			System.out.println("�˳��������밴--------------5");
		//if���ָ���ж�
			int choice =input.nextInt();
			if(choice==1)
			{
				ResumeService.addResume(resumeList);
			}
			else if(choice==2)
			{
				ResumeService.deleteResume(resumeList);
			}
			else if(choice==3)
			{
				ResumeService.updateBook(resumeList);
			}
			else if(choice==4)
			{
				ResumeService.showBook(resumeList);
			}
			else if(choice==5)
			{
				DataOperate.saveData(resumeList);
				break;
			}
			else {
				System.out.println("���������ȷ�Ϻ��������");
			}
		}
		System.out.println("�����˳���������ϵͳ");
	}
}