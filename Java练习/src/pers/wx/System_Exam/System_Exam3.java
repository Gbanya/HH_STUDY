/*���� Java��Ŀ2020��3��26��*/
package pers.wx.System_Exam;

public class System_Exam3 {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		//��ʾʹ��������
	  	byte b[]=new byte[512]; //�趨���뻺����Ϊ512Byte
	  	//ʹ��������ʱ��������쳣��׽
	    System.out.println("�����벻����512B���ַ��������س���������");
	  	try{
	  	    int i=0;
	  	    //�ӱ�׼in�豸�������ݵ�ָ�������� 
	  	    //����ֵiΪ������ֽڸ�����ע�⣺�س���Ҳռ��2���ֽ�
	  	    //���������ֽڸ������ڻ��������ȣ��򳬳����ֲ��ᱻ���ա�
	  	    i=System.in.read(b);

	  	    String s=new String(b,0,i); //�ѻ����������������ת��Ϊ�ַ���
	  	    System.out.println("������ "+i+" ���ֽڵ��ַ���");	
	  	    System.out.println("�����: "+s);	
	        
	        /*����System.in���java����׼����������InputStream�����
	        ��java������Զ��Ѵ򿪲���׼�������������ݡ�
	        ��������Ҳ���ص���close()�������رա�
	        */

	  	   }
	  	 catch(Exception e) 
	  	   {
	  	   	//InputStream���read()�������׳�IOException���쳣
	  	   	//IOException����java.io���ж��壬IOException��ֱ�Ӽ̳���Exception��
	  	   	System.out.print("�������");	
	  	   }

	}

}
