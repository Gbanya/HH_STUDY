package cn.swjtu.day0710_Extends06;

public class Fu {
   /* public Fu(){
        System.out.println("父类无参构造函数！");
    }*/

    int num=10;

    public Fu(int num){
        System.out.println("父类有参构造方法！");
    }

    public void method(){

        System.out.println(num);
    }
}
