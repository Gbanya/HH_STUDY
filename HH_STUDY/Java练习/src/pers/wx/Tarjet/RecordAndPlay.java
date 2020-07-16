package pers.wx.Tarjet;
import java.io.*;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.TargetDataLine;
public class RecordAndPlay
{
    static volatile boolean stop=false;
    public static int dqz_ctr=0; //0Ϊ�����������ţ�1Ϊֻ������������2Ϊֻ����������
    public static void main(String[] args)
    {
    	  System.out.println("�����в�������args.length="+args.length);
    	  System.out.println("�����д�������Ĳ���Ϊ L ʱֻ������������Ϊ R ʱֻ���������������򲥷�������");
    	  dqz_ctr=0;
    	  if(1==args.length)
    	  {
    	  	if(args[0].equalsIgnoreCase("L"))dqz_ctr=1;
    	  	else if(args[0].equalsIgnoreCase("R"))dqz_ctr=2;
    	  }
        Play();
    }
    
    //����ʵʱ��Ƶ
    public static void Play()
    {

        try
        {
            AudioFormat audioFormat =
//                    new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 44100F,
//                    8, 1, 1, 44100F, false);
             new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,44100F, 16, 2, 4,
             44100F, true);//�з�������PCM���룬ÿ������ֵ16bit���룬44.1KHz����Ƶ�ʣ�˫������ÿ֡4�ֽڣ�������������ÿ����2�ֽڣ���ÿ��֡��44100���ɲ����ʶ��ã���ָʾ�Ƿ��� big-endian (������ǰ)�ֽ�˳��洢���������е����ݣ�false ��ζ�� little-endian��С����ǰ������

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
            FloatControl fc=(FloatControl)sourceDataLine.getControl(FloatControl.Type.MASTER_GAIN); 
            double value=2; //ԭ��������2��
            //double value=0.5; //ԭ��������һ��
            //0.0001����Ϊ -80dB
            float dB = (float)
                  (Math.log(value==0.0?0.0001:value)/Math.log(10.0)*20.0);
            fc.setValue(dB); //��dBΪ��λ�����趨�����Ϊ2����6.0206dB������СΪ0����������ЧΪ�����ţ�
            
            int nByte = 0;
            //final int bufSize=4*100;//��֡��֡��Ϊ400�ֽڣ���˫����16bit�����Ĳ����¼�Ϊ400*8/16/2=ÿ����100������������Ҳ��100/44100Hz=0.00226757369614512471655328798186�������
            //final int bufSize=4*441; //0.01�룬441��������
            final int bufSize=4*2048; //2048��������
            System.out.println("������=44100Hz��˫������16bit����PCM��ÿ����ÿ֡"+bufSize/4+"�������㣨"+(bufSize/4.0/44100)+"s����������ǿ="+dB+"dB");
            
            byte[] buffer = new byte[bufSize];
            long ncount=0; //����
			while (nByte != -1) 
			{ 
				ncount++;
                nByte = targetDataLine.read(buffer, 0, bufSize);
				/*
				 * int n; for(n=0;n<=bufSize&&n<nByte;n+=1) { short data = buffer[n]; }
				 */
                System.out.print("\r��"+ncount+"�δ���Ƶ��һ�ζ��� Byte="+nByte+" �ֽ�");
                int n; 
                short l1=0;
                short r1=0;
                int l2=0;
                int r2=0;
                int d1=0;
                float d2=0;
                float d3=0;
                for(n=0;n<=bufSize&&n<nByte;n+=4)
                {
                l1 = (short)(((buffer[n] & 0x00FF) << 8) | (0x00FF & buffer[n+1]));
                r1 = (short)(((buffer[n+2] & 0x00FF) << 8) | (0x00FF & buffer[n+3]));
                l2 = (int)((short)(Math.abs(l1)));
                r2 = (int)((short)(Math.abs(r1)));
                d1 += l2+r2;
                }
                d2 = d1/2048;
                System.out.println("\rƽ��������"+d2);
                d3 = (float)(Math.log(d2));
                System.out.println("\rһ֡��"+d3);
				sourceDataLine.write(buffer, 0, nByte);//ԭʼ�������������������Ͳ��� }
			}
			  sourceDataLine.stop();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
