package ima;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.JSeparator;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.awt.List;
import javax.swing.JComboBox;
import java.awt.Choice;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SaleVou {

	JFrame frame;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField;
	private JTextField textField_9;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SaleVou window = new SaleVou();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SaleVou() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.ORANGE);
		frame.setBounds(100, 100, 1071, 569);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Sale Voucher");
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 40));
		lblNewLabel_1.setBounds(258, 10, 437, 54);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Customer Name");
		lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel_2.setBounds(10, 85, 135, 35);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("ID");
		lblNewLabel_3.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel_3.setBounds(478, 85, 30, 35);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(530, 87, 107, 36);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Address");
		lblNewLabel_4.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel_4.setBounds(647, 85, 75, 35);
		frame.getContentPane().add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(732, 88, 186, 33);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("DATE");
		lblNewLabel_5.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(705, 10, 67, 24);
		frame.getContentPane().add(lblNewLabel_5);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_3.setBounds(797, 13, 121, 24);
		Date d=new Date();
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
		textField_3.setText(sf.format(d));
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Product Details");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_6.setBounds(10, 130, 135, 24);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Product Category");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_7.setBounds(10, 174, 135, 33);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Product Name");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_8.setBounds(407, 174, 117, 33);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("MRP");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_9.setBounds(273, 215, 43, 33);
		frame.getContentPane().add(lblNewLabel_9);
		
		textField_6 = new JTextField();				//mrp
		textField_6.setEditable(false);
		textField_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_6.setBounds(312, 217, 90, 33);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Quantity");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_10.setBounds(585, 215, 90, 33);
		frame.getContentPane().add(lblNewLabel_10);
		
		textField_7 = new JTextField();	//qty
		textField_7.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_7.setBounds(667, 217, 128, 33);
		frame.getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Voucher Number");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_11.setBounds(651, 40, 157, 37);
		frame.getContentPane().add(lblNewLabel_11);
		
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setBackground(Color.WHITE);
		textField_8.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_8.setBounds(797, 45, 121, 24);
		int vno=0;
		String q10="select max(svno) from salevoucher";
		try {
				DatabaseConn c=new DatabaseConn();
				ResultSet rs=c.s.executeQuery(q10);
				rs.next();
				vno=rs.getInt("max(svno)");
				vno=vno+1;
				textField_8.setText(Integer.toString(vno));
				
		}
		catch(Exception ae){
			System.out.println(ae);
			JOptionPane.showMessageDialog(null, ae);
		}
		frame.getContentPane().add(textField_8);
		textField_8.setColumns(10);
		
		Choice choice = new Choice();
			
		choice.setFont(new Font("Dialog", Font.BOLD, 15));
		choice.setBounds(150, 85, 166, 35);
		try {
			DatabaseConn c=new DatabaseConn();
			String q1="Select firmname from customer";
			ResultSet rs=c.s.executeQuery(q1);
			while(rs.next()) {
				choice.add(rs.getString("firmname"));
			}
			
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
		frame.getContentPane().add(choice);
		
		JLabel lblNewLabel_12 = new JLabel("Product Id");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_12.setBounds(10, 227, 121, 24);
		frame.getContentPane().add(lblNewLabel_12);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(113, 220, 139, 28);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_13 = new JLabel("Stock");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_13.setBounds(407, 217, 66, 31);
		frame.getContentPane().add(lblNewLabel_13);
		
		textField_9 = new JTextField();
		textField_9.setEditable(false);
		textField_9.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_9.setBounds(458, 219, 107, 29);
		frame.getContentPane().add(textField_9);
		textField_9.setColumns(10);
		Choice choice_1 = new Choice();
		choice_1.setFont(new Font("Dialog", Font.BOLD, 15));
		
		choice_1.setBounds(143, 181, 131, 26);
		frame.getContentPane().add(choice_1);
		
		Choice choice_2 = new Choice();
		choice_2.setFont(new Font("Dialog", Font.BOLD, 15));
		choice_2.setBounds(530, 174, 296, 25);
		try {
			DatabaseConn c=new DatabaseConn();
			String q1="Select catcode from category";
			ResultSet rs=c.s.executeQuery(q1);
			while(rs.next()) {
				choice_1.add(rs.getString("catcode"));
			}
			
			
			JButton btnNewButton_7 = new JButton("Get");
			btnNewButton_7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						ResultSet rs=c.s.executeQuery(q1);
						String cat=choice_1.getSelectedItem();
						choice_2.removeAll();
						String q2="select pname from product where catcode='"+cat+"'";
						System.out.println(q2);
						ResultSet rs1=c.s.executeQuery(q2);
						while(rs1.next()) {
							choice_2.add(rs1.getString("pname"));
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				}
			});
			btnNewButton_7.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnNewButton_7.setBounds(293, 178, 98, 29);
			frame.getContentPane().add(btnNewButton_7);
			/*JButton btnNewButton_6 = new JButton("Get");
			btnNewButton_6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						ResultSet rs=c.s.executeQuery(q1);
						String cat=choice_1.getSelectedItem();
						choice_2.removeAll();
						String q2="select pname from product where catcode='"+cat+"'";
						System.out.println(q2);
						ResultSet rs1=c.s.executeQuery(q2);
						while(rs1.next()) {
							choice_2.add(rs1.getString("pname"));
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						
					}
				
				}
			});*/
			
			String cat=choice_1.getSelectedItem();
		
			String q2="select pname from product where catcode='"+cat+"'";
			ResultSet rs1=c.s.executeQuery(q2);
			while(rs1.next()) {
				choice_2.add(rs1.getString("pname"));
			}
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			
		}

		
		JButton btnNewButton_1 = new JButton("FETCH");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DatabaseConn c=new DatabaseConn();
					
					String q1="Select pid,mrp,quantity from product where catcode='"+choice_1.getSelectedItem()+"' and pname='"+choice_2.getSelectedItem()+"'";
					ResultSet rs=c.s.executeQuery(q1);
					rs.next();
					textField.setText(rs.getString("pid"));
					textField_6.setText(rs.getString("mrp"));
					textField_9.setText(rs.getString("quantity"));
					
					
					
					
				}
				catch(Exception e1)
				{
					System.out.println(e1);
					JOptionPane.showMessageDialog(null, e1);
				}
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(842, 170, 90, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("GET");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					DatabaseConn c=new DatabaseConn();
					String s1=choice.getSelectedItem();
					
					String q="Select id , address from customer where firmname='"+s1+"'";
					ResultSet rs1=c.s.executeQuery(q);
					rs1.next();
					textField_1.setText(rs1.getString("id"));
					textField_2.setText(rs1.getString("address"));
					}
					catch(Exception ae) {
						System.out.println(ae);
						JOptionPane.showMessageDialog(null, ae);
					}
				}
			
		});
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"PRODUCT ID", "PRODUCT NAME", "MRP", "Quantity"},
			},
			new String[] {
				"Product ID", "Product Name", "MRP", "Quantity"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, String.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(1).setPreferredWidth(212);
		table.getColumnModel().getColumn(3).setPreferredWidth(98);
		table.setBounds(10, 314, 610, 208);
		frame.getContentPane().add(table);
		
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2.setBounds(323, 74, 85, 46);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int stk=Integer.parseInt(textField_9.getText());
				int qty=Integer.parseInt(textField_7.getText());
				if(qty<stk) {
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				model.addRow(new Object[] {textField.getText(),choice_2.getSelectedItem(),textField_6.getText(),textField_7.getText()});
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Quantity Exceed Stock");
				}
			}
		});
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(823, 228, 121, 24);
		frame.getContentPane().add(btnNewButton);
		
				frame.getContentPane().add(choice_2);
				
				JButton btnNewButton_3 = new JButton("RESET");
				btnNewButton_3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame.setVisible(false);
						SaleVou window = new SaleVou();
						window.frame.setVisible(true);
					}
				});
				btnNewButton_3.setBackground(Color.BLUE);
				btnNewButton_3.setForeground(Color.RED);
				btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 25));
				btnNewButton_3.setBounds(630, 313, 157, 83);
				frame.getContentPane().add(btnNewButton_3);
				
				JButton btnNewButton_4 = new JButton("CLOSE");
				btnNewButton_4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame.setVisible(false);
					}
				});
				btnNewButton_4.setBackground(Color.BLUE);
				btnNewButton_4.setForeground(Color.RED);
				btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 25));
				btnNewButton_4.setBounds(823, 314, 139, 83);
				frame.getContentPane().add(btnNewButton_4);
				
				JButton btnNewButton_5 = new JButton("SAVE");
				btnNewButton_5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						DatabaseConn c=new DatabaseConn();
						for(int i=1;i<table.getRowCount();i++) {
							String ProductId=table.getValueAt(i,0).toString();
							String ProductQty=table.getValueAt(i,3).toString();
							String query="call sale_procedure("+textField_8.getText()+","+textField_1.getText()+",'"+ProductId+"',"+ProductQty+",'"+textField_3.getText()+"')";
							//System.out.println(query);
							try {
								ResultSet rs=c.s.executeQuery(query);
								JOptionPane.showMessageDialog(null, "Sale Voucher Created");
								frame.setVisible(false);
								SaleVou window = new SaleVou();
								window.frame.setVisible(true);
								
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								//e1.printStackTrace();
								System.out.println(e1);
								JOptionPane.showMessageDialog(null, e1);
							}
						}
						
					}
				});
				btnNewButton_5.setBackground(Color.BLUE);
				btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 50));
				btnNewButton_5.setForeground(Color.GREEN);
				btnNewButton_5.setBounds(630, 418, 332, 104);
				frame.getContentPane().add(btnNewButton_5);
				
				
				
				
	}
}
