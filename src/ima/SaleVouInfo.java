package ima;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.proteanit.sql.DbUtils;
public class SaleVouInfo extends JFrame implements ActionListener{
	JTable t1;
	JTextField vno,sid,date;
	JButton b1,b2,b3;
	SaleVouInfo(){
		setTitle("Sale Voucher Details");
		setBounds(500,200,500,550);
		
		
		
		JLabel l1=new JLabel("Voucher no.");
		l1.setBounds(20,30,100,30);
		add(l1);
		
		vno=new JTextField();
		vno.setBounds(100, 30, 60, 30);
		add(vno);
		
		JLabel l2=new JLabel("Customer ID");
		l2.setBounds(20,80,100,20);
		add(l2);
		sid=new JTextField();
		sid.setBounds(100, 80, 100, 20);
		add(sid);
		
		JLabel l3=new JLabel("Date");
		l3.setBounds(270,80,100,20);
		add(l3);
		date=new JTextField();
		date.setBounds(310, 80, 100, 20);
		add(date);
		
		
		JLabel l4=new JLabel("Product ID");
		l4.setBounds(20,110,200,20);
		add(l4);
		
		JLabel l5=new JLabel("Quantity");
		l5.setBounds(300,110,200,20);
		add(l5);
		
		
		t1=new JTable();
		t1.setBounds(10,140,500,300);
		add(t1);
		
		
		b1=new JButton("Load Data");
		b1.setBounds(200,30,100,30);
		b1.addActionListener(this);
		add(b1);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.white);
		b2=new JButton("Back");
		b2.setBounds(350,30,100,30);
		add(b2);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.white);
		b2.addActionListener(this);
		
		b3=new JButton("Delete");
		b3.setBounds(180,450,100,30);
		add(b3);
		b3.setBackground(Color.red);
		b3.setForeground(Color.white);
		b3.addActionListener(this);
		
		
		setLayout(null);
		setVisible(true);
		
		getContentPane().setBackground(Color.white);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new SaleVouInfo();
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		String Vno=vno.getText();
		DatabaseConn c=new DatabaseConn();
		if(ae.getSource()==b1) {
			
			try {			
			String q="select * from salevoucher where svno="+Vno;
			ResultSet rs=c.s.executeQuery(q);
			rs.next();
			sid.setText(rs.getString("cid"));
			date.setText(rs.getString("sv_date"));
			String q2="select pid,quantity from salevoucher where svno="+Vno;
			ResultSet rs1=c.s.executeQuery(q2);
			t1.setModel(DbUtils.resultSetToTableModel(rs1));
			
			}
			catch (Exception e) {
				System.out.println(e);
				JOptionPane.showMessageDialog(null, "Invalid Voucher Number");
			}
			
		}
		if(ae.getSource()==b3) {
			String q3="delete from salevoucher where svno="+Vno;
			try {
				c.s.execute(q3);
				JOptionPane.showMessageDialog(null, "Voucher Deleted Successfully");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Failed");
			}
			this.setVisible(false);
			new SaleVouInfo();
			
		}
		else if(ae.getSource()==b2) {
			this.setVisible(false);
		}
	}

}
