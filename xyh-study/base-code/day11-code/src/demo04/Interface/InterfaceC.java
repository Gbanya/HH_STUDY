package demo04.Interface;
/*
�ӿ�֮��Ķ�̳�
�ýӿڹ���4���ӿڷ���
*/
public interface InterfaceC extends InterfaceA,InterfaceB {
    public abstract  void methodC();

/*    @Override
    void methodA();

    @Override
    void common();*/
    //������ӿڵ��е�Ĭ�Ϸ�������ظ�����ô�ӽӿڱ������Ĭ�Ϸ����ĸ�����д
   // �����ұ������defalut�ؼ��֡�
    @Override
    default void method() {
        System.out.println("������ӿڵ��е�Ĭ�Ϸ�������ظ�����ô�ӽӿڱ������Ĭ�Ϸ����ĸ�����д");
    }

/*    @Override
    void methodB();*/
}
