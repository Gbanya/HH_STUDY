package demo04.Interface;

public interface InterfaceB {
    public abstract  void methodB();
    public abstract void common();
    public default  void  method() {
        System.out.println("�ӿ�B��Ĭ�Ϸ���");
    }
}
