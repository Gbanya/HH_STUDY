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
	public ReturnResult deleteResume(Resume resume)
	{
		Protocol protocol = new Protocol();
		String message = protocol.deleteResumeMessage(resume);
		String returnMessage = client.sendMessageToSever(message);
		Parser parser = new Parser();
		ReturnResult returnResult = parser.parserDelete(returnMessage);
		return returnResult;
	}

	public ReturnResult updateResume(Resume resume)
	{
		Protocol protocol = new Protocol();
		String message = protocol.updateResumeMessage(resume);
		String returnMessage = client.sendMessageToSever(message);
		Parser parser = new Parser();
		ReturnResult returnResult = parser.parserUpdate(returnMessage);
		return returnResult;
	}
	public ReturnResult searchByName(Resume resume)
	{
		Protocol protocol = new Protocol();
		String message = protocol.searchResumeByNameMessage(resume);
		String returnMessage = client.sendMessageToSever(message);
		Parser parser = new Parser();
		ReturnResult returnResult = parser.parserSearch(returnMessage);
		return returnResult;
	}
	public ReturnResult searchById(Resume resume)
	{
		Protocol protocol = new Protocol();
		String message = protocol.searchResumeByIdMessage(resume);
		String returnMessage = client.sendMessageToSever(message);
		Parser parser = new Parser();
		ReturnResult returnResult = parser.parserSearch(returnMessage);
		return returnResult;
	}
	public ReturnResult searchBySchool(Resume resume)
	{
		Protocol protocol = new Protocol();
		String message = protocol.searchResumeBySchoolMessage(resume);
		String returnMessage = client.sendMessageToSever(message);
		Parser parser = new Parser();
		ReturnResult returnResult = parser.parserSearch(returnMessage);
		return returnResult;
	}
	public ReturnResult searchByProcess(Resume resume)
	{
		Protocol protocol = new Protocol();
		String message = protocol.searchResumeByProcessMessage(resume);
		String returnMessage = client.sendMessageToSever(message);
		Parser parser = new Parser();
		ReturnResult returnResult = parser.parserSearch(returnMessage);
		return returnResult;
	}
	public ReturnResult searchByKey(Resume resume)
	{
		Protocol protocol = new Protocol();
		String message = protocol.searchResumeByKeyMessage(resume);
		String returnMessage = client.sendMessageToSever(message);
		Parser parser = new Parser();
		ReturnResult returnResult = parser.parserSearch(returnMessage);
		return returnResult;
	}
	public void Closenet(String str)
	{
		String returnMessage=client.sendMessageToSever(str);
		client.closeClient();
	}

}
