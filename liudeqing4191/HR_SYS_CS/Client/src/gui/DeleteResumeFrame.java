package gui;

import control.Operator;
import model.Resume;
import model.ReturnResult;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class DeleteResumeFrame extends JFrame {
    private JTextField resumeIdField;
    public DeleteResumeFrame() {

        super("�����֤��ɾ��");
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

        JLabel lblNewLabel = new JLabel("���֤��");
        lblNewLabel.setForeground(new Color(102, 153, 102));
        lblNewLabel.setBounds(265, 169, 179, 49);
        getContentPane().add(lblNewLabel);
        lblNewLabel.setFont(f);

        resumeIdField = new JTextField();
        resumeIdField.setBounds(467, 168, 233, 50);
        resumeIdField.setFont(a);
        getContentPane().add(resumeIdField);
        resumeIdField.setColumns(10);

        JButton btnNewButton_2 = new JButton("ȷ��");
        btnNewButton_2.setBackground(SystemColor.info);
        btnNewButton_2.setForeground(new Color(102, 153, 102));
        AbstractAction delete=new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String resumeId =resumeIdField.getText();
                //�ѽ����еõ�Id���ݷ���Resume��
                //��Book����Operator����
                Resume resume = new Resume(null, resumeId);
                Operator o =new Operator();
                ReturnResult rr=o.deleteResume(resume);
                if(rr.isSuccess)
                {
                    JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "ɾ��ʧ��");
                }
            }
        };
        btnNewButton_2.addActionListener(delete);
        InputMap imap = ((JComponent) getContentPane()).getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        imap.put(KeyStroke.getKeyStroke("ENTER"), "delete");
        ActionMap amap = ((JComponent) getContentPane()).getActionMap();
        amap.put("delete", delete);
        btnNewButton_2.setBounds(604, 426, 113, 49);
        btnNewButton_2.setFont(a);
        getContentPane().add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton("����");
        btnNewButton_3.setBackground(SystemColor.info);
        btnNewButton_3.setForeground(new Color(102, 153, 102));
        btnNewButton_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainClassFrame mainClassFrame=new MainClassFrame();
                mainClassFrame.setVisible(true);
                DeleteResumeFrame.this.dispose();
            }
        });
        btnNewButton_3.setBounds(790, 426, 113, 49);
        btnNewButton_3.setFont(a);
        getContentPane().add(btnNewButton_3);

        imagePanel.setOpaque(false);
        this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {  
        new DeleteResumeFrame();
    }  
}  

