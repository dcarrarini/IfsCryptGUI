package it.ifsitalia.ifsCrypt.main;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import it.ifsitalia.ifsCrypt.IfsCrypt;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;


public class IfsCryptGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Stringa;
	private JTextField SecretKey;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IfsCryptGUI frame = new IfsCryptGUI();
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
	public IfsCryptGUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 435, 251);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		SecretKey = new JTextField();
		SecretKey.setBounds(82, 60, 320, 20);
		contentPane.add(SecretKey);
		SecretKey.setColumns(10);
		
		Stringa = new JTextField();
		Stringa.setBounds(82, 29, 320, 20);
		contentPane.add(Stringa);
		Stringa.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Secret Key");
		lblNewLabel.setBounds(15, 63, 67, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblStringa = new JLabel("Stringa");
		lblStringa.setBounds(15, 32, 67, 14);
		contentPane.add(lblStringa);
		
		textField = new JTextField();
		textField.setBounds(15, 160, 387, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		final JCheckBox checkDecripta = new JCheckBox("Decripta");
		final JCheckBox checkCripta = new JCheckBox("Cripta");
		checkCripta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkDecripta.setSelected(false);
			}
		});
		checkCripta.setBounds(15, 96, 195, 23);
		contentPane.add(checkCripta);
		
		
		checkDecripta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkCripta.setSelected(false);
			}
		});
		checkDecripta.setBounds(212, 96, 190, 23);
		contentPane.add(checkDecripta);
		
		JButton btnNewButton = new JButton("Esegui");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String secretKey = SecretKey.getText();
				if (secretKey.length()<=0) {
					secretKey = "bPeShVmYq3t6w9z$B&E)H@McQfTjWnZr";
			     }
				if (checkCripta.isSelected()) {
					textField.setText(IfsCrypt.encrypt(Stringa.getText(), secretKey));
				}
				if(checkDecripta.isSelected()) {
					textField.setText(IfsCrypt.decrypt(Stringa.getText(), secretKey));
				}
			}
		});
		btnNewButton.setBounds(15, 126, 387, 23);
		contentPane.add(btnNewButton);
	}
}
