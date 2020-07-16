import concurrent.SocketThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ������������
 */
public class HRServer {

    private int port;

    ThreadPoolExecutor executor;

    public HRServer(int port) {
        this.port = port;
    }

    /**
     * ��������ʼ�����̳߳أ������߳���Ϊ5������߳���Ϊ10��������г���Ϊ5
     * Todo ���ڸ���ʵ����������ȷ���̳߳ش�С����ͨ�������ļ�������������
     *
     * ���ϼ���Ƿ����µ�tcp���ӣ�
     * ��{Դip��Դ�˿ڣ�Ŀ��ip��Ŀ�Ķ˿�}ȷ���Ƿ�Ϊ�µ�tcp����
     * Ϊ�µ�socket���ӷ����̳߳���Դ
     */
    private void run() {
        executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(5));
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server has started at " + port);
            while (true) {
                Socket socket = server.accept();
                SocketThread socketThread = new SocketThread(socket);
                executor.execute(socketThread);
                System.out.println("New thread has been created, thread id is " + socketThread.getId());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        HRServer server = new HRServer(9001);
        server.run();
    }
}
