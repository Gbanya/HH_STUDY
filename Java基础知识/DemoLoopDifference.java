/*
����ѭ��������

1.�������һ�ζ������㣬��ô forѭ����whileѭ������ִ��0�Σ���do-whileѭ����ִ������һ��
2.forѭ���ı�����С���ŵ��ж��壬ֻ����ѭ���ڲ��ſ���ʹ�ã�whileѭ����do-whileѭ����ʼ����䱾���������棬���Գ���ѭ��֮�󻹿���ʹ��

*/

public class DemoLoopDifference{
	public static void main(String[] args){
		for(int i=1;i<0;i++){
			System.out.println("hello");
		}
		//System.out.println(i)  ����д��  iֻ����forѭ����ʹ��
		System.out.println("=======")
		
		int i=1;
		do{
			System.out.println("hello");
			i++;
		}while(i<0);
		System.out.println(i);//����ʹ��
	}
}