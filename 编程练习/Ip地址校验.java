/**
 * @program: HH_STUDY
 * @description:��дһ��������֤һ��IP��ַ�ĸ�ʽ�Ƿ���ȷ����ȷ����true������ȷ����false
 * ���õ�String������
 * 1.charAt(int index):��ȡָ�����������ַ�
 * 2.indexOf(String str):��ȡstr���ַ��������е�һ�γ��ֵ�����
 * 3.substring(int start):��start��ʼ��ȡ�ַ���
 * .......
 * @author: qiu haoran
 * @create: 2020-07-18 23:03
 */
public class Ip��ַУ�� {
    //IP��ַ��4���ֹ��ɣ���a.b.c.d��ÿ��������0~255������
    public boolean ipjy(String ip){
        String [] ipstr=ip.split("\\.");
        int len=ipstr.length;
        if(len!=4)
            return  false;
        while(len>0){
//            Stringת��ΪInt
            len--;
            try {
               int temp=Integer.parseInt(ipstr[len]);
               if(!(0<=temp&&temp<=255))
                   return false;
            }catch (NumberFormatException e){
                //��web�б���ʹ�ø÷������ᵼ���ڴ����
                e.printStackTrace();
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Ip��ַУ�� ip= new  Ip��ַУ��();
        if(ip.ipjy("a.b.12.2"))
            System.out.println("true");
        else{
            System.out.println("false");
        }
    }

    public void StrDemo(){
        String str="�л���Ϊ123abc";
//       1.charAt(int index):��ȡָ�����������ַ�
        char s=str.charAt(2);
//       2.int indexOf(String str, int fromIndex): ���ش� fromIndex λ�ÿ�ʼ����ָ���ַ����ַ����е�һ�γ��ִ���������������ַ�����û���������ַ����򷵻� -1��
        int  i=str.indexOf('��');
//       3.String substring(int start,int end):��start��ʼ����end������ȡ�ַ���������start��������end
        String s3=str.substring(0,4);
//       4.toCharArray():���ַ���ת��Ϊ�ַ�����
        char [] s4=str.toCharArray();
//       5.��Сд�ַ���ת��
        String s5=str.toLowerCase();
        s5.toUpperCase();
//       6.split():ȥ���ַ�����ָ���ĵ��ַ���Ȼ�󷵻�һ���µ��ַ���
        String [] s6=str.split("//.");
        s6=str.split("//.|,",3);//�������3,.�ͣ������ָ���
//       7.replace(char oldChar, char newChar)����ָ���ַ��滻����һ��ָ�����ַ�
        String s7=str.replace('a','b');
//       8.contains(CharSequence s)���鿴�ַ������Ƕ�����ָ���ַ�
        String s8="�л�";
        boolean flag8=str.contains(s8);
//       9.concat(String str)����ԭ�е��ַ����Ļ����ϼ���ָ���ַ���
        String s9=str.concat("111");
        s9=s9+"222";
    }

}
