/*
��������ת��

���������Ͳ�һ��ʱ�����ᷢ����������װ��

�Զ�ת������ʽ��
	1.�ص㣺���벻��Ҫ�������⴦���Զ����
	2.�������ݷ�Χ��С����


*/

public class Demo01DataType{
	public static void main(String[] args){
		System.out.println(1024);
		System.out.println(3.14);
		
		long num1=100L;
		System.out.println(num1);//100
		
		//int -->long ,������ֵ��Χ��С����
		//��һ�д��뷢�����Զ�����ת��
		long num2=100;//�����long���ұ���int,���Ҳ�һ��
		System.out.println(num2);//100
		
		//�����float���ұ���long,���Ҳ�һ��
		//long -->float,������ֵ��Χ��С����
		float num3=100L;
		System.out.println(num3);//
	}
}