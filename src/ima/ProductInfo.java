package ima;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;
public class ProductInfo extends JFrame implements ActionListener{
	JTable t1;
	JButton b1,b2;
	ProductInfo(){
		setTitle("Product Details");
		setBounds(400,200,1000,550);
		JLabel l1=new JLabel("Product Name");
		l1.setBounds(20,5,100,20);
		add(l1);
		
		JLabel l2=new JLabel("Product ID");
		l2.setBounds(200,5,100,20);
		add(l2);
		
		JLabel l3=new JLabel("MRP");
		l3.setBounds(400,5,200,20);
		add(l3);
		
		JLabel l4=new JLabel("Category Code");
		l4.setBounds(600,5,200,20);
		add(l4);
		
		JLabel l5=new JLabel("Quantity");
		l5.setBounds(800,5,100,20);
		add(l5);
		
		
		t1=new JTable();
		t1.setBounds(0,30,1000,450);
		add(t1);
		
		
		b1=new JButton("Load Data");
		b1.setBounds(400,480,100,30);
		b1.addActionListener(this);
		add(b1);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.white);
		b2=new JButton("Back");
		b2.setBounds(550,480,100,30);
		add(b2);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.white);
		b2.addActionListener(this);
		
		
		setLayout(null);
		setVisible(true);
		
		getContentPane().setBackground(Color.white);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new ProductInfo();
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==b1) {
			try {
			DatabaseConn c=new DatabaseConn();
			String q="select * from product";
			ResultSet rs=c.s.executeQuery(q);
			t1.setModel(DbUtils.resultSetToTableModel(rs));
			
			}
			catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
			
		}
		else if(ae.getSource()==b2) {
			this.setVisible(false);
		}
	}

}
