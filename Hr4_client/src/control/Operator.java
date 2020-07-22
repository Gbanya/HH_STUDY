package control;

import model.Resume;
import model.ReturnResult;
import net.Client;
import util.Parser;
import util.Protocol;

public class Operator {
	Client client=Client.getClient();
	public Operator(){
		if (client == null)
			client = new Client();

	}
	/*
	 * ģʽ
	 * �Ѵ�������book�ŵ�Protocol�б�дЭ��
	 * �ѵõ���Э��ͨ��Client���sendMessageToSever������Э�飨�ַ��������͵�������
	 * �ѷ��������ص�Э�飨Ҳ���ַ�����parser ���� �����󷵻�ReturnResult���ͽ��
	 * �ѽ���ڷ��ظ��������
	 * */

	public ReturnResult addBook(Resume Resume)
	{
		Protocol protocol = new Protocol();
		String message = protocol.AddBookMessage(Resume);
		String returnMessage = client.sendMessageToSever(message);
		Parser parser = new Parser();
		ReturnResult returnResult = parser.parserAdd(returnMessage);
		return returnResult;
	}
	public ReturnResult deleteBookByName(Resume Resume)
	{
		Protocol protocol = new Protocol();
		String message = protocol.deleteBookByNameMessage(Resume);
		String returnMessage = client.sendMessageToSever(message);
		Parser parser = new Parser();
		ReturnResult returnResult = parser.parserDelete(returnMessage);
		return returnResult;
	}

	public ReturnResult changeBook(Resume Resume,Resume oldBook)
	{
		Protocol protocol = new Protocol();
		String message = protocol.changeBookMessage(Resume,oldBook);
		String returnMessage = client.sendMessageToSever(message);
		Parser parser = new Parser();
		ReturnResult returnResult = parser.parserDelete(returnMessage);
		return returnResult;
	}
	public ReturnResult searchByName(Resume Resume)
	{
		Protocol protocol = new Protocol();
		String message = protocol.searchBookByNameMessage(Resume);
		String returnMessage = client.sendMessageToSever(message);
		Parser parser = new Parser();
		ReturnResult returnResult = parser.parserSearch(returnMessage);
		return returnResult;
	}
	public ReturnResult searchById(Resume Resume)
	{
		Protocol protocol = new Protocol();
		String message = protocol.searchBookByIdMessage(Resume);
		String returnMessage = client.sendMessageToSever(message);
		Parser parser = new Parser();
		ReturnResult returnResult = parser.parserSearch(returnMessage);
		return returnResult;
	}
	public ReturnResult searchBySchool(Resume Resume)
	{
		Protocol protocol = new Protocol();
		String message = protocol.searchBookBySchoolMessage(Resume);
		String returnMessage = client.sendMessageToSever(message);
		Parser parser = new Parser();
		ReturnResult returnResult = parser.parserSearch(returnMessage);
		return returnResult;
	}
	public ReturnResult searchByKeyWord(Resume Resume)
	{
		Protocol protocol = new Protocol();
		String message = protocol.searchBookByKeyWordMessage(Resume);
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
