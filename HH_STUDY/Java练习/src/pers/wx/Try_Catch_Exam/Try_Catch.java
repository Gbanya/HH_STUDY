/*���� Java��Ŀ2020��3��27��*/
package pers.wx.Try_Catch_Exam;

public class Try_Catch {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		System.out.println("�쳣��׽�����ӣ�");
	    System.out.println("��ֱ�����������ݣ�");
	    System.out.println("1���������в���");
	    System.out.println("2�������в���Ϊ0");
	    System.out.println("3�������в���Ϊһ�����ܱ�ʾ�������ַ���");
	    System.out.println("4�������в���Ϊһ����ʾ�������ַ���������5");
	    System.out.println("5�������в���Ϊ100");
	    System.out.println("6�������в���Ϊ-100");
	    System.out.println("*******************************************\n");
	    
	    Try_Catch t=new Try_Catch();
	    int i=t.my_test(args);
	    System.out.println("**************************");
	    System.out.println("��������ֵΪ��"+i);
	  }
	  
	  //�������в��� String args[] ���ݹ���
	  public int my_test(String args[])
	  {  
	    int a,b,c;
	    try
	    {
	    	a=100;
	    	
	    	//���ַ���ת��Ϊintֵ���˴��п��ܷ��������±�Խ���쳣
	    	//�����ܷ�����ֵת���쳣
	    	b=Integer.parseInt(args[0]);
	    	c=a/b;    //���������㣬�˴����ܷ������������쳣
	    	System.out.println("c=a/b="+c);
	    	
	    	//����˴�ִ����return��䣬��try-catch-finally���֮���������䲻�ᱻִ�У���finally�����Ȼ�ᱻִ�С�
	    	if(b==100) return -1;
	    	
	    	//����˴���ֹ��JVM����˺��������䣬����finally��䡢main()�����е�������䶼���ᱻִ����
	    	if(b==-100) System.exit(0);	
	    	
	    }
	    catch(ArrayIndexOutOfBoundsException e)
	    {
	    	//��׽�������±�Խ���쳣
	    	System.out.println("��׽�������±�Խ���쳣");
	    	e.printStackTrace(); //����쳣��Դ
	    	return 1;
	    }
	    catch(ArithmeticException e)
	    {
	    	//��׽�����������쳣
	    	System.out.println("��׽�����������쳣");
	    	e.printStackTrace(); //����쳣��Դ
	    	return 2;
	    }
	    catch(NumberFormatException e)
	    {
	    	//��׽����ֵת���쳣
	    	System.out.println("��׽����ֵת���쳣");
	    	e.printStackTrace(); //����쳣��Դ
	    	return 3;
	    }
	    finally
	    {
	    	System.out.println("finallyģ�����ǻᱻִ�С�");
	    }
	    
	    System.out.println("������try-catch-finaly���֮�����䡣");
	    return 0;
	  }  
}
