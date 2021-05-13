package ima;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Login extends JFrame implements ActionListener  {
	JLabel l1,l2,l3;
	JTextField t1;
	JPasswordField t2;
	JButton b1,b2,b3,b4;
	Login(){
		setTitle("Login");
		l1=new JLabel("User Name");
		l1.setBounds(20,80, 80, 20);
		add(l1);
		
		l2=new JLabel("Password");
		l2.setBounds(20,110,80,20);
		add(l2);
		
		t1=new JTextField();
		t1.setBounds(100,80, 120, 20);
		add(t1);
		
		t2=new JPasswordField();
		t2.setBounds(100, 110, 120, 20);
		add(t2);
		
		b1=new JButton("Login");
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
		
		b3=new JButton("ADD USER");
		b3.setBounds(250,50,180,40);
		b3.setBackground(Color.yellow);
		b3.setForeground(Color.cyan);
		b3.addActionListener(this);
		add(b3);
		
		b4=new JButton("FORGOT  PASSWORD");
		b4.setBounds(250,110,180,40);
		b4.setBackground(Color.yellow);
		b4.setForeground(Color.cyan);
		b4.addActionListener(this);
		add(b4);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("first.png"));
		Image i2=i1.getImage().getScaledInstance(350, 180,Image.SCALE_DEFAULT );
		ImageIcon i3=new ImageIcon(i2);
		l3=new JLabel(i3);
		l3.setBounds(30,0, 350, 200);
		add(l3);

		//setUndecorated(true);
		setBounds(600,300,450,245);
		getContentPane().setBackground(Color.cyan);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Login();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==b1)
		{
			try {
			String username=t1.getText();
			String password=t2.getText();
			
			DatabaseConn c=new DatabaseConn();
			String q1="select * from user where id = '"+username+"' and password = sha1('"+password+"')";
			
				ResultSet rs=c.s.executeQuery(q1);
				
				
				if(rs.next()) {
					new Dashboard().setVisible(true);
					System.out.println("Logged in");
					this.setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "INCORRECT ID OR PASSWORD");
					//this.setVisible(false );
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		else if(e.getSource()==b3) {
			new AddUser().setVisible(true);
		}
		else if(e.getSource()==b4) {
			new ForgotPass().setVisible(true);
		}
		else if(e.getSource()==b2){
			System.exit(0);
		}
		
	}
	
	
}
