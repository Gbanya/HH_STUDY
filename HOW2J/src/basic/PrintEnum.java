package basic;


public class PrintEnum {
    /*public static void main(String[] args){
        for (Season s : Season.values())
            System.out.println(s);
    }
    */

    public static void main(String[] args){
        for (HeroProperty h: HeroProperty.values()){
            switch (h){
                case TANK:
                    System.out.println("̹��");
                    break;
                case WIZARD:
                    System.out.println("��ʦ");
                    break;
                case ASSASSIN:
                    System.out.println("�̿�");
                    break;
                case WARRIOR:
                    System.out.println("��ս");
                    break;
                case ASSIST:
                    System.out.println("����");
                    break;
                case FARMING:
                    System.out.println("��Ұ");
                    break;
                case RANGED:
                    System.out.println("Զ��");
                    break;
                case PUSH:
                    System.out.println("�ƽ�");
                    break;
            }

        }
    }
}
