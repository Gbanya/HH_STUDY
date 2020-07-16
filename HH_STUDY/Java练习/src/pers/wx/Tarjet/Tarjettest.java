package pers.wx.Tarjet;

import java.io.File;
import java.io.FileOutputStream;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.TargetDataLine;
 
public class Tarjettest{
	private static FileOutputStream os;
	/*
	 * //������ private static float RATE = 44100f; //�����ʽPCM private static
	 * AudioFormat.Encoding ENCODING = AudioFormat.Encoding.PCM_SIGNED; //֡��С 16
	 * private static int SAMPLE_SIZE = 16; //�Ƿ��� private static boolean BIG_ENDIAN
	 * = true; //ͨ���� private static int CHANNELS = 2;
	 */
 
	public static void main(String[] args) throws Exception{
		if(args.length<1) {
			save("G:/Tarjettest/123.pcm");
		}else {
			save(args[0]);
		}
	}
 
	public static void save(String path) throws Exception {
		File file = new File(path);
		
		if(file.isDirectory()) {
			if(!file.exists()) {
				file.mkdirs();
			}
			file.createNewFile();
		}
		
		AudioFormat audioFormat =
//              new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 44100F,
//              8, 1, 1, 44100F, false);
       new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,48000F, 16, 2, 4,
       44100F, true);//�з�������PCM���룬ÿ������ֵ16bit���룬44.1KHz����Ƶ�ʣ�˫������ÿ֡4�ֽڣ�������������ÿ����2�ֽڣ���ÿ��֡��44100���ɲ����ʶ��ã���ָʾ�Ƿ��� big-endian (������ǰ)�ֽ�˳��洢���������е����ݣ�false ��ζ�� little-endian��С����ǰ������
		TargetDataLine targetDataLine = AudioSystem.getTargetDataLine(audioFormat);
		targetDataLine.open(audioFormat);       
		targetDataLine.start();
		
		final int bufSize=4*2048; //2048��������
		System.out.println("������=44100Hz��˫������16bit����PCM��ÿ����ÿ֡"+bufSize/4+"�������㣨"+(bufSize/4.0/44100)+"s��");
		byte[] buffer = new byte[bufSize];
		int flag = 0;
		os = new FileOutputStream(file);
		while((flag = targetDataLine.read(buffer, 0, buffer.length))>0) {//�������вɼ�����
			os.write(buffer);
			System.out.println(flag);
		}
	}
}