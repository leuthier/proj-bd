package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;

public class CadastroCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeCli;
	private JTextField txtEmailCliente;
	private JTextField txtCpfCliente;
	private JTextField txtTelefoneCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroCliente frame = new CadastroCliente();
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
	public CadastroCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNomeCli = new JTextField();
		txtNomeCli.setBounds(10, 54, 237, 20);
		contentPane.add(txtNomeCli);
		txtNomeCli.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 36, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 88, 46, 14);
		contentPane.add(lblEmail);
		
		txtEmailCliente = new JTextField();
		txtEmailCliente.setBounds(10, 104, 237, 20);
		contentPane.add(txtEmailCliente);
		txtEmailCliente.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(257, 36, 46, 14);
		contentPane.add(lblCpf);
		
		txtCpfCliente = new JTextField();
		txtCpfCliente.setBounds(257, 54, 167, 20);
		contentPane.add(txtCpfCliente);
		txtCpfCliente.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(257, 88, 124, 14);
		contentPane.add(lblTelefone);
		
		txtTelefoneCliente = new JTextField();
		txtTelefoneCliente.setBounds(257, 104, 167, 20);
		contentPane.add(txtTelefoneCliente);
		txtTelefoneCliente.setColumns(10);
		
		JLabel lblTelaCadastroCliente = new JLabel("Tela Cadastro Cliente");
		lblTelaCadastroCliente.setBounds(10, 11, 414, 14);
		contentPane.add(lblTelaCadastroCliente);
	}
}
