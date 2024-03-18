
package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class ViewConversor {

	private JFrame frame;
	private JTextField txtValor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewConversor window = new ViewConversor();
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
	public ViewConversor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Conversor de Moedas");
		lblNewLabel.setBounds(0, 0, 434, 50);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBackground(SystemColor.textHighlight);
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 20));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Insira um Valor");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(39, 78, 116, 19);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("De");
		lblNewLabel_2.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(39, 124, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Para");
		lblNewLabel_3.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(39, 173, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		txtValor = new JTextField();
		txtValor.setBounds(154, 77, 195, 22);
		frame.getContentPane().add(txtValor);
		txtValor.setColumns(10);
		
		JComboBox txtDe = new JComboBox();
		txtDe.setModel(new DefaultComboBoxModel(new String[] {"USD"}));
		txtDe.setBounds(154, 121, 195, 22);
		frame.getContentPane().add(txtDe);
		
		JComboBox txtPara = new JComboBox();
		txtPara.setModel(new DefaultComboBoxModel(new String[] {"real brasileiro", "euro"}));
		txtPara.setBounds(154, 170, 195, 22);
		frame.getContentPane().add(txtPara);
		
		JPanel panel = new JPanel();
		panel.setBounds(21, 61, 403, 155);
		frame.getContentPane().add(panel);
		
		JButton btnNewButton = new JButton("Converte");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				double enter;
				
				double valor = Double.parseDouble(txtValor.getText());
				
				if (txtDe.getSelectedItem().toString() == "USD" && txtPara.getSelectedItem().toString() == "real brasileiro")
					
				{
					enter = valor * 4.98;
					
					JOptionPane.showMessageDialog(null, "seu valor está aqui " + String.valueOf(enter));
				}
				
				else  if (txtDe.getSelectedItem().toString() == "USD" && txtPara.getSelectedItem().toString() == "euro")
				{
					enter = valor * 0.92;
					
					JOptionPane.showMessageDialog(null, "seu valor está aqui " + String.valueOf(enter));
				}
				
			}
			
		});
		btnNewButton.setBounds(190, 227, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
