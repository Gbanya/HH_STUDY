package demo04.Interface;

public interface MyInterfaceB {
    public abstract  void B();
    public abstract  void C();
    public default  void D(){
        System.out.println("����B���Ĭ�Ϸ���");
    }
}
