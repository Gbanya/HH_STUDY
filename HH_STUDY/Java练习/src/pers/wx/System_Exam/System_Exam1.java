/*���� Java��Ŀ2020��3��26��*/
package pers.wx.System_Exam;

public class System_Exam1 {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
			String str;
		   
		   //Java����ʱ�����汾
		   str=System.getProperty("java.version");
		   System.out.println("����ʱ�����汾��"+str);

		   //Java�����ʵ�ֵİ汾
		   str=System.getProperty("java.vm.version");
		   System.out.println("Java�����ʵ�ֵİ汾��"+str);

		   //Java���·��
		   str=System.getProperty("java.class.path");
		   System.out.println("Java���·����"+str);
		   
		   //����ϵͳ�汾
		   str=System.getProperty("os.version");
		   System.out.println("����ϵͳ�汾��"+str);

		   //��ǰ��¼����ϵͳ���û���
		   str=System.getProperty("user.name");
		   System.out.println("��ǰ��¼����ϵͳ���û�����"+str);

		   //�û���ǰ·��
		   str=System.getProperty("user.dir");
		   System.out.println("�û���ǰ·����"+str);
		   
		   //�û�HOME·��
		   str=System.getProperty("user.home");
		   System.out.println("�û�HOME·����"+str);  

	}

}
