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
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JTextField;
import javax.swing.KeyStroke;

import control.Operator;
import model.Book;
import model.ReturnResult;

import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Toolkit;  
public class DeleteByBookAuthor extends JFrame {
	private JTextField bookAuthorField;  
  
    public DeleteByBookAuthor() {  

        super("��������ɾ��");  
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
        
        JLabel lblNewLabel = new JLabel("������");
        lblNewLabel.setForeground(new Color(102, 153, 102));
        lblNewLabel.setBounds(265, 169, 179, 49);
        getContentPane().add(lblNewLabel);
        lblNewLabel.setFont(f);
        
        bookAuthorField = new JTextField();
        bookAuthorField.setBounds(467, 168, 233, 50);
        bookAuthorField.setFont(a);
        getContentPane().add(bookAuthorField);
        bookAuthorField.setColumns(10);
        
        JButton btnNewButton_2 = new JButton("ȷ��");
        btnNewButton_2.setBackground(new Color(255, 255, 225));
        btnNewButton_2.setForeground(new Color(102, 153, 102));
        AbstractAction delete=new AbstractAction() {
        	public void actionPerformed(ActionEvent e) {
				String bookAuthor =bookAuthorField.getText();
				//�ѽ����еõ����������ݷ���Book��
				//��Book����Operator����
				Book book=new Book(null,bookAuthor,0);
				Operator o =new Operator();
				ReturnResult rr=o.deleteBookByAuthor(book);
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
		imap.put(KeyStroke.getKeyStroke("ENTER"), "btnNewButton_2");  
		ActionMap amap = ((JComponent) getContentPane()).getActionMap();  
		amap.put("btnNewButton_2", delete);
        btnNewButton_2.setBounds(604, 426, 113, 49);
        btnNewButton_2.setFont(a);
        getContentPane().add(btnNewButton_2);
        
        JButton btnNewButton_3 = new JButton("����");
        btnNewButton_3.setForeground(new Color(102, 153, 102));
        btnNewButton_3.setBackground(SystemColor.info);
        btnNewButton_3.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
				DeleteBookFrame deleteBookFrame=new DeleteBookFrame();
				deleteBookFrame.setVisible(true);
				DeleteByBookAuthor.this.dispose();
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
        new DeleteByBookAuthor();  
    }  
}  