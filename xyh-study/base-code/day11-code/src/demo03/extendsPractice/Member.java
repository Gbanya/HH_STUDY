package demo03.extendsPractice;

import java.util.ArrayList;
import java.util.Random;

public class Member extends User {
    public Member() {

    }
    public Member(String name,int money){
        super(name,money);
    }

    public void receive(ArrayList<Integer> list){
        //�Ӷ�������������ȡһ�����Լ�
        //�����ȡһ�����ϵ��е��������
        int index=new Random().nextInt(list.size());
        //���ݼ��ϵ���ɾ�������ҽ���ɾ���ĺ�����Լ�
        int deta=list.remove(index);
        int money=super.getMoney();
        super.setMoney(money+deta);
    }
}
