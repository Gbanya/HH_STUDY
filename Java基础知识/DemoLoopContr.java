/*
break�ؼ��ֵ��÷��г���������

1.��������switch��䵱�У�һ��ִ�У�����switch������̽���
2.��������ѭ����䵱�У�һ��ִ�У�����ѭ�����̽��������ѭ��

ע�⣺
���Ǵ���ȷ���ĳ�������forѭ�����������whileѭ����

��һ��ѭ�����������continue�ؼ���
һ��ִ�У�����������ǰʣ�����ݣ����Ͽ�ʼ��һ��ѭ��
*/

public class DemoLoopContr{
	public static void main(String[] args){
		for(int i=1;i<10;i++){
			//���ϣ���ӵ�4�ο�ʼ������ȫ��Ҫ�ˣ���Ҫ���ѭ��
			if(i==4){
				break;
			}
			System.out.println("hello");
		}
		
		
		//continue�ؼ���
		for(int i=1;i<10;i++){
			if(i==4){
				continue;
			}
			System.out.println(i+"�㵽��");//������4��
		}
	}
}