package demo01.Abstract;

import java.security.PublicKey;

/*������븲����д���󷽷���abstract�ؼ���*/
public class Cat extends Animal{

    public Cat(){
        System.out.println("����è");
    }
    @Override
    public  void  eat(){
        System.out.println("è����");
    }
}
