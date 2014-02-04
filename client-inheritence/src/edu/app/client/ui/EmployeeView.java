package edu.app.client.ui;

import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import edu.app.client.delegate.AuthenticationServiceDelegate;
import edu.app.entity.Employee;
import edu.app.entity.User;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import org.jdesktop.beansbinding.ObjectProperty;
import org.jdesktop.beansbinding.ELProperty;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class EmployeeView extends JFrame {
	
	private User user;
	private List<Employee> employees;
	private Employee selectedEmployee;

	private JPanel contentPane;
	private JTable employeesTable;
	private JTextField idField;
	private JTextField loginField;
	private JTextField passwordField;
	private JTextField emailField;
	private JPanel detailsPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeView frame = new EmployeeView(new Employee("dev", "star","dev@ghost.com"));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param user 
	 */
	public EmployeeView(User user) {
		this.user = user;
		this.employees = ObservableCollections.observableList(AuthenticationServiceDelegate.findAllEmployee());
		this.selectedEmployee = new Employee();
		setTitle("Employee View");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel welcomeLabel = new JLabel("");
		welcomeLabel.setText("welcome "+user.getLogin()+" your email is "+((Employee)user).getEmail());
		
		JPanel employeePanel = new JPanel();
		employeePanel.setBorder(new TitledBorder(null, "employees", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		detailsPanel = new JPanel();
		detailsPanel.setBorder(new TitledBorder(null, "employee details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(employeePanel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
						.addComponent(detailsPanel, GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
						.addComponent(welcomeLabel))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(welcomeLabel)
					.addGap(3)
					.addComponent(employeePanel, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(detailsPanel, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(41, Short.MAX_VALUE))
		);
		
		JLabel idLabel = new JLabel("id");
		
		JLabel loginLabel = new JLabel("login");
		
		JLabel passwordLabel = new JLabel("password");
		
		JLabel emailLabel = new JLabel("email");
		
		idField = new JTextField();
		idField.setColumns(10);
		
		loginField = new JTextField();
		loginField.setColumns(10);
		
		passwordField = new JTextField();
		passwordField.setColumns(10);
		
		emailField = new JTextField();
		emailField.setColumns(10);
		GroupLayout gl_detailsPanel = new GroupLayout(detailsPanel);
		gl_detailsPanel.setHorizontalGroup(
			gl_detailsPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_detailsPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_detailsPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(loginLabel)
						.addComponent(passwordLabel)
						.addComponent(emailLabel)
						.addComponent(idLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_detailsPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(idField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
						.addComponent(emailField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
						.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
						.addComponent(loginField, GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_detailsPanel.setVerticalGroup(
			gl_detailsPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_detailsPanel.createSequentialGroup()
					.addGroup(gl_detailsPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(idLabel)
						.addComponent(idField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_detailsPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(loginLabel)
						.addComponent(loginField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_detailsPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordLabel)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_detailsPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(emailLabel)
						.addComponent(emailField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(35, Short.MAX_VALUE))
		);
		detailsPanel.setLayout(gl_detailsPanel);
		
		JScrollPane employeeScrollPane = new JScrollPane();
		GroupLayout gl_employeePanel = new GroupLayout(employeePanel);
		gl_employeePanel.setHorizontalGroup(
			gl_employeePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_employeePanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(employeeScrollPane, GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_employeePanel.setVerticalGroup(
			gl_employeePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_employeePanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(employeeScrollPane, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(65, Short.MAX_VALUE))
		);
		
		employeesTable = new JTable();
		employeeScrollPane.setViewportView(employeesTable);
		employeePanel.setLayout(gl_employeePanel);
		contentPane.setLayout(gl_contentPane);
		initDataBindings();
		resetTextFields();
		
	}

	private void resetTextFields() {
		idField.setText("");
		loginField.setText("");
		passwordField.setText("");
		emailField.setText("");
	}

	private void openTextFieldsForEdition(boolean state) {
		idField.setEnabled(state);
		loginField.setEnabled(state);
		passwordField.setEnabled(state);
		emailField.setEnabled(state);
	}
	protected void initDataBindings() {
	}
}
