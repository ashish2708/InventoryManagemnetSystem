package ima;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;
public class SupplierInfo extends JFrame implements ActionListener{
	JTable t1;
	JButton b1,b2;
	SupplierInfo(){
		setBounds(400,200,700,550);
		setTitle("Supplier Details");
		JLabel l1=new JLabel("Supplier ID");
		l1.setBounds(5,5,100,20);
		add(l1);
		
		JLabel l2=new JLabel("Firm Name");
		l2.setBounds(120,5,100,20);
		add(l2);
		
		JLabel l3=new JLabel("Supplier Name");
		l3.setBounds(240,5,200,20);
		add(l3);
		
		JLabel l4=new JLabel("Address");
		l4.setBounds(360,5,200,20);
		add(l4);
		
		JLabel l5=new JLabel("Email");
		l5.setBounds(480,5,100,20);
		add(l5);
		
		JLabel l6=new JLabel("Contact Number");
		l6.setBounds(585,5,100,20);
		add(l6);
		
		
		t1=new JTable();
		t1.setBounds(0,30,700,450);
		add(t1);
		
		
		b1=new JButton("Load Data");
		b1.setBounds(150,480,100,30);
		b1.addActionListener(this);
		add(b1);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.white);
		b2=new JButton("Back");
		b2.setBounds(350,480,100,30);
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
		
		new SupplierInfo();
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==b1) {
			try {
			DatabaseConn c=new DatabaseConn();
			String q="select * from supplier";
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
