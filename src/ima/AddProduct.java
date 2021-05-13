package ima;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
public class AddProduct extends JFrame implements ActionListener {
	JTextField t1,t2,t3,t4;
	Choice c1;
	JButton b1,b2;
	AddProduct(){
		setTitle("Product Form");
		setBounds(500,200,600,350);
		JLabel tag=new JLabel("NEW PRODUCT FORM");
		tag.setBounds(50,0,350,50);
		tag.setFont(new Font("TimesRoman", Font.BOLD, 22));
		tag.setForeground(Color.BLACK);
		add(tag);
		
		JLabel l1=new JLabel("Product Name");
		l1.setBounds(20,50,100,30);
		add(l1);
		t1=new JTextField();
		t1.setBounds(120,50,150,30);
		add(t1);
		
		JLabel l2=new JLabel("Product Id");
		l2.setBounds(20,90,150,30);
		add(l2);
		t2=new JTextField();	
		t2.setBounds(120,90,150,30);
		add(t2);
		
		JLabel l3=new JLabel("Quantity");
		l3.setBounds(20,130,150,30);
		add(l3);
		t3=new JTextField();
		t3.setBounds(120,130,150,30);
		add(t3);
		
		JLabel l4=new JLabel("MRP");
		l4.setBounds(20,170,150,30);
		add(l4);
		t4=new JTextField();
		t4.setBounds(120,170,150,30);
		add(t4);
		
		
		JLabel l5=new JLabel("Category ID");
		l5.setBounds(20,210,100,30);
		add(l5);
		c1=new Choice();
		c1.setBounds(120, 210, 150, 50);
		add(c1);
		try {
			DatabaseConn c=new DatabaseConn();
			String q1="Select catcode from category";
			ResultSet rs=c.s.executeQuery(q1);
			while(rs.next()) {
				c1.add(rs.getString("catcode"));
			}
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
		ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("product.gif"));
		Image img2=img.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT );
		ImageIcon img3=new ImageIcon(img2);
		JLabel imagelabel=new JLabel(img3);
		imagelabel.setBounds(320,25,200,200);
		add(imagelabel);
		
		b1=new JButton("ADD");
		b2=new JButton("Cancel");
		b1.setBounds(80,250,80,20);
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b2.setBounds(180,250,80,20);
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
		new AddProduct().setVisible(true);;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==b1) {
			String PName=t1.getText();
			String PId=t2.getText();
			String Qty=t3.getText();
			String Mrp=t4.getText();
			String PCat=(String)c1.getSelectedItem();
			DatabaseConn c=new DatabaseConn();
			String q1="Insert Into product values('"+PName+"','"+PId+"',"+Mrp+",'"+PCat+"',"+Qty+")";
			try{
				c.s.executeUpdate(q1);
				JOptionPane.showMessageDialog(null, "Product Added");
				this.setVisible(false);
			}
			catch(Exception ae) {
				System.out.println(ae);
				JOptionPane.showMessageDialog(null, "Invalid info");
			}
			
		}
		else if(e.getSource()==b2) {
			this.setVisible(false);
		}
	}


	

}
