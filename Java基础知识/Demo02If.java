/*
���̣�˳���жϡ�ѡ��

switch ���ʹ�õ�ע�����
1.���case�������ֵ�������ظ�
2.switch�����С������ֻ�ܷ�  
������������ byte/short/char/int���͵�����
������������ ��String �ַ�����enumö��
3.switch����ʽ���Ժ���ǰ��˳����Եߵ�������break��仹����ʡ�ԡ�
��ƥ���ĸ�case�ʹ��ĸ�λ�ÿ�ʼ����ִ�У�ֱ������break�����������Ϊֹ����
*/

public class Demo02If{
	public static void main(String[] arge){
		System.out.println("������������");
		int age=16;
		
		///��if���
		if(age>=18){
			System.out.println("��������");
		}
		System.out.println("�ؼҳԷ�");
		
		//if ...else... ���
		//�ж���ż
		int num=13;
		if(num%2==0){
			System.out.println("ż��");
		}else{
			System.out.println("����");
		}
		
		//if...else if...else...���
		/*
		if(�ж����){
			
			�����
			
		}else if(�ж����){
			
			�����	
		}
		������
		else  if (�ж����){
			
			�����
		}else{
			  
			�����
		}
		
		*/
		
		//ʹ����Ԫ������ͱ�׼��if����else..���ֱ�ʵ�֣�ȥ�������ֵ��е����ֵ
		
		int a=10;
		int b=20;
		
		//��Ԫ�����
		int max=a>b?a:b;
		System.out.println("���ֵ��"+max);//���ֵ��20
		
		//ʹ��if  else
		int max1;
		if(a>b){
			max1=a;
		}else{
			max1=b;
		}
		System.out.println("���ֵ��"+max1);
	
		
	}
}