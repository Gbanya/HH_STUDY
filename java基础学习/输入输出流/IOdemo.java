package ���������;

import java.io.*;

public class IOdemo {
//+++++++++++++++++�ֽ���++++++++++++++++++++++
    //-----------------InputStream(���ļ�������������ڴ�д��)-------------------------
    private static void showContent(String path) throws IOException, IOException {
        // ����
        FileInputStream fis = new FileInputStream(path);

        int len;
        while ((len = fis.read()) != -1) {
            System.out.print((char) len);
        }
        // ʹ����ر���
        fis.close();
    }

    private static void showContent2(String path) throws IOException {
        // ����
        FileInputStream fis = new FileInputStream(path);

        // ͨ������ȡ����
        byte[] byt = new byte[1024];
        int len = fis.read(byt);//
        for (int i = 0; i <len; i++) {
            System.out.print(byt[i]);
     }
        // ʹ����ر���
        fis.close();
    }
    //-----------------OutputStream(д��)-------------------------
    //    * 1. ������
    //    * 2��д����
    //    * 3���ر���
    private static void writeTxtFile(String path) throws IOException {
        // 1�����ļ������������Ŀ�ĵ���ָ�����ļ�
        FileOutputStream fos = new FileOutputStream(path,true);

        // 2��ͨ�������ļ�д����
        byte[] byt = "hello world:this is a hr demo".getBytes();//�˴��ɶ�����뷽ʽeg:"UTF-8"
        fos.write(byt);

        // 3:��������ر���
        fos.close();
    }
    //-----------------������-------------------------
    //ʵ���ļ�����
    public static void copyFile(String srcPath, String destPath)
            throws IOException {
        // ���������������
        FileInputStream fis = new FileInputStream(srcPath);
        FileOutputStream fos = new FileOutputStream(destPath);

        // ʹ�û�����,���ٶ�Ӳ�̵Ķ�ȡ���������Ͷ�Ӳ�̵����
        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        // ��ȡ��д����Ϣ
        int len = 0;

        while ((len = bis.read()) != -1) {
            bos.write(len);
        }

        // �ر���
        bis.close();
        bos.close();
    }
//+++++++++++++++++�ַ���++++++++++++++++++++++
    //�ַ����ĳ�����ࣺReader �� Writer
    //FileReader���ļ�
    public static void readFileDemo(String path) throws Exception {
        Reader reader = new FileReader(path);
        int len = 0;
        while ((len = reader.read()) != -1) {
            System.out.print((char) len);
        }
        reader.close();
    }

    public static void writeFileDemo(String path) throws Exception {
        Writer writer = new FileWriter(path);
        String txt="�ַ���д�����";
        writer.write(txt);//��дstring,char,char[]����
        writer.close();
    }

    public static void bufferwriteFileDemo(String path) throws Exception {
        Writer writer = new FileWriter(path);
        //��װ������
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        String txt="�����ַ���д�����";
        bufferedWriter.write(txt);//��дstring,char,char[]����
        bufferedWriter.close();
    }
    //�����ܽ�
    //1.Unicodeȫ����ÿ����ͬ���ԵĲ�ͬ�ַ���ͳһ����,����2��16�η����ַ��ռ�
    //2.�ֽ�����ascall����2��8�η����룬��Ҫ��Ӧ������ĸ�����ֵ�
    //3.UTF-16��UTF-8�����Unicode����Ĳ�ͬ��ȡ��ʽ��UTF-8��ͨ�����루��ͷ�����ֵ��ֽںͶ��ֽڱ���
    public IOdemo(){
    }

    public static void main(String[] args) throws Exception {
        String path="C:\\HH_STUDY\\HH_STUDY\\java����ѧϰ\\���������\\test";
        bufferwriteFileDemo(path);
    }
}
