/*���� Java��Ŀ2020��3��27��*/
package pers.wx.Throw_Exam;

class �Զ����쳣�� extends Exception
{
  String msg;
  public 	�Զ����쳣��() //���췽��
  {
    this.msg="";	
  }
  public 	�Զ����쳣��(String s)  //���췽��
  {
    this.msg=s;	
  }
	public String toString()  //������д
	{
		return super.toString()+"��"+this.msg;
	}
}

public class ExtendsException {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		int a=3;
    	int x;
    	�Զ����쳣�� my_e=new �Զ����쳣��("��ֵС��100");
      try 
        {
        	if(a<100) throw my_e;  //�Զ����쳣��ֻ������Ϊ�ж��Ƿ��׳��쳣�������
        	x=a/0;
        }
      catch(�Զ����쳣�� e)  //��׽���Զ����쳣�ࡱ�쳣
        { 
          System.out.println("��׽�����Զ����쳣�ࡱ�쳣");
          e.printStackTrace(); //����쳣��Դ
        }  
      catch(ArithmeticException e)  //��׽���������쳣
        {
    	    System.out.println("��׽�����������쳣");
    	    e.printStackTrace(); //����쳣��Դ
        }     

	}

}
