package demo03.threeMember;

public class Son  extends Father{
    int num=20;
    public void method(){
        int num=30;
        //�ֲ�����
        System.out.println(num);
        //����ı���
        System.out.println(this.num);
        //����ı���
        System.out.println(super.num);
    }

}
