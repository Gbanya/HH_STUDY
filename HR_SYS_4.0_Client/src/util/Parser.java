package util;

import model.Resume;
import model.ResumeList;
import model.ReturnResult;

public class Parser 
{
	/**���ԡ�/n�������õ��Ƿ�ɹ��ͳɹ��������ʧ��ԭ��
	 * ���ʧ�� returnResult.isSuccess=false returnResult.failReasonΪ�����ĵڶ�����
	 * �ɹ���returnResult.isSuccess=true
	 * ���ԡ�;������������
	 * ���ԡ���������ÿ������������Էֱ𸳸�Book�浽BookList
	 * �ٰ�BookList�ŵ�returnResult.resultData��
	 * ����returnResult
	 * */
	public ReturnResult parserAdd(String message)
	{
		ReturnResult returnResult = new ReturnResult();
		String[] amessage=message.split("/n");
		if(amessage[0].equals("Success"))
		{
			returnResult.isSuccess = true;
		}
		else
		{
			returnResult.failReason=amessage[1];
		}
		return returnResult;
	}

}