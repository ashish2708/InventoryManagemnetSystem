package ima;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class InventoryManagementSystem extends JFrame implements ActionListener{
	JLabel l1,l2;
	JButton b1;
	public InventoryManagementSystem() {
		setTitle("Inventory Management System");
		setBounds(150,200,1200,500);
		l1=new JLabel("INVENTORY MANAGEMENT");
		l1.setBounds(60, 100, 1200, 90);
		l1.setForeground(Color.yellow);
		//l1.setBackground(Color.);
		l1.setFont(new Font("SERIF",Font.PLAIN,80 ));
		add(l1);
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("1.jpg"));
		Image img2=i1.getImage().getScaledInstance(1200, 500,Image.SCALE_DEFAULT );
		ImageIcon img3=new ImageIcon(img2);
		l2=new JLabel(img3);
		l2.setBounds(0,0,1200,500);
		add(l2);
		
		

		
		
		
		b1=new JButton("ENTER");
		b1.setBounds(500, 300, 200, 50);
		b1.setFont(new Font("serif",Font.BOLD,30 ));
		//b1.setBackground(Color.black);
		b1.setForeground(Color.CYAN);
		b1.addActionListener(this);
		l2.add(b1);
		
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		while(true)								//dipper
		{
			
			l1.setVisible(false);
			try
			{
				Thread.sleep(300);
			}
			catch(Exception e) {
			
			}
			l1.setVisible(true);
			try
			{
				Thread.sleep(2000);
			}
			catch(Exception e) {
			
			}
			
		}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new InventoryManagementSystem();
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1) {
			new Login().setVisible(true);
			this.setVisible(false);
		}
	}
	

}
