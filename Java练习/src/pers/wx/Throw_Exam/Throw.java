/*���� Java��Ŀ2020��3��27��*/
package pers.wx.Throw_Exam;

public class Throw {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		 int a=10,b=55,x;    //��b����5���򲻻��׳�������ִ��catch����
		    try
		    
		{   //�ڱ�Ҫʱ����ʹ��throw�����ʾ���׳�һ����Ϊ�жϵ��쳣�������ǿ�ϵͳ�Զ��׳��쳣
		    	   if(a<b)  throw new Exception("���׳����쳣��b��a��");
		    	   x=a-b;
		    
		}
		    catch(Exception e)
		    
		{  //�쳣��׽
		    	  x=b-a;
		    	  System.out.println(e.toString( ));
		    
		}
		    System.out.println(x);
		  }

}
