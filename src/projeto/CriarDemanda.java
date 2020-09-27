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
import javax.swing.JOptionPane;


public class CriarDemanda {
    
    public static void CriarDemanda() throws ClassNotFoundException, SQLException{
        String motorista = "93400783064";
        String IDPedido = "4";
        String IDMotorista = null;
        String Placa = null;
        String NOMEMotorista = null;
        String NumPedido = null, DataEntrega = null, Endereco = null, Latitude, Longitude;
        Float PesoTotal = null, CubagemTotal = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conexao;
        conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestaofrotas?useTimezone=true&serverTimezone=UTC","javaapp","projeto");
        Statement st = conexao.createStatement();
        st.executeQuery("Select ID, Nome from motorista where CPF ='"+motorista+"'");
        ResultSet rs = st.getResultSet();
        if(rs.next()){
        IDMotorista = rs.getString(1);
        NOMEMotorista = rs.getString(2);
        }
        Statement sta = conexao.createStatement();
        sta.executeQuery("SELECT distinct Placa FROM gestaofrotas.veiculo INNER JOIN motorista WHERE ID_Motorista = "+IDMotorista+"");
        ResultSet rss = sta.getResultSet();
        if(rss.next()){
        Placa = rss.getString(1);
        }
        Statement stat = conexao.createStatement();
        stat.executeQuery("SELECT numeropedido, DataEntrega, Endereco, PesoTotal, CubagemTotal from PedidoVenda where ID ="+IDPedido+"");
        ResultSet rsss = stat.getResultSet();
        if(rsss.next()){
        NumPedido = rsss.getString(1);
        DataEntrega = rsss.getString(2);
        Endereco = rsss.getString(3);
        PesoTotal = rsss.getFloat(4);
        CubagemTotal = rsss.getFloat(5);
        }
        
        try{
            PreparedStatement cadastrar =
            conexao.prepareStatement("INSERT INTO demanda(ID,NomeMotorista,NomeVeiculo,NumeroPedido,DataEntrega,EnderecoDestino,PesoTotal,CubagemTotal) VALUES (?,?,?,?,?,?,?,?)");
            cadastrar.setString(1, null);
            cadastrar.setString(2, NOMEMotorista);
            cadastrar.setString(3, Placa);
            cadastrar.setString(4, NumPedido);
            cadastrar.setString(5, DataEntrega);
            cadastrar.setString(6, Endereco);
            cadastrar.setFloat(7, PesoTotal);
            cadastrar.setFloat(8, CubagemTotal);
            cadastrar.executeUpdate();
            JOptionPane.showMessageDialog(null,"Demanda cadastrada com sucesso",
            "Cadastrado",JOptionPane.INFORMATION_MESSAGE);
        }catch (Exception erro){
            JOptionPane.showMessageDialog(null,"Problema no cadastro",
            "Cadastrado",JOptionPane.WARNING_MESSAGE);
        }
        
    }
    
}
