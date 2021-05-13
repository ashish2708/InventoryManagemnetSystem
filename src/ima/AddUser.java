package ima;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddUser extends JFrame implements ActionListener {
	JTextField t1,t2,t3,t4,t5,t6,t7;
	JComboBox c1,c2;
	Choice c3;
	JButton b1,b2;
	AddUser(){
		setTitle("USER FORM");
		setBounds(500,200,700,500);
		JLabel tag=new JLabel("NEW USER FORM");
		tag.setBounds(50,0,350,50);
		tag.setFont(new Font("TimesRoman", Font.BOLD, 22));
		tag.setForeground(Color.BLACK);
		add(tag);
		
		JLabel l1=new JLabel("NAME");
		l1.setBounds(20,50,100,30);
		add(l1);
		t1=new JTextField();
		t1.setBounds(120,50,150,30);
		add(t1);
		
		JLabel l2=new JLabel("GENDER");
		l2.setBounds(20,90,150,30);
		c1=new JComboBox(new String[] {"M","F"});
		c1.setBackground(Color.WHITE);
		c1.setBounds(120,90,150,30);
		add(c1);
		
		
		JLabel l3=new JLabel("ADDRESS");
		l3.setBounds(20,130,100,30);
		add(l3);
		add(l2);
		t2=new JTextField();
		t2.setBounds(120,130,150,30);
		add(t2);
		
		
		
		JLabel l4=new JLabel("EMAIL");
		l4.setBounds(20,170,150,30);
		add(l4);
		t3=new JTextField();
		t3.setBounds(120,170,150,30);
		add(t3);
		
		
		JLabel l5=new JLabel("USER ID");
		l5.setBounds(20,210,100,30);
		add(l5);
		t4=new JTextField();
		t4.setBounds(120,210,150,30);
		add(t4);
//		c2=new JComboBox(new String[] {"PASSPORT","AADHAR","DRIVING LICENSE","VOTER ID"});
//		c2.setBounds(120,210,150,30);
//		c2.setBackground(Color.WHITE);
//		add(c2);
		
		JLabel l6=new JLabel("PASSWORD");
		l6.setBounds(20,250,100,30);
		add(l6);
		t5=new JTextField();
		t5.setBounds(120,250,150,30);
		add(t5);
		JLabel l7=new JLabel("SECURITY QUESTION");
		l7.setBounds(20,290,170,30);
		add(l7);
		t6=new JTextField();
		t6.setBounds(190,290,150,30);
		add(t6);
		
		
		JLabel l8=new JLabel("ANSWER");
		l8.setBounds(20,330,170,30);
		add(l8);
		t7=new JTextField();
		t7.setBounds(190,330,150,30);
		add(t7);
		
		ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("add-user.png"));
		Image img2=img.getImage().getScaledInstance(300, 250,Image.SCALE_DEFAULT );
		ImageIcon img3=new ImageIcon(img2);
		JLabel imagelabel=new JLabel(img3);
		imagelabel.setBounds(320,25,300,250);
		add(imagelabel);
		
		b1=new JButton("ADD");
		b2=new JButton("Cancel");
		b1.setBounds(80,420,80,20);
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b2.setBounds(180,420,80,20);
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
		new AddUser().setVisible(true);;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==b1) {
			String name=t1.getText();
			String gen=(String)c1.getSelectedItem();
			String ad=t2.getText();
			String email=t3.getText();
			String id=t4.getText();
			String pass=t5.getText();
			//String roomno=c3.getSelectedItem();
			String sq=t6.getText();
			String ans=t7.getText();
			
			DatabaseConn c=new DatabaseConn();
			String q1="Insert Into user values('"+id+"','"+name+"','"+gen+"','"+ad+"','"+email+"','"+sq+"','"+ans+"',sha1("+pass+"))";
			try{
				c.s.executeUpdate(q1);
				JOptionPane.showMessageDialog(null, "User created with id="+id);
				this.setVisible(false);
			}
			catch(Exception ae) {
				JOptionPane.showMessageDialog(null, ae);
			}
			
		}
		else if(e.getSource()==b2) {
			this.setVisible(false);
		}
	}


	

}
