/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author user
 */
public class CadastroMotorista {
    
    public static void CriaCadastroMotorista(String Nome ,String Cpf, String DataNasc, String Cidade, String Endereco, String TipoCarteira, String NumeroCelular) throws ParseException{
        String branco = null;
        NumeroCelular = NumeroCelular.replaceAll("[()-]","");
        String regexStr = "^[0-9]{11}$";
        Cpf = Cpf.replaceAll("[.-]", "");      
        DataNasc = DataNasc.replaceAll("[/]", "-");
        if(Nome == null){
            branco = "Nome\n";
	}
	if(Cpf == null){
            branco = branco+"CPF\n";
        }
        if(DataNasc == null){
            branco = branco +"Data de Nascimento\n";
        }
        if(Cidade == null){
            branco = branco +"Cidade \n";
        }
        if(Endereco == null){
            branco = branco+"Endereço \n";
        }   
        if(TipoCarteira == null){
            branco = branco+"Tipo de Carteira \n";            
        }
        if(branco != null){
            final JPanel panel = new JPanel();
            JOptionPane.showMessageDialog(panel, "Completar os campos em branco abaixo: \n"+branco, "Campos em Branco!",
            JOptionPane.WARNING_MESSAGE);
        }else{
            if (TipoCarteira.matches("C|D|E")){   
		if (ValidaData.isValidDate(DataNasc) == true){
                    if (ValidaCPF.isCPF(Cpf) == true){
			if(NumeroCelular.matches(regexStr)){
                            try {
                                Class.forName("com.mysql.cj.jdbc.Driver");
                                Connection conexao;
                                conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestaofrotas?useTimezone=true&serverTimezone=UTC","javaapp","projeto");
                                Statement st = conexao.createStatement();
                                st.executeQuery("Select * from motorista where CPF ='"+Cpf+"'");
                                ResultSet rs = st.getResultSet();
                                    if(rs.next()){
                                        try{
                                            final JPanel panel = new JPanel();
                                            JOptionPane.showMessageDialog(panel, "CPF já cadastrado", "Cadastro em Duplicidade!",
                                            JOptionPane.WARNING_MESSAGE);
                                            }catch (Exception erro){}
                                    }else
                                    {
                                        Statement sta = conexao.createStatement();
                                        sta.executeQuery("Select * from motorista where NumeroCelular ='"+NumeroCelular+"'");
                                        ResultSet rss = sta.getResultSet();
                                        if(rss.next()){
                                            try{
                                                final JPanel panel = new JPanel();
                                                JOptionPane.showMessageDialog(panel, "Numero de telefone já cadastrado", "Cadastro em Duplicidade!",
                                                JOptionPane.WARNING_MESSAGE);
                                                }catch (Exception erro){}
                                        }else{
                                            try{
                                                PreparedStatement cadastrar =
                                                conexao.prepareStatement("INSERT INTO motorista(ID,Nome,DataNasc,CPF,Cidade,Endereco,TipoCarteira,NumeroCelular) VALUES (?,?,?,?,?,?,?,?)");
                                                cadastrar.setString(1, null);
                                                cadastrar.setString(2, Nome);
                                                cadastrar.setString(3, DataNasc);
                                                cadastrar.setString(4, Cpf);
                                                cadastrar.setString(5, Cidade);
                                                cadastrar.setString(6, Endereco);
                                                cadastrar.setString(7, TipoCarteira);
                                                cadastrar.setString(8, NumeroCelular);
                                                cadastrar.executeUpdate();
                                                JOptionPane.showMessageDialog(null,"Contato cadastrado com sucesso",
                                                                "Cadastrado",JOptionPane.INFORMATION_MESSAGE);

                                            }catch (Exception erro){
                                            JOptionPane.showMessageDialog(null,"Problema no cadastro",
                                                                "Cadastrado",JOptionPane.INFORMATION_MESSAGE);}
                                        } 

                                    }
                                } catch (SQLException ex) {
                                    Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (ClassNotFoundException ex) {
                                    Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
                                }
                        }else{
                        final JPanel panel = new JPanel();
                        JOptionPane.showMessageDialog(panel, "Numero de Celular já cadastrado", "Cadastro em Duplicidade!",
                        JOptionPane.WARNING_MESSAGE);
                        }
                    }else{
                    final JPanel panel = new JPanel();
                    JOptionPane.showMessageDialog(panel, "CPF Incorreto", "ERRO!",
                    JOptionPane.WARNING_MESSAGE);
                    }
                }else{
                    final JPanel panel = new JPanel();
                    JOptionPane.showMessageDialog(panel, "Data Incorreta, favor revisar", "ERRO!",
                    JOptionPane.WARNING_MESSAGE);
                        }
            }else{
		final JPanel panel = new JPanel();
                JOptionPane.showMessageDialog(panel, "Tipo de Carteira Inválido", "ERRO!",
                JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}
						