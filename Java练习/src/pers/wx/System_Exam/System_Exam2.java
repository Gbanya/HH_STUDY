/*���� Java��Ŀ2020��3��26��*/
package pers.wx.System_Exam;

public class System_Exam2 {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		//������Java�������ִ��һ�ڴ˿�ѭ������Ҫ��ʱ��
	     long my_begin, my_end;
	     my_begin=System.currentTimeMillis( );  //��ȡ��ǰʱ��
	     System.out.println("��ʼʱ�䣺"+my_begin);
	     for(long i=0;i<100000000L;i++) ;       //��һ�ڴο�ѭ��
	     my_end=System.currentTimeMillis( );  //��ȡ���ѭ����ʱ��
	     System.out.println("����ʱ�䣺"+my_end);
	     double usedtime=(my_end-my_begin)/1000.0; 
	     System.out.println("����һ�ڴο�ѭ����ʱ���ǣ�"+usedtime+"��");

	}

}
