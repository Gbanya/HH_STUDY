package demo08.This;
/*
* this�ؼ����������ʱ�������ݣ��÷�����������
* 1.�ڱ���ĳ�Ա�����У����ʱ���ĳ�Ա����
* 2.�ڱ���ĳ�Ա�����У����ʱ������һ����Ա����
* 3.�ڱ���Ĺ��췽���У����ʱ�����һ�����췽��
* ��3��Ӧ��ע��
* 1��this(....)���ñ����ǹ��췽���ĵ�һ����䣬��Ӧ����Ψһ��
* 2) super(...)��this(...)����ͬʱʹ�ã������1��ì��
* */
public class Son extends Father{
    int num=20;
    public Son(){
        //�ڱ���Ĺ��췽���У����ʱ�����һ�����췽��
        this(20);
        System.out.println("������޲�������");
    }
    public Son(int num){
        System.out.println("�������в������췽����������"+num);
    }
    public void showNum(){
        int num=10;
        System.out.println(num);//�ֲ�����10
        //�ڱ���ĳ�Ա�����У����ʱ���ĳ�Ա����
        System.out.println(this.num);//20
    }

    public void methodA(){
        System.out.println("AAAAA");
    }
    public void methodB(){
        //�ڱ���ĳ�Ա�����У����ʱ������һ����Ա����
        this.methodA();
        System.out.println("BBBBB");
    }
}
