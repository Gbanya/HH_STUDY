import model.Resume;
import util.Protocol;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class HRClient {

    private String host;
    private int port;
    private Socket socket;

    private final Protocol protocol;

    private final int MAX_BUFFERED_SIZE = 1024;

    private Scanner scanner;

    public HRClient(String host, int port) {
        this.host = host;
        this.port = port;
        this.protocol = new Protocol();
        this.scanner = new Scanner(System.in);

    }

    private void connect() throws IOException {
        this.socket = new Socket(host, port);
        System.out.println("Socket connection created at " + port);
    }

    private void sendMessage(String message) throws IOException {
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(message.getBytes());
        System.out.println("Message sent to server: " + message);
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[MAX_BUFFERED_SIZE];
        inputStream.read(bytes);
        String receipt = new String(bytes);
        System.out.println("Response from server: " + receipt);
        printIndex();
    }

    private void chooseOperation() throws IOException {
        printIndex();
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            if ("1".equals(input)) {
                System.out.println("�������ѡ������");
                String name = scanner.nextLine();
                System.out.println("�������ѡ�����֤��");
                String id = scanner.nextLine();
                System.out.println("�������ѡ��ѧУ");
                String school = scanner.nextLine();
                Resume resume = new Resume(name, id, school);
                String operation = protocol.add(resume);
                sendMessage(operation);
            } else if ("2".equals(input)) {
                System.out.println("�������ѡ������");
                String name = scanner.nextLine();
                Resume resume = new Resume(name);
                String operation = protocol.query(resume);
                sendMessage(operation);
            } else if ("3".equals(input)) {
                System.out.println("�������ѡ������");
                String name = scanner.nextLine();
                System.out.println("�������ѡ�����֤��");
                String id = scanner.nextLine();
                System.out.println("�������ѡ��ѧУ");
                String school = scanner.nextLine();
                Resume resume = new Resume(name, id, school);
                String operation = protocol.update(resume);
                sendMessage(operation);
            } else if ("4".equals(input)) {
                System.out.println("�������ѡ������");
                String name = scanner.nextLine();
                Resume resume = new Resume(name);
                String operation = protocol.delete(resume);
                sendMessage(operation);
            } else if ("5".equals(input)) {
                String operation = protocol.queryAll();
                sendMessage(operation);
            } else if ("6".equals(input)) {
                System.out.println("��лʹ�ã��ټ�");
                closeClient();
                break;
            } else {
                System.out.println("�����������������1��6");
            }
        }
    }

    private void closeClient() throws IOException {
        socket.close();
        scanner.close();
    }

    private void printIndex() {
        System.out.println("��ӭ����HRSYS����ϵͳC/S��\n��ѡ����Ĳ����������س���ȷ��");
        System.out.println("1.��Ӽ���");
        System.out.println("2.��ѯ����");
        System.out.println("3.���¼�����Ϣ");
        System.out.println("4.ɾ������");
        System.out.println("5.������м���");
        System.out.println("6.�˳�");
    }


    public static void main(String[] args) {
        HRClient client = new HRClient("127.0.0.1", 9001);
        try {
            client.connect();
            client.chooseOperation();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
