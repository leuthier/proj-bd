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

public class TelaInicial extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;

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
		
		JButton btnIniciarProjeto = new JButton("Iniciar Projeto");
		btnIniciarProjeto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Nome: " + txtNome.getText() );
			}
		});
		btnIniciarProjeto.setBounds(162, 184, 129, 23);
		contentPane.add(btnIniciarProjeto);
		
		JLabel lblAlunos = new JLabel("Alunos:");
		lblAlunos.setBounds(39, 23, 46, 14);
		contentPane.add(lblAlunos);
		
		txtNome = new JTextField();
		txtNome.setBounds(90, 20, 86, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
	}
}
