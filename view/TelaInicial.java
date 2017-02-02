package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class TelaInicial extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JButton btnListar;
	private JButton btnRemover;
	private JButton btnAlterar;

	/**
	 * Launch the application.
	 */
		
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
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
	public TelaInicial() {
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroCliente cadastroCliente = new CadastroCliente();
				cadastroCliente.abrirCadastroCliente();
			}
		});
		btnCadastrar.setBounds(73, 92, 299, 23);
		contentPane.add(btnCadastrar);
		
		JLabel lblAlunos = new JLabel("Projeto Fundamento de Banco de Dados - 2016.2");
		lblAlunos.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlunos.setBounds(39, 32, 354, 14);
		contentPane.add(lblAlunos);
		
		btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarCliente listarCliente = new ListarCliente();
				listarCliente.abrirListaClientes();
			}
		});
		btnListar.setBounds(73, 124, 299, 23);
		contentPane.add(btnListar);
		
		btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRemover.setBounds(73, 187, 299, 23);
		contentPane.add(btnRemover);
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(73, 153, 299, 23);
		contentPane.add(btnAlterar);
				
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				Object[] options = { "Sim", "Não" };
				int i = JOptionPane.showOptionDialog(null,
						"Tem certeza que deseja sair?", "Saída",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
						options, options[0]);
				if (i == JOptionPane.YES_OPTION) {
					System.exit(0);
				} else {
					repaint();
				}
			}
		});
	}
	public void abrirTelaInicial() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
//	private void formFrameClosing(javax.swing.event.InternalFrameEvent evt) { 
//		this.fechar(null); 
//	} 
	
//	jFrame.addWindowListener(new java.awt.event.WindowAdapter() {
//		public void windowClosing(java.awt.event.WindowEvent e) {
//			if (e.getID() == WindowEvent.WINDOW_CLOSING){
//				int selectedOption = JOptionPane.showConfirmDialog(null,"Deseja Sair Realmente?", "Sistema informa:", JOptionPane.YES_NO_OPTION);
//if(selectedOption == JOptionPane.YES_OPTION){
//	  	                	
//}	
//			}	
//		}
	
//	private void fechar(java.awt.event.WindowEvent e){
//		if (e.getID() == WindowEvent.WINDOW_CLOSING){
//			if(javax.swing.JOptionPane.showConfirmDialog(null,"Deseja Fechar?","ATENÇÃO ",javax.swing.JOptionPane.YES_NO_OPTION )==0){
//				System.exit(0);
//			}
//		}
//	}
	
	
	
}
