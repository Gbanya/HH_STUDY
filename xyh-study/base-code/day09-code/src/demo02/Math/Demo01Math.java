package demo02.Math;
/*
java.util.Math������ѧ��صĹ����࣬�����ṩ�˴����ľ�̬�������������ѧ������صĲ���
1.public static double abs(double num);��ȡ����ֵ���ж������أ�
2.public static double ceil(double num);����ȡ��
3.public static double floor(double num);����ȡ��
4.public static long round(double num);��������
5.Math.PI������Ƶ�Բ���ʳ���
* */
public class Demo01Math {
    public static void main(String[] args) {
        //��ȡ����ֵ
        System.out.println(Math.abs(3.14));
        System.out.println(Math.abs(0));
        System.out.println(Math.abs(-2.5));
        System.out.println("=========================");
        //����ȡ��
        System.out.println(Math.ceil(3.9));//4.0
        System.out.println(Math.ceil(3.1));//4.0
        System.out.println(Math.ceil(3));//3.0
        System.out.println("=========================");

        //����ȡ��
        System.out.println(Math.floor(30.9));//30.0
        System.out.println(Math.floor(30.1));//30.0
        System.out.println(Math.floor(31.0));//30.0
        System.out.println("=========================");

        //��������(û��С����)
        System.out.println(Math.round(10.3));//10
        System.out.println(Math.round(10.1));//10
        System.out.println(Math.round(10.6));//11

        //Բ����(doubleֵ)
        System.out.println(Math.PI);
    }
}
