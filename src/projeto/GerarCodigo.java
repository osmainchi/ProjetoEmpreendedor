/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class GerarCodigo {
    
       public static void GerarCodigo (String CPF) throws ClassNotFoundException{
           String cpf = CPF;
           cpf = cpf.replaceAll("[.-]", "");
           Random r = new Random();
           int code, low = 100000, max = 999999;
           code = r.nextInt(max-low) +low;
           try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conexao;
                conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestaofrotas?useTimezone=true&serverTimezone=UTC","javaapp","projeto");
                PreparedStatement atualizar =
                conexao.prepareStatement("UPDATE motorista SET CodigoCelular = ? WHERE CPF = '"+cpf+"'");
                atualizar.setInt(1, code);
                atualizar.executeUpdate();
                JOptionPane.showMessageDialog(null,"Código "+code+" atualizado com sucesso!",
                    "Atualizado!",JOptionPane.INFORMATION_MESSAGE);
                
           }catch (SQLException ex) {
                Logger.getLogger(CadastroMotorista.class.getName()).log(Level.SEVERE, null, ex);
            } 
           
           
       }
    
}
