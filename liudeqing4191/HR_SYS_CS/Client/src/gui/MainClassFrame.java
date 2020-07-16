package gui;
    import javax.swing.ImageIcon;  
    import javax.swing.JFrame;  
    import javax.swing.JLabel;  
    import javax.swing.JPanel;

import control.Operator;

    import java.awt.Color;
    import java.awt.Font;

    import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class MainClassFrame extends JFrame {
      
        public MainClassFrame() {  
            //���ñ���  
            super("��ӭ����HR����ϵͳ");
            getContentPane().setBackground(new Color(240, 240, 240));
            setSize(1024,623);  
            setLocation(200, 50);  
//            Cursor cursor=Toolkit.getDefaultToolkit().createCustomCursor(Toolkit.getDefaultToolkit().getImage("6.png"), new Point(0, 0),"Slef");
//            getContentPane().setCursor(cursor);

            ImageIcon icon=new ImageIcon("11.jpg");
            this.setIconImage(icon.getImage());

            String path = "1.jpg";  
            ImageIcon background = new ImageIcon(path);
            JLabel label = new JLabel(background);  
            label.setBounds(0, 0, this.getWidth(), this.getHeight());  
            JPanel imagePanel = (JPanel) this.getContentPane();  
            getContentPane().setLayout(null);
            Font a=new Font("����",Font.BOLD,20);
            
            JButton btnNewButton = new JButton("��Ӽ���");
            btnNewButton.setForeground(new Color(102, 153, 102));
            btnNewButton.setBackground(SystemColor.info);
            btnNewButton.addActionListener(new ActionListener() {
            	@Override
                public void actionPerformed(ActionEvent e) {
    				AddResumeFrame addResumeFrame =new AddResumeFrame();
    				addResumeFrame.setVisible(true);
    				MainClassFrame.this.dispose();
            	}
            });
            btnNewButton.setBounds(413, 67, 156, 47);
            btnNewButton.setFont(a);
            getContentPane().add(btnNewButton);
            
            JButton btnNewButton_1 = new JButton("ɾ������");
            btnNewButton_1.setForeground(new Color(102, 153, 102));
            btnNewButton_1.setBackground(SystemColor.info);
            btnNewButton_1.addActionListener(new ActionListener() {
            	@Override
                public void actionPerformed(ActionEvent e) {
    				DeleteResumeFrame deleteResumeFrame =new DeleteResumeFrame();
    				deleteResumeFrame.setVisible(true);
    				MainClassFrame.this.dispose();
            	}
            });
            btnNewButton_1.setBounds(413, 159, 156, 47);
            btnNewButton_1.setFont(a);
            getContentPane().add(btnNewButton_1);
            
            JButton btnNewButton_2 = new JButton("�޸ļ���");
            btnNewButton_2.setForeground(new Color(102, 153, 102));
            btnNewButton_2.setBackground(SystemColor.info);
            btnNewButton_2.addActionListener(new ActionListener() {
            	@Override
                public void actionPerformed(ActionEvent e) {
    				UpdateResumeFrame updateResumeFrame =new UpdateResumeFrame();
    				updateResumeFrame.setVisible(true);
    				MainClassFrame.this.dispose();
            	}
            });
            btnNewButton_2.setBounds(413, 247, 156, 47);
            btnNewButton_2.setFont(a);
            getContentPane().add(btnNewButton_2);
            
            JButton btnNewButton_3 = new JButton("��ѯ����");
            btnNewButton_3.setForeground(new Color(102, 153, 102));
            btnNewButton_3.setBackground(SystemColor.info);
            btnNewButton_3.addActionListener(new ActionListener() {
            	@Override
                public void actionPerformed(ActionEvent e) {
    				SearchResumeFrame searchResumeFrame =new SearchResumeFrame();
    				searchResumeFrame.setVisible(true);
    				MainClassFrame.this.dispose();
            	}
            });
            btnNewButton_3.setBounds(413, 336, 156, 47);
            btnNewButton_3.setFont(a);
            getContentPane().add(btnNewButton_3);
            
            JButton btnNewButton_4 = new JButton("�˳�");
            btnNewButton_4.setForeground(new Color(102, 153, 102));
            btnNewButton_4.setBackground(SystemColor.info);
            btnNewButton_4.addActionListener(new ActionListener() {
            	@Override
                public void actionPerformed(ActionEvent e) {
    				String str="bye";
    				Operator o=new Operator();
    				o.Closenet(str);
    				System.exit(0);
            	}
            });
            btnNewButton_4.setBounds(413, 426, 156, 47);
            btnNewButton_4.setFont(a);
            getContentPane().add(btnNewButton_4);
            imagePanel.setOpaque(false);  
            this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));  
            setVisible(true);  
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        }  
      
        public static void main(String[] args) {  
            new MainClassFrame();  
        }  
    }  