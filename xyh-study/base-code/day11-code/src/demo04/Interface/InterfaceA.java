package demo04.Interface;

public interface InterfaceA {
    public abstract  void methodA();
    public abstract void common();
    public default  void  method() {
        System.out.println("�ӿ�A��Ĭ�Ϸ���");
    }
}
