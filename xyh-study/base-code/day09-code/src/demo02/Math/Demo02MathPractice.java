package demo02.Math;
/*
��Ŀ
����-10.8��5.9֮�䣬����ֵ����6����С��2.1������
*/
public class Demo02MathPractice {
    public static void main(String[] args) {
        //����ȡ��
       int a=(int)Math.ceil(-10.8);
       //int ��ǿ����������С��
       int b=(int)5.9;
       int num=0;
        for (int i =a ; i <=b ; i++) {
            if(Math.abs(i)>6||Math.abs(i)<2.1){
                System.out.println(i);
                num++;
            }

        }
        System.out.println("����Ҫ���һ���У�"+num+"��");
    }
}