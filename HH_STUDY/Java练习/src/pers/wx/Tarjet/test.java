package pers.wx.Tarjet;
import java.io.*;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.TargetDataLine;

public class test {
	
		static volatile boolean stop = false;
		 
		public static void main(String[] args) {
			Play();
		}
	 
		// ������Ƶ�ļ�
		public static void Play() {
	 
			try {
				AudioFormat audioFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 44100F, 16, 2, 4, 44100F, true);
	 
				DataLine.Info info = new DataLine.Info(TargetDataLine.class, audioFormat);
	 
				TargetDataLine targetDataLine = (TargetDataLine) AudioSystem.getLine(info);
				targetDataLine.open(audioFormat);
	 
				final SourceDataLine sourceDataLine;
				info = new DataLine.Info(SourceDataLine.class, audioFormat);
	 
				sourceDataLine = (SourceDataLine) AudioSystem.getLine(info);
				sourceDataLine.open(audioFormat);
	 
				targetDataLine.start();
				sourceDataLine.start();
	 
				//�ط���Ƶʱ��������ǿ����
	            //FloatControl fc=(FloatControl)sourceDataLine.getControl(FloatControl.Type.MASTER_GAIN); 
	            //double value=2; //ԭ��������2��
	            //double value=0.5; //ԭ��������һ��
	            //0.0001����Ϊ -80dB
	            //float dB = (float)
	                  //(Math.log(value==0.0?0.0001:value)/Math.log(10.0)*20.0);
	            //fc.setValue(dB); //��dBΪ��λ�����趨�����Ϊ2����6.0206dB������СΪ0����������ЧΪ�����ţ�
	            
				int nByte = 0;
				final int bufSize=4*2048; //2048��������
	            System.out.println("������=44100Hz��˫������16bit����PCM��ÿ����ÿ֡"+bufSize/4+"�������㣨"+(bufSize/4.0/44100)+"s����������ǿ="+"dB");
				byte[] buffer = new byte[bufSize];
				long ncount=0; //����
				while (nByte != -1) {
					ncount++;
	                nByte = targetDataLine.read(buffer, 0, bufSize);
	                System.out.print("\r��"+ncount+"�δ���Ƶ��һ�ζ��� Byte="+nByte+" �ֽ�");
	                for(int n=0;n<=8191;n++)
	                {	           
	                	if(Math.abs(buffer[n])>125)
	                	{System.out.print("PCM="+buffer[n]);}
	                	else;
	                }
					sourceDataLine.write(buffer, 0, nByte);//ԭʼ�������������������Ͳ��� }
				}
				sourceDataLine.stop();
	 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	 

}
