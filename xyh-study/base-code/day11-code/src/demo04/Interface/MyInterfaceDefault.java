package demo04.Interface;
/*
��java8��ʼ���ӿ���������Ĭ�Ϸ���
��ʽ��
public default ����ֵ���� ��������(�����б�){
������
}

��ע���ӿڵ��е�Ĭ�Ϸ��������Խ���ӿ�����������;Ҳ����ƴ�Ӻ���ģ��
*/
public interface MyInterfaceDefault {
    //���󷽷�
    public abstract  void methodAbs();
    //����·�����ΪĬ�Ϸ�����A��B��ʵ�������踲����д
    public default void methodDefault(){
        System.out.println("������ӵ�Ĭ�Ϸ���");
    }
}
