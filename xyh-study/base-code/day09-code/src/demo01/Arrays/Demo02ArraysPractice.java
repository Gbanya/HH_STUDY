package demo01.Arrays;

import java.util.Arrays;

/*ʹ��Arrays��ص�API����һ������ַ����������ַ��������У��������ӡ*/
public class Demo02ArraysPractice {
    public static void main(String[] args) {
        String str="asv76agfqwdfvasdfvjh";
        char[] chars=str.toCharArray();
        //�����������������
        Arrays.sort(chars);
        for (int i = chars.length-1; i >=0; i--) {
            System.out.print(chars[i]);
        }
    }
}
