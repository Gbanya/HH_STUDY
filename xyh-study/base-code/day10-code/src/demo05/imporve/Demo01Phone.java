package demo05.imporve;
/*
�̳��з�������д����
���ԭ��
�����Ѿ�Ͷ��ʹ�õ��࣬������Ҫ�����޸ġ�
�Ƽ�����һ���µ��࣬���ظ��������й������ݣ�������ӸĶ�������
* */
public class Demo01Phone {
    public static void main(String[] args) {
        //�Ͽ��ֻ�
        Phone phone=new Phone();
        phone.call();
        phone.send();
        phone.show();
        System.out.println("==================");

        //�¿��ֻ�
        NewPhone newPhone=new NewPhone();
        newPhone.call();
        newPhone.send();
        newPhone.show();
    }
}
