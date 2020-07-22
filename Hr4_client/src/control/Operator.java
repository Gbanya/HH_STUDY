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
	 * 模式
	 * 把传过来的book放到Protocol中编写协议
	 * 把得到的协议通过Client里的sendMessageToSever方法把协议（字符串）发送到服务器
	 * 把服务器返回的协议（也是字符串）parser 解析 解析后返回ReturnResult类型结果
	 * 把结果在返回给界面输出
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
