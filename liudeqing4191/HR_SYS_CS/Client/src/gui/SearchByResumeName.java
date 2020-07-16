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
import model.ResumeList;
import model.ReturnResult;

import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class SearchByResumeName extends JFrame {
	private JTextField resumeNameField;
  
    public SearchByResumeName() {

        super("����������");  
        getContentPane().setBackground(new Color(240, 240, 240));
        setSize(1024,623);  
        setLocation(200, 50);  
//        Cursor cursor=Toolkit.getDefaultToolkit().createCustomCursor(Toolkit.getDefaultToolkit().getImage("6.png"), new Point(0, 0),"Slef");
//        getContentPane().setCursor(cursor);
        ImageIcon icon=new ImageIcon("11.jpg");
        this.setIconImage(icon.getImage());
        String path = "1.jpg";  
        ImageIcon background = new ImageIcon(path);  
        JLabel label = new JLabel(background);  
        label.setBounds(0, 0, this.getWidth(), this.getHeight());  
        JPanel imagePanel = (JPanel) this.getContentPane();  
        getContentPane().setLayout(null);
        Font f=new Font("����",Font.BOLD,30);
        Font a=new Font("����",Font.BOLD,20);
    
        
        JLabel lblNewLabel = new JLabel("������������");
        lblNewLabel.setForeground(new Color(200, 153, 102));
        lblNewLabel.setBounds(195, 169, 192, 49);
        getContentPane().add(lblNewLabel);
        lblNewLabel.setFont(f);
        
        resumeNameField = new JTextField();
        resumeNameField.setBounds(557, 174, 233, 50);
        resumeNameField.setFont(a);
        getContentPane().add(resumeNameField);
        resumeNameField.setColumns(10);
        
        JButton btnNewButton_2 = new JButton("ȷ��");
        btnNewButton_2.setBackground(SystemColor.info);
        btnNewButton_2.setForeground(new Color(102, 153, 102));
        AbstractAction search=new AbstractAction()  {
        	@Override
            public void actionPerformed(ActionEvent e) {
                String resumeName =resumeNameField.getText();
                Resume resume = new Resume(resumeName,null);

                Operator o =new Operator();
                ReturnResult rr=o.searchByName(resume);
                ResumeList resumes=(ResumeList) rr.resultData;//parse�Ľ��ת����bookList�ŵ���������ʾ
                int resumeCount = resumes.size();
                if(resumeCount>0)
                {
                    SearchResult rs=new SearchResult(resumes);
                    rs.setVisible(true);
                }
                else {
                    JOptionPane.showMessageDialog(null, "û���ҵ����ѧ��");
                }
        	}
        };
        btnNewButton_2.addActionListener(search);
		InputMap imap = ((JComponent) getContentPane()).getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);  
		imap.put(KeyStroke.getKeyStroke("ENTER"), "btnNewButton_2");  
		ActionMap amap = ((JComponent) getContentPane()).getActionMap();  
		amap.put("btnNewButton_2", search);
        btnNewButton_2.setBounds(557, 426, 113, 49);
        btnNewButton_2.setFont(a);
        getContentPane().add(btnNewButton_2);
        
        JButton btnNewButton_3 = new JButton("����");
        btnNewButton_3.setBackground(SystemColor.info);
        btnNewButton_3.setForeground(new Color(102, 153, 102));
        btnNewButton_3.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
				SearchResumeFrame searchResumeFrame =new SearchResumeFrame();
				searchResumeFrame.setVisible(true);
				SearchByResumeName.this.dispose();
        	}
        });
        btnNewButton_3.setBounds(736, 426, 113, 49);
        btnNewButton_3.setFont(a);
        getContentPane().add(btnNewButton_3);

        imagePanel.setOpaque(false);  
        this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));  
        setVisible(true);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    }  
  
    public static void main(String[] args) {  
        new SearchByResumeName();
    }  
}  