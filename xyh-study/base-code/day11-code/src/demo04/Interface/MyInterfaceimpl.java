package demo04.Interface;


import jdk.swing.interop.SwingInterOpUtils;

public class MyInterfaceimpl  implements MyInterfaceA,MyInterfaceB{
    @Override
    public void A() {
        System.out.println("������д��A����");
    }

    @Override
    public void B() {
        System.out.println("������д��B����");
    }

    @Override
    public void C() {
        System.out.println("������д��A��B�ӿڶ��еĳ��󷽷�");
    }

    @Override
    public void D() {
        System.out.println("�Զ���ӿڵ��г�ͻ��Ĭ�Ϸ��������˸�����д");
    }
}
