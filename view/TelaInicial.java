package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class TelaInicial extends JFrame {

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
	}
}
