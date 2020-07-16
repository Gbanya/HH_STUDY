package pers.wx.Tarjet;
//TargetDataLine������������(��˷�),��SourceDataLine�����(����,����).
//��������,��μ�����ĳ���.(���к�,ʵʱ�ش���˷�¼��,ʵʱ���).
//javax.sound����Ĭ�ϰ�����JDK��
import java.io.*;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.TargetDataLine;

//��ʾAWT��ͼ
import java.awt.*;  //����java.util��

class dqz_draw extends Frame  //�����Frame��̳е�dqz_draw��
{
	
	
	public void paint(Graphics g)
	{ 
		//����һ���µ�����myfont������Ϊ���塢��б�塢�߶�Ϊ40��
		Font myfont=new Font("����",Font.ITALIC,40);
		g.setFont(myfont);  //����myfont����Ϊ��ǰ����
		
		
		g.drawOval(60,50,80,80);	//��ָ��(X,Y)���괦���Ƴ����Ϊ80����Բ����Բ����	
    g.setColor(Color.red);  //���õ�ǰ��ɫΪ��ɫ
		g.fillOval(150,50,80,80);	//��ָ��(X,Y)���괦���Ƴ����Ϊ80��ʵ����Բ����Բ����	
    g.setColor(Color.red);  //���õ�ǰ��ɫΪ��ɫ
		g.drawOval(240,50,80,80);	//��ָ��(X,Y)���괦���Ƴ����Ϊ80����Բ����Բ����	
	
		g.setColor(Color.green);  //���õ�ǰ��ɫΪ��ɫ
		g.drawString("���ǲ���",80,260);  //��ָ��(X,Y)���괦�����ַ���

    int i,x,y,R,G,B;
    for(i=0;i<20;i++)  //����20�����ʵ��Բ
    {
    	 x=(int)(Math.random()*300)+30; //�����������x
    	 y=(int)(Math.random()*300)+30; //�����������y
    	 R=(int)(Math.random()*255);  //������ɺ��ɫ
    	 G=(int)(Math.random()*255);  //��������̻�ɫ
    	 B=(int)(Math.random()*255);  //�����������ɫ
    	 g.setColor(new Color(R,G,B));   //���õ�ǰ��ɫΪ���RGB��ɫ
    	 
    	 g.fillOval(x,y,10,10); //�������ɫ��������괦����ֱ��Ϊ10�����ص�ʵ��Բ
    }

    g.setColor(Color.orange);  //���õ�ǰ��ɫΪ��ɫ
    y=100;
    for(i=0;i<40;i++)  //����40������
    {
    	y+=5;
    	g.drawRect(30,30,320,y); //���λ���40�����Ϊ5�ľ���
    }
    
   

 }
} 

public class RecordAndPlay2      //���幫����
{
    static volatile boolean stop=false;
    public static int dqz_ctr=0; //0Ϊ�����������ţ�1Ϊֻ������������2Ϊֻ����������
    static dqz_draw a; //��ͼ����
    
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
    	  
    	 a=new dqz_draw(); //ʵ����һ��ֱ�Ӽ̳���Frame���dqz_draw�����
  	   a.setTitle("java������¼��������");
  	   a.setSize(600,480); //�������Ϊ320��240����
	     //a.setLocation(120,250); //�������λ��X,Y����
	   
	     /*���ò���Ϊ������
	     ��������ò������ͣ���������и�������󽫱��ص���һ��
	     �����ֻ�ܿ������һ��������� */
  	   a.setLayout(new FlowLayout()); 
  
     
       //����������ʾ���
       //�����ڴ�֮�д���֮�����Ŀ��ӻ���������ܱ���ʾ
       a.setVisible(true);
       
       Play();
    }
    
    //������Ƶ�ļ�
    public static void Play() 
    {

        try {
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
            FloatControl fc=(FloatControl)sourceDataLine.getControl(FloatControl.Type.MASTER_GAIN);
            double value=2;
            float dB = (float)
                  (Math.log(value==0.0?0.0001:value)/Math.log(10.0)*20.0);
            fc.setValue(dB);
            int nByte = 0;
            final int bufSize=4*100;
            byte[] buffer = new byte[bufSize];
            
            //dqz���Զ��з��ŵ�����PCM����������������ݷ���
            byte[] bleft=new byte[bufSize];
            int kk=0,hh=0;
            
            while (nByte != -1) {
                //System.in.read();
                nByte = targetDataLine.read(buffer, 0, bufSize);
                //System.out.println("\nByte="+nByte);
                
                if(1==dqz_ctr)
                {
                  //��ȡ��������ÿ����������2�ֽڣ�
                  for(kk=0;kk<bufSize&&kk<nByte;kk+=4)
                  {
                	  bleft[kk]=buffer[kk]; //��������������
                	  bleft[kk+1]=buffer[kk+1];
                	  bleft[kk+2]=0; //����������ɾ��
                	  bleft[kk+3]=0;
                  }
                  sourceDataLine.write(bleft, 0, nByte); //�����������������Ͳ���
                }
                else if(2==dqz_ctr)
                {
                  //��ȡ��������ÿ����������2�ֽڣ�
                  for(kk=0;kk<bufSize&&kk<nByte;kk+=4)
                  {
                	  bleft[kk]=0; //����������ɾ��
                	  bleft[kk+1]=0;
                	  bleft[kk+2]=buffer[kk+2]; //��������������
                	  bleft[kk+3]=buffer[kk+3];
                	}
                	sourceDataLine.write(bleft, 0, nByte); //�����������������Ͳ���
                }
                else
                {
                	//����û�д������ԭʼ������������
                	sourceDataLine.write(buffer, 0, nByte); //ԭʼ�������������������Ͳ���
                }
                
                
            }
            sourceDataLine.stop();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
