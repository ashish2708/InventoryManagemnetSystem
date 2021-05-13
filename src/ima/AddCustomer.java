package ima;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
public class AddCustomer extends JFrame implements ActionListener {
	JTextField t1,t2,t3,t4,t5,t6;
	JButton b1,b2;
	AddCustomer(){
		setTitle("Customer Form");
		setBounds(500,200,600,400);
		JLabel tag=new JLabel("NEW CUSTOMER FORM");
		tag.setBounds(50,0,350,50);
		tag.setFont(new Font("TimesRoman", Font.BOLD, 22));
		tag.setForeground(Color.BLACK);
		add(tag);
		
		JLabel l1=new JLabel("Firm Name");
		l1.setBounds(20,50,100,30);
		add(l1);
		t1=new JTextField();
		t1.setBounds(120,50,150,30);
		add(t1);
		
		JLabel l2=new JLabel("Customer Name");
		l2.setBounds(20,90,150,30);
		add(l2);
		t2=new JTextField();
		t2.setBounds(120,90,150,30);
		add(t2);
		
		
		JLabel l4=new JLabel("ADDRESS");
		l4.setBounds(20,130,150,30);
		add(l4);
		t3=new JTextField();
		t3.setBounds(120,130,150,30);
		add(t3);
		
		t4=new JTextField();
		t4.setBounds(120,170,150,30);
		add(t4);
		
		
		JLabel l6=new JLabel("Email");
		l6.setBounds(20,210,100,30);
		add(l6);
		t5=new JTextField();
		t5.setBounds(120,210,150,30);
		add(t5);
		JLabel l8=new JLabel("Contact no.");
		l8.setBounds(20,250,100,30);
		add(l8);
		t6=new JTextField();
		t6.setBounds(120,250,150,30);
		add(t6);
		
		ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("3.png"));
		Image img2=img.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT );
		ImageIcon img3=new ImageIcon(img2);
		JLabel imagelabel=new JLabel(img3);
		imagelabel.setBounds(320,70,200,200);
		add(imagelabel);
		
		b1=new JButton("ADD");
		b2=new JButton("Cancel");
		b1.setBounds(80,300,80,20);
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b2.setBounds(180,300,80,20);
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
		new AddCustomer().setVisible(true);;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==b1) {
			String FirmName=t1.getText();
			String CustomerName=t2.getText();
			String Address=t3.getText()+" "+t4.getText();
			String Email=t5.getText();
			String Contact=t6.getText();
			int CId = 0;
			
			DatabaseConn c=new DatabaseConn();
			String q="select max(id) from customer";
			try {
					ResultSet rs=c.s.executeQuery(q);
					rs.next();
					CId=rs.getInt("max(id)");
					CId=CId+1;
					
			}
			catch(Exception ae){
				System.out.println(ae);
				JOptionPane.showMessageDialog(null, ae);
			}
			
			String q1="Insert Into customer values("+CId+",'"+FirmName+"','"+CustomerName+"','"+Address+"','"+Email+"','"+Contact+"')";
			try{
				c.s.executeUpdate(q1);
				JOptionPane.showMessageDialog(null, "Customer Created with Couctomer Id: "+CId);
				this.setVisible(false);
				
				//new Dashboard().setVisible(true);
			}
			catch(Exception ae) {
				System.out.println(ae);
				JOptionPane.showMessageDialog(null, e);
			}
			
			
		}
		else if(e.getSource()==b2) {
			this.setVisible(false);
		}
	}


	

}
