package demo04.Interface;

public interface MyInterfaceA {
    public abstract  void A();
    public abstract  void C();
    public default  void D(){
        System.out.println("����A���Ĭ�Ϸ���");
    }
}
