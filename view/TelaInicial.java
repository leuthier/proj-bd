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
	private JButton btnSmartphone;
	private JButton btnReparo;
	private JButton btnMaterial;

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
		
		JButton btnClientes = new JButton("Clientes");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCliente telaCliente = new TelaCliente();
				telaCliente.abrirTelaCliente();
			}
		});
		btnClientes.setBounds(73, 93, 299, 23);
		contentPane.add(btnClientes);
		
		JLabel lblAlunos = new JLabel("Projeto Fundamento de Banco de Dados - 2016.2");
		lblAlunos.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlunos.setBounds(39, 32, 354, 14);
		contentPane.add(lblAlunos);
		
		btnSmartphone = new JButton("Smartphone");
		btnSmartphone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaSmartphone telaSmartphone = new TelaSmartphone();
				telaSmartphone.abrirTelaSmartphone();
			}
		});
		btnSmartphone.setBounds(73, 124, 299, 23);
		contentPane.add(btnSmartphone);
		
		btnReparo = new JButton("Reparo");
		btnReparo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaReparo telaReparo = new TelaReparo();
				telaReparo.abrirTelaReparo();
			}
		});
		btnReparo.setBounds(73, 183, 299, 23);
		contentPane.add(btnReparo);
		
		btnMaterial = new JButton("Material");
		btnMaterial.setBounds(73, 153, 299, 23);
		btnMaterial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMaterial telaMaterial = new TelaMaterial();
				telaMaterial.abrirTelaMaterial();
			}
		});
		contentPane.add(btnMaterial);
		
		JButton btnMaterialReparo = new JButton("Material / Reparo");
		btnMaterialReparo.setToolTipText("Material que foi usado em algum reparo");
		btnMaterialReparo.setBounds(73, 212, 299, 23);
		btnMaterialReparo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMaterialReparo telaMaterialReparo = new TelaMaterialReparo();
				telaMaterialReparo.abrirTelaMaterialReparo();
			}
		});
		contentPane.add(btnMaterialReparo);
				
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				Object[] options = { "Sim", "Não" };
				int i = JOptionPane.showOptionDialog(null,
						"Tem certeza que deseja sair?", "Atencao",
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
}
