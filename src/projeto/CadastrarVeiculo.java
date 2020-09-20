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

public class CadastrarVeiculo {
    
    public static void CriarCadastroVeiculo(String placa, String fabricante, String modelo, String motorista, String peso, String cubagem) throws ClassNotFoundException{
        String branco = null;
        String IDMotorista = null;
        String regexStr = "[A-Z]{3}-[0-9]{4}";
        String regexStr2 = "[A-Z]{3}-[0-9]{1}[A-Z]{1}[0-9]{2}";
        if(placa == null){
            branco = "Placa\n";
	}
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
        if(branco != null){
            final JPanel panel = new JPanel();
            JOptionPane.showMessageDialog(panel, "Completar os campos em branco abaixo: \n"+branco, "Campos em Branco!",
            JOptionPane.WARNING_MESSAGE);
        }else{
            if(placa.matches(regexStr)||placa.matches(regexStr2)){
                if(peso.contains("[a-zA-Z]+") == false){
                    float Peso = Float.parseFloat(peso);
                    if(cubagem.contains("[a-zA-Z]+") == false){
                        float Cubagem = Float.parseFloat(cubagem);
                        try {
                                Class.forName("com.mysql.cj.jdbc.Driver");
                                Connection conexao;
                                conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestaofrotas?useTimezone=true&serverTimezone=UTC","javaapp","projeto");
                                Statement st = conexao.createStatement();
                                st.executeQuery("Select * from veiculo where Placa ='"+placa+"'");
                                ResultSet rs = st.getResultSet();
                                    if(rs.next()){
                                        try{
                                            final JPanel panel = new JPanel();
                                            JOptionPane.showMessageDialog(panel, "Placa já cadastrada", "Cadastro em Duplicidade!",
                                            JOptionPane.WARNING_MESSAGE);
                                            }catch (Exception erro){}
                                    }else{
                                        Statement sta = conexao.createStatement();
                                        sta.executeQuery("Select ID from motorista where CPF ='"+motorista+"'");
                                        ResultSet rss = sta.getResultSet();
                                        if(rss.next()){
                                            try{
                                                IDMotorista = rss.getString(1);
                                                PreparedStatement cadastrar =
                                                conexao.prepareStatement("INSERT INTO motorista(ID,ID_Motorista,Fabricante,Modelo,Placa,Peso,Cubagem) VALUES (?,?,?,?,?,?,?)");
                                                cadastrar.setString(1, null);
                                                cadastrar.setString(2, IDMotorista);
                                                cadastrar.setString(3, fabricante);
                                                cadastrar.setString(4, modelo);
                                                cadastrar.setString(5, placa);
                                                cadastrar.setFloat(6, Peso);
                                                cadastrar.setFloat(7, Cubagem);
                                                cadastrar.executeUpdate();
                                                    JOptionPane.showMessageDialog(null,"Contato cadastrado com sucesso",
                                                                    "Cadastrado",JOptionPane.INFORMATION_MESSAGE);

                                                }catch (Exception erro){
                                                JOptionPane.showMessageDialog(null,"Problema no cadastro",
                                                                    "Cadastrado",JOptionPane.INFORMATION_MESSAGE);
                                                        }
                                            
                                        }else {
                                                final JPanel panel = new JPanel();
                                                JOptionPane.showMessageDialog(panel, "Motorista não localizado!/nValidar cadastro do motorista", "Erro",
                                                JOptionPane.WARNING_MESSAGE);
                                                }
                                            }
                        }catch (SQLException ex) {
                                    Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
                        }
                                      
                    }else{
                        final JPanel panel = new JPanel();
                        JOptionPane.showMessageDialog(panel, "Valor de Cubagem Incorreto!", "ERRO!",
                        JOptionPane.WARNING_MESSAGE);
                    }
                }else{
                        final JPanel panel = new JPanel();
                        JOptionPane.showMessageDialog(panel, "Valor de Peso Incorreto!", "ERRO!",
                        JOptionPane.WARNING_MESSAGE);
                     }
            }else{
                    final JPanel panel = new JPanel();
                    JOptionPane.showMessageDialog(panel, "Placa Inválida", "ERRO!",
                    JOptionPane.WARNING_MESSAGE);
            }
      }
    }
}
