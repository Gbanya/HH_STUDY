package demo02.MemberVariable;
/*
������ļ̳й�ϵ���У������Ա�����븸��ĳ�Ա�����������򴴽��������ʱ�������ַ��ʷ�ʽ
1.ֱ��ͨ�����������ʳ�Ա������
�Ⱥ������˭����������˭��û����������
2.���ͨ����Ա�������ʳ�Ա����
�÷������ڣ������ﶨ�壩˭��������˭��û����������


* */
public class Demo01ExtendsField {
    public static void main(String[] args) {
        //��������Ķ���
        Father f=new Father();//10
        //����ֻ��ʹ������ĳ�Ա����
        System.out.println(f.numFather);
        System.out.println("===========================");
        //�����������
        Son s=new Son();
        //������Է��ʸ���ĳ�Ա����
        System.out.println(s.numFather);//10
        System.out.println(s.numSon);//20
        System.out.println("===========================");

        //�������1���Ⱥ������˭����������˭��û����������
        //�����numֵ
        System.out.println(s.num);//40
        System.out.println("===========================");

        //�������2���÷������ڣ������ﶨ�壩˭��������˭��û����������
        //����������������ж���ģ�����ʹ�����࣬û����������
        s.methodSon();//40
        //��������Ǹ����ж����
        s.methodFather();//30



    }
}
