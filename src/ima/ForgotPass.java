package ima;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ForgotPass extends JFrame implements ActionListener  {
	JLabel l1,l2,l3,l4,l5;
	JTextField t1,t2,t3,t4;
	JPasswordField t5,t6;
	JButton b1,b2,b3,b4;
	ForgotPass(){
		setTitle("Change Password");
		l1=new JLabel("User id");
		l1.setBounds(20,80, 80, 20);
		add(l1);
		
		l2=new JLabel("user name");
		l2.setBounds(20,110,80,20);
		add(l2);
		
		t1=new JTextField();
		t1.setBounds(100,80, 120, 20);
		add(t1);
		
		t2=new JTextField();
		t2.setBounds(100, 110, 120, 20);
		add(t2);
		
		
		
		b1=new JButton("get");
		b1.setBounds(50,150,80,20);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.white);
		b1.addActionListener(this);
		add(b1);
		
		b2=new JButton("Cancel");
		b2.setBounds(140,150,80,20);
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		b2.addActionListener(this);
		add(b2);
		
		l3=new JLabel("Security Question");
		l3.setBounds(20,180,110,20);
		add(l3);
		t3=new JTextField();
		t3.setBounds(140, 180, 180, 20);
		add(t3);
		
		l4=new JLabel("Answer");
		l4.setBounds(20,210,110,20);
		add(l4);
		t4=new JTextField();
		t4.setBounds(140, 210, 180, 20);
		add(t4);
		
		b3=new JButton("Change");
		b3.setBounds(90,300,120,30);
		b3.setBackground(Color.black);
		b3.setForeground(Color.white);
		b3.addActionListener(this);
		add(b3);
		l5=new JLabel("New Password");
		l5.setBounds(20,240,110,20);
		add(l5);
		t5=new JPasswordField();
		t5.setBounds(140, 240, 180, 20);
		add(t5);
		
		
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("changepass.png"));
		Image i2=i1.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT );
		ImageIcon i3=new ImageIcon(i2);
		l3=new JLabel(i3);
		l3.setBounds(270,50, 100, 100);
		add(l3);
		l5=new JLabel("Confirm Password");
		l5.setBounds(20,270,110,20);
		add(l5);
		t6=new JPasswordField();
		t6.setBounds(140, 270, 180, 20);
		add(t6);
		
		setBounds(600,300,450,370);
		getContentPane().setBackground(Color.cyan);
		setLayout(null);
		setVisible(true);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new ForgotPass();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==b1)
		{
			try {
			String uid=t1.getText();
			String name=t2.getText();
			
			DatabaseConn c=new DatabaseConn();
			String q1="select securityque from user where id = '"+uid+"' and name ='"+name+"'";
			//System.out.println(q1);
				ResultSet rs=c.s.executeQuery(q1);
				
				
				if(rs.next()) {
					t3.setText(rs.getString("securityque"));
					//System.out.println(rs.getString("securityque"));
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Incorrect USER ID or Name");
					//this.setVisible(false );
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
				System.out.println(e);
			}
			
		}
		
		else if(e.getSource()==b2){
			//System.exit(0);
			this.setVisible(false);
		}
		else if(e.getSource()==b3) {
			try {
			String uid=t1.getText();
			String sa=t4.getText();
			DatabaseConn c=new DatabaseConn();
			String q1="select password from user where id = '"+uid+"' and sanswer ='"+sa+"'";
			System.out.println(q1);
				ResultSet rs=c.s.executeQuery(q1);
				
				
				if(rs.next()) {
					String NewPass=t5.getText();
					String NewPass2=t6.getText();
					System.out.println(NewPass+NewPass2);
					
					if(Objects.equals(NewPass,NewPass2)) {
						System.out.println(uid);
						String q2="update user set password =sha1('"+NewPass+"') where id='"+uid+"'";
						try {
						c.s.executeUpdate(q2);
						
						JOptionPane.showMessageDialog(null, "Password Changed");
						this.setVisible(false);
						}
						catch(Exception e1) {
							System.out.println(e1);
						}
						
					}
					else {
						JOptionPane.showMessageDialog(null, "Password Not matched");
					}
					
					
					//System.out.println(rs.getString("securityque"));
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Incorrect Answer");
					//this.setVisible(false );
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
				System.out.println(e);
			}
		
			
		}
		
	}
	
	
}
