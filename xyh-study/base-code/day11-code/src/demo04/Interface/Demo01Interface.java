package demo04.Interface;
/*
�ӿھ��Ƕ����Ĺ����淶
�ӿ���һ��������������,����Ҫ�����ݾ������еĳ��󷽷�
һ����ζ���һ���ӿڵĸ�ʽ
public interface �ӿ�����(){
//�ӿ�����
}
�����java7���ӿ��п��԰����������У�
1.����
2.���󷽷�
�����java8�����Զ�������������У�
3.Ĭ�Ϸ���
4.��̬����
�����java9�������Զ������
5.˽�з���

�����ӿڵ�ʹ�ò���
1.�ӿڲ���ֱ��ʹ�ã�������һ��ʵ������ʵ�ֽӿ�
��ʽ:
public class ʵ�������� implements �ӿ�����{
//....
}
2.�ӿڵ�ʵ������븲����д��ʵ�֣��ӿ������еĳ��󷽷�
3.����ʵ����Ķ������ʹ��

ע��������ʵ���ಢû�и�����д�ӿ������еĳ��󷽷��������ʵ����ͱ����ǳ�����
* */
public class Demo01Interface {
    public static void main(String[] args) {
        MyInterfaceAbstractimpl imp=new MyInterfaceAbstractimpl();
        imp.methodAbs1();
        imp.methodAbs2();
        imp.methodAbs3();
        imp.methodAbs4();
    }
}
