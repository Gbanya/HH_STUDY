/*���� Java��Ŀ2020��3��27��*/
package pers.wx.Throw_Exam;

public class Throw2 {
	
	public void abs(int a,int b) throws Exception
    { if(a<b)  throw new Exception("���׳����쳣��b��a��");
      System.out.println("a��b��");
    }

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Throw2 my_test=new Throw2();
	      int a=3,b=10;
	      try 
	        {
	        	my_test.abs(a,b);
	        }
	      catch(Exception e)  //�쳣��׽ 
	        { 
	          System.out.println(e.toString( ));
	        }
	      

	}

}
