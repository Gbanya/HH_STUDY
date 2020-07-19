package basic;

public abstract class Animal {
    protected int legs;

    public Animal(int l){
        legs = l;
    }

    abstract void eat();

    public void walk(){
        if(legs == 2)
            System.out.println("ֱ������");
        else if (legs == 4)
            System.out.println("ſ����");
        else
            System.out.println("������");
    }
}
