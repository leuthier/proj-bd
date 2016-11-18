package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import model.bean.Cliente;
import model.dao.ClienteDAO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class CadastroCliente extends JFrame {

	/**
	 * dava erro se nao gerasse isso 
	 */
	private static final long serialVersionUID = 1L;
	
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
		txtCpfCliente.setText("00000000000");
		txtCpfCliente.setToolTipText("");
		txtCpfCliente.setBounds(257, 54, 167, 20);
		contentPane.add(txtCpfCliente);
		txtCpfCliente.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(257, 88, 124, 14);
		contentPane.add(lblTelefone);
		
		txtTelefoneCliente = new JTextField();
		txtTelefoneCliente.setText("999999999");
		txtTelefoneCliente.setBounds(257, 104, 167, 20);
		contentPane.add(txtTelefoneCliente);
		txtTelefoneCliente.setColumns(10);
		
		JLabel lblTelaCadastroCliente = new JLabel("Tela Cadastro Cliente");
		lblTelaCadastroCliente.setBounds(10, 11, 414, 14);
		contentPane.add(lblTelaCadastroCliente);
		
		//BOTAO CADASTRAR + AÇÃO
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Cliente cliente = new Cliente();
				ClienteDAO clienteDAO = new ClienteDAO();
				
				String strCpf = txtCpfCliente.getText();
				
				String strTelefone = txtTelefoneCliente.getText();
				String nomeCliente = (txtNomeCli.getText());
				String email = (txtEmailCliente.getText());
				if (tamanhoOk(cliente, strCpf, strTelefone, nomeCliente, email)){
					int cpf = 0;
					int telefone = 0;
					try{
						cpf = Integer.parseInt(strCpf);
					}catch(NumberFormatException ex){
						JOptionPane.showMessageDialog(null,"CPF Invalido","Erro",JOptionPane.ERROR_MESSAGE);
						return;
					}
					try{
						telefone = Integer.parseInt(strTelefone);
					}catch(NumberFormatException ex){
						JOptionPane.showMessageDialog(null,"Telefone Invalido","Erro",JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					if ((isValidEmailAddress(email)) != true ){
						JOptionPane.showMessageDialog(null,"Email Invalido","Erro",JOptionPane.ERROR_MESSAGE);
						return;
					}else{
						cliente.setEmail(email);
					}
					
					if ((Character.isLetter(nomeCliente.charAt(0))) != true ){
						JOptionPane.showMessageDialog(null,"Nome Invalido","Erro",JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					cliente.setCpf(cpf);
					cliente.setTelefone(telefone);
					cliente.setNomeCli(nomeCliente);
					clienteDAO.create(cliente);
				}else{
					JOptionPane.showMessageDialog(null,"- CPF deve conter 11 digitos\n- Telefone deve conter 9 digitos\n- Nome deve conter entre 3 e 101 caracteres"
							+ "\n- Email deve conter ate 51 caracteres","Erro",JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
		
		});
		btnCadastrar.setBounds(173, 227, 112, 23);
		contentPane.add(btnCadastrar);
	}
	
	   private boolean isValidEmailAddress(String email){
           String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
           java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
           java.util.regex.Matcher m = p.matcher(email);
           return m.matches();
	   }
	   
	   private boolean tamanhoOk(Cliente cliente,String strCpf, String strTelefone, String nomeCliente, String email){		   
			  
		   if ( (strCpf.length()) == 11
				   && (strTelefone.length()) == 9 
				   && ( (nomeCliente.length()) < 101 && (nomeCliente.length()) > 3 )
				   && ( (email.length()) < 51) ){
			   			return true;	
			}else{
				 return false;
			}	
	   }
	
}
