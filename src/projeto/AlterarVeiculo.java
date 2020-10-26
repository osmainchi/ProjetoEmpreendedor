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
public class AlterarVeiculo {
    
    public static String ValidaPlaca(String placa) throws ClassNotFoundException{
        String p="";
        String regexStr = "[A-Z]{3}-[0-9]{4}";
        String regexStr2 = "[A-Z]{3}-[0-9]{1}[A-Z]{1}[0-9]{2}";
        if(placa!=null){
            if(placa.matches(regexStr)||placa.matches(regexStr2)){                
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conexao;
                    conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestaofrotas?useTimezone=true&serverTimezone=UTC","javaapp","projeto");
                    Statement st = conexao.createStatement();
                    st.executeQuery("Select ID from veiculo where Placa ='"+placa+"'");
                    ResultSet rs = st.getResultSet();
                        if(rs.next()){
                            p = rs.getString(1);
                            return p;
                        }else {
                            return "false";                            
                        }             
                    }catch (SQLException ex) {}     
                }else{
                    return "N";
                }          
            }else{
                return "B";
            }
        return p;
    }
    
public static String GetFabricante (String ID) throws ClassNotFoundException{
    String fabricante;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao;
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestaofrotas?useTimezone=true&serverTimezone=UTC","javaapp","projeto");
            Statement st = conexao.createStatement();
            st.executeQuery("Select Fabricante from veiculo where ID ='"+ID+"'");
            ResultSet rs = st.getResultSet();
                if(rs.next()){
                    fabricante = rs.getString(1);
                    return fabricante;
                }else {
                    fabricante = "false";
                    return fabricante;
                }             
            }catch (SQLException ex) {}
        return "";
    }
public static String GetMotorista (String ID) throws ClassNotFoundException{
    String m,motorista;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao;
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestaofrotas?useTimezone=true&serverTimezone=UTC","javaapp","projeto");
            Statement st = conexao.createStatement();
            st.executeQuery("Select ID_Motorista from veiculo where ID ='"+ID+"'");
            ResultSet rs = st.getResultSet();
                if(rs.next()){
                    m = rs.getString(1);                    
                }else {
                    motorista = "false";
                    return motorista;
                }
                try{
                    Statement sta = conexao.createStatement();
                    sta.executeQuery("Select CPF from motorista where ID ='"+m+"'");
                    ResultSet rss = sta.getResultSet();
                if(rss.next()){
                    m = rss.getString(1);
                    return m;                    
                }else {
                    motorista = "false2";
                    return motorista;
                }
                    
                }catch (SQLException ex) {}
            }catch (SQLException ex) {}
        return "";
    }

public static String GetModelo (String ID) throws ClassNotFoundException{
    String modelo;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao;
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestaofrotas?useTimezone=true&serverTimezone=UTC","javaapp","projeto");
            Statement st = conexao.createStatement();
            st.executeQuery("Select Modelo from veiculo where ID ='"+ID+"'");
            ResultSet rs = st.getResultSet();
                if(rs.next()){
                    modelo = rs.getString(1);
                    return modelo;
                }else {
                    modelo = "false";
                    return modelo;
                }             
                }catch (SQLException ex) {}
        return "";
    }
    
public static String GetPeso (String ID) throws ClassNotFoundException{
    String peso;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao;
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestaofrotas?useTimezone=true&serverTimezone=UTC","javaapp","projeto");
            Statement st = conexao.createStatement();
            st.executeQuery("Select Peso from veiculo where ID ='"+ID+"'");
            ResultSet rs = st.getResultSet();
                if(rs.next()){
                    peso = rs.getString(1);
                    return peso;
                }else {
                    peso = "false";
                    return peso;
                }             
            }catch (SQLException ex) {}
        return "";
    }
       
 public static String GetCubagem (String ID) throws ClassNotFoundException{
    String cubagem;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao;
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestaofrotas?useTimezone=true&serverTimezone=UTC","javaapp","projeto");
            Statement st = conexao.createStatement();
            st.executeQuery("Select Cubagem from veiculo where ID ='"+ID+"'");
            ResultSet rs = st.getResultSet();
                if(rs.next()){
                    cubagem = rs.getString(1);
                    return cubagem;
                }else {
                    cubagem = "false";
                    return cubagem;
                }             
            }catch (SQLException ex) {}
        return "";
    }
 
 public static String GetAtivo (String ID) throws ClassNotFoundException{
    String ativo;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao;
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestaofrotas?useTimezone=true&serverTimezone=UTC","javaapp","projeto");
            Statement st = conexao.createStatement();
            st.executeQuery("Select Ativo from veiculo where ID ='"+ID+"'");
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
    
 public static String AtualizaVeiculo(String placa, String fabricante, String modelo, String motorista, String peso, String cubagem,String Ativo) throws SQLException, ClassNotFoundException{
        String branco = "";
        String IDMotorista;
        float Peso = Float.parseFloat(peso);
        float Cubagem = Float.parseFloat(cubagem);
        if(fabricante == null){
            branco = branco+"Fabricante\n";
        }
        if(modelo == null){
            branco = branco +"Modelo\n";
        }
        if(motorista == null){
            branco = branco +"Motorista \n";
        }
        if(peso == null){
            branco = branco+"Peso \n";
        }
        if(cubagem == null){
            branco = branco+"Cubagem \n";
        }
        if(branco != ""){
            final JPanel panel = new JPanel();
            JOptionPane.showMessageDialog(panel, "Completar os campos em branco abaixo: \n"+branco, "Campos em Branco!",
            JOptionPane.WARNING_MESSAGE);
            branco = "";
        }else{
            if (ValidaCPF.isCPF(motorista) == true){
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conexao;
                    conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestaofrotas?useTimezone=true&serverTimezone=UTC","javaapp","projeto");
                    Statement st = conexao.createStatement();
                    st.executeQuery("Select ID from motorista where CPF ='"+motorista+"'");
                    ResultSet rs = st.getResultSet();
                    if(rs.next()){
                        try{
                            IDMotorista = rs.getString(1);
                            PreparedStatement atualizar =
                            conexao.prepareStatement("UPDATE veiculo SET Fabricante=?, Modelo =?, ID_Motorista=?, Peso=?, Cubagem =?, Ativo=? WHERE Placa = '"+placa+"'");
                            atualizar.setString(1, fabricante);
                            atualizar.setString(2, modelo);
                            atualizar.setString(3, IDMotorista);
                            atualizar.setString(4, peso);
                            atualizar.setString(5, cubagem);
                            atualizar.setString(6, Ativo);                                                
                            atualizar.executeUpdate();
                                                JOptionPane.showMessageDialog(null,"Motorista atualizado com sucesso",
                                                        "Atualizado!",JOptionPane.INFORMATION_MESSAGE);
                                                  
                        }catch (Exception erro){
                            JOptionPane.showMessageDialog(null,"Problema no cadastro",
                            "Cadastrado",JOptionPane.WARNING_MESSAGE);
                        }                                            
                        }else {
                            final JPanel panel = new JPanel();
                            JOptionPane.showMessageDialog(panel, "Motorista não localizado!\nValidar cadastro do motorista", "Erro",
                            JOptionPane.WARNING_MESSAGE);
                        }
                }catch (SQLException ex) {
                    Logger.getLogger(CadastrarVeiculo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                final JPanel panel = new JPanel();
                JOptionPane.showMessageDialog(panel, "CPF Inválido!", "ERRO!",
                JOptionPane.WARNING_MESSAGE);   
                }
        }
            
     return branco;   
    }
            
    
 }
