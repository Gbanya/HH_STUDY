package control;

import model.Book;
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

	public ReturnResult addBook(Book book)
	{
		Protocol protocol = new Protocol();
		String message = protocol.AddBookMessage(book);
		String returnMessage = client.sendMessageToSever(message);
		Parser parser = new Parser();
		ReturnResult returnResult = parser.parserAdd(returnMessage);
		return returnResult;
	}
	public ReturnResult deleteBookByName(Book book)
	{
		Protocol protocol = new Protocol();
		String message = protocol.deleteBookByNameMessage(book);
		String returnMessage = client.sendMessageToSever(message);
		Parser parser = new Parser();
		ReturnResult returnResult = parser.parserDelete(returnMessage);
		return returnResult;
	}
	public ReturnResult deleteBookByAuthor(Book book)
	{
		Protocol protocol = new Protocol();
		String message = protocol.deleteBookByAuthorMessage(book);
		String returnMessage = client.sendMessageToSever(message);
		Parser parser = new Parser();
		ReturnResult returnResult = parser.parserDelete(returnMessage);
		return returnResult;
	}
	public ReturnResult changeBook(Book book,Book oldBook)
	{
		Protocol protocol = new Protocol();
		String message = protocol.changeBookMessage(book,oldBook);
		String returnMessage = client.sendMessageToSever(message);
		Parser parser = new Parser();
		ReturnResult returnResult = parser.parserDelete(returnMessage);
		return returnResult;
	}
	public ReturnResult searchByName(Book book)
	{
		Protocol protocol = new Protocol();
		String message = protocol.searchBookByNameMessage(book);
		String returnMessage = client.sendMessageToSever(message);
		Parser parser = new Parser();
		ReturnResult returnResult = parser.parserSearch(returnMessage);
		return returnResult;
	}
	public ReturnResult searchByAuthor(Book book)
	{
		Protocol protocol = new Protocol();
		String message = protocol.searchBookByAuthorMessage(book);
		String returnMessage = client.sendMessageToSever(message);
		Parser parser = new Parser();
		ReturnResult returnResult = parser.parserSearch(returnMessage);
		return returnResult;
	}
	public ReturnResult searchByPrice(Book book)
	{
		Protocol protocol = new Protocol();
		String message = protocol.searchBookByPriceMessage(book);
		String returnMessage = client.sendMessageToSever(message);
		Parser parser = new Parser();
		ReturnResult returnResult = parser.parserSearch(returnMessage);
		return returnResult;
	}
	public ReturnResult searchByKeyWord(Book book)
	{
		Protocol protocol = new Protocol();
		String message = protocol.searchBookByKeyWordMessage(book);
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
