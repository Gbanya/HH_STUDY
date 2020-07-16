package gui;
    import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JFrame;  
    import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
    import java.awt.Font;

    import javax.swing.JTextField;
import javax.swing.KeyStroke;

import control.Operator;
import model.Resume;
import model.ReturnResult;

import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class UpdateResumeFrame extends JFrame {
    	private JTextField oldresumeIdField;  
    	private JTextField reumeNameField;
    	private JTextField reumeSchoolField;
    	private JTextField reumeProcessField;
    	private JLabel lblNewLabel_2;
    	private JLabel lblNewLabel_3;


        public UpdateResumeFrame() {
            //���ñ���  
            super("��ӭ�����޸���Ϣ����");
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
            Font f=new Font("����",Font.BOLD,25);
            Font a=new Font("����",Font.BOLD,20);
            //--------------------id
            JLabel lblNewLabel = new JLabel("��Ҫ�޸ĵ����֤��");
            lblNewLabel.setForeground(new Color(102, 153, 102));
            lblNewLabel.setBounds(109, 94, 159, 44);
            lblNewLabel.setFont(a);
            getContentPane().add(lblNewLabel);
            
            oldresumeIdField = new JTextField();
            oldresumeIdField.setBounds(267, 94, 159, 43);
            oldresumeIdField.setFont(a);
            getContentPane().add(oldresumeIdField);
            oldresumeIdField.setColumns(10);

            //---------------------name
            JLabel lblNewLabel_1 = new JLabel("�µ�����");
            lblNewLabel_1.setForeground(new Color(102, 153, 102));
            lblNewLabel_1.setBounds(508, 94, 108, 44);
            lblNewLabel_1.setFont(f);
            getContentPane().add(lblNewLabel_1);
            
            reumeNameField = new JTextField();
            reumeNameField.setBounds(688, 94, 169, 44);
            getContentPane().add(reumeNameField);
            reumeNameField.setFont(a);
            reumeNameField.setColumns(10);
            //---------------------ȷ��
            JButton btnNewButton_2 = new JButton("ȷ��");
            btnNewButton_2.setBackground(SystemColor.info);
            btnNewButton_2.setForeground(new Color(102, 153, 102));
            AbstractAction change=new AbstractAction()  {
            	@Override
                public void actionPerformed(ActionEvent e) {
            	    //��ȡ
            		String oldresumeId =oldresumeIdField.getText();
    				String reumeName =reumeNameField.getText();
    				String reumeSchool =reumeSchoolField.getText();
    				int reumeProcess =Integer.parseInt(reumeProcessField.getText());
    				int reumeDeleteStatus =0;
    				//���
                    Resume resume=new Resume(reumeName,oldresumeId);
                    resume.setSchool(reumeSchool);
                    resume.setProcess(reumeProcess);
                    resume.setDeleteStatus(reumeDeleteStatus);

    				Operator o =new Operator();
    				//��Book����Operator����
    				ReturnResult rr=o.updateResume(resume);
    				if(rr.isSuccess)
    				{
    					JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
    				}
    				else
    				{
    					JOptionPane.showMessageDialog(null, "û���ҵ���Ӧͬѧ���޸�");
    				}
            	}
            };
            btnNewButton_2.addActionListener(change);
    		InputMap imap = ((JComponent) getContentPane()).getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);  
    		imap.put(KeyStroke.getKeyStroke("ENTER"), "btnNewButton_2");  
    		ActionMap amap = ((JComponent) getContentPane()).getActionMap();  
    		amap.put("btnNewButton_2", change);
            btnNewButton_2.setBounds(331, 451, 113, 51);
            btnNewButton_2.setFont(a);
            getContentPane().add(btnNewButton_2);

            //----------------------����
            JButton btnNewButton_3 = new JButton("����");
            btnNewButton_3.setBackground(SystemColor.info);
            btnNewButton_3.setForeground(new Color(102, 153, 102));
            btnNewButton_3.addActionListener(new ActionListener() {
            	@Override
                public void actionPerformed(ActionEvent e) {
    				MainClassFrame mainClassFrame=new MainClassFrame();
    				mainClassFrame.setVisible(true);
    				UpdateResumeFrame.this.dispose();
            	}
            });
            btnNewButton_3.setBounds(537, 451, 113, 51);
            btnNewButton_3.setFont(a);
            getContentPane().add(btnNewButton_3);


            //------------------------------school
            reumeSchoolField = new JTextField();
            reumeSchoolField.setBounds(688, 217, 169, 44);
            reumeSchoolField.setFont(a);
            getContentPane().add(reumeSchoolField);
            reumeSchoolField.setColumns(10);

            lblNewLabel_2 = new JLabel("ѧУ");
            lblNewLabel_2.setForeground(new Color(102, 153, 102));
            lblNewLabel_2.setBounds(508, 217, 108, 44);
            lblNewLabel_2.setFont(f);
            getContentPane().add(lblNewLabel_2);

            //-----------------------------process
            reumeProcessField = new JTextField();
            reumeProcessField.setBounds(690, 330, 167, 44);
            reumeProcessField.setFont(a);
            getContentPane().add(reumeProcessField);
            reumeProcessField.setColumns(10);

            
            lblNewLabel_3 = new JLabel("����");
            lblNewLabel_3.setForeground(new Color(102, 153, 102));
            lblNewLabel_3.setBounds(508, 330, 108, 44);
            lblNewLabel_3.setFont(f);
            getContentPane().add(lblNewLabel_3);




            imagePanel.setOpaque(false);  
            this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));  
            setVisible(true);  
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        }  
      
        public static void main(String[] args) {  
            new UpdateResumeFrame();
        }  
    }  