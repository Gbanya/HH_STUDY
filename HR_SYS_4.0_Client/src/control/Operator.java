package control;

import model.Resume;
import model.ReturnResult;
import net.Client;
import util.Parser;
import util.Protocol;

public class Operator {
	Client client=Client.getClient();
	public Operator(){
//		if (client == null)
//			client = new Client();
		
	} 
	/*
	 * ģʽ
	 * �Ѵ�������book�ŵ�Protocol�б�дЭ��
	 * �ѵõ���Э��ͨ��Client���sendMessageToSever������Э�飨�ַ��������͵�������
	 * �ѷ��������ص�Э�飨Ҳ���ַ�����parser ���� �����󷵻�ReturnResult���ͽ��
	 * �ѽ���ڷ��ظ��������
	 * */

	public ReturnResult addResume(Resume resume)
	{
		Protocol protocol = new Protocol();
		String message = protocol.AddResumeMessage(resume);
		String returnMessage = client.sendMessageToSever(message);
		Parser parser = new Parser();
		ReturnResult returnResult = parser.parserAdd(returnMessage);
		return returnResult;
	}

}
