/**
 * 
 */
package pers.wx.chengfabiao;

/**
 * @author Administrator
 *
 */
public class Table {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		//���㲢����žų˷���Ҫ���ظ��Ĳ���ֻ����һ����
	  	/*
	  	���˼�룺�ò�����Ķ�ά���������棬
	  	�Ա��Լ�ڴ�ռ䡣
	  	*/
	  	final int N=9;
	    int a[][]=new int[N][];  //�����ά���飬��ָ����һά��9��Ԫ��
	    int i,j;
	    
	  	for(i=0;i<N;i++)
	  	  a[i]=new int[i+1];  //�����ά����ά������ģ���ڶ�ά�ĳ��ȸ�����ͬ��
	  	
	  	for(i=0;i<N;i++)  
	  	{
	  		for(j=0;j<=i;j++) a[i][j]=(i+1)*(j+1); //���㲢����˷���
	  	}

	  	for(i=0;i<N;i++)
	  	{
	  		for(j=0;j<=i;j++)
	  		  System.out.print(" "+a[i][j]);
	  		System.out.println();  //�˷����ÿ�������Ϻ��������
	  	}

	}

}
