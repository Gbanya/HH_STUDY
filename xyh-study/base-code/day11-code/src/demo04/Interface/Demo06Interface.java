package demo04.Interface;

import jdk.swing.interop.SwingInterOpUtils;

/*
* ʹ�ýӿڵ�ʱ����Ҫע�⣺
* 1.�ӿ���û�о�̬�������߹��췽����
* 2.һ�����ֱ�Ӹ�������ֻ��һ������һ�������ͬʱʵ�ֶ���ӿ�
*  ��ʽ��
* public class MyInterfaceImpl implement InterfaceA,InterfaceB{
*
* }
* 3.���ʵ������ʵ�ֵĶ���ӿڵ��д����ظ��ĳ��󷽷�������дһ������
* 4.���ʵ����û�и�����д���нӿڵ��е����г��󷽷�����ôʵ���������һ��������
* 5.���ʵ����ʵ�ֵĶ���ӿ��У������ظ���Ĭ�Ϸ�������ôʵ����һ��Ҫ���ͻ��Ĭ�Ϸ������и�����д
* 6.һ�������ֱ�Ӹ��൱�еķ������ͽӿڵ��е�Ĭ�Ϸ��������˳�ͻ�������ø��൱�еķ���
* */
public class Demo06Interface {
    public static void main(String[] args) {
        Zi zi=new  Zi();
        //����ʹ�ø���ķ���
        zi.show();
    }
}
