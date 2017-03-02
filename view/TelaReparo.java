package view;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JTextFieldDateEditor;

import model.bean.Material;
import model.bean.Reparo;
import model.dao.MaterialDAO;
import model.dao.ReparoDAO;
import model.dao.SmartphoneDAO;

import java.awt.Color;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
*
* @author Bernardojr
*/
public class TelaReparo extends javax.swing.JFrame {
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
   /**
    * Creates new form TelaReparo
    */
   public TelaReparo() {
       initComponents();
       readJTable();
   }

   /**
    * This method is called from within the constructor to initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is always
    * regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
   private void initComponents() {

       jPanel1 = new javax.swing.JPanel();
       jScrollPane2 = new javax.swing.JScrollPane();
       tabelaReparo = new javax.swing.JTable();
       jLabel2 = new javax.swing.JLabel();
       jLabel3 = new javax.swing.JLabel();
       txtCodigo = new javax.swing.JTextField();
       escolherData = new com.toedter.calendar.JDateChooser();
       editor = (JTextFieldDateEditor) escolherData.getDateEditor();
       editor.setEditable(false);
       escolherData.setBackground(Color.WHITE);
       btnSalvar = new javax.swing.JButton();
       btnExcluir = new javax.swing.JButton();

       setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
       setTitle("Reparo");
       setBackground(new java.awt.Color(255, 255, 255));

       jPanel1.setBackground(new java.awt.Color(255, 255, 255));

       tabelaReparo.setModel(new javax.swing.table.DefaultTableModel(
           new Object [][] {

           },
           new String [] {
               "C�digo do Celular", "Data executada", "Conserto anterior"
           }
       ));
       tabelaReparo.addMouseListener(new java.awt.event.MouseAdapter() {
           public void mouseClicked(java.awt.event.MouseEvent evt) {
               tabelaReparoMouseClicked(evt);
           }
       });
       jScrollPane2.setViewportView(tabelaReparo);

       jLabel2.setText("C�digo do celular");

       jLabel3.setText("Data do reparo");

       txtCodigo.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               txtCodigoActionPerformed(evt);
           }
       });

       btnSalvar.setText("Salvar");
       btnSalvar.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               btnSalvarActionPerformed(evt);
           }
       });

       btnExcluir.setText("Excluir");
       btnExcluir.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               btnExcluirActionPerformed(evt);
           }
       });

       javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
       jPanel1Layout.setHorizontalGroup(
       	jPanel1Layout.createParallelGroup(Alignment.LEADING)
       		.addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE)
       		.addGroup(jPanel1Layout.createSequentialGroup()
       			.addContainerGap()
       			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
       				.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
       				.addComponent(jLabel2)
       				.addComponent(txtCodigo, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
       			.addGap(18)
       			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
       				.addComponent(escolherData, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
       				.addComponent(jLabel3)
       				.addComponent(btnExcluir, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE))
       			.addContainerGap(338, Short.MAX_VALUE))
       );
       jPanel1Layout.setVerticalGroup(
       	jPanel1Layout.createParallelGroup(Alignment.TRAILING)
       		.addGroup(jPanel1Layout.createSequentialGroup()
       			.addContainerGap(43, Short.MAX_VALUE)
       			.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
       				.addComponent(jLabel2)
       				.addComponent(jLabel3))
       			.addPreferredGap(ComponentPlacement.UNRELATED)
       			.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
       				.addComponent(txtCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
       				.addComponent(escolherData, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
       			.addGap(23)
       			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
       				.addComponent(btnSalvar)
       				.addComponent(btnExcluir))
       			.addPreferredGap(ComponentPlacement.UNRELATED)
       			.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE))
       );
       jPanel1.setLayout(jPanel1Layout);

       javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
       getContentPane().setLayout(layout);
       layout.setHorizontalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
       );
       layout.setVerticalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
       );

       pack();
   }// </editor-fold>                        

   private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {                                          
       // TODO add your handling code here:
   }                                         

   private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {                                          
	   	Reparo reparo = new Reparo();
   		ReparoDAO reparoDAO = new ReparoDAO();
   	
   		String codCelular = txtCodigo.getText();
		String data = editor.getText();
		
		if (tamanhoOk(codCelular)){
			
			if(codCelular.matches("^[0-9]*$")){
				reparo.setCodCelular(codCelular);;
			}else{
				JOptionPane.showMessageDialog(null,"C�digo inv�lido - Deve conter apenas n�meros","Erro",JOptionPane.ERROR_MESSAGE);
				return;}
			
			try {
				java.util.Date parsed = sdf.parse(data);
		        Date sql = new Date(parsed.getTime());
				reparo.setDataExecutada(sql);
			} catch (ParseException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null,"Data no formato incorreto","Erro",JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			SmartphoneDAO smartphoneDAO = new SmartphoneDAO();
			
			if (smartphoneDAO.pesquisarPorCodigo(reparo.getCodCelular()) != null){
				reparoDAO.criar(reparo);	
				txtCodigo.setText(null);
				editor.setText(null);
			}else{
				JOptionPane.showMessageDialog(null,"C�digo do celular nao encontrado","Erro",JOptionPane.ERROR_MESSAGE);
				return;
			}	
		}else{
			JOptionPane.showMessageDialog(null,"- C�digo deve conter 11 digitos","Erro",JOptionPane.ERROR_MESSAGE);
			return;
		}
		readJTable();
   }                                         

   private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {                                           
	   if(tabelaReparo.getSelectedRow() != -1){
		   Reparo reparo = new Reparo();
		   ReparoDAO reparoDAO = new ReparoDAO();
		   
		   reparo.setCodCelular(txtCodigo.getText());
		   try {
			    java.util.Date parsed = sdf.parse(editor.getText());
		        Date sql = new Date(parsed.getTime());
				reparo.setDataExecutada(sql);
		   } catch (Exception e) {
				JOptionPane.showMessageDialog(null,"Data no formato incorreto","Erro",JOptionPane.ERROR_MESSAGE);
				return;
		   }
		   reparoDAO.excluir(reparo);
		   txtCodigo.setText(null);
		   editor.setText(null);
		   readJTable();

   	}else{
   		JOptionPane.showMessageDialog(null, "Selecione um material para excluir.");
   	}
   }
   
   private void tabelaReparoMouseClicked(java.awt.event.MouseEvent evt) {                                     
   	if(tabelaReparo.getSelectedRow() != -1){
   		txtCodigo.setText(tabelaReparo.getValueAt(tabelaReparo.getSelectedRow(), 0).toString());
   		editor.setText(tabelaReparo.getValueAt(tabelaReparo.getSelectedRow(), 1).toString());
   	}
   }

   /**
    * @param args the command line arguments
    */
   public static void main(String args[]) {
       /* Set the Nimbus look and feel */
       //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
       /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
        * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
        */
       try {
           for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
               if ("Nimbus".equals(info.getName())) {
                   javax.swing.UIManager.setLookAndFeel(info.getClassName());
                   break;
               }
           }
       } catch (ClassNotFoundException ex) {
           java.util.logging.Logger.getLogger(TelaReparo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       } catch (InstantiationException ex) {
           java.util.logging.Logger.getLogger(TelaReparo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       } catch (IllegalAccessException ex) {
           java.util.logging.Logger.getLogger(TelaReparo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       } catch (javax.swing.UnsupportedLookAndFeelException ex) {
           java.util.logging.Logger.getLogger(TelaReparo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       }
       //</editor-fold>

       /* Create and display the form */
       java.awt.EventQueue.invokeLater(new Runnable() {
           public void run() {
               new TelaReparo().setVisible(true);
           }
       });
   }
   
   private boolean tamanhoOk(String codigo){		   
		  
	   if (codigo.length() == 11 ){
		   	return true;	
	   }else{
			return false;
	   }	
   }
   
   public static Date formataData(String data) throws Exception { 
		if (data == null || data.equals(""))
			return null;
       Date date = null;
       try {
           DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
           date = (java.sql.Date)formatter.parse(data);
       } catch (ParseException e) {            
           throw e;
       }
       return date;
	}
   
   public void readJTable(){
   	DefaultTableModel modelo = (DefaultTableModel) tabelaReparo.getModel();
   	modelo.setRowCount(0);
   	ReparoDAO reparoDao = new ReparoDAO();
   	
   	
   	try {
		for(Reparo m: reparoDao.listar()){
			
			if (m.getDataUltimoConserto() != null){
				modelo.addRow(new Object[]{m.getCodCelular(),
					sdf.format(m.getDataExecutada()),sdf.format(m.getDataUltimoConserto())});
			}else{
			modelo.addRow(new Object[]{m.getCodCelular(), sdf.format(m.getDataExecutada())});}
			
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }  

   // Variables declaration - do not modify                     
   private javax.swing.JButton btnExcluir;
   private javax.swing.JButton btnSalvar;
   private com.toedter.calendar.JDateChooser escolherData;
   private JTextFieldDateEditor editor;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel jLabel3;
   private javax.swing.JPanel jPanel1;
   private javax.swing.JScrollPane jScrollPane2;
   private javax.swing.JTable tabelaReparo;
   private javax.swing.JTextField txtCodigo;
   // End of variables declaration                   
}
