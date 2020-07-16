package pers.wx.MD5;
import java.security.MessageDigest;
public class MD5test {
	//����MD5�࣬
	//�����ṩһ�� hexMD5() �������ڼ��������ַ�����MD5ֵ

	  private String[] hexDigits = { 
	      "0", "1", "2", "3", "4", "5", "6", "7", 
	      "8", "9", "a", "b", "c", "d", "e", "f"}; 

	  /** 
	   * ת���ֽ�����Ϊ16�����ִ� 
	   * @param b �ֽ����� 
	   * @return 16�����ִ� 
	   */ 

	  public String byteArrayToHexString(byte[] b) { 
	    StringBuffer resultSb = new StringBuffer(); 
	    for (int i = 0; i < b.length; i++) { 
	      resultSb.append(byteToHexString(b[i])); 
	    } 
	    return resultSb.toString(); 
	  } 

	  private String byteToHexString(byte b) { 
	    int n = b; 
	    if (n < 0) 
	      n = 256 + n; 
	    int d1 = n / 16; 
	    int d2 = n % 16; 
	    return hexDigits[d1] + hexDigits[d2]; 
	  } 

	  public String hexMD5(String origin) { 
	    String resultString = null; 

	    try { 
	      resultString=new String(origin); 
	      MessageDigest md = MessageDigest.getInstance("MD5"); 
	      resultString=byteArrayToHexString(md.digest(resultString.getBytes())); 
	    } 
	    catch (Exception ex) { 

	    } 
	    return resultString; 
	  } 


	/*
	 * public static void main(String[] args) { // TODO �Զ����ɵķ������ MD5test MD5=new
	 * MD5test(); String a="!"; String result=MD5.hexMD5(a);
	 * System.out.println("\rMD5:"+result); }
	 */

}
