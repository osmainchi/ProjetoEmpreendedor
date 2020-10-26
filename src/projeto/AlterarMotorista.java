/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/**
 *
 * @author user
 */
public class AlterarMotorista {
    
    public static String ValidaID(String CPF) throws ClassNotFoundException{
        String ID="";
        if(CPF!=null){
            CPF = CPF.replaceAll("[.-]", "");
            if (ValidaCPF.isCPF(CPF) == true){
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conexao;
                    conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestaofrotas?useTimezone=true&serverTimezone=UTC","javaapp","projeto");
                    Statement st = conexao.createStatement();
                    st.executeQuery("Select ID from motorista where CPF ='"+CPF+"'");
                    ResultSet rs = st.getResultSet();
                        if(rs.next()){
                            ID = rs.getString(1);
                            return ID;
                        }else {
                            ID = "false";
                            return ID;
                        }             
                    }catch (SQLException ex) {}
                }else{                
                    return "N";                
                }
            }else{
            return "B";
            }        
        return ID;
    }
    
    public static String GetNome(String ID) throws ClassNotFoundException{
        String nome="";
        try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conexao;
                    conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestaofrotas?useTimezone=true&serverTimezone=UTC","javaapp","projeto");
                    Statement st = conexao.createStatement();
                    st.executeQuery("Select Nome from motorista where ID ='"+ID+"'");
                    ResultSet rs = st.getResultSet();
                        if(rs.next()){
                            nome = rs.getString(1);
                            return nome;
                        }else {
                            nome = "false";
                            return nome;
                        }             
                    }catch (SQLException ex) {}
        return "";
    }
    
    public static String GetCidade(String ID) throws ClassNotFoundException{
        String cidade="";
        try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conexao;
                    conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestaofrotas?useTimezone=true&serverTimezone=UTC","javaapp","projeto");
                    Statement st = conexao.createStatement();
                    st.executeQuery("Select Cidade from motorista where ID ='"+ID+"'");
                    ResultSet rs = st.getResultSet();
                        if(rs.next()){
                            cidade = rs.getString(1);
                            return cidade;
                        }else {
                            cidade = "false";
                            return cidade;
                        }             
                    }catch (SQLException ex) {}
        return "";
    }
    
    
    public static String GetDataNasc(String ID) throws ClassNotFoundException{
        String datanasc="";
        try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conexao;
                    conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestaofrotas?useTimezone=true&serverTimezone=UTC","javaapp","projeto");
                    Statement st = conexao.createStatement();
                    st.executeQuery("Select DataNasc from motorista where ID ='"+ID+"'");
                    ResultSet rs = st.getResultSet();
                        if(rs.next()){
                            datanasc = rs.getString(1);
                            return datanasc;
                        }else {
                            datanasc = "false";
                            return datanasc;
                        }             
                    }catch (SQLException ex) {}
        return "";
    }
    
     public static String GetEndereco(String ID) throws ClassNotFoundException{
        String endereco="";
        try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conexao;
                    conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestaofrotas?useTimezone=true&serverTimezone=UTC","javaapp","projeto");
                    Statement st = conexao.createStatement();
                    st.executeQuery("Select Endereco from motorista where ID ='"+ID+"'");
                    ResultSet rs = st.getResultSet();
                        if(rs.next()){
                            endereco = rs.getString(1);
                            return endereco;
                        }else {
                            endereco = "false";
                            return endereco;
                        }             
                    }catch (SQLException ex) {}
        return "";
    }
     
     public static String GetTipoCarteira(String ID) throws ClassNotFoundException{
        String tipocarteira="";
        try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conexao;
                    conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestaofrotas?useTimezone=true&serverTimezone=UTC","javaapp","projeto");
                    Statement st = conexao.createStatement();
                    st.executeQuery("Select TipoCarteira from motorista where ID ='"+ID+"'");
                    ResultSet rs = st.getResultSet();
                        if(rs.next()){
                            tipocarteira = rs.getString(1);
                            return tipocarteira;
                        }else {
                            tipocarteira = "false";
                            return tipocarteira;
                        }             
                    }catch (SQLException ex) {}
        return "";
    }
     
     public static String GetNumeroCelular(String ID) throws ClassNotFoundException{
        String numcelular="";
        try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conexao;
                    conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestaofrotas?useTimezone=true&serverTimezone=UTC","javaapp","projeto");
                    Statement st = conexao.createStatement();
                    st.executeQuery("Select NumeroCelular from motorista where ID ='"+ID+"'");
                    ResultSet rs = st.getResultSet();
                        if(rs.next()){
                            numcelular = rs.getString(1);
                            return numcelular;
                        }else {
                            numcelular = "false";
                            return numcelular;
                        }             
                    }catch (SQLException ex) {}
        return "";
    }      
 
     public static String GetAtivo(String ID) throws ClassNotFoundException{
        String ativo="";
        try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conexao;
                    conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestaofrotas?useTimezone=true&serverTimezone=UTC","javaapp","projeto");
                    Statement st = conexao.createStatement();
                    st.executeQuery("Select Ativo from motorista where ID ='"+ID+"'");
                    ResultSet rs = st.getResultSet();
                        if(rs.next()){
                            ativo = rs.getString(1);
                            return ativo;
                        }else {
                            ativo = "false";
                            return ativo;
                        }             
                    }catch (SQLException ex) {}
        return "";
    }     
     
    
    public static String AtualizaMotorista(String Nome ,String Cpf, String DataNasc, String Cidade, String Endereco, String TipoCarteira, String NumeroCelular, String Ativo) throws ParseException, ClassNotFoundException{
        
        String branco = "";
        NumeroCelular = NumeroCelular.replaceAll("[()-]","");
        String regexStr = "^[0-9]{11}$";            
        
        if(Nome == null){
            branco = "Nome\n";
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
        if(branco != ""){
            final JPanel panel = new JPanel();
            JOptionPane.showMessageDialog(panel, "Completar os campos em branco abaixo: \n"+branco, "Campos em Branco!",
            JOptionPane.WARNING_MESSAGE);
            branco = "";
        }else{
            Cpf = Cpf.replaceAll("[.-]", "");         
            DataNasc = DataNasc.replaceAll("[/]", "-");
            if (TipoCarteira.matches("C|D|E")){   
               if (ValidaData.isValidDate(DataNasc) == true){
                   if(NumeroCelular.matches(regexStr)){
                       try {
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            Connection conexao;
                            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestaofrotas?useTimezone=true&serverTimezone=UTC","javaapp","projeto");
                            Statement st = conexao.createStatement();
                            st.executeQuery("Select * from motorista where NumeroCelular ='"+NumeroCelular+"' and CPF != '"+Cpf+"'");
                            ResultSet rs = st.getResultSet();
                            if(rs.next()){
                                try{
                                    final JPanel panel = new JPanel();
                                    JOptionPane.showMessageDialog(panel, "Numero de telefone já cadastrado", "Cadastro em Duplicidade!",
                                    JOptionPane.WARNING_MESSAGE);
                                    }catch (Exception erro){}
                                        }else{
                                             try{
                                                PreparedStatement atualizar =
                                                conexao.prepareStatement("UPDATE motorista SET Nome=?, DataNasc =?, Cidade=?, Endereco=?, TipoCarteira =?, NumeroCelular=?, Ativo=? WHERE CPF = '"+Cpf+"'");
                                                atualizar.setString(1, Nome);
                                                atualizar.setString(2, DataNasc);
                                                atualizar.setString(3, Cidade);
                                                atualizar.setString(4, Endereco);
                                                atualizar.setString(5, TipoCarteira);
                                                atualizar.setString(6, NumeroCelular);
                                                atualizar.setString(7, Ativo);                                                
                                                atualizar.executeUpdate();
                                                JOptionPane.showMessageDialog(null,"Motorista atualizado com sucesso",
                                                        "Atualizado!",JOptionPane.INFORMATION_MESSAGE);
                                                
                                            }catch (Exception erro){
                                                JOptionPane.showMessageDialog(null,"Problema na atualização",
                                                        "Erro",JOptionPane.INFORMATION_MESSAGE);}
                                        
                                        }
                                }catch (SQLException ex) {
                                    Logger.getLogger(CadastroMotorista.class.getName()).log(Level.SEVERE, null, ex);
                       }                       
                   }else{
                       final JPanel panel = new JPanel();
                        JOptionPane.showMessageDialog(panel, "Numero de Celular Incorreto", "ERRO!",
                        JOptionPane.WARNING_MESSAGE);
                   }                   
               }else{
                   final JPanel panel = new JPanel();
                    JOptionPane.showMessageDialog(panel, "Data Incorreta, favor revisar", "ERRO!",
                    JOptionPane.WARNING_MESSAGE);
               }
            }else {
                final JPanel panel = new JPanel();
                JOptionPane.showMessageDialog(panel, "Tipo de Carteira Inválido", "ERRO!",
                JOptionPane.WARNING_MESSAGE);
            }
        }
        return branco;
    }
            
}
    
    

