package Pages;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Helper.DBConnection;
import Helper.Constant;
import PopUpAlert.SadFaceAlert;

import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmail;
	private JPasswordField txtPassword;
	private SadFaceAlert sd = new SadFaceAlert();
	private Constant cons = new Constant();
	//DB
	
	public Connection conn = null;
	public ResultSet rs;
	public Statement st;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 585, 363);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 139, 139));
		panel.setBounds(0, 0, 585, 72);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Java Login");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel, BorderLayout.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("Email :");
		lblNewLabel_1.setBounds(92, 131, 42, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password :");
		lblNewLabel_2.setBounds(92, 174, 67, 16);
		contentPane.add(lblNewLabel_2);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(178, 126, 311, 26);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					conn = DBConnection.getConnection();
					st = (Statement) conn.createStatement();
				//	String email = txtEmail.getText().toString();
					String password = txtPassword.getText().toString();
					rs = st.executeQuery("select * from FinanceSoftware.tblLogin where  password ='"
						+ password + "';");
					if (rs.next()) {
						System.out.println("ok");
					}  else {
						
						sd.setBounds(200, 140,403, 256);
						sd.lblTitle.setText("Fail!");
						sd.lblMessage.setText(cons.kmsgWrongEmailPassword);
						sd.setUndecorated(true);
						sd.setModal(true);
						sd.setVisible(true);  
					}
				} catch (Exception ee) {
					sd.setBounds(200, 140, 403, 256);
					sd.lblTitle.setText("Fail!");
					sd.lblMessage.setText("Please start mysql database.");
					sd.setUndecorated(true);
					//sd.setLocationRelativeTo(contentPane);
			        sd.setModal(true);
					sd.setVisible(true);
					System.out.println(ee.getMessage());
				}
				
				
				
			}
		});
		btnLogin.setBounds(216, 211, 117, 29);
		contentPane.add(btnLogin);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnClose.setBounds(345, 211, 117, 29);
		contentPane.add(btnClose);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(178, 169, 311, 26);
		contentPane.add(txtPassword);
	}
}
