package demo07.Super;
/*
super�ؼ��ֵ��÷�������
1.�������Ա�����У����ʸ���ĳ�Ա����
2.�������Ա�����У����ʸ���ĳ�Ա����
3.������Ĺ��췽���У����ʸ���Ĺ��췽��
*/
public class Son extends Father{
    int num=20;

    public Son(){
        super();
    }
    public void methodSon(){
        System.out.println(num);
        //1.�������Ա�����У����ʸ���ĳ�Ա����
        System.out.println(super.num);
    }
    public void method(){
        //2.�������Ա�����У����ʸ���ĳ�Ա����
        super.method();
        System.out.println("����ĳ�Ա����");
    }
}
