package demo04.method;

public class Son extends Father{
    public void methodS(){
        System.out.println("���෽��ִ��");
    }
    public void method(){
        System.out.println("������������ִ��");
    }

    @Override//(����Ƿ�Ϊ��Ч�ط�����д)
    //����дpublic����default�����η�Ȩ��С�ڸ���public������
    public String methodOver(){
        return null;
    }
}
