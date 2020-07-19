package basic;

import java.util.Scanner;

public class Cat extends Animal implements Pet{

    String name;

    public Cat(String s){
        super(4);
        this.name = s;
    }

    public Cat(){
        this(null);
    }

    @Override
    public void getName(){
        Scanner sc = new Scanner(System.in);
        name = sc.nextLine();
        sc.close();
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void play() {
        System.out.println(this.name + "����һ���棡");
    }

    @Override
    void eat() {
        System.out.println("��"+ this.name + "ιʳ�У�");
    }

    public static void main(String[] args){
        Cat c = new Cat();
        c.getName();
        c.walk();
        c.play();
        c.eat();
    }
}
