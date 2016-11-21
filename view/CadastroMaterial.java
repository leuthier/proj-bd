package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.bean.Cliente;
import model.bean.Material;
import model.dao.MaterialDAO;

public class CadastroMaterial extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodMaterial;
	private JTextField txtDescricao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroMaterial frame = new CadastroMaterial();
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
	public CadastroMaterial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblTelaCadastroCliente = new JLabel("Tela Cadastro Material");
		lblTelaCadastroCliente.setBounds(10, 11, 414, 14);
		contentPane.add(lblTelaCadastroCliente);
		
		JLabel lblNome = new JLabel("Código");
		lblNome.setBounds(10, 36, 46, 14);
		contentPane.add(lblNome);
		
		txtCodMaterial = new JTextField();
		txtCodMaterial.setBounds(10, 54, 150, 20);
		contentPane.add(txtCodMaterial);
		txtCodMaterial.setColumns(10);
		
		JLabel lblEmail = new JLabel("Descrição");
		lblEmail.setBounds(10, 88, 60, 14);
		contentPane.add(lblEmail);
		
		txtDescricao = new JTextField();
		txtDescricao.setBounds(10, 104, 415, 20);
		contentPane.add(txtDescricao);
		txtDescricao.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(173, 227, 112, 23);
		contentPane.add(btnCadastrar);
		btnCadastrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Material material = new Material();
				MaterialDAO materialDAO = new MaterialDAO();
				String strCodMat = txtCodMaterial.getText();
				String strDescricao = txtDescricao.getText();
				if (tamanhoOk(material, strCodMat, strDescricao)){
					int codMat = 0;
					try{
						codMat = Integer.parseInt(strCodMat);
					}catch(NumberFormatException ex){
						JOptionPane.showMessageDialog(null,"CPF Invalido","Erro",JOptionPane.ERROR_MESSAGE);
						return;
					}			
					material.setCodMat(codMat);
					material.setDescricao(strDescricao);
					materialDAO.create(material);
					}else{
					JOptionPane.showMessageDialog(null,"- CPF deve conter 11 digitos\n- Telefone deve conter 9 digitos\n- Nome deve conter entre 3 e 101 caracteres"
							+ "\n- Email deve conter ate 51 caracteres","Erro",JOptionPane.ERROR_MESSAGE);
					return;
					}
				}
		});
	}
	
	private boolean tamanhoOk(Material material,String strCodMat, String strDescricao){		   
		  
		   if (strDescricao.length() <= 100){
			   			return true;	
			}else{
				 return false;
			}	
	   }

}


