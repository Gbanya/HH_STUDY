package demo04.Interface;
/*
�ӿڵ�Ĭ�Ϸ�������ͨ���ýӿڵ�ʵ�������ֱ�ӵ���
�ӿڵ�Ĭ�Ϸ�������ͨ���ýӿڵ�ʵ������󸲸���д
*/
public class Demo02Default {
    public static void main(String[] args) {
        //����ʵ�������
        MyInterfaceDefaultA a=new MyInterfaceDefaultA();
        a.methodAbs();
        //����Ĭ�Ϸ��������ʵ����û�У��������ҽӿ�
        a.methodDefault();
        System.out.println("===============");
        MyInterfaceDefaultB b=new MyInterfaceDefaultB();
        b.methodAbs();
        b.methodDefault();
    }
}
