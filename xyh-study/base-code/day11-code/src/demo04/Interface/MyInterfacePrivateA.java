package demo04.Interface;

/*
�ӿ��е�˽�з���
����������
������Ҫ��ȡһ�����еķ����������������Ĭ�Ϸ���֮���ظ����������
����������з�����Ӧ����ʵ����ʹ�ã������Ҫ˽�л�

���������
1.��ͨ˽�з�����������Ĭ�Ϸ���֮���ظ���������
��ʽ��
private ����ֵ���� ��������(�����б�){
//������
}
2.��̬˽�з�������������̬����֮���ظ���������
private static ����ֵ���� ��������(�����б�){
//������
}
*/
public interface MyInterfacePrivateA {
    public default void methodDefault1() {

        System.out.println("Ĭ�Ϸ���1");
/*        System.out.println("AAA");
        System.out.println("BBB");
        System.out.println("CCC");*/
        common();
    }

    public default void methodDefault2() {

        System.out.println("Ĭ�Ϸ���2");
        common();
       /* System.out.println("AAA");
        System.out.println("BBB");
        System.out.println("CCC");*/

    }
    private void common(){
        System.out.println("AAA");
        System.out.println("BBB");
        System.out.println("CCC");
    }

}

