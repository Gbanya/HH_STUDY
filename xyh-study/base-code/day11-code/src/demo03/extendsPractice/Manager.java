package demo03.extendsPractice;

import java.util.ArrayList;


public class Manager extends User{
    public Manager(){

    }

    public Manager(String name, int money) {
        super(name, money);
    }
    public ArrayList<Integer> send(int totalMoney, int count){
        //��Ҫһ�����ϣ������洢���ɸ����
        ArrayList<Integer> redList=new ArrayList<>();
        int leftMoney=super.getMoney();//�鿴Ⱥ����ǰ�����
        if(totalMoney>leftMoney){
            System.out.println("����");
            return redList;
        }
        //��Ǯ
        super.setMoney(leftMoney-totalMoney);
        //�����
        int avg=totalMoney/count;
        int mod=totalMoney%count;//��ͷ
        //��ͷ�������һ�������

        //�ź��
        for (int i = 0; i < count-1; i++) {
            redList.add(avg);
        }
        int last=avg+mod;
        redList.add(last);
        return redList;
    }
}
