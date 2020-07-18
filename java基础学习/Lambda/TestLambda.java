package Lambda;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import Lambda.Hero;
//�ѷ�����Ϊ�������д��ݵı��˼��
public class TestLambda {
    static Integer flag=0;//������ʾ����������
    public static void main(String[] args) {
        Random r = new Random();
        List<Hero> heros = new ArrayList<Hero>();
        //�������hero�������list
        for (int i = 0; i < 10; i++) {
            heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
        }
        System.out.println("��ʼ����ļ��ϣ�");
        System.out.println(heros);
        //0:ֱ�ӷ���ɸѡ��1��������ɸѡ��2lambdaɸѡ
        switch(flag){
            case 0:
                System.out.println("ɸѡ�� hp>100 && damange<50��Ӣ��");
                filter(heros);
            case 1:
                System.out.println("ʹ��������ķ�ʽ��ɸѡ�� hp>100 && damange<50��Ӣ��");
                //������ʵ�ֽӿڣ�ĳ���ֲ���ֻ��Ҫ��һ�Σ���ô�Ϳ���ʹ�������ڲ���
                HeroChecker checker = new HeroChecker() {
                    @Override
                    //ʵ��test����
                    public boolean test(Hero h) {
                        return (h.hp>100 && h.damage<50);
                    }
                };
                filter(heros,checker);
            case 2:
                //����Ӧ�ã���������ڲ���
                System.out.println("ʹ��Lamdba�ķ�ʽ��ɸѡ�� hp>100 && damange<50��Ӣ��");
                filter(heros,h->h.hp>100 && h.damage<50);
        }
    }
    //ѭ���ж��Ƿ���������
    private static void filter(List<Hero> heros) {
        for (Hero hero : heros) {
            if(hero.hp>100 && hero.damage<50)
                System.out.print(hero);
        }
    }
    private static void filter(List<Hero> heros,HeroChecker checker) {
        for (Hero hero : heros) {
            if(checker.test(hero))
                System.out.print(hero);
        }
    }
}