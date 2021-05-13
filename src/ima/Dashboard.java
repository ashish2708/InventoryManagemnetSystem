package ima;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class Dashboard extends JFrame implements ActionListener {		
		JMenuBar mb;
		JMenu m1,m2,m4;
		JMenuItem i1,i2,i3,i4,i5,i6,i7,i11,i12,i13,i14,i15;
		JLabel imagelabel,welcomeLabel;
		Dashboard(){
			setTitle("Dashboard");
			setBounds(0,0,1800,1020);
			
			mb=new JMenuBar();
			add(mb);
			mb.setBounds(0, 0,1800, 50);
			
			m1=new JMenu("ADMIN");
			m1.setForeground(Color.red);
			m2=new JMenu("REPORT");
			m2.setForeground(Color.red);
		//	m3=new JMenu("LOGOUT");
			m4=new JMenu("CREATE VOUCHER");
			m4.setForeground(Color.red);
			mb.add(m1);
			mb.add(m4);
			mb.add(m2);
			//m3.setBounds(1500,0,10,10);
			//mb.add(m3);
		//	m3.setForeground(Color.red);
			//m3.addActionListener(this);
			
			i1=new JMenuItem("Add Customer");
			m1.add(i1);
			i1.addActionListener(this);
			
			i2=new JMenuItem("Add Supplier");
			m1.add(i2);
			i2.addActionListener(this);
			
			i3=new JMenuItem("Add Product");
			m1.add(i3);
			i3.addActionListener(this);
			
			i4=new JMenuItem("Add Category");
			m1.add(i4);
			i4.addActionListener(this);
			
			i5=new JMenuItem("Customer Info");
			m2.add(i5);
			i5.addActionListener(this);
			
			i6=new JMenuItem("Supplier Info");
			m2.add(i6);
			i6.addActionListener(this);
			
			i7=new JMenuItem("Current Stock");
			m2.add(i7);
			i7.addActionListener(this);
			
			i11=new JMenuItem("Purchase(IN)");
			m4.add(i11);
			i11.addActionListener(this);
			
			i12=new JMenuItem("Sale(out)");
			m4.add(i12);
			i12.addActionListener(this);
			
			i13=new JMenuItem("Purchse VoucherInfo");
			m2.add(i13);
			i13.addActionListener(this);
			
			i14=new JMenuItem("Sale VoucherInfo");
			m2.add(i14);
			i14.addActionListener(this);
			i15=new JMenuItem("Product To Order");
			m2.add(i15);
			i15.addActionListener(this);
			
			ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("2.jpg"));
			Image img2=img.getImage().getScaledInstance(1800, 1000,Image.SCALE_DEFAULT );
			ImageIcon img3=new ImageIcon(img2);
			imagelabel=new JLabel(img3);
			imagelabel.setBounds(0,0,1800,1000);
			add(imagelabel);
			
			welcomeLabel=new JLabel("WELCOME");
			welcomeLabel.setBounds(500,300,600,100);
			welcomeLabel.setFont(new Font("TimesRoman", Font.BOLD, 100));
			welcomeLabel.setForeground(Color.RED);
			imagelabel.add(welcomeLabel);
			
			setLayout(null);
			
			setVisible(true);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			
			

		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Dashboard();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getActionCommand()=="Add Customer") {
			new AddCustomer().setVisible(true);
		}
		else if(ae.getActionCommand()=="Add Supplier") {
			new AddSupplier();
		}
		else if(ae.getActionCommand()=="Add Product") {
			new AddProduct();
		}
		else if(ae.getActionCommand()=="Add Category") {
			new AddCategory();
		}
		else if(ae.getActionCommand()=="Purchase(IN)"){
			PurVou pv=new PurVou();
	        pv.frame.setVisible(true);
					
		}
		else if(ae.getActionCommand()=="Sale(out)") {
			new SaleVou().frame.setVisible(true);
		}
		else if(ae.getActionCommand()=="Current Stock") {
			new ProductInfo().setVisible(true);
		}
		else if(ae.getActionCommand()=="Customer Info") {
			new CustomerInfo().setVisible(true);;
		}
		else if(ae.getActionCommand()=="Supplier Info") {
			new SupplierInfo().setVisible(true);
		}
		else if(ae.getActionCommand()=="Purchse VoucherInfo") {
			new PurchaseVoucherInfo().setVisible(true);
		}
		else if(ae.getActionCommand()=="Sale VoucherInfo") {
			new SaleVouInfo().setVisible(true);
		}
		else if(ae.getActionCommand()=="Product To Order") {
			new ProductToOrder().setVisible(true);
		}
		
	}

}
