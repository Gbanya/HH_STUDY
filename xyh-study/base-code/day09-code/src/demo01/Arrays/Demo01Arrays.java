package demo01.Arrays;

import java.util.Arrays;

/*
java.util.Arrays��һ����������صĹ����࣬�����ṩ�˴�����̬����������ʵ�����鳣���Ĳ���
1.public static String toString(����)���������������ַ���������Ĭ�ϸ�ʽ��[Ԫ��1��Ԫ��2��Ԫ��3...]��
2.public static void sort(����):����Ĭ�����򣨴�С���󣩶������Ԫ�ؽ�������

ע��
1.�������ֵ��sortĬ�ϰ��������С����
2.������ַ�����sortĬ�ϰ�����ĸ����
3.������Զ�������ͣ���ô�Զ��������ҪComparable����Comparator�ӿڵ�֧�֡�
* */
public class Demo01Arrays {
    public static void main(String[] args) {
        int[] intArray={10,20,30};
        String intStr= Arrays.toString(intArray);
        String str="[10, 20, 30]";
        System.out.println(intStr);
        System.out.println(str);

        int[] array1={1,3,5,0,9,8,4};
        Arrays.sort(array1);
        System.out.println(Arrays.toString(array1));
        String[] array2={"aaa","ccc","bbb"};
        Arrays.sort(array2);
        System.out.println(Arrays.toString(array2));
    }
}
