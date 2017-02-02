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


public class CadastroCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField txtNomeCli;
	private JTextField txtEmailCliente;
	private JTextField txtCpfCliente;
	private JTextField txtTelefoneCliente;

	/**
	 * Launch the application.
	 */
	public void abrirCadastroCliente() {
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
		txtCpfCliente.setToolTipText("Deve conter apenas números");
		txtCpfCliente.setBounds(257, 54, 167, 20);
		contentPane.add(txtCpfCliente);
		txtCpfCliente.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(257, 88, 124, 14);
		contentPane.add(lblTelefone);
		
		txtTelefoneCliente = new JTextField();
		txtTelefoneCliente.setText("81999999999");
		txtTelefoneCliente.setToolTipText("Deve conter apenas números. DDD+Número");
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
				String telefone = txtTelefoneCliente.getText();
				String nomeCliente = (txtNomeCli.getText());
				String email = (txtEmailCliente.getText());
				
				if (tamanhoOk(telefone, nomeCliente, email)){
					Long cpf;
					try{
						cpf = Long.parseLong(strCpf);
						//cpf = Long.valueOf(strCpf).longValue();
					}catch(NumberFormatException ex){
						JOptionPane.showMessageDialog(null,"CPF Invalido","Erro",JOptionPane.ERROR_MESSAGE);
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
					JOptionPane.showMessageDialog(null,"- CPF deve conter 11 digitos\n- Telefone deve conter 11 digitos\n- Nome deve conter entre 3 e 101 caracteres"
							+ "\n- Email deve conter ate 51 caracteres","Erro",JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
		
		});
		btnCadastrar.setBounds(229, 227, 112, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicial telaInicial = new TelaInicial();
				telaInicial.abrirTelaInicial();
			}
		});
		btnVoltar.setBounds(104, 227, 89, 23);
		contentPane.add(btnVoltar);
	}
	
	   private boolean isValidEmailAddress(String email){
           String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
           java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
           java.util.regex.Matcher m = p.matcher(email);
           return m.matches();
	   }
	   
	   private boolean tamanhoOk(String telefone, String nomeCliente, String email){		   
			  
		   if (    (telefone.length()) == 11 
				   && ( (nomeCliente.length()) < 101 && (nomeCliente.length()) > 3 )
				   && ( (email.length()) < 51) ){
			   			return true;	
			}else{
				 return false;
			}	
	   }
	   
	// retirado de: https://www.vivaolinux.com.br/script/Codigo-para-validar-CPF-e-CNPJ-otimizado
	   private static final int[] pesoCPF = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
	   private static int calcularDigito(String str, int[] peso) {
	      int soma = 0;
	      
	      for (int indice=str.length()-1, digito; indice >= 0; indice-- ) {
	         digito = Integer.parseInt(str.substring(indice,indice+1));
	         soma += digito*peso[peso.length-str.length()+indice];
	      }
	      
	      soma = 11 - soma % 11;
	      return soma > 9 ? 0 : soma;
	      
	   }

	   
	   public static boolean isValidCPF(String cpf) {
		   
	      if ((cpf==null) || (cpf.length()!=11)){
	    	  return false;
	      }

	      Integer digito1 = calcularDigito(cpf.substring(0,9), pesoCPF);
	      Integer digito2 = calcularDigito(cpf.substring(0,9) + digito1, pesoCPF);
	      return cpf.equals(cpf.substring(0,9) + digito1.toString() + digito2.toString());
	  
	   }
}
