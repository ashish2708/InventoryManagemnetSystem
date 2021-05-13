package ima;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
public class AddCategory extends JFrame implements ActionListener {
	JTextField t1,t2;
	JButton b1,b2;
	AddCategory(){
		setTitle("Category Form");
		setBounds(500,200,600,250);
		JLabel tag=new JLabel("NEW CATEGORY FORM");
		tag.setBounds(50,0,350,50);
		tag.setFont(new Font("TimesRoman", Font.BOLD, 22));
		tag.setForeground(Color.BLACK);
		add(tag);
		
		JLabel l1=new JLabel("Category Name");
		l1.setBounds(20,50,100,30);
		add(l1);
		t1=new JTextField();
		t1.setBounds(120,50,150,30);
		add(t1);
		
		JLabel l2=new JLabel("Category Code");
		l2.setBounds(20,90,150,30);
		add(l2);
		t2=new JTextField();
		t2.setBounds(120,90,150,30);
		add(t2);
		
		ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("4.png"));
		Image img2=img.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT );
		ImageIcon img3=new ImageIcon(img2);
		JLabel imagelabel=new JLabel(img3);
		imagelabel.setBounds(320,5,200,200);
		add(imagelabel);
		
		b1=new JButton("ADD");
		b2=new JButton("Cancel");
		b1.setBounds(80,150,80,20);
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b2.setBounds(180,150,80,20);
		add(b1);
		b1.addActionListener(this);
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		add(b2);
		b2.addActionListener(this);
		
		
		
		
		getContentPane().setBackground(Color.white);
		
		setLayout(null);
		setVisible(true);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AddCategory().setVisible(true);;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==b1) {
			String CatName=t1.getText();
			String Code=t2.getText();
			
			DatabaseConn c=new DatabaseConn();
			String q1="Insert Into category values('"+CatName+"','"+Code+"')";
			try{
				c.s.executeUpdate(q1);
				JOptionPane.showMessageDialog(null, "Category Created");
				this.setVisible(false);
				//new Dashboard().setVisible(true);
				
			}
			catch(Exception ae) {
				JOptionPane.showMessageDialog(null, "Invalid Entry");
			}
			
		}
		else if(e.getSource()==b2) {
			this.setVisible(false);
		}
	}


	

}
