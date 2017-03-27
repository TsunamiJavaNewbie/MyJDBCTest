package com.LeeTs.frame;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.LeeTs.dao.impl.AdminDaoImpl;

public class Admin_Login {

	private JFrame frame;
	private JTextField AdminIDtextField;
	private JPasswordField AdminIDpasswordField;
	AdminDaoImpl adi = null;
	static Admin_Login window = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new Admin_Login();
					window.frame.setVisible(true);
					window.frame.setTitle("管 理 员 登 录");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Admin_Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 445, 327);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		AdminIDtextField = new JTextField();
		AdminIDtextField.setBounds(132, 67, 217, 24);
		frame.getContentPane().add(AdminIDtextField);
		AdminIDtextField.setColumns(10);

		AdminIDpasswordField = new JPasswordField();
		AdminIDpasswordField.setBounds(132, 115, 217, 24);
		frame.getContentPane().add(AdminIDpasswordField);

		JButton LoginButton = new JButton("登 录");
		LoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adi = new AdminDaoImpl();
				String username = AdminIDtextField.getText();
				char[] pass = AdminIDpasswordField.getPassword();
				String password = new String(pass);
				if (password
						.equals(adi.QueryByUsername(username).getPassword())) {
					// 登陆后关闭登录窗口
					window.frame.dispose();
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
					System.out.println("登录成功！");
				} else {
					JOptionPane.showMessageDialog(null, "请输入正确的密码");
					System.out.println("登录失败！");
				}
			}
		});
		LoginButton.setBounds(70, 180, 113, 27);
		frame.getContentPane().add(LoginButton);

		JButton ResetButton = new JButton("重 置");
		ResetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminIDtextField.setText("");
				AdminIDpasswordField.setText("");
			}
		});
		ResetButton.setBounds(212, 180, 113, 27);
		frame.getContentPane().add(ResetButton);

		JLabel lblNewLabel = new JLabel("账 号 ：");
		lblNewLabel.setBounds(28, 70, 72, 18);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("密 码 ：");
		lblNewLabel_1.setBounds(28, 118, 72, 18);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
