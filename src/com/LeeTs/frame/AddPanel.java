package com.LeeTs.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.LeeTs.dao.IDeptDao;
import com.LeeTs.dao.IUserDao;
import com.LeeTs.dao.impl.DeptDaoImpl;
import com.LeeTs.dao.impl.UserDaoImpl;
import com.LeeTs.entity.Dept;
import com.LeeTs.entity.User;

@SuppressWarnings("serial")
public class AddPanel extends JPanel {
	private JTextField txtName;
	private JTextField txtBirth;
	@SuppressWarnings("rawtypes")
	private JComboBox cmbDept;
	private IUserDao userDao;
	private IDeptDao deptDao;

	/**
	 * Create the panel.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public AddPanel() {
		setLayout(null);

		JLabel label = new JLabel("用户名：");
		label.setBounds(86, 68, 54, 15);
		add(label);

		txtName = new JTextField();
		txtName.setBounds(150, 65, 146, 18);
		add(txtName);
		txtName.setColumns(10);

		JLabel label_1 = new JLabel("部门：");
		label_1.setBounds(86, 114, 54, 15);
		add(label_1);

		userDao = new UserDaoImpl();
		deptDao = new DeptDaoImpl();
		List<Dept> list = deptDao.queryAll();

		cmbDept = new JComboBox(list.toArray());
		cmbDept.setBounds(150, 110, 146, 23);
		add(cmbDept);

		JLabel label_2 = new JLabel("生日：");
		label_2.setBounds(86, 163, 54, 15);
		add(label_2);

		txtBirth = new JTextField();
		txtBirth.setBounds(150, 160, 146, 23);
		add(txtBirth);
		txtBirth.setColumns(10);

		JButton btnNewButton = new JButton("添加用户");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = txtName.getText();
				String birth = txtBirth.getText();
				Dept dept = (Dept) cmbDept.getSelectedItem();
				User user = new User();
				user.setBirth(birth);
				user.setName(name);
				user.setDeptid(dept.getDeptid());
				if (userDao.add(user)) {
					JOptionPane.showMessageDialog(null, "插入成功");
					txtName.setText("");
					txtBirth.setText("");

				} else {
					JOptionPane.showMessageDialog(null, "插入失败");
				}

			}
		});
		btnNewButton.setBounds(150, 217, 116, 23);
		add(btnNewButton);

	}
}
